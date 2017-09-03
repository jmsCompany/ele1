package qingyun.ele.ws;

import java.io.Serializable;

public class WSDCInput implements Serializable {

	private String hl; //回路
	private Float dl;//电流
	private Float dy; //电压
	
	public String getHl() {
		return hl;
	}
	public void setHl(String hl) {
		this.hl = hl;
	}
	public Float getDl() {
		return dl;
	}
	public void setDl(Float dl) {
		this.dl = dl;
	}
	public Float getDy() {
		return dy;
	}
	public void setDy(Float dy) {
		this.dy = dy;
	}
	
}
