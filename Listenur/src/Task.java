
public class Task {
	
	private String task;
	private int score;
	
	public Task(String task, int score) {
		
		this.task = task;
		this.score = score;
		
	} // Task - constructor

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		
		return this.task + " - " + score;
		
	} // toString
	
}
