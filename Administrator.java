package day6;

//mark :- this class is for adminstrator user which extends to our  abstract user class
public class Administrator extends User{

	//DESC :- constructor
	public Administrator(int id, String name, String email, String password) {
		super(id, name, email, password);
	}
	
	//Desc :- TO register the user in the database as admin
	@Override
	public void register()
	{
		//register
	}
	
	
	// DESC :- to update the details of the adminstrator
	@Override
	public void updateDetails()
	{
		// update
	}
	
	
	//DESC :- to approve the hotel
	public void approveHotel(int hotelId)
	{
		Database.getInstance().approveHotel(hotelId);
	}
	
	// DESC :- to delete the user from database
	public void deleteUser(int userId)
	{
		Database.getInstance().deleteUser(userId);
	}
	
	//DESC :- to deletehotel from database
	public void deleteHotel(int hotelId)
	{
		Database.getInstance().deleteHotel(hotelId);
	}

}
