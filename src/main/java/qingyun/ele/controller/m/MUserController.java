package qingyun.ele.controller.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qingyun.ele.domain.db.Users;
import qingyun.ele.repository.UsersRepository;
import qingyun.ele.service.UsrService;
import qingyun.ele.ws.Valid;
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

	
}
