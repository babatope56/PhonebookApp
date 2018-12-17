package phonebook;

public class Person {
	 public static void main(String[] args){

	   }
	static int id = Main.people.size();
	
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	//private String path = "/Users/babatopeayelabola/Documents/Training/Workspace/PhoneBookApplication3/";

	public Person(String firstName, String lastName, String number, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
		id++;
		
	}


	public static int getId() {
		return id;
	}


	public static void setId(int id) {
		Person.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
