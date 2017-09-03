package qingyun.ele.ws;

import java.io.Serializable;

public class WSDCOutput implements Serializable {

	private String xw; //相位
	private Float dl;//电流
	private Float dy; //电压
	private Float gl;//功率
	

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
	public Float getGl() {
		return gl;
	}
	public void setGl(Float gl) {
		this.gl = gl;
	}
	public String getXw() {
		return xw;
	}
	public void setXw(String xw) {
		this.xw = xw;
	}
	
}
