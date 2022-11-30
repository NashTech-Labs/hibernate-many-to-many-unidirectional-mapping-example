package com.knoldus.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 6832006422622219737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "ENTERING_DATE", nullable = false)
	private Date enteringDate;

	@Column(name = "NATIONALITY", nullable = false)
	private String nationality;

	@Column(name = "CODE", nullable = false)
	private String code;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_CLASS_ROOM", 
             joinColumns = { @JoinColumn(name = "ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "CLASS_ROOM_ID") })	
	private List<ClassRoom> classRooms = new ArrayList<ClassRoom>();

	public Student() {

	}

	public Student(String name, Date enteringDate, String nationality, String code) {
		this.name = name;
		this.enteringDate = enteringDate;
		this.nationality = nationality;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setEnteringDate(Date enteringDate) {
		this.enteringDate = enteringDate;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCode() {
		return code;
	}

	public Date getEnteringDate() {
		return enteringDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}
	
	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}
	
	
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Student))
	            return false;
	        Student other = (Student) obj;
			return id == other.id;
		}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", enteringDate=" + enteringDate.toString() + ", nationality="
				+ nationality + ", code=" + code +", classRooms=" + classRooms + "]";
	}
}