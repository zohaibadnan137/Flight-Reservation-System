package main;

import java.io.*;
import java.util.*;

public class Flight {

	private int number;
	private String aircraft;
	private String origin;
	private String destination;
		
	private DateTime departure;
	private DateTime arrival;
		
	Seat business[];
	private int numberOfBusinessSeats;
	private int businessPrice;
		
	Seat economy[];
	private int numberOfEconomySeats;
	private int economyPrice;
		
	public Flight(int number)
	{
		this.number = number;
		aircraft = "NULL";
		origin = "NULL";
		destination = "NULL";
		
		numberOfBusinessSeats = 0;
		businessPrice = 0;
		
		numberOfEconomySeats = 0;
		economyPrice = 0;
	}
	public Flight(int number, String aircraft, String origin, String destination, DateTime departure, DateTime arrival, int numberOfBusinessSeats, int businessPrice, int numberOfEconomySeats, int economyPrice)
	{
		this.number = number;
		this.aircraft = aircraft;
		this.origin = origin;
		this.destination = destination;
		
		this.departure = departure;
		this.arrival = arrival;
		
		this.numberOfBusinessSeats = numberOfBusinessSeats;
		this.businessPrice = businessPrice;
		business = new Seat[numberOfBusinessSeats];
		for(int count = 0; count < numberOfBusinessSeats; count++)
			business[count] = new Seat(count + 1, false, true, businessPrice);
		
		this.numberOfEconomySeats = numberOfEconomySeats;
		this.economyPrice = economyPrice;
		economy = new Seat[numberOfEconomySeats];
		for(int count = 0; count < numberOfEconomySeats; count++)
			economy[count] = new Seat(count + 1, false, false, economyPrice);
	}
	
	public void printFlightDetails()
	{
		System.out.println("Flight " + number);
		System.out.print(origin);
		System.out.print(" to " + destination);
		System.out.println();
		System.out.println("Departure: " + departure.getDateTime());
		System.out.println("Arrival: " + arrival.getDateTime());
		System.out.println("Aircraft:" + aircraft);
		
		this.printAvailableSeats(true);
		System.out.println();
		this.printAvailableSeats(false);
	}
		
	public void printAvailableSeats(Boolean seatType)
	{
		int numberOfAvailableSeats = 0;
		if(seatType) // Business
		{
			System.out.print("Number of available business seats: ");
			for(int count = 0; count < numberOfBusinessSeats; count++)
				if(business[count].status == false)
					numberOfAvailableSeats++;
		}
		else // Economy
		{
			System.out.print("Number of available economy seats: ");
			for(int count = 0; count < numberOfEconomySeats; count++)
				if(economy[count].status == false)
					numberOfAvailableSeats++;
		}
		System.out.print(numberOfAvailableSeats);
	}
		
	public void bookSeat(Boolean seatType, int seatNumber) throws InvalidSeatBookingException 
	{
		if((seatType && seatNumber > numberOfBusinessSeats) || (!seatType && seatNumber > numberOfEconomySeats))
			throw new InvalidSeatBookingException("You have entered an invalid seat number.");
		
		if(seatType) // Business
			business[seatNumber - 1].status = true;
		else
			economy[seatNumber - 1].status = false;
	}
		
	public void loadFlight() throws FileNotFoundException 
	{
		String fileName = number + ".txt";
		File inputFile = new File(System.getProperty("user.dir") + "/src/main/Flights/" + fileName);
		Scanner fileInput = new Scanner(inputFile);

		aircraft = fileInput.next();
		origin = fileInput.next();
		destination = fileInput.next();
		
		int day = fileInput.nextInt();
		int month = fileInput.nextInt();
		int year = fileInput.nextInt();
		int hours = fileInput.nextInt();
		int minutes = fileInput.nextInt();
		
		departure = new DateTime(day, month, year, hours, minutes);
		
		day = fileInput.nextInt();
		month = fileInput.nextInt();
		year = fileInput.nextInt();
		hours = fileInput.nextInt();
		minutes = fileInput.nextInt();
		
		arrival = new DateTime(day, month, year, hours, minutes);
		
		numberOfBusinessSeats = fileInput.nextInt();
		businessPrice = fileInput.nextInt();
		business = new Seat[numberOfBusinessSeats];
		for(int count = 0; count < numberOfBusinessSeats; count++)
			business[count] = new Seat(count + 1, false, true, businessPrice);
		
		
		numberOfEconomySeats = fileInput.nextInt();
		economyPrice = fileInput.nextInt();
		economy = new Seat[numberOfEconomySeats];
		for(int count = 0; count < numberOfEconomySeats; count++)
			economy[count] = new Seat(count + 1, false, false, economyPrice);
		
		char seatType;
		int seatNumber;
		
		while(fileInput.hasNext())
		{
			seatType = fileInput.next().charAt(0);
			seatNumber = fileInput.nextInt();
			
			if(seatType == 'b') 
				business[seatNumber].bookSeat();
			else if(seatType == 'e')
				economy[seatNumber].bookSeat();
		}
		
		fileInput.close();
	}
}
