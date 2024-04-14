package Com.Project.Employee;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Employeesworking 
{
	Scanner sc = new Scanner(System.in);
	public void insert()
	{
		char ans;
		do
		{
			Session session=HibernateUtil.getsession();
			
			Employee e=new Employee();

			System.out.println("Enter Employee Name");
			e.setEmp_name(sc.next());
			System.out.println("Enter Employee Salary");
			e.setEmp_salary(sc.nextInt());
			System.out.println("Enter Employee Age");
			e.setEmp_age(sc.nextInt());
			System.out.println("Enter Employee Gender");
			e.setEmp_gender(sc.next());
			
			
			System.out.println("Enter Employee Deparatment No");
			int Dep_id=sc.nextInt();
			Department dp=session.get(Department.class, Dep_id);
			
			if(dp!= null)
			{
				e.setEmp_Dept(dp);
			}
			else
			{
				System.err.println(" Thier is no Department "+Dep_id+"  with this Id");
			}
			
			
			
			System.out.println("Enter Employee Manager Id No");
			int Manager_id=sc.nextInt();
			
			Manager m= session.get(Manager.class, Manager_id);
			
			if(m!=null)
			{
				e.setEmp_manager_idno(m);
			}
			else
			{
				System.err.println("Manager No  " +Manager_id+" Does not Exsits");
			}
			
			
			Transaction tx=session.beginTransaction();
			session.save(e);
			tx.commit();
			session.save(e);
			
			
			System.out.println("Do you want to insert again");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
			
		
	}
	
	
	public void display()
	{
		Session session=HibernateUtil.getsession();
		Transaction tx=session.beginTransaction();
		
		Query Q=session.createQuery("From Employee");
		
		List<Employee> li=Q.getResultList();
		
		System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
		for(Employee e:li)
		{
			System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
		}
		tx.commit();
		session.close();
	}
	
	
	public void customize()
	{
		char ans;
		
		do 
		{
			Session session=HibernateUtil.getsession();
			Transaction tx=session.beginTransaction();
			
			System.out.println("Enter Your Choose ");
			System.out.println("1)By Name ");
			System.out.println("2)By Salary ");
			System.out.println("3)By Age ");
			System.out.println("4)By Gender ");
			System.out.println("5)By Department No ");
			System.out.println("6)By Manager Id No  ");
			int Choice=sc.nextInt();
			switch (Choice) {
			case 1:
				System.out.println("Enter Name that You want to search ");
				String Name=sc.next();
				
				List<Employee> li=session.createQuery("from Employee where EMp_Name=:Name").
						setParameter("Name", Name).getResultList();
				
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
				for(Employee e:li)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}
				
				
				break;
			case 2:
				System.out.println("Enter Salary Range From :");
				int S_Sal=sc.nextInt();
				System.out.println("Enter Salary Range TO:");
				int E_Sal=sc.nextInt();	
				List<Employee> li1=session.createQuery("from Employee where Emp_Salary between :S_Sal and :E_Sal").
						setParameter("S_Sal", S_Sal).setParameter("E_Sal", E_Sal).getResultList();
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");			
				for(Employee e:li1)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}	
				
				break;
			case 3:
				System.out.println("Enter Age Range From :");
				int S_Age=sc.nextInt();
				System.out.println("Enter Age Range TO:");
				int E_Age=sc.nextInt();	
				List<Employee> li2=session.createQuery("from Employee where Emp_Age between :S_Age and :E_Age").
						setParameter("S_Age", S_Age).setParameter("E_Age", E_Age).getResultList();
				
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
				for(Employee e:li2)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}
				
				break;
			case 4:
				System.out.println("Enter the Gender ");
				String Gender=sc.next();
				
				List<Employee> li4=session.createQuery("from Employee where Emp_Gender=:Gender").
						setParameter("Gender", Gender).getResultList();
				
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
				for(Employee e:li4)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}
				
				break;
			case 5:
				System.out.println("Enter Department No :");
				int Department=sc.nextInt();
				
				List<Employee> li5=session.createQuery("from Employee where Emp_Department =:Department").
						setParameter("Department", Department).getResultList();
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
				for(Employee e:li5)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}
				
				break;
			case 6:
				System.out.println("Enter the Manger id whose details you want to see");
				int Manager=sc.nextInt();
				
				List<Employee> li6=session.createQuery("from Employee where Emp_Manager =:Manager").
						setParameter("Manager", Manager).getResultList();
				System.out.println("Id\tEmp_Name\tEmp_Salary\tEmp_Age\tEmp_Gender\tEmp_depart\tEmp_Manager");
				for(Employee e:li6)
				{
					System.out.println(e.getEmp_id()+"\t"+e.getEmp_name()+"\t\t"+e.getEmp_salary()+"\t\t"+e.getEmp_age()+"\t"+e.getEmp_gender()+"\t\t"+e.getEmp_Dept()+"\t\t"+e.getEmp_manager_idno());
				}
				
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}		
		
			System.out.println("Do you want to repat the process ");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='Y' || ans=='y');	
	}
	
	
	
	public void Update()
	{
		
		
		char ans;
		do
		{

			Session session=HibernateUtil.getsession();
			Transaction tx=session.beginTransaction();
			
			System.out.println("Enter Your Choose ");
			System.out.println("1)Update  Name");
			System.out.println("2)Update  Salary");
			System.out.println("3)Update  Age ");
			System.out.println("4)Update  Gender ");
			System.out.println("5)Update  Department No ");
			System.out.println("6)Update  Manager Id No  ");
			int Choice=sc.nextInt();
			switch (Choice) {
			case 1:
				System.out.println("Enter the Id that you want to Update ");
				int id2=sc.nextInt();
				
				Employee e2=session.get(Employee.class, id2);
				
				System.out.println("Enter New Name That you want to update ");
				e2.setEmp_name(sc.next());
				
				tx.commit();
				session.close();
				break;
			case 2:
				System.out.println("Enter the Id that you want to Update ");
				int id3=sc.nextInt();
				
				Employee e3=session.get(Employee.class, id3);
				
				System.out.println("Enter New Salary That you want to update ");
				e3.setEmp_salary(sc.nextInt());
				tx.commit();
				session.close();
				break;
			case 3:
				System.out.println("Enter the Id that you want to Update ");
				int id4=sc.nextInt();
				
				Employee e4=session.get(Employee.class, id4);
				
				System.out.println("Enter New Age That you want to update ");
				e4.setEmp_age(sc.nextInt());
				tx.commit();
				session.close();
				break;
			case 4:
				System.out.println("Enter the Id that you want to Update ");
				int id5=sc.nextInt();
				
				Employee e5=session.get(Employee.class, id5);
				
				System.out.println("Enter New Gender That you want to update ");
				e5.setEmp_gender(sc.next());
				tx.commit();
				session.close();
				break;
			case 5:
				System.out.println("Enter the Id that you want to Update ");
				int id6=sc.nextInt();
				
				Employee e6=session.get(Employee.class, id6);
				
				System.out.println("Enter New Department No That you want to update ");
				e6.setEmp_gender(sc.next());
				tx.commit();
				session.close();
				break;
			case 6:
				System.out.println("Enter the Id that you want to Update ");
				int id7=sc.nextInt();
				
				Employee e7=session.get(Employee.class, id7);
				
				System.out.println("Enter New Manager No That you want to update ");
				e7.setEmp_gender(sc.next());
				tx.commit();
				session.close();
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}
			System.out.println("Do you want to delete the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');

		
		
		
		
	}
	
	
	public void delete ()
	{
		char ans;
		do
		{
			Session session=HibernateUtil.getsession();
			Transaction tx=session.beginTransaction();
			
			System.out.println("Enter the id that you want to delete : ");
			int id=sc.nextInt();
			
			Employee e=session.get(Employee.class, id);
			
			session.delete(e);
			tx.commit();
			session.close();
			
			System.out.println("Do you want to delete the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
	}
	

	
	public void operations () 
	{
		char ans;
		do
		{
			System.out.println("Enter a choose  for Employee");
			System.out.println("1) insert into Employee table ");
			System.out.println("2) Display Entier Table of Employee ");
			System.out.println("3) Customize Employee table ");
			System.out.println("4) Update values into Employee table ");
			System.out.println("5) Delete values from Employee table ");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				display();
				break;
			case 3:
				customize();
				break;
			case 4:
				Update();
				break;
			case 5:
				delete();
				break;

			default:
				break;
			}
		
		
			System.out.println("Do you want to repeat the process");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
		
		
	}
	
}
