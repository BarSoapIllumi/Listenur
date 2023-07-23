
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Client> clients = patientDataParser("TestCases.csv");
		ArrayList<String> taskList = new ArrayList<String>();

		for (Client i : clients) {
			System.out.println(i);
			System.out.println();

		}

		start();

	} // main

	public static void start() {

		String input = "";
		String[] parsedInput;
		ArrayList<Task> tasks = new ArrayList<Task>();

		do {

			input = JOptionPane.showInputDialog("Requests: ");
			parsedInput = input.split(" ");

			System.out.println("Processing...");
			tasks = processData(parsedInput, tasks);

			
			for (Task i : tasks) {
				
				System.out.println(i);
				
			} // for
			
		} while (true);

	} // start

	public static ArrayList<Task> processData(String[] input, ArrayList<Task> tasks) {

		HashMap<String, Integer> keywords = parseKeywordWeights("keywords.csv");
		int temp = 0;
		String inputString = "";

		System.out.println("processData");

		System.out.println(Arrays.toString(input));

		temp = compareKeyWords(input, keywords);
		
		for (Task task : tasks) {
			
			if (task.getScore() <= temp) {
				
				for (String word : input) {
					
					inputString += word + " ";
					
				} // for
				
				Task tempTask = new Task(inputString, temp);
				
				tasks.add(task);
				
			} // if
			
		} // for
		
		return tasks;

	} // processData

	public static int compareKeyWords(String[] input, HashMap<String, Integer> keywords) {

		int score = 0;

		for (String word : input) {

			if (keywords.containsKey(word)) {

				score += keywords.get(word);

			} // if

		} // for

		return score;

	} // compareKeyWords

	private static HashMap<String, Integer> parseKeywordWeights(String filePath) {
		HashMap<String, Integer> keywordWeights = new HashMap<String, Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			boolean isFirstLine = true;

			while ((line = br.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					continue; // Skip the header row
				}

				String[] data = line.split(",");
				if (data.length == 2) {
					String keyword = data[0].trim();
					int weight = Integer.parseInt(data[1].trim());

					keywordWeights.put(keyword, weight);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keywordWeights;
	}

	public static ArrayList<Client> patientDataParser(String file) {

		ArrayList<Client> clients = new ArrayList<Client>();
		Patient tempPatient;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			boolean isFirstLine = true;

			while ((line = br.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					continue; // Skip the header row
				}

				String[] data = line.split(",");
				if (data.length == 4) {
					String name = data[0].trim();
					int age = Integer.parseInt(data[1].trim());
					String gender = data[2].trim();
					int roomNumber = Integer.parseInt(data[3].trim());

					tempPatient = (new Patient(name, age, gender, roomNumber));
					clients.add(new Client(tempPatient));

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return clients;

	} // parser

}