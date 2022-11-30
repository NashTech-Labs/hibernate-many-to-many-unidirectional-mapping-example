package com.knoldus.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_ROOM")
public class ClassRoom {

	@Id
	@GeneratedValue
	@Column(name = "CLASS_ROOM_ID")
	private long id;

	@Column(name = "NAME")
	private String name;
	

	public ClassRoom() {

	}

	public ClassRoom(String name) {
		this.name = name;
	}
	 @Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ClassRoom))
            return false;
        ClassRoom other = (ClassRoom) obj;
        if (id != other.id)
            return false;
        if (name == null) {
			return other.name == null;
        } else return name.equals(other.name);
	}
	
	
	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", name=" + name + "]";
	}

}
