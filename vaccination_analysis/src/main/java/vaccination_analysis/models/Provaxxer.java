package vaccination_analysis.models;

public class Provaxxer extends Twitterer {

	public Provaxxer(String username, int followers, int friends) {
		super(username, followers, friends);
		
	}
	public boolean isAntivaxxer() {
		return false;
	}


}
