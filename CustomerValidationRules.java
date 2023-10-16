package day10;

import java.time.LocalDate;
import java.util.List;

public class CustomerValidationRules {

	public static void duplicateCustomer(String email,List<Customer>array) throws CustomerException
	{
		Customer temp=new Customer(email);
		if(array.contains(temp))
		{
			throw new CustomerException("Email not valid !");
		}
		
	}
	public static ServicePlan validateEnum (String name,double regprice) throws IllegalArgumentException,CustomerException
	{
		ServicePlan temp=ServicePlan.valueOf(name);
		if(temp.getCharges()==regprice)
		{
			return temp;
		}
		throw new CustomerException("Registration price invalid !");
		
	}
	public static int emailValidation(String email,List<Customer>array) throws CustomerException
	{
		Customer temp=new Customer(email);
		int index=array.indexOf(temp);
		if(index==-1)
		{
			throw new CustomerException("Email not valid !");
		}
		return index;	
	}
	public static Customer passwordValidation(String password,int index,List<Customer>array) throws CustomerException
	{
		Customer temp=array.get(index);
		if(temp.getPassword().equals(password))
		return temp;
		
		throw new CustomerException("Wrong Password !");
	}
	public static Customer signUp(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, String plan,List<Customer>array) throws CustomerException
	{
		duplicateCustomer(email,array);
		ServicePlan tempenum=validateEnum(plan,registrationAmount);
		return new Customer(firstName,lastName,email,password,registrationAmount,dob,tempenum);//Signup Validation complite
	}
	public static Customer signInValidation(String email,String password,List<Customer>array) throws CustomerException
	{
		int index=emailValidation(email,array);
		Customer temp=passwordValidation(password,index,array);
		return temp;
	}
}
	


