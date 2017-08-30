package qingyun.ele.ws;

import java.io.Serializable;

public class WSReq implements Serializable {

	private String time;
	private Long id;
	private String type;
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
}
