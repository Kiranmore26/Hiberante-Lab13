package Com.Project.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static final SessionFactory sessionfactory=getSessionFactory();
	
	private static SessionFactory getSessionFactory() 
	{
		
		try 
		{
			return new Configuration().configure().
					addAnnotatedClass(Employee.class).
					addAnnotatedClass(Department.class).
					addAnnotatedClass(Manager.class).
					buildSessionFactory();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static Session getsession()
	{
		return sessionfactory.openSession();
	}
}
