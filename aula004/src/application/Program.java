package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Room number:");
			int number = sc.nextInt();
			System.out.print("Check-in date(dd/mm/yyyy):");
			Date checkin = sdf.parse(sc.next());	
			System.out.print("Check-out date(dd/mm/yyyy):");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number,checkin,checkout);
			System.out.print("Reservation: "+reservation);
			//
			System.out.println();
			System.out.print("Enter to update raservation:");
			System.out.print("Check-in date(dd/mm/yyyy):");
			checkin = sdf.parse(sc.next());	
			System.out.print("Check-out date(dd/mm/yyyy):");
			checkout = sdf.parse(sc.next());

			reservation.updateDate(checkin, checkout);
			System.out.print("Update Reservation: "+reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format!");
		}		
		catch (DomainException e) {
			System.out.println("Reservation:"+e.getMessage());
		}	
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}	
		sc.close();

	}

}

