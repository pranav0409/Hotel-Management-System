package day6;

import java.util.ArrayList;
import java.util.List;

//mark :- HOTEL CLASS FOR HOTEL MANAGEMENT
public class Hotel {
	private int hotelId;
	private String name;
	private String location;
	private int numberOfRooms;
	private List<String> facilities;
	private boolean isApproved;
	private List<Room> rooms;
	
	
	//DESC :- constructor
	public Hotel(int hotelId, String name, String location, int numberOfRooms, List<String> facilities) {
		
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.numberOfRooms = numberOfRooms;
		this.facilities = new ArrayList<>(facilities);
		this.isApproved = false;
		this.rooms = new ArrayList<>();
	}
	
	
	// DESC :- method to add room
	public void addRoom(Room room)
	{
		this.rooms.add(room);
	}
	
	// DESC :- method to update room details
	public void updateDetails(String name,String location,int numberOfRooms, List<String> facilities)
	{
		this.name = name;
		this.location = location;
		this.numberOfRooms = numberOfRooms;
		this.facilities = new ArrayList<>(facilities);
	}

	
	//DESC :- GETTER AND SETTER 
	
	public int getHotelId() {
		return hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
