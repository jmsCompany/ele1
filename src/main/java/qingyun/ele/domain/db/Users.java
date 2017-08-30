package qingyun.ele.domain.db;
// Generated 2017-4-17 14:45:18 by Hibernate Tools 3.2.2.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "ele")
public class Users implements java.io.Serializable {

	private Long id;
	private Dic dicByDepartment;
	private Dic dicByRole;
	private Dic dicByPos;
	private Dic dicByEmpStatus;
	private String username;
	private String password;
	private String token;
	private String mobile;
	private String email;
	private String name;
	private Long enabled;
	private Date lastLogin;
	private Long fd;
	private Long ts;
	private Long ycts;
	private Set<Logs> logses = new HashSet<Logs>(0);
	private Set<ProjectSteps> projectStepses = new HashSet<ProjectSteps>(0);

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", length = 19)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "enabled")
	public Long getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	public Users() {
	}

	public Users(Long id, Dic dicByDepartment) {
		this.id = id;
		this.dicByDepartment = dicByDepartment;
	}

	public Users(Long id, Dic dicByDepartment, Dic dicByRole, Dic dicByPos, Dic dicByEmpStatus, String username,
			String password, String token, String mobile, String email, String name, Set<Logs> logses,
			Set<ProjectSteps> projectStepses) {
		this.id = id;
		this.dicByDepartment = dicByDepartment;
		this.dicByRole = dicByRole;
		this.dicByPos = dicByPos;
		this.dicByEmpStatus = dicByEmpStatus;
		this.username = username;
		this.password = password;
		this.token = token;
		this.mobile = mobile;
		this.email = email;
		this.name = name;
		this.logses = logses;
		this.projectStepses = projectStepses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department", nullable = false)
	public Dic getDicByDepartment() {
		return this.dicByDepartment;
	}

	public void setDicByDepartment(Dic dicByDepartment) {
		this.dicByDepartment = dicByDepartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	public Dic getDicByRole() {
		return this.dicByRole;
	}

	public void setDicByRole(Dic dicByRole) {
		this.dicByRole = dicByRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pos")
	public Dic getDicByPos() {
		return this.dicByPos;
	}

	public void setDicByPos(Dic dicByPos) {
		this.dicByPos = dicByPos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_status")
	public Dic getDicByEmpStatus() {
		return this.dicByEmpStatus;
	}

	public void setDicByEmpStatus(Dic dicByEmpStatus) {
		this.dicByEmpStatus = dicByEmpStatus;
	}

	@Column(name = "username", length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "token", length = 128)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Logs> getLogses() {
		return this.logses;
	}

	public void setLogses(Set<Logs> logses) {
		this.logses = logses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<ProjectSteps> getProjectStepses() {
		return this.projectStepses;
	}

	public void setProjectStepses(Set<ProjectSteps> projectStepses) {
		this.projectStepses = projectStepses;
	}
	@Column(name = "fd")
	public Long getFd() {
		return fd;
	}

	public void setFd(Long fd) {
		this.fd = fd;
	}
	@Column(name = "ts")
	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
	@Column(name = "ycts")
	public Long getYcts() {
		return ycts;
	}

	public void setYcts(Long ycts) {
		this.ycts = ycts;
	}

}
