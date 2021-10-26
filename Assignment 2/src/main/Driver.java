package main;

import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String args[]) throws FileNotFoundException, InvalidOptionException 
	{
		int numberOfFlights = 2;
		
		// Create two flights
		Flight flights[] = new Flight[numberOfFlights];
		flights[0] = new Flight(101);
		flights[1] = new Flight(303);
		
		// Load data for both flights 
		flights[0].loadFlight();
		flights[1].loadFlight();
		
		// Display Menu
		
		int option = 0;
		
		while(option != 3)
		{
			System.out.println("*** Airline Reservation System ***");
			System.out.println("1. View available flights");
			System.out.println("2. Book a flight");
			System.out.println("3. Exit");
			System.out.println("4. Enter an option: ");
			
			Scanner consoleInput = new Scanner(System.in);
			option = consoleInput.nextInt();
			
			if(option == 1)
			{
				for(int count = 0; count < numberOfFlights; count++)
					flights[count].printFlightDetails();
			}
			else if(option == 2)
			{
				
			}
			else
				throw new InvalidOptionException("You have entered an invalid option.");
		}
		return;
	}
	
}
