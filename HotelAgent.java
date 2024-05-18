package day6;

//mark :- this class is for Hotel agents users which extends to our  abstract user class
public class HotelAgent extends User{

	// DESC :- constructor
	public HotelAgent(int id, String name, String email, String password) {
		super(id, name, email, password);
	}
	
	//DESC :- to register user in the database
	@Override
	public void register()
	{
		Database.getInstance().addUser(this);
	}
	
	//DESC :- to update the details
	@Override
	public void updateDetails()
	{
		//update details logic
	}
	
	//DESC :- to add the hotels
	public void addHotel(Hotel hotel)
	{
		Database.getInstance().addHotel(hotel);
	}
	
	//DESC :- to update the Hotels 
	public void updateHotel(Hotel hotel)
	{
		Database.getInstance().updateHotel(hotel);
	}

}
