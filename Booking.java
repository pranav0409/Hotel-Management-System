package day6;

//MARK :- THIS IS BOOKING CLASS FOR HOTEL MANAGEMENT
public class Booking {
	
	private int bookingId;
	private int hotelId;
	private int roomId;
	private int userId;
	private String Status;
	
	//DESC :- CONSTRUCTOR
	public Booking(int bookingId, int hotelId, int roomId, int userId, String status) {
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		Status = status;
	}
	
	
	// MARK :- GETTER AND SETTER

	public int getBookingId() {
		return bookingId;
	}

	

	public int getHotelId() {
		return hotelId;
	}

	
	public int getRoomId() {
		return roomId;
	}

	

	public int getUserId() {
		return userId;
	}

	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}
