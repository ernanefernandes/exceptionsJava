package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException( "Error in reservation:Check-out date must be after chek-in date");
		}
	    this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
	  long diff = 	checkout.getTime()-checkin.getTime();
	  return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if (!checkout.after(checkin)) {
			throw new DomainException( "Error in reservation:Check-out date must be after chek-in date");
		}
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must future dates!");				
		}
		this.checkin  = checkin;
		this.checkout = checkout;
				
	}

	@Override
	public String toString() {
		return "Room="   + roomNumber 
				         + ", check-in:"  + sdf.format(checkin) 
				         + ", check-out:" + sdf.format(checkout)
				         + ","+duration()
				         +"nights";
	}
	
	
	
}
