package Java_Assignment53;
/*
 * This class will help you to master the concepts like Inheritance, Overriding, Abstraction and Logic Building
 */

import java.util.*;
public class Java_Assignment5_3 
{

	public static void main(String[] args) 
	{
		char c;
		String s;
		int no_of_leaves;
		Scanner sc=new Scanner(System.in);
		//Permanent Employee Details
		PermanentEmp pemp=new PermanentEmp();
		System.out.println("\nEnter the Permanent Employee Details");
		pemp.getEmpInfo();		
		pemp.calculate_salary();
		System.out.println("\n Enter type of leave taken : C for casual: p for paid and s for sick");
		s=sc.next();
		c=s.charAt(0);
		   
		   
		System.out.println("Enter the total number days of leave taken");
		no_of_leaves=sc.nextInt();
		if(pemp.avail_leave(no_of_leaves, c))
		{
			pemp.calculate_balance_leaves();
		}
		//Temporary Employee Details
		System.out.println("\nEnter the Temporary Employee Details");
		TemporaryEmp temp=new TemporaryEmp();
		temp.getEmpInfo();		
		temp.calculate_salary();
		System.out.println("\n Enter type of leave taken : C for casual: p for paid and s for sick");
		s=sc.next();
		c=s.charAt(0);
		   
		   
		System.out.println("Enter the total number days of leave taken");
		no_of_leaves=sc.nextInt();
		if(temp.avail_leave(no_of_leaves, c))
		{
			temp.calculate_balance_leaves();
		}
		sc.close();

	}

}

class Employee //Employee Base class
{
    int empId;
    String empName;
    int total_leaves;
    double total_salary;
    int bal_leave;
    int paid_leavetaken,sick_leavetaken,casual_leavetaken;
    int paid_leave,sick_leave,casual_leave;
    double basic,hra,pf;
    Scanner sc=new Scanner(System.in);
    void getEmpInfo() // getEmpInfo method
    {
        System.out.println("Enter EmployeeId: ");
        empId=sc.nextInt();
        System.out.println("Enter EmployeeName: ");
        empName=sc.next();
      
    }
    void calculate_balance_leaves() // calculate_balance_leaves method
    {
         System.out.println("Enter No of leave taken ");
         int leave_taken=sc.nextInt();
         bal_leave=total_leaves-leave_taken;
         System.out.println("Tot balance leave: "+bal_leave);
    }
    boolean avail_leave(int no_of_leaves,char type_of_leave) // avail_leave method
    {
       if(no_of_leaves<bal_leave && type_of_leave=='C')
        return true;
       else
        return false;
       
    }
    void calculate_salary()
    {
      
       
    }
}

class PermanentEmp extends Employee //PermanentEmp derived class
{
	
	 public PermanentEmp() //Constructor
	 {
	     paid_leave=15;
	     sick_leave=10;
	     casual_leave=15;
	 }
	 void print_leave_details() // method for print leave details
	 {
	     System.out.println("Paid leave: "+paid_leave);
	     System.out.println("Sick_leave: "+sick_leave);
	     System.out.println("Casual Leave: "+casual_leave);
	 }
	 void calculate_balance_leaves() // method for  calculate balance leaves
	 {
	     System.out.println("Enter No of casualleave taken ");
	     int casual_leavetaken=sc.nextInt();
	     System.out.println("Enter No of sick_leave lleave taken ");
	     int sick_leavetaken=sc.nextInt();
	     System.out.println("Enter No of casualleave taken ");
	     int paid_leavetaken=sc.nextInt();
	     int bcasual_leave=casual_leave-casual_leavetaken;
	     int bsick_leave=sick_leave-sick_leavetaken;
	     int bpaid_leave=paid_leave-paid_leavetaken;	     
	     System.out.println("Tot balance casual_leave: "+bcasual_leave);
	     System.out.println("Tot balance sick_leave: "+bsick_leave);
	     System.out.println("Tot balance paid_leave: "+bpaid_leave);
	 }
	 boolean avail_leave(int no_of_leaves,char type_of_leave) // method for avail_leave
	{
	  if(no_of_leaves<casual_leave && type_of_leave=='C')
	    return true;
	  else
	    return false;
	}
	 void calculate_salary() // calculate_salary method
	{
	     System.out.println("Enter PermanentEmployee Basic Salary: ");
	     basic=sc.nextDouble();
	     pf=basic*12/100;
	     hra=basic*50/100;
	     total_salary=(basic+hra)-pf;
	     System.out.println("Total Salary of Permanent  Employee : "+total_salary);
	}
}

class TemporaryEmp extends Employee  //TemporaryEmp derived class
{
    TemporaryEmp() //Constructor
    {
	     paid_leave=15;
	     sick_leave=10;
	     casual_leave=15;
    }
    void calculate_balance_leaves() // method for  calculate balance leaves
    {
         System.out.println("Enter No of casualleave taken ");
         int casual_leavetaken=sc.nextInt();
         System.out.println("Enter No of sick_leave lleave taken ");
         int sick_leavetaken=sc.nextInt();
         System.out.println("Enter No of paid taken ");
         int paid_leavetaken=sc.nextInt();
         casual_leave=casual_leave-casual_leavetaken;
         sick_leave=sick_leave-sick_leavetaken;
         paid_leave=paid_leave-paid_leavetaken;
         
         bal_leave=casual_leave+sick_leave+paid_leave;
        
         System.out.println("Tot balance leave: "+bal_leave);
    }
    boolean avail_leave(int no_of_leaves,char type_of_leave) // method for avail_leave
    {
        return true;
    }
    void calculate_salary() // calculate_salary method
    {
         System.out.println("Enter Temporary Employee Salary: ");
         basic=sc.nextDouble();
         pf=(basic*12)/100;
         hra=(basic*50)/100;
         total_salary=(basic+hra)-pf;
         System.out.println("Total Salary of Temporary Employee : "+total_salary);
    }
}