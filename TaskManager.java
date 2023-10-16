package extra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean flag=false; List<Task>taskList=new ArrayList<>();Task temp;
		try(Scanner sc=new Scanner(System.in))
		{
			while(!flag)
			{
				try {
					System.out.println("Option as : \n1). Add New Task \n2)Delete a task\n3)Update task status\n4)Display all pending tasks\n5)Display all pending tasks for today\n6)exit");
					System.out.println("chooes your option : ");
					switch(sc.nextInt())
					{
					case 1: System.out.println("enter details as : taskName, description and taskDate(YYYY-MM-DD) : ");
						temp=new Task(sc.next(),sc.next(),sc.next());
						taskList.add(temp);
						System.out.println("Succesfully added !");
						break;
					case 2: System.out.println("Enter TaskId : ");
					        temp=TaskValidationRules.taskIdValidation(sc.nextInt(),taskList);
					        System.out.println(taskList.remove(temp));
					        System.out.println("Succesfully removed !");
					        break;
					case 3:System.out.println("Enter TaskId : ");
							temp=TaskValidationRules.taskIdValidation(sc.nextInt(),taskList);
							System.out.println("task status can be : ");
							for(Status s:Status.values())
								System.out.println(s.name());
							System.out.println("give your choice :");
							Status s=Status.valueOf(sc.next().toUpperCase());
							temp.setStatus(s);
							System.out.println("Status Succesfully updated !");
							break;
					case 4:for(Task t:taskList)
						{
						if(TaskValidationRules.checkStatus(t,"PENDING"))
							System.out.println(t);
						}
						break;
					case 5:for(Task k:taskList)
							{
								if(TaskValidationRules.checkStatus(k,"PENDING"))
										if(TaskValidationRules.checkDate(k))
												System.out.println(k);
							}
										break;
					case 6:flag=true;
					System.out.println("Bye !");
							break;
					default : System.out.println("enter correct choice !");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

}
