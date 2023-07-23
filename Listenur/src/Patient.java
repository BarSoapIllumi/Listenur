import java.util.*;

public class Patient {

	private String name;
	private int age;
	private String gender;
	private int roomNumber;
	private ArrayList<String> notes;
	
	public Patient(String name, int age, String gender, int roomNumber) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.roomNumber = roomNumber;
		
	} // Patient

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ArrayList<String> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		
		String output = "";
		
		output += "Name: " + this.name + 
				"\nAge: " + this.age +
				"\nGender: " + this.gender +
				"\nRoom Number: " + this.roomNumber;
		
		return output;
		
	} // toString
	
}
