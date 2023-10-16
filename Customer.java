package day10;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator; 
	static {idGenerator=0;}
	public Customer(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		super();
		this.id =++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}
	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
			{	Customer temp=(Customer)obj;
			return email.equals(temp.email);
			}
	return false;
			}
	@Override
	public String toString() {
		return "Customer details: id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan=" + plan;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String s)
	{
		password=s;
		System.out.println("Password Succesfully updated !");
	}
	
	}
	
	

