package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number:");
		int number = sc.nextInt();
		System.out.print("Check-in date(dd/mm/yyyy):");
		Date checkin = sdf.parse(sc.next());	
		System.out.print("Check-out date(dd/mm/yyyy):");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.print("Error in reservation:Check-out date must be after chek-in date");

		}else
		{
			Reservation reservation = new Reservation(number,checkin,checkout);
			System.out.print("Reservation: "+reservation);

			//
			System.out.println();
			System.out.print("Enter to update raservation:");
			System.out.print("Check-in date(dd/mm/yyyy):");
			checkin = sdf.parse(sc.next());	
			System.out.print("Check-out date(dd/mm/yyyy):");
			checkout = sdf.parse(sc.next());
			String error = reservation.updateDate(checkin, checkout);

			if(error!=null ) {
				System.out.print(error);
			}else
			{
				System.out.print("Reservation: "+reservation);
			}
		}

		sc.close();

	}

}

