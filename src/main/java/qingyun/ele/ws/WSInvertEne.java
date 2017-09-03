package qingyun.ele.ws;

public class WSInvertEne implements java.io.Serializable {


	private String sn; //逆变器序列号
	private Float dl;  //电量
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Float getDl() {
		return dl;
	}
	public void setDl(Float dl) {
		this.dl = dl;
	}

	

}
