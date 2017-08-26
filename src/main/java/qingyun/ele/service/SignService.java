package qingyun.ele.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qingyun.ele.SecurityUtils;
import qingyun.ele.domain.db.SignEvent;
import qingyun.ele.domain.db.SignWorkflowSteps;
import qingyun.ele.domain.db.UserRole;
import qingyun.ele.domain.db.Users;
import qingyun.ele.repository.SignEventRepository;
import qingyun.ele.repository.SignWorkflowStepsRepository;
import qingyun.ele.repository.UserRoleRepository;
import qingyun.ele.repository.UsersRepository;

@Service
@Transactional(readOnly = true)
public class SignService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private SignWorkflowStepsRepository signWorkflowStepsRepository;
	@Autowired
	private SignEventRepository signEventRepository;

	@Autowired
	private SecurityUtils securityUtils;
	
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	
	@Transactional(readOnly = false)
	public void initializedSign(Long idSignWorkFlow, Long eventId)
	{
		//如果已经有，删除                      
		for(SignEvent se: signEventRepository.findNotDeletedByIdEventAndIdSignWorkflow(eventId,idSignWorkFlow))
		{
			se.setDeleted(1l);
			signEventRepository.save(se);
		}
		//找到当前
		List<SignWorkflowSteps> sws = signWorkflowStepsRepository.findByIdSignWorkflow(idSignWorkFlow);
		//int seq = 1;
		for (SignWorkflowSteps s : sws) {
			SignEvent se = new SignEvent();
			se.setContent(s.getContent());
			se.setDeleted(0l);
			se.setIdDepartment(s.getIdDepartment());
            se.setIdEvent(eventId);
            se.setIdRole(s.getIdRole());
            se.setIdSignatory(s.getIdSignatory());
            se.setIdSignWorkflow(idSignWorkFlow);
            se.setIdSignWorkflowSteps(s.getId()); //已经无用了
            se.setIsLoc(se.getIsLoc());
            se.setLvl(s.getLvl());
            se.setStatus(2l); //待签字
           // se.se
			signEventRepository.save(se);
		}
	}

	// 判断是否出现签字按钮 0不出现，1出现
	public Long isEditable(
			SignEvent signEvent) {
		Long signEventId=signEvent.getId();
		Long eventId=signEvent.getIdEvent();
		Long idSignatory=signEvent.getIdSignatory();
		Long idPos=signEvent.getIdRole();
		Users usr = securityUtils.getCurrentDBUser();
		System.out.println(" signId: "+idSignatory +", uid: " + usr.getId()  +", name: " +usr.getUsername());
		//System.out.println(" signId: "+idSignatory );

		if (idSignatory == null&&idPos==null) { //不应该发生！
			return 0l;
		} 
		if(idSignatory!=null)
		{
			System.out.println("应签字人id: " + idSignatory);
			if (!usr.getId().equals(idSignatory)) {
				  System.out.println("直接返回不可编辑");
					return 0l;
				}
			Long editable = 0l;
			//System.out.println(" stepId: "+signWorkflowStepsId);

			Long currentLvl = signEvent.getLvl();
			Long upperLvl = currentLvl - 1l;
			// 上一级签字数

			if (signEvent.getStatus()==null||signEvent.getStatus().equals(2l)) // 还未签字,这时有两种情况，未签但是应该签了，一种是未签但是还需要等上级签完
			{
				if (currentLvl.equals(1l)) // 第一层，可签字
				{
					System.out.println("第一层，可签");
					editable = 1l;
					return editable;

				} else {
					boolean uppperSignfinished = isThisLvlFinished(signEvent.getIdSignWorkflow(), upperLvl,
							eventId);
					if (uppperSignfinished) {
						editable = 1l;
						return editable;
					} else {
						editable = 0l;
						return editable;
					}
				}
			} else // 已经签字
			{
				if (signEvent.getStatus().equals(0l))// 拒绝,应该永远不会发生，因为拒绝之后，就变成删除状态。
				{
					editable = 1l;
					return editable;
				} else {
					editable = 0l;
					return editable;

				}
			}
		}
		
		
		if(idPos!=null)
		{
			Long editable = 0l;
			UserRole ur = userRoleRepository.findrolesByUserIdAndroleId(usr.getId(), idPos);
			if(ur==null )
			{
				editable = 0l;
				return editable;
			}
			else
			{
				
				//System.out.println(" stepId: "+signWorkflowStepsId);
				
				Long currentLvl = signEvent.getLvl();
				Long upperLvl = currentLvl - 1l;
				// 上一级签字数

				if (signEvent.getStatus()==null||signEvent.getStatus().equals(2l)) // 还未签字,这时有两种情况，未签但是应该签了，一种是未签但是还需要等上级签完
				{
					if (currentLvl.equals(1l)) // 第一层，可签字
					{
						//System.out.println("第一层，可签");
						editable = 1l;
						return editable;

					} else {
						boolean uppperSignfinished = isThisLvlFinished(signEvent.getIdSignWorkflow(), upperLvl,
								eventId);
						if (uppperSignfinished) {
							editable = 1l;
							return editable;
						} else {
							editable = 0l;
							return editable;
						}
					}
				} else // 已经签字
				{
					if (signEvent.getStatus().equals(0l))// 拒绝
					{
						editable = 1l;
						return editable;
					} else {
						editable = 0l;
						return editable;

					}
				}
				
			}
			//return 1l;
		}
		
		
		System.out.println("签名 和职位 不应该同时有值。 ");
		return 0l;
		
		
		
		

	}

	// 判断此层是否都已经签好字
	public Boolean isThisLvlFinished(Long signWorkflowId, Long lvl, Long eventId) {
		Boolean finished = true;
		//List<SignWorkflowSteps> sfs = signWorkflowStepsRepository.findByIdSignWorkflowAndLvl(signWorkflowId, lvl);
		System.out.println("is finish: lvl: " + lvl +", signworkId: " +signWorkflowId +", eventId:"  + eventId);
		List<SignEvent>  sfs = signEventRepository.findNotDeletedByIdEventAndIdSignWorkflowAndLvl(eventId, signWorkflowId,lvl);
		for (SignEvent signEvent : sfs) {
		
				if (signEvent.getStatus()!=null&&signEvent.getStatus().equals(2l)) {
					finished = false;
					return finished;
				}
			
		}
		return finished;
	}
	
	

}
