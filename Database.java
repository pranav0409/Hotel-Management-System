package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Database {

	private static Database instance = null;
	
	private List<User> users;
	private List<Hotel> hotels;
	private List<Room> rooms;
	private List<Booking> bookings;
	private List<Feedback> feedbacks;
	
	private Database()
	{
		users = new ArrayList<>();
		hotels = new ArrayList<>();
		rooms = new ArrayList<>();
		bookings = new ArrayList<>();
		feedbacks = new ArrayList<>();
	}
	
	public static Database getInstance()
	{
		if(instance == null)
		{
			instance = new Database();
		}
		return instance;
	}
	
	//methods to add , update , delete,and get users,hotels,rooms,bookings,feedbacks;
	
	
	// user management
	public void addUser(User user)
	{
		users.add(user);
	}
	
	public void deleteUser(int userId)
	{
		users.removeIf(user -> user.getId() == userId);
	}
	
	public Optional<User> getUserById(int userId)
	{
		return users.stream().filter(user -> user.getId() == userId).findFirst();
	}
	
	
	// hotel management
	public void addHotel(Hotel hotel)
	{
		hotels.add(hotel);
	}
	
	public void updateHotel(Hotel hotel)
	{
		hotels = hotels.stream().map(h -> h.getHotelId() == hotel.getHotelId() ? hotel : h).collect(Collectors.toList());
	}
	
	public void deleteHotel(int hotelId)
	{
		hotels.removeIf(hotel -> hotel.getHotelId()== hotelId);
	}
	
	public void approveHotel(int hotelId)
	{
		hotels.stream().filter(hotel -> hotel.getHotelId() == hotelId).forEach(hotel -> hotel.setApproved(true));
	}
	
	public List<Hotel> searchHotels(String criteria)
	{
		return hotels.stream().filter(hotel -> hotel.getName().contains(criteria) || hotel.getLocation().contains(criteria)).collect(Collectors.toList());
	}
	
	public Optional<Hotel> getHotelById(int hotelId)
	{
		return hotels.stream().filter(hotel -> hotel.getHotelId() == hotelId).findFirst();
	}
	
	
	//Room management
	
	public void addRoom(Room room)
	{
		rooms.add(room);
	}
	
	public List<Room>getRoomsByHotelId(int hotelId)
	{
		return rooms.stream().filter(room -> room.getHotelId() == hotelId).collect(Collectors.toList());
	}
	
	//booking management
	
	public void bookRoom(int hotelId, int roomId , int userId)
	{
		Optional<Room> roomOpt = rooms.stream().filter(room -> room.getRoomId()== roomId && room.getHotelId() == hotelId && room.isAvailable()).findFirst();
		
		if(roomOpt.isPresent())
		{
			Room room = roomOpt.get();
			room.setAvailable(false);
			bookings.add(new Booking(bookings.size()+ 1,hotelId,roomId,userId,"Booked"));
		}
		else
		{
			System.out.println("Room is not available");
		}
	}
	
	public List<Booking> getBookingByUserId(int userId)
	{
		return bookings.stream().filter(booking -> booking.getUserId() == userId).collect(Collectors.toList());
	}
	
	
	// feedback management
	
	public void addFeedback(Feedback feedback)
	{
		feedbacks.add(feedback);
	}
	
	//getter for the lists
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public List<Hotel> getHotels()
	{
		return hotels;
	}
	
	public List<Room> getRooms()
	{
		return rooms;
	}
	
	public List<Booking> getBookings()
	{
		return bookings;
	}
	
	public List<Feedback> getFeedbacks()
	{
		return feedbacks;
	}
	
	
}
