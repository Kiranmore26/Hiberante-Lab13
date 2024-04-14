package Com.Project.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager 
{	
	@Id
	@Column(name = "M_id",length=10)
	private int Manager_id;
	@Column(name = "M_name",length=255)
	private String Manager_name;
	@Column(name = "M_city",length=255)
	private String Manager_city;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(int manager_id, String manager_name, String manager_city) {
		super();
		Manager_id = manager_id;
		Manager_name = manager_name;
		Manager_city = manager_city;
	}
	
	
	public int getManager_id() {
		return Manager_id;
	}
	
	public void setManager_id(int manager_id) {
		Manager_id = manager_id;
	}
	
	public String getManager_name() {
		return Manager_name;
	}
	
	public void setManager_name(String manager_name) {
		Manager_name = manager_name;
	}
	
	public String getManager_city() {
		return Manager_city;
	}
	
	public void setManager_city(String manager_city) {
		Manager_city = manager_city;
	}
	
	
	
	
	
	
}
