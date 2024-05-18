
package day6;

public class Feedback {
	private int feedbackId;
	private int hotelId;
	private int userId;
	private int rating;
	private String comment;
	
	public Feedback(int feedbackId, int hotelId, int userId, int rating, String comment) {
		this.feedbackId = feedbackId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public int getUserId() {
		return userId;
	}


	public int getRating() {
		return rating;
	}

	public String getComment() {
		return comment;
	}

}
