package Com.Project.Employee;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc = new Scanner(System.in);
	public void operation() 
	{
		Employeesworking ew = new Employeesworking();
		DepartmentWorking dw=new DepartmentWorking();
		ManagerWorking mw =new ManagerWorking();
		char ans;
		do
		{
			System.out.println("Do operations on : ");
			System.out.println("1)Employee Table");
			System.out.println("2)Department Table ");
			System.out.println("3)Manager Table");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				ew.operations();
				break;
			case 2:
				dw.operations();
				break;
			case 3:
				mw.operations();
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}
		
			
			System.out.println("DO you want to repeat the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y'|| ans=='y');
		
		
		
	}	
	
	
    public static void main( String[] args ) throws Exception
    {
      App a= new App();
      a.operation();
    }
}
