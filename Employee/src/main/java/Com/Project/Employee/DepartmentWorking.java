package Com.Project.Employee;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentWorking 
{
	Scanner sc = new Scanner(System.in);
	public void insert ()
	{
		char ans;
		do
		{
			Session session =HibernateUtil.getsession();
			Department d = new Department();
			System.out.println("Enter Department Id ");
			d.setDept_id(sc.nextInt());
			System.out.println("Enter Department Name ");
			d.setDept_name(sc.next());
			System.out.println("Enter The position ");
			d.setDept_postion(sc.next());
			Transaction tx = session.beginTransaction();
			session.save(d);
			tx.commit();
			session.close();
			
			System.out.println("Do you want to insert something else :");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');	
	}
	
	
	public void Display() 
	{
		Session session=HibernateUtil.getsession();
		Transaction tx =session.beginTransaction();
		
		Query Q=session.createQuery("from Department");
		
		List<Department> li =Q.getResultList();
		
		System.out.println("Department_Id\tDepartment_Name\t\tDepartment_position");
		for(Department d:li)
		{
			System.out.println("   "+d.getDept_id()+"\t\t"+d.getDept_name()+"\t\t"+d.getDept_postion());
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
			
			System.out.println("Enter your Choose");
			System.out.println("1)By Department id");
			System.out.println("2)By Department Name");
			System.out.println("3)By Department Position");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("Enter the Id Whose Details you want to see");
				int id=sc.nextInt();
				
				List<Department> li=session.createQuery(" from Department where Dept_id=:id").
						setParameter("id", id).getResultList();
				
				System.out.println("Department_Id\tDepartment_Name\t\tDepartment_position");
				for(Department d:li)
				{
					System.out.println("  "+d.getDept_id()+"\t\t"+d.getDept_name()+"\t\t"+d.getDept_postion());
				}
				
				break;
			case 2:
				System.out.println("Enter th department name whose detail you want to see");
				String d_name=sc.next();
				
				List<Department> li2=session.createQuery("from Department where Dept_Name =:d_name").
						setParameter("d_name", d_name).getResultList();
				System.out.println("Department_Id\tDepartment_Name\t\tDepartment_position");
				for(Department d:li2)
				{
					System.out.println("  "+d.getDept_id()+"\t\t"+d.getDept_name()+"\t\t"+d.getDept_postion());
				}
				
				break;
			case 3:
				System.out.println("Enter the position Name ");
				String position=sc.next();
				
				List<Department> li3=session.createQuery("from Department where Dept_Postion =:position").
						setParameter("position", position).getResultList();
				System.out.println("Department_Id\tDepartment_Name\t\tDepartment_position");
				for(Department d:li3)
				{
					System.out.println("  "+d.getDept_id()+"\t\t"+d.getDept_name()+"\t\t"+d.getDept_postion());
				}
				break;

			default:
				break;
			}
			
			System.out.println("Do you want to repeat the process");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
		
	}
	
	public void update() 
	{
		Session session=HibernateUtil.getsession();
		Transaction tx=session.beginTransaction();
		
		System.out.println("What do you want to update ");
		System.out.println("1) Department Name ");
		System.out.println("2) Department position ");
		int choice=sc.nextInt();
		
		switch (choice) 
		{
		case 1:
			System.out.println("Enter The Department No that you want to update ");
			int d_id2=sc.nextInt();
			
			Department d2=session.get(Department.class, d_id2);
			System.out.println("Enter new department name ");
			d2.setDept_name(sc.next());
			
			session.save(d2);
			tx.commit();
			session.close();
			break;
		case 2:
			System.out.println("Enter The Department No that you want to update ");
			int d_id3=sc.nextInt();
			
			Department d3=session.get(Department.class, d_id3);
			System.out.println("Enter new department position ");
			d3.setDept_postion(sc.next());
			
			session.save(d3);
			tx.commit();
			session.close();
			break;

		default:
			System.out.println("Wrong input");
			break;
		}
	}
	
	
	public void delete() 
	{
		Session session =HibernateUtil.getsession();
		Transaction tx=session.beginTransaction();
		
		System.out.println("Enter the id that you want to delete ");
		int id=sc.nextInt();
		
		Department d=session.get(Department.class, id);
		session.delete(d);
		tx.commit();
		session.close();
		
		
	}
	
	public void operations() 
	{
		char ans;
		do
		{
			System.out.println("Choose From Below options ");
			System.out.println("1) To insert value into table ");
			System.out.println("2) To Display the table ");
			System.out.println("3) To Display Customize table");
			System.out.println("4) TO Update the value in table ");
			System.out.println("5) TO delete the value from the table ");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				insert();
				break;
			case 2:
				Display();
				break;
			case 3:
				customize();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}
			
			System.out.println("Do you want to repeat the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y'  || ans=='y');
		
	}
}
