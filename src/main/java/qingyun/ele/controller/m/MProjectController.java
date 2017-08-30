package qingyun.ele.controller.m;

import java.util.*;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import qingyun.ele.ws.*;

@RestController
@Transactional(readOnly = true)
public class MProjectController {
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/projList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<WSProject> projList() {
		 List<WSProject> ls = new ArrayList<WSProject>();
		 WSProject w = new WSProject();
		 w.setAddress("福建省三明市尤溪县汤川镇光明村");
		 w.setDrfd(9.8f);
		 w.setDrsy(8.33f);
		 w.setFdgl(2.529f);
		 w.setId(1l);
		 w.setLjfd(2789.4f);
		 w.setLjsy(2370.99f);
		 w.setPic("$2a$10$U9skSXceJ3zNyZVWy6Vo.eGLuQzxlEf39HvF9MMFoL1ShG32Qmy_1500882431017.jpg");
		 w.setZjrl(10.000f);
		 ls.add(w);	
		 
		 
		 WSProject w1 = new WSProject();
		 w1.setAddress("福建省三明市尤溪县汤川镇黑暗村");
		 w1.setDrfd(9.8f);
		 w1.setDrsy(8.33f);
		 w1.setFdgl(2.529f);
		 w1.setId(1l);
		 w1.setLjfd(2789.4f);
		 w1.setLjsy(2370.99f);
		 w1.setPic("$2a$10$U9skSXceJ3zNyZVWy6Vo.eGLuQzxlEf39HvF9MMFoL1ShG32Qmy_1500882431017.jpg");
		 w1.setZjrl(10.000f);
		 ls.add(w1);	
		 
		 return ls;
	}
	
	
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/getloc", method = RequestMethod.GET)
	public WSLoc getloc(@RequestParam("id") Long id) {
		
		WSLoc loc = new WSLoc();
		loc.setLang("31.1502551756");
		loc.setLat("121.4310178657");
		return loc;
	}
	
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/proj", method = RequestMethod.GET)
	public WSProjectDetail proj(@RequestParam("id") Long id) {
		WSProjectDetail w = new WSProjectDetail();
		w.setId(id);
		w.setAddress("福建省三明市尤溪县汤川镇光明村");
		w.setCjsj("2017-08-21");
		w.setYxzt("Normal");
		w.setFdgl(2.529f);
		w.setBfb(25.3f);
		w.setZjrl(10.1f);
		w.setDrdl(9.8f);
		w.setDrjp(0.004f);
		w.setDrsy(8.33f);
		w.setDrzz(0.029f);
		w.setLjdl(2789.4f);
		w.setLjjp(1.27f);
		w.setLjsy(2370.99f);
		w.setLjzz(8.368f);
		return w;
		
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/datacollects", method = RequestMethod.GET)
	public WSDataCollects dataCollect(@RequestParam("id") Long id) {
		WSDataCollects w = new WSDataCollects();
		
		w.setAddress("福建省三明市尤溪县汤川镇光明村");
		
		WSDataCollect wc  = new WSDataCollect();
		wc.setCwxx("N/A");
		wc.setDrfd(9.8f);
		wc.setFdgl(2529f);
		wc.setLjfd(9.8f);
		wc.setSn("8010KDTU175G5643");
		wc.setZt("Normal");
		wc.setPic("$2a$10$U9skSXceJ3zNyZVWy6Vo.eGLuQzxlEf39HvF9MMFoL1ShG32Qmy_1500882431017.jpg");
		w.getData().add(wc);
		
		WSDataCollect wc1  = new WSDataCollect();
		wc1.setCwxx("N/A");
		wc1.setDrfd(9.8f);
		wc1.setFdgl(2529f);
		wc1.setLjfd(9.8f);
		wc1.setSn("8010KDTU175G5643");
		wc1.setZt("Normal");
		wc1.setPic("$2a$10$U9skSXceJ3zNyZVWy6Vo.eGLuQzxlEf39HvF9MMFoL1ShG32Qmy_1500882431017.jpg");
		w.getData().add(wc1);
		
		return w;
		
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/m/mapchars", method = RequestMethod.POST)
	public WSRes mapchars(@RequestBody WSReq wsReq) {
		WSRes res = new WSRes();
		res.setxAxis("6,4,8,20");
		res.setyAxis("120,140");
		res.setToday("123KWH");
		return res;
	}
}