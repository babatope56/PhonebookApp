package phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static phonebook.Person.id;

public class Main {

	public static void main(String[] args) throws IOException {
        readPeopleFromFile();
        menu();
    }
	public static Scanner in = new Scanner(System.in);
	public static File file = new File("Addresses.txt");
    static List<Person> people = new ArrayList<>();
    
        
    

    public static void menu() throws IOException {
    	
    	System.out.println("Select an Option(1-4)");
		System.out.println("1. Add Contact");
		System.out.println("2. Search");
		System.out.println("3. Delete Contact");
		System.out.println("4. Exit");
		
		String option;
		option = in.nextLine();
		do {
			option = in.nextLine();
			switch (option) {
			case "1": 
				addContact();
				break;
			case "2":
				search();
				break;
			
			default:
				System.out.println("Enter Number From 1-4");
			}
    	}while(!option.equals("2"));
    	
    }
	 
	public static void exit() {
		
	}

	public static void deleteContact() {
		
	}

	public static void search() throws IOException {
		System.out.println("1. Find with Firstname");
        System.out.println("2. Find with Lastname");

        String option;
        do {
            option = in.nextLine();
            switch (option) {
                case "1":
                    findByFirstname();
                    break;
                case "2":
                    findByLastname();
                    break;
                default:
                    
            }
        } while (!option.equals("1") && !option.equals("2"));
        System.out.println();
        menu();
	}

	private static void findByLastname() {
		System.out.println("Enter Lastname");
		String lastnameToFind = in.nextLine();
		int matches = 0;
		for(Person person : people) {
			if(person.getLastName().equals(lastnameToFind)) {
				System.out.println(person);
				matches++;
			}
		}
		if(matches<=0) {
            System.out.println("There is no person with this name ");
		}
	}

	private static void findByFirstname() {
		System.out.println("Enter Firstname");
		String firstnameToFind = in.nextLine();
		int matches = 0;
		for(Person person : people) {
			if(person.getFirstName().equals(firstnameToFind)) {
				System.out.println(person);
				matches++;
			}
		}
		if(matches<=0) {
			System.out.println("There's no person with this name");
		}
	}

	public static void addContact() throws IOException {
		System.out.println("Enter First Name: ");
        String firstName = in.nextLine();
      
        System.out.println("Enter Last Name: ");
        String lastName = in.nextLine();
        
        System.out.println("Enter phone number: ");
        String number = in.nextLine();
        
        System.out.println("Enter address: ");
        String address = in.nextLine();
        
        Person person = new Person(firstName, lastName, number,  address);
        
        addToFile(person);
       people.add(person);
        System.out.println("added person number "  + person);
        System.out.println();
        menu();
        
        
	}
	
   
	private static void addToFile(Person person) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
			writer.write(person.getFirstName() + " \r\n " + person.getLastName() + " \r\n " + person.getNumber()+ " \r\n " + person.getAddress());
		}catch(IOException e) {
		System.out.println(e);
		}
	
	}
	 private static boolean readPeopleFromFile() throws IOException {
	        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String name = null;
	            while((name = reader.readLine()) != null) {
	                Person person = new Person(name, reader.readLine(), reader.readLine(), reader.readLine());
	                people.add(person);        
	                reader.readLine();                                 
	            }
	            return true;
	        }
	        catch ( IOException e) {
	            System.out.println(e);
	        }
	        return false;
	 }
	    
}
