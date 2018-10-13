package secretsanta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import secretsanta.internal.Matcher;
import secretsanta.internal.RandomMatcherImpl;
import secretsanta.internal.SequentialMatcherImpl;
import secretsanta.internal.User;

public class MatcherTest {
	
	private final String[] userNames = { "Anne", "Betty", "Carlos", "Damien", "Elsa", "Fran", "George"};
	
	@Test
	public void SequentialMatcherTest() {
		
		List<User> users = new ArrayList<User>();
		
		for (String userName : userNames) {
			users.add(new User(userName));
		}
		
		Matcher sequentialMatcher = new SequentialMatcherImpl();
		Map<User, User> pairMap = sequentialMatcher.matchUsers(users);
		
		// Check all the users are present, and the pairs are unique
		for (Entry<User, User> entry : pairMap.entrySet()) {
			Assert.assertNotEquals(entry.getValue(), entry.getKey());
			Assert.assertTrue(Arrays.asList(userNames).contains(entry.getKey().getEmail()));
			Assert.assertTrue(Arrays.asList(userNames).contains(entry.getValue().getEmail()));
		}
	}
	
	@Test
	public void RandomMatcherTest() {
		
		List<User> users = new ArrayList<User>();
		
		for (String userName : userNames) {
			users.add(new User(userName));
		}
		
		Matcher randomMatcher = new RandomMatcherImpl();
		Map<User, User> pairMap = randomMatcher.matchUsers(users);
		
		// Check all the users are present, and the pairs are unique
		for (Entry<User, User> entry : pairMap.entrySet()) {
			Assert.assertNotEquals(entry.getValue(), entry.getKey());
			Assert.assertTrue(Arrays.asList(userNames).contains(entry.getKey().getEmail()));
			Assert.assertTrue(Arrays.asList(userNames).contains(entry.getValue().getEmail()));
		}
	}

}
