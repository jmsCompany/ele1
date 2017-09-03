package qingyun.ele.ws;

import java.util.ArrayList;
import java.util.List;

public class WSDaliyReport implements java.io.Serializable {

	
//	电站名称:吉和祥8kw屋面分布式光伏电站
//	当日电量:10.66kWh
//	装机容量:8kWp总电量:6291.2kWh
//	时间:2017-09-03
//	
	private String site; // 电站名
	private Float drdl; //当日电量
	private Float zjrl; //装机容量:
	private Float zdl;  //总电量
	private String time; //时间
	
	private List<WSInvertEne> nbq = new ArrayList<WSInvertEne>();  //逆变器数值

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Float getDrdl() {
		return drdl;
	}

	public void setDrdl(Float drdl) {
		this.drdl = drdl;
	}

	public Float getZjrl() {
		return zjrl;
	}

	public void setZjrl(Float zjrl) {
		this.zjrl = zjrl;
	}

	public Float getZdl() {
		return zdl;
	}

	public void setZdl(Float zdl) {
		this.zdl = zdl;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<WSInvertEne> getNbq() {
		return nbq;
	}

	public void setNbq(List<WSInvertEne> nbq) {
		this.nbq = nbq;
	}
	
}
