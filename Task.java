package extra;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	private static int count;
	static { count=0;}
	public Task(String taskName, String description, String taskDate) {
		super();
		taskId=++count;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = LocalDate.parse(taskDate);
		status=Status.valueOf("PENDING");
		active=true;
	}
	
	public Task(int taskId) {
		super();
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "Task details as : taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task)
		{
			Task temp=(Task)obj;
			return taskId==temp.taskId;
		}
		return false;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	
	
	

}
