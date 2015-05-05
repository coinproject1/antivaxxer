package vaccination_analysis.models;

import java.io.Serializable;
import java.util.Date;

public class Tweet implements Serializable {

	/**
	 * 
	 */
	private long id;
	private static final long serialVersionUID = 1445515991640811472L;
	private boolean isAntivaxxer;
	private String location;
	private String message;
	private Date date;
	
	public Tweet(String message, String location, Date date) {

		if (message == null || location == null || date == null) {
			throw new NullPointerException("cannot create tweet");
		}
		this.message = message;
		this.location = location;
		this.date = date;
		this.isAntivaxxer = false;
	}
	
	public Tweet(String message, String location, Date date,
			boolean isAntivaxxer) {

		if (message == null || location == null || date == null) {
			throw new NullPointerException("cannot create tweet");
		}
		this.message = message;
		this.location = location;
		this.date = date;
		this.isAntivaxxer = isAntivaxxer;
	}
	
	public Tweet(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getLocation() {
		return location;
	}

	public Date getDate() {
		return date;
	}

	public boolean isAntivaxxer() {
		return isAntivaxxer;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
