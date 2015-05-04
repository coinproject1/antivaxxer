package antivaxxers.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Tweet implements Serializable {

	/**
	 * 
	 */
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

}
