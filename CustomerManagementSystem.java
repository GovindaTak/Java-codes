package day10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static day10.CustomerValidationRules.*;
public class CustomerManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;Customer temp;
		List<Customer>customerList=new ArrayList<>();
		
		try(Scanner sc=new Scanner(System.in))
		{
			while(!flag)
			{
				try {
					System.out.println("options :- \n1)Signup \n2)SignIn \n3)Change password\n4)Un subscribe customer\n5)Display all details\n6)exit\n chooes option: ");
					switch(sc.nextInt())
					{
					case 1: System.out.println("we have following plans : ");
							for(ServicePlan p:ServicePlan.values())
								System.out.println(p);
							System.out.println("enter complete details as : firstName,lastName,email,password,registrationAmount,(YYYY-MM-DD)dob and ServicePlan_Name ");
							temp=signUp(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()),sc.next().toUpperCase(),customerList);
							customerList.add(temp);
							System.out.println("Succesfully added !");
							break;
					case 2:System.out.println("enter email and password :");
							temp=signInValidation(sc.next(),sc.next(),customerList);
							System.out.println(temp);
							break;
					case 3:System.out.println("enter email,old_password :");
							temp=signInValidation(sc.next(),sc.next(),customerList);
							System.out.println("enter NEW password :");
							temp.setPassword(sc.next());
							break;
					case 4:System.out.println("enter email :");
							int index=emailValidation(sc.next(),customerList);
							//temp=customerList.get(index); not need
							System.out.println(customerList.remove(index));
							System.out.println("Succesfully removed !");
							break;
					case 5:System.out.println("All Customer details as : ");
							for(Customer t:customerList)
								System.out.println(t);
							break;
					case 6:flag=true;
							System.out.println("Bye !");
							break;
					default: System.out.println("enter correct choice !");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println(e.getMessage());
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
