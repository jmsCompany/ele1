package qingyun.ele.ws;


public class WSDataCollect{

	private String sn; //序列号
	private Float fdgl; //发电功率
	private String zt; // 状态
	private Float drfd; //当日发电
	private Float ljfd; //累计发电
	private String cwxx; //错误信息
	private String pic; //图片
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Float getFdgl() {
		return fdgl;
	}
	public void setFdgl(Float fdgl) {
		this.fdgl = fdgl;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public Float getDrfd() {
		return drfd;
	}
	public void setDrfd(Float drfd) {
		this.drfd = drfd;
	}
	public Float getLjfd() {
		return ljfd;
	}
	public void setLjfd(Float ljfd) {
		this.ljfd = ljfd;
	}
	public String getCwxx() {
		return cwxx;
	}
	public void setCwxx(String cwxx) {
		this.cwxx = cwxx;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

	
}
