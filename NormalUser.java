package day6;

import java.util.List;


//mark :- this class is for normal user which extends to our  abstract user class
public class NormalUser extends User {

	//DESC :- constructor
	public NormalUser(int id, String name, String email, String password) {
		super(id, name, email, password);
	}
	
	
	//DESC :- to register  as the normal user
	@Override
	public void register()
	{
		Database.getInstance().addUser(this);
	}
	
	
	//DESC :- to update details of the normal User
	@Override
	public void updateDetails()
	{
		//update details logic
	}
	
	//DESC :- method to search the hotel from database
	public List<Hotel> searchHotels(String criteria)
	{
		return Database.getInstance().searchHotels(criteria);
	}
	
	//DESC :- method to book room
	public void bookRoom(int hotelId,int roomId)
	{
		Database.getInstance().bookRoom(hotelId, roomId,this.id );
	}
	
	
	// DESC :- method to give feedBAck
	public void giveFeedBack(int hotelId, int rating ,String comment)
	{
		Database.getInstance().addFeedback(new Feedback(0,hotelId,this.id,rating,comment));
	}

	// DESC :- method for get booking by user id;
	public List<Booking> getBookings()
	{
		return Database.getInstance().getBookingByUserId(getId());
	}
}
