package il.good.neighbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "families")
public class Family implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String city;
	private String street;
	private int streetNumber;
	private int houseNumber;
	private String comments;
	private Map map;

	public Family() {
	}

	public Family(String firstName, String lastName,
			String phoneNumber, String city, String street, int streetNumber,
			int houseNumber, String comments, Map map) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.houseNumber = houseNumber;
		this.comments = comments;
		this.map = map;
	}
	
	public Family(String firstName, String lastName,
			String phoneNumber, String city, String street, int streetNumber,
			int houseNumber, String comments) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.houseNumber = houseNumber;
		this.comments = comments;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@Column(name = "phoneNumber", nullable = false, length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "city", nullable = false, length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "street", nullable = false, length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "streetNumber", nullable = false)
	public int getStreetNumber() {
		return this.streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Column(name = "houseNumber", nullable = false)
	public int getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Column(name = "comments", length = 45)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@ManyToOne
	@JoinColumn(name = "Map_id", nullable = true)
	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", city=" + city
				+ ", street=" + street + ", streetNumber=" + streetNumber
				+ ", houseNumber=" + houseNumber + ", comments=" + comments
				+ "]";
	}
}
