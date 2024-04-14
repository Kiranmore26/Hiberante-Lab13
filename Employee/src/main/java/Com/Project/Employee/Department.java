package Com.Project.Employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department 
{
	@Id
	@Column(name = "Dept_id",length = 10)
	private int dept_id;
	
	@Column(name = "Dept_Name",length = 255)
	private String dept_name;
	@Column(name = "Dept_Postion",length = 255)
	private String dept_postion;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public Department(int dept_id, String dept_name, String dept_postion) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_postion = dept_postion;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_postion() {
		return dept_postion;
	}
	public void setDept_postion(String dept_postion) {
		this.dept_postion = dept_postion;
	}

	
	
	
}
