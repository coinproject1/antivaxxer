package vaccination_analysis.models;


public class Antivaxxer extends Twitterer{

	public Antivaxxer(String username, int followers, int friends) {
		super(username, followers, friends);
	}
	
	public boolean isAntivaxxer() {
		return true;
	}

	

}
