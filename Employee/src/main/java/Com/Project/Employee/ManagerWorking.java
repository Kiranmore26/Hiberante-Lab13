package Com.Project.Employee;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManagerWorking 
{
	Scanner sc = new Scanner(System.in);
	public void insert() 
	{
		char ans;
		do
		{
			
			Session session=HibernateUtil.getsession();
			Manager m = new Manager();
			
			System.out.println("Enter Manager id");
			m.setManager_id(sc.nextInt());
			System.out.println("Enter Manager Name");
			m.setManager_name(sc.next());
			System.out.println("Enter Manager City");
			m.setManager_city(sc.next());
			
			Transaction tx=session.beginTransaction();
			session.save(m);
			tx.commit();
			session.close();
			
			System.out.println("Do you want repeat the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');		
	}
	
	public void display() 
	{
		Session session=HibernateUtil.getsession();
		Transaction tx=session.beginTransaction();
		
		
		Query q=session.createQuery("from Manager ");
		List<Manager> li =q.getResultList();
		
		System.out.println("Manager_id\tManager_Name\tCity");
		for(Manager m:li)
		{
			System.out.println(m.getManager_id()+"\t\t"+m.getManager_name()+"\t\t"+m.getManager_city());
		}
				
	}
	
	public void operations() 
	{
		
		char ans;
		do
		{

			System.out.println("Choose From Below options ");
			System.out.println("1) To insert value into table ");
			System.out.println("2) To Display the table ");

			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				insert();
				break;
			case 2:
				display();
				break;

			default:
				System.out.println("Wrong Input ");
				break;
			}
			
			
			System.out.println("do you want to repeat the process");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
		
	}

}
