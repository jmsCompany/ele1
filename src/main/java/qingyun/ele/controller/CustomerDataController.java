package qingyun.ele.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qingyun.ele.domain.db.CustomerData;
import qingyun.ele.repository.CustomerDataRepository;
import qingyun.ele.ws.Valid;
import qingyun.ele.ws.WSArea;
import qingyun.ele.ws.WSChart;
import qingyun.ele.ws.WSDCInput;
import qingyun.ele.ws.WSDCOutput;
import qingyun.ele.ws.WSDevice;
import qingyun.ele.ws.WSReq;
import qingyun.ele.ws.WSSSInv;
import qingyun.ele.ws.WSSationInfo;
import qingyun.ele.ws.WSTableData;

@RestController
@Transactional(readOnly = true)
public class CustomerDataController {

	@Autowired
	private CustomerDataRepository customerDataRepository;
	private static final Log logger = LogFactory.getLog(CustomerDataController.class);

	@Transactional(readOnly = false)
	@RequestMapping(value = "/info/customer/saveCustomerData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Valid saveCustomerData(@RequestBody CustomerData customerData) {
		Valid v = new Valid();
		customerDataRepository.save(customerData);
		v.setValid(true);
		return v;
	}
	
	
	@Transactional(readOnly = false)
	@RequestMapping(value = "/info/customer/areaData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSArea areaData() {
		WSArea v = new WSArea();
		String[] date ={"1968/10/4", "1968/10/5", "1968/10/6", "1968/10/7", "1968/10/8", "1968/10/9", "1968/10/10", "1968/10/11", "1968/10/12", "1968/10/13", "1968/10/14", "1968/10/15", "1968/10/16", "1968/10/17", "1968/10/18", "1968/10/19", "1968/10/20", "1968/10/21", "1968/10/22", "1968/10/23", "1968/10/24", "1968/10/25", "1968/10/26", "1968/10/27", "1968/10/28", "1968/10/29", "1968/10/30", "1968/10/31", "1968/11/1", "1968/11/2", "1968/11/3", "1968/11/4", "1968/11/5", "1968/11/6", "1968/11/7", "1968/11/8", "1968/11/9", "1968/11/10", "1968/11/11", "1968/11/12", "1968/11/13", "1968/11/14", "1968/11/15", "1968/11/16", "1968/11/17", "1968/11/18", "1968/11/19", "1968/11/20", "1968/11/21", "1968/11/22", "1968/11/23", "1968/11/24", "1968/11/25", "1968/11/26", "1968/11/27", "1968/11/28", "1968/11/29", "1968/11/30", "1968/12/1", "1968/12/2", "1968/12/3", "1968/12/4", "1968/12/5", "1968/12/6", "1968/12/7", "1968/12/8", "1968/12/9", "1968/12/10", "1968/12/11", "1968/12/12", "1968/12/13", "1968/12/14", "1968/12/15", "1968/12/16", "1968/12/17", "1968/12/18", "1968/12/19", "1968/12/20", "1968/12/21", "1968/12/22", "1968/12/23", "1968/12/24", "1968/12/25", "1968/12/26", "1968/12/27", "1968/12/28", "1968/12/29", "1968/12/30", "1968/12/31", "1969/1/1", "1969/1/2", "1969/1/3", "1969/1/4", "1969/1/5", "1969/1/6", "1969/1/7", "1969/1/8", "1969/1/9", "1969/1/10", "1969/1/11"};
		Integer[] data ={92, 89, 83, 74, 69, 75, 73, 71, 62, 58, 49, 39, 32, 27, 32, 24, 17, 10, 19, 15, 20, 16, 18, 19, 18, 11, 15, 10, 14, 9, 5, 4, -4, 5, 12, 15, 21, 17, 17, 27, 19, 10, 14, 21, 24, 27, 24, 34, 33, 39, 34, 44, 48, 44, 46, 39, 43, 48, 43, 39, 38, 40, 36, 40, 49, 50, 59, 65, 70, 71, 68, 64, 68, 72, 75, 67, 65, 60, 61, 69, 69, 63, 73, 66, 59, 60, 51, 54, 61, 69, 63, 62, 71, 63, 63, 65, 59, 51, 57, 67};
		
		v.setData(data);
		v.setDate(date);
		v.setValid(true);
		return v;
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(value = "/info/getdlchart", consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSArea getglchart(@RequestBody WSReq wsReq)
	{
		WSArea a  = new WSArea();
		return a;
	}
	@Transactional(readOnly = false)
	@RequestMapping(value = "/info/getglchart", consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSChart getdlchart(@RequestBody WSReq wsReq)
	{
		WSChart a  = new WSChart();
		System.out.println("type: " + wsReq.getType());
		if(wsReq.getType().equals("day"))
		{
			String[] x  = {"2016-09", "2016-10", "2016-11", "2016-12", "2017-01","2017-02","2017-03"
					,"2017-04","2017-05","2017-06","2017-07","2017-08"};
			Float[] y = {29.9f, 71.5f, 106.4f, 129.2f, 144.0f, 176.0f, 135.6f, 148.5f, 216.4f, 194.1f,
					95.6f, 54.4f};
			a.setX(x);
			a.setY(y);
		}

		else
		{
			String[] x  = { "2017-01","2017-02","2017-03"
					,"2017-04","2017-05","2017-06","2017-07","2017-08"};
			Float[] y = { 144.0f, 176.0f, 135.6f, 148.5f, 216.4f, 194.1f,
					95.6f, 54.4f};
			a.setX(x);
			a.setY(y);
		}
	

		return a;
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/info/getssinv", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<WSSSInv> getssinv(@RequestBody WSReq wsReq)
	{
		List<WSSSInv> invs = new ArrayList<WSSSInv>();
		
		
		
		WSSSInv i1 = new WSSSInv();
		i1.setDrdl(12.3f);
		i1.setLjnl(212.4f);
		i1.setPl(212f);
		i1.setRowSpan(3);
		i1.setSeq(1);
		i1.setSn("qwwqsaassa0012");
		i1.setWd(45f);
		i1.setTime("2017-09-02 08:00");
		
		 List<WSDCOutput> output1 = new ArrayList<WSDCOutput>(); //AC 
		 WSDCOutput o1 = new WSDCOutput();
		 o1.setDl(12.9f);
		 o1.setDy(12f);
		 o1.setGl(12f);
		 o1.setXw("相位1");
		 WSDCOutput o2 = new WSDCOutput();
		 o2.setDl(12.9f);
		 o2.setDy(12f);
		 o2.setGl(12f);
		 o2.setXw("相位2");
		 WSDCOutput o3 = new WSDCOutput();
		 o3.setDl(12.9f);
		 o3.setDy(12f);
		 o3.setGl(12f);
		 o3.setXw("相位1");
		 output1.add(o1);
		 output1.add(o2);
		 output1.add(o3);
		 List<WSDCInput> input1 = new ArrayList<WSDCInput>();  //DC
		 WSDCInput in1 = new WSDCInput();
		 in1.setDl(12.5f);
		 in1.setDy(12f);
		 in1.setHl("回路1");
		 input1.add(in1);
		 
		 for(int i=0;i<2; i++)
		 {
			 WSDCInput in = new WSDCInput();
			 input1.add(in);
		 }
		 
		i1.setOutput(output1);
		i1.setInput(input1);
		invs.add(i1);
		
		
		
		
		
		WSSSInv i = new WSSSInv();
		i.setDrdl(12.3f);
		i.setLjnl(212.4f);
		i.setPl(212f);
		i.setRowSpan(4);
		i.setSeq(1);
		i.setWd(46f);
		i.setSn("qwwqsaassawww0012");
		i.setTime("2017-09-02 08:10");
		
		 List<WSDCOutput> output2 = new ArrayList<WSDCOutput>(); //AC 
		 WSDCOutput o4 = new WSDCOutput();
		 o4.setDl(12.9f);
		 o4.setDy(12f);
		 o4.setGl(12f);
		 o4.setXw("相位1");
		 WSDCOutput o5 = new WSDCOutput();
		 o5.setDl(12.9f);
		 o5.setDy(12f);
		 o5.setGl(12f);
		 o5.setXw("相位2");
		 WSDCOutput o6 = new WSDCOutput();
		 o6.setDl(12.9f);
		 o6.setDy(12f);
		 o6.setGl(12f);
		 o6.setXw("相位3");
		 output2.add(o4);
		 output2.add(o5);
		 output2.add(o6);
		 
		 WSDCOutput o7 = new WSDCOutput();
		 output2.add(o7);
		 List<WSDCInput> input2 = new ArrayList<WSDCInput>();  //DC
		 WSDCInput in2 = new WSDCInput();
		 in2.setDl(12.5f);
		 in2.setDy(12f);
		 in2.setHl("回路1");
		 input2.add(in2);
		 
		 WSDCInput in3 = new WSDCInput();
		 in3.setDl(12.5f);
		 in3.setDy(12f);
		 in3.setHl("回路2");
		 input2.add(in3);
		 
		 WSDCInput in4 = new WSDCInput();
		 in4.setDl(12.5f);
		 in4.setDy(12f);
		 in4.setHl("回路3");
		 input2.add(in4);
		 
		 
		 WSDCInput in5 = new WSDCInput();
		 in5.setDl(12.5f);
		 in5.setDy(12f);
		 in5.setHl("回路4");
		 input2.add(in5);
		 
		 
		 
		i.setOutput(output2);
		i.setInput(input2);
		invs.add(i);
		
	
		
		return invs;
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(value = "/info/getdevicechart", consumes = MediaType.APPLICATION_JSON_VALUE)
	public WSArea getdevicechart(@RequestBody WSReq wsReq)
	{
		WSArea a  = new WSArea();
		return a;
	}
	
	
	@RequestMapping(value = "/info/devices", method = RequestMethod.GET)
	public List<WSDevice> devices(@RequestParam Long proId) {
		List<WSDevice> ls = new ArrayList<WSDevice>();
		WSDevice d1 = new WSDevice();
		d1.setID_DEVICE(1001);
		d1.setMAC("5609876543456789");
		ls.add(d1);
		
		WSDevice d2 = new WSDevice();
		d2.setID_DEVICE(1001);
		d2.setMAC("ABCSSSSSSSS33333");
		ls.add(d2);	
		
		return ls;
		
	}
	@RequestMapping(value = "/info/handlealert", method = RequestMethod.GET)
	public Valid handlealert(@RequestParam Long id) {
		
		Valid v = new Valid();
		v.setValid(true);
		return v;
		
	}
	
	@RequestMapping(value = "/info/deletealert", method = RequestMethod.GET)
	public Valid deletealert(@RequestParam Long id) {
		
		Valid v = new Valid();
		v.setValid(false);
		v.setMsg("删除失败，该功能还未实现！");
		return v;
		
	}
	
	@RequestMapping(value = "/info/station", method = RequestMethod.GET)
	public WSSationInfo stationInfo(@RequestParam Long proId) {
		WSSationInfo info = new WSSationInfo();
		
		info.setAzs("上海潜拓");
		info.setBjs(15);
		info.setDndl(132f);
		info.setDqgl(23.3f);
		info.setDqgl(124.5f);
		info.setDrdl(12.3f);
		info.setDydl(145.7f);
		info.setFdxl(12.1f);
		info.setFzgl(122.5f);
		
		info.setLang("31.1502551756");
		info.setLat("121.4310178657");
		
		info.setPic("$2a$10$yRNu8bxzH6MpId7HvEQOzQseG3wiXuq6e25DVsU1wBYiQ9iWJZi_1499584643298.jpg");
		info.setZcsj("2017-08-12");
		info.setZhgxsj("2017-09-02");
		info.setZdl(12.5f);
		info.setZjrl(1212.4f);
		
		return info;
	
	}
	


	@RequestMapping(value = "/info/getalertstable", method = RequestMethod.POST)
	public WSTableData getalertstable(
			@RequestParam(required =false) Integer timetype ,
			@RequestParam(required =false) Integer type,
			@RequestParam(required =false) String q,
			@RequestParam Integer start, @RequestParam Integer draw,
			@RequestParam Integer length) {
		int page_num = (start.intValue() / length.intValue()) + 1;
		Pageable pageable = new PageRequest(page_num - 1, length);

		//ID 逆变器SN 报警信息	报警代码	报警时间	报警状态	查看图标	操作
		List<String[]> lst = new ArrayList<String[]>();
		for (int i= 1; i<4; i++) {
			String[] d = {
					""+1001,
					"001413821388-001",
					"第2路组串输入电压低",
					"4",
					"2017-08-31 8:00",
					"已经处理",
					""+i
			};
			lst.add(d);
		}

		WSTableData t = new WSTableData();
		t.setDraw(draw);
		t.setRecordsTotal(3);
		t.setRecordsFiltered(3);
		t.setData(lst);
		return t;
	}

	

	@RequestMapping(value = "/info/customer/customerDataTable", method = RequestMethod.POST)
	public WSTableData customerDataTable(@RequestParam Integer start, @RequestParam Integer draw,
			@RequestParam Integer length) {
		int page_num = (start.intValue() / length.intValue()) + 1;
		Pageable pageable = new PageRequest(page_num - 1, length);

		Page<CustomerData> customerData = customerDataRepository.findByIdDesc(pageable);
		List<String[]> lst = new ArrayList<String[]>();
		for (CustomerData w : customerData.getContent()) {
			String[] d = {w.getCustomerCode(),w.getCustomerName(),w.getInverterSn(),
					""+w.getVpv1(),""+w.getVpv3(),""+w.getVpv3(),
					""+w.getLpv1(),""+w.getLpv2(),""+w.getLpv3(),
					""+w.getVac1(),""+w.getVac2(),""+w.getVac3(),
					""+w.getLac1(),""+w.getLac2(),""+w.getLac3(),
					""+w.getPac1(),""+w.getPac2(),""+w.getPac3(),
					""+w.getFac(),""+w.getTemp(),""+w.getCTime(),
					""+w.getTodayEne(),""+w.getTotalEne()
			};
			lst.add(d);
		}

		WSTableData t = new WSTableData();
		t.setDraw(draw);
		t.setRecordsTotal((int) customerData.getTotalElements());
		t.setRecordsFiltered((int) customerData.getTotalElements());
		t.setData(lst);
		return t;
	}

}
