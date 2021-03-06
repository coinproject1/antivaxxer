package antivaxxers.dbhandling;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import antivaxxers.models.Tweet;
import antivaxxers.models.Twitterer;
import antivaxxers.twitterAPI.TwitterHandler;

public class DbHandler {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("antivaxxers");
	EntityManager em = emf.createEntityManager();
	TwitterHandler twitterHandler = new TwitterHandler();

	private void saveTweetsFromUser(String username, boolean isAntivaxxer) {

		Twitterer twitterer = new Twitterer(username, isAntivaxxer);
		Collection<Tweet> tweetsfromUser = twitterHandler
				.getTweetsFromUser(username);

		Iterator<Tweet> itr = tweetsfromUser.iterator();
		while (itr.hasNext()) {
			twitterer.addTweet(itr.next());
		}

		EntityTransaction t;
		t = em.getTransaction();
		t.begin();
		em.persist(twitterer);
		t.commit();

	}

	public void saveTweetsFromUsers(String[] usernames, boolean isAntivaxxer) {
		int i = 0;
		while (i <= usernames.length) {
			saveTweetsFromUser(usernames[i], isAntivaxxer);
		}
	}

	public List<Twitterer> getAntivaxxers() {
		return null;
	}

	public List<Twitterer> getProvaxxers() {
		// TODO Auto-generated method stub
		return null;
	}

}
