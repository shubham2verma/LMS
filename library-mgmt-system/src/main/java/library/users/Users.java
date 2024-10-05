package library.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	private String 	id;
	private String 	name;
//	private String 	branch;
//	private String semester;
	
	public Users() {

	}
	
	public Users(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	public String getBranch() {
//		return branch;
//	}
//
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//
//	public String getSemester() {
//		return semester;
//	}
//
//	public void setSemester(String semester) {
//		this.semester = semester;
//	}
	
}
