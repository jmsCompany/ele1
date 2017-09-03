package qingyun.ele.ws;

import java.util.ArrayList;
import java.util.List;

public class WSSSInv extends Valid implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer seq; //序号
	private String sn; //逆变器序号
	private Float drdl;//当日电量
	private Float ljnl;//累计能量
	private String time; //时间
	private Float wd; //温度
	private Float pl; //频率
    private Integer rowSpan; //合并行数
    private List<WSDCOutput> output = new ArrayList<WSDCOutput>(); //AC 
    private List<WSDCInput> input = new ArrayList<WSDCInput>();  //DC

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Float getDrdl() {
		return drdl;
	}

	public void setDrdl(Float drdl) {
		this.drdl = drdl;
	}

	public Float getLjnl() {
		return ljnl;
	}

	public void setLjnl(Float ljnl) {
		this.ljnl = ljnl;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getWd() {
		return wd;
	}

	public void setWd(Float wd) {
		this.wd = wd;
	}

	public Float getPl() {
		return pl;
	}

	public void setPl(Float pl) {
		this.pl = pl;
	}

	public Integer getRowSpan() {
		return rowSpan;
	}

	public void setRowSpan(Integer rowSpan) {
		this.rowSpan = rowSpan;
	}

	public List<WSDCOutput> getOutput() {
		return output;
	}

	public void setOutput(List<WSDCOutput> output) {
		this.output = output;
	}

	public List<WSDCInput> getInput() {
		return input;
	}

	public void setInput(List<WSDCInput> input) {
		this.input = input;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
