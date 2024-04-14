package Com.Project.Employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee 
{
	@Id
	@Column(name = "Emp_id",length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Emp_id;
	@Column(name = "Emp_Name",length = 255)
	private String Emp_name;
	@Column(name = "Emp_Salary",length = 10)
	private int Emp_salary;
	@Column(name = "Emp_Age",length = 10)
	private int Emp_age;
	@Column(name = "Emp_Gender",length = 255)
	private String Emp_gender;
	
	
	@ManyToOne
	@JoinColumn(name = "M_id")
	private Manager Emp_manager_idno;
	
	
	@ManyToOne
	@JoinColumn(name="Dept_id")
	private Department Emp_Dept ;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int emp_id, String emp_name, int emp_salary, int emp_age, String emp_gender,
			Manager emp_manager_idno, Department emp_Dept) {
		super();
		Emp_id = emp_id;
		Emp_name = emp_name;
		Emp_salary = emp_salary;
		Emp_age = emp_age;
		Emp_gender = emp_gender;
		Emp_manager_idno = emp_manager_idno;
		Emp_Dept = emp_Dept;
	}


	public int getEmp_id() {
		return Emp_id;
	}


	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}


	public String getEmp_name() {
		return Emp_name;
	}


	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}


	public int getEmp_salary() {
		return Emp_salary;
	}


	public void setEmp_salary(int emp_salary) {
		Emp_salary = emp_salary;
	}


	public int getEmp_age() {
		return Emp_age;
	}


	public void setEmp_age(int emp_age) {
		Emp_age = emp_age;
	}


	public String getEmp_gender() {
		return Emp_gender;
	}


	public void setEmp_gender(String emp_gender) {
		Emp_gender = emp_gender;
	}


	public Manager getEmp_manager_idno() {
		return Emp_manager_idno;
	}


	public void setEmp_manager_idno(Manager emp_manager_idno) {
		Emp_manager_idno = emp_manager_idno;
	}


	public Department getEmp_Dept() {
		return Emp_Dept;
	}


	public void setEmp_Dept(Department emp_Dept) {
		Emp_Dept = emp_Dept;
	}
	
	
	
	
		
}
