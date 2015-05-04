package antivaxxers.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Twitterer implements Serializable {


	private static final long serialVersionUID = -3154256279468380981L;
	
	// Persistent Fields:
	@Id
	@GeneratedValue
	private long id;
	public long getId() {
		return id;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	private String name;
	private String geoLocation;
	private boolean isAntivaxxer;
	
	@OneToMany
	private List<Tweet> tweets;
	

	public Twitterer(String name, boolean isAntivaxxer) {
		this.name = name;
		this.isAntivaxxer = isAntivaxxer;

	}
	public Twitterer(String name) {
		this.name = name;
	}
	
	public void addTweet(Tweet tweet) {
		this.tweets.add(tweet);
	}

	public String getName() {
		return name;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public boolean isAntivaxxer() {
		return isAntivaxxer;
	}

	// String Representation:
	@Override
	public String toString() {
		return this.name;
	}

}
