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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SubLocation generated by hbm2java
 */
@Entity
@Table(name = "sub_location", catalog = "ele")
public class SubLocation implements java.io.Serializable {

	private Long id;
	private String name;
	private Long enabled;
	private Set<SubSubLocation> subSubLocations = new HashSet<SubSubLocation>(0);
	private Location location;

	public SubLocation() {
	}

	public SubLocation(Long id) {
		this.id = id;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subLocation")
	public Set<SubSubLocation> getSubSubLocations() {
		return this.subSubLocations;
	}

	public void setSubSubLocations(Set<SubSubLocation> subSubLocations) {
		this.subSubLocations = subSubLocations;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_location")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "enabled")
	public Long getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

}
