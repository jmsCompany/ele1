package qingyun.ele.domain.db;
// Generated 2017-6-25 10:39:13 by Hibernate Tools 3.2.2.GA


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustomerDevice generated by hbm2java
 */
@Entity
@Table(name="customer_device"
    ,catalog="ele"
)
public class CustomerDevice  implements java.io.Serializable {


     private Long id;
     private Long idCustomer;    //项目Id
     private String inverterSn;  //逆变器序列号
     private String dataloggerSn; //采集器序列号
     private String inverterAlias; //逆变器别名
     private String dataloggerAlias; //采集器别名
     private String inverterType;   
     private Long status;   //故障，正常
     private Date lastUpdated;
     private Long createdBy;
     
     private Float vol; //初容量
     private Long idx; //序号
     private Long deleted; //是否删除
     private Long online; //在线
     
    

    public CustomerDevice() {
    }

	
    public CustomerDevice(Long id, Long idCustomer) {
        this.id = id;
        this.idCustomer = idCustomer;
    }
    public CustomerDevice(Long id, Long idCustomer, String inverterSn, String dataloggerSn, String inverterAlias, String dataloggerAlias, String inverterType, Long status, Date lastUpdated, Long createdBy) {
       this.id = id;
       this.idCustomer = idCustomer;
       this.inverterSn = inverterSn;
       this.dataloggerSn = dataloggerSn;
       this.inverterAlias = inverterAlias;
       this.dataloggerAlias = dataloggerAlias;
       this.inverterType = inverterType;
       this.status = status;
       this.lastUpdated = lastUpdated;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="id_customer", nullable=false)
    public Long getIdCustomer() {
        return this.idCustomer;
    }
    
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    
    @Column(name="inverter_sn", length=64)
    public String getInverterSn() {
        return this.inverterSn;
    }
    
    public void setInverterSn(String inverterSn) {
        this.inverterSn = inverterSn;
    }
    
    @Column(name="datalogger_sn", length=64)
    public String getDataloggerSn() {
        return this.dataloggerSn;
    }
    
    public void setDataloggerSn(String dataloggerSn) {
        this.dataloggerSn = dataloggerSn;
    }
    
    @Column(name="inverter_alias", length=64)
    public String getInverterAlias() {
        return this.inverterAlias;
    }
    
    public void setInverterAlias(String inverterAlias) {
        this.inverterAlias = inverterAlias;
    }
    
    @Column(name="datalogger_alias", length=64)
    public String getDataloggerAlias() {
        return this.dataloggerAlias;
    }
    
    public void setDataloggerAlias(String dataloggerAlias) {
        this.dataloggerAlias = dataloggerAlias;
    }
    
    @Column(name="inverter_type", length=64)
    public String getInverterType() {
        return this.inverterType;
    }
    
    public void setInverterType(String inverterType) {
        this.inverterType = inverterType;
    }
    
    @Column(name="status")
    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updated", length=19)
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    @Column(name="created_by")
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="vol", precision=12, scale=0)
	public Float getVol() {
		return vol;
	}


	public void setVol(Float vol) {
		this.vol = vol;
	}


	public Long getIdx() {
		return idx;
	}


	public void setIdx(Long idx) {
		this.idx = idx;
	}


	public Long getDeleted() {
		return deleted;
	}


	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}


	public Long getOnline() {
		return online;
	}


	public void setOnline(Long online) {
		this.online = online;
	}




}


