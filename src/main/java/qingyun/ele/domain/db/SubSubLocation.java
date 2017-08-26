package qingyun.ele.domain.db;
// Generated 2017-4-17 14:45:18 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SubSubLocation generated by hbm2java
 */
@Entity
@Table(name = "sub_sub_location", catalog = "ele")
public class SubSubLocation implements java.io.Serializable {

	private Long id;
	private SubLocation subLocation;
	private String name;
	private Long enabled;
	private String code;
	private Set<Dic> dics = new HashSet<Dic>(0);
	private Set<Customer> customers = new HashSet<Customer>(0);

	public SubSubLocation() {
	}

	public SubSubLocation(Long id) {
		this.id = id;
	}

	public SubSubLocation(Long id, SubLocation subLocation, String name, Set<Dic> dics, Set<Customer> customers) {
		this.id = id;
		this.subLocation = subLocation;
		this.name = name;
		this.dics = dics;
		this.customers = customers;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sub_loc")
	public SubLocation getSubLocation() {
		return this.subLocation;
	}

	public void setSubLocation(SubLocation subLocation) {
		this.subLocation = subLocation;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "role_locations", catalog = "ele", joinColumns = {
			@JoinColumn(name = "id_sub_sub_location", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", nullable = false, updatable = false) })
	public Set<Dic> getDics() {
		return this.dics;
	}

	public void setDics(Set<Dic> dics) {
		this.dics = dics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subSubLocation")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Column(name = "enabled")
	public Long getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	@Column(name = "code",length = 45)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}