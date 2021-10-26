package main;

public class Seat {
	
	private int number;
	Boolean status;
	private Boolean type;
	private int price;
		
	public Seat(int number, Boolean status, Boolean type, int price) // A constructor
	{
		this.number = number;
		this.status = status;
		this.type = type;
		this.price = price;
	}
	
	public int getSeatNumber()
	{
		return number;
	}
	public Boolean getSeatStatus()
	{
		return status;
	}
	public Boolean getSeatType()
	{
		return type;
	}
	public int getSeatPrice()
	{
		return price;
	}
		
	public void bookSeat()
	{
		status = true;
		return;
	}
	public void freeSeat()
	{
		status = false;
		return;
	}
		
	public void displaySeat()
	{
		System.out.println("Seat number: " + number);
		System.out.print("Status: ");
		if(status == true)
			System.out.print("Booked");
		else
			System.out.print("Free");
		System.out.println();
		System.out.print("Type: ");
		if(type == true)
			System.out.print("Business");
		else
			System.out.print("Economy");
		System.out.println("Price: " + price);
		return;
	}
}
