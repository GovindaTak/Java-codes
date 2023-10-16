package extra;

import java.time.LocalDate;
import java.util.List;

public class TaskValidationRules {

	public static Task taskIdValidation(int id,List<Task>array) throws TaskException
	{	
		Task temp=new Task(id);
		int index=array.indexOf(temp);
		if(index==-1)
			throw new TaskException("Invalid TaskId !");
		temp=array.get(index);
		return temp;
	}
	public static boolean checkStatus(Task temp,String s)
	{
		Status en=Status.valueOf(s);
		return temp.getStatus()==en;
	}
	public static boolean checkDate(Task temp)
	{
		LocalDate d=LocalDate.now();
		return temp.getTaskDate().equals(d);
	}
}
