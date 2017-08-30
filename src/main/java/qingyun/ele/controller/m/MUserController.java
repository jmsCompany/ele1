package qingyun.ele.controller.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qingyun.ele.SecurityUtils;
import qingyun.ele.domain.db.Users;
import qingyun.ele.repository.UsersRepository;
import qingyun.ele.service.UsrService;
import qingyun.ele.ws.Valid;
import qingyun.ele.ws.WSMset;
import qingyun.ele.ws.WSUser;
import qingyun.ele.ws.WSUserPassword;
import qingyun.ele.ws.WSUserProfile;

@RestController
@Transactional(readOnly = true)
public class MUserController {

	@Autowired
	private UsrService usrService;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private SecurityUtils securityUtils;

	@Transactional(readOnly = false)
	@RequestMapping(value = "/m/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSUserProfile login(@RequestBody WSUser wsUser) {
		WSUserProfile wsUserProfile = new WSUserProfile();

		String token = usrService.login(wsUser.getUsername(), wsUser.getPassword());
		if (token == null) {
			wsUserProfile.setValid(false);
			wsUserProfile.setMsg("用户名或密码错误");
			return wsUserProfile;
		}
		Users u = usersRepository.findByUsername(wsUser.getUsername());
		wsUserProfile.setValid(true);
		wsUserProfile.setToken(token);
		wsUserProfile.setUsername(u.getUsername());

		wsUserProfile.setIdUser(u.getId());
		wsUserProfile.setName(u.getName());
		return wsUserProfile;
	}

	
	@Transactional(readOnly = false)
	@RequestMapping(value = "/m/updateUser", method = RequestMethod.POST)
	public Valid updateUser(@RequestBody WSUserPassword wsUserPassword) throws Exception {
		Valid v = new Valid();
		String username = wsUserPassword.getUsername();
		Users u = usersRepository.findByUsername(username);
		if (u!=null) {
			u.setPassword(new BCryptPasswordEncoder().encode(wsUserPassword.getNewPassword()));
			u.setEmail(wsUserPassword.getEmail());
			usersRepository.save(u);
			v.setValid(true);
			v.setMsg("新密码已发送您邮箱");
			return v;
		} else {
			v.setValid(false);
			v.setMsg("无该用户！");
			return v;
		}
	}

	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/getsetting", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSMset getsetting() {
		Users usr = securityUtils.getCurrentDBUser();
		Long fd = usr.getFd()==null?0l:usr.getFd();
		Long ts = usr.getTs()==null?0l: usr.getTs();
		Long ycts = usr.getYcts()==null?0l:usr.getYcts();
		WSMset set = new WSMset();
		set.setFd(fd);
		set.setTs(ts);
		set.setYcts(ycts);
		return set;
	}
	
	
	@Transactional(readOnly = false)
	@RequestMapping(value = "/m/savesetting", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Valid saveSetting(@RequestBody WSMset set) {
		Users usr = securityUtils.getCurrentDBUser();
		usr.setFd(set.getFd());
		usr.setTs(set.getTs());
		usr.setYcts(set.getYcts());
		usersRepository.save(usr);
	    Valid v =new Valid();
	    v.setValid(true);
	    v.setMsg("保存成功！");
	    return v;
	}
	
	
}
