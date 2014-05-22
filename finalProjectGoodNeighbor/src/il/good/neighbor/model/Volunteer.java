package il.good.neighbor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "volunteers")
public class Volunteer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private boolean isComing;
	private boolean isApproved;
	private Set<Map> maps;
	private Map tempMap;

	public Volunteer() {
	}

	public Volunteer(String id, String firstName, String lastName, String email,
			String phoneNumber, String userName, String password,
			boolean isComing) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.isComing = isComing;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "firstName", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phoneNumber", nullable = false, length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "userName", unique = true, nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "permanentVolunteer", fetch = FetchType.EAGER)
	public Set<Map> getMaps() {
		return this.maps;
	}

	public void setMaps(Set<Map> maps) {
		this.maps = maps;
	}
	
	@OneToOne(mappedBy = "temporaryVolunteer")
	public Map getTempMap() {
		return tempMap;
	}

	public void setTempMap(Map tempMap) {
		this.tempMap = tempMap;
	}
	
	@Column(name = "isComing", nullable = false)
	public boolean isComing() {
		return isComing;
	}

	public void setComing(boolean isComing) {
		this.isComing = isComing;
	}

	@Column(name = "isApproved", nullable = false)
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName
				+ ", password=" + password + ", isComing=" + isComing
				+ ", isApproved=" + isApproved + ", maps=" + maps + "]";
	}
	
	
}

