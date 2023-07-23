import javax.swing.JOptionPane;

public class Client {
	
	private Patient patient;

	public Client(Patient patient) {
		
		this.patient = patient;
		
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void start() {
		
		String input = "";
		String [] parsedInput;
		
		do {
			
			input = JOptionPane.showInputDialog("Requests: ");
			parsedInput = input.split(" ");
			
			System.out.println("Processing...");
			processData(parsedInput);
			
		} while (true);
		
	} // start
	
	@Override
	public String toString() {
		return this.patient.toString();
	}
	
} // Client
