package antivaxxers.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Twitterer implements Serializable {


	private static final long serialVersionUID = -3154256279468380981L;
	// Persistent Fields:
	@Id
	@GeneratedValue
	private String name;
	private String geoLocation;
	private boolean isAntivaxxer;

	public Twitterer(String name, String geoLocation, boolean isAntivaxxer) {
		this.name = name;
		this.geoLocation = geoLocation;
		this.isAntivaxxer = isAntivaxxer;

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
