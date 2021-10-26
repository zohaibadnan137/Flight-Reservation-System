package main;

public class Passenger {

	private String name;
	private Boolean gender; // False for male, true for female 
	private int age;
	private String passportNumber;
	
	private Flight flight;
	private Seat seat;
	
	public Passenger(String name, Boolean gender, int age, String passportNumber)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.passportNumber = passportNumber;
	}
	
	public void printPassengerDetails()
	{
		System.out.println("Name: " + name);
		if(gender)
			System.out.println("Gender: Female");
		else
			System.out.println("Gender: Male");
		System.out.println("Age: " + age);
		System.out.println("Passport Number: " + passportNumber);
	}
	
	public void assignFlightSeat(Flight flight, Seat seat)
	{
		this.flight = flight;
		this.seat = seat;
	}
}
