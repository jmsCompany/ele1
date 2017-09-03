package qingyun.ele.ws;

import java.io.Serializable;

public class WSReq implements Serializable {

	private String time;
	private Long id;
	private String type;
	//1直流输入电压，2直流输入电流，3交流输出电压，4交流输出电流，5，交流输出功率，6交流输出频率，7温度，8累计能量
	private Integer stype;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStype() {
		return stype;
	}
	public void setStype(Integer stype) {
		this.stype = stype;
	}
}
