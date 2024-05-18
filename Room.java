package day6;

// MARK :- Room class for hotel maanagement system
public class Room {
	private int roomId;
	private int hotelId;
	private boolean isAvailable;
	private double price;
	
	//DESC :- constructor
	public Room(int roomId, int hotelId, boolean isAvailable, double price) {
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.isAvailable = isAvailable;
		this.price = price;
	}

	//DESC :- getter and setter
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
