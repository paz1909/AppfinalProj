package il.good.neighbor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "maps")
public class Map implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Boolean isSaved;
	private Boolean isChosenToday;
	private String areaName;
	private Volunteer permanentVolunteer;
	private Volunteer temporaryVolunteer;
	private Set<Family> families = new HashSet<>();

	public Map() {
	}

	public Map(Boolean isSaved, Boolean isChosenToday, String areaName, Volunteer permanentVolunteer, Volunteer temporaryVolunteer) {
		this.isSaved = isSaved;
		this.isChosenToday = isChosenToday;
		this.areaName = areaName;
		this.permanentVolunteer = permanentVolunteer;
		this.temporaryVolunteer = temporaryVolunteer;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getMapId() {
		return id;
	}

	public void setMapId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne()
	@JoinColumn(name = "perm_volunteer_id", nullable = true)
	public Volunteer getPermanentVolunteer() {
		return this.permanentVolunteer;
	}

	public void setPermanentVolunteer(Volunteer permanentVolunteer) {
		this.permanentVolunteer = permanentVolunteer;
	}
	
	@OneToOne()
	@JoinColumn(name = "temp_volunteer_id", nullable = true)
	public Volunteer getTemporaryVolunteer() {
		return this.temporaryVolunteer;
	}

	public void setTemporaryVolunteer(Volunteer temporaryVolunteer) {
		this.temporaryVolunteer = temporaryVolunteer;
	}

	@Column(name = "isSaved" , nullable = false)
	public Boolean getIsSaved() {
		return this.isSaved;
	}

	public void setIsSaved(Boolean isSaved) {
		this.isSaved = isSaved;
	}

	@Column(name = "isChosenToday", nullable = false)
	public Boolean getIsChosenToday() {
		return this.isChosenToday;
	}

	public void setIsChosenToday(Boolean isChosenToday) {
		this.isChosenToday = isChosenToday;
	}

	@Column(name = "areaName", nullable = false, length = 45)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@OneToMany(mappedBy = "map", fetch = FetchType.EAGER)
	public Set<Family> getFamilies() {
		return this.families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}
	
	@Override
	public String toString() {
		return "Map [id=" + id + ", isSaved=" + isSaved + ", isChosenToday="
				+ isChosenToday + ", areaName=" + areaName + ", volunteer="
				+ permanentVolunteer + ", families=" + families + "]";
	}

}
