package secretsanta;

import java.util.ArrayList;
import java.util.List;

import secretsanta.internal.Matcher;
import secretsanta.internal.RandomMatcherImpl;
import secretsanta.internal.SequentialMatcherImpl;
import secretsanta.internal.User;

public class Main {
	
	public static void main(String args[]) {
		
		//String[] userNames = { "Anne", "Betty", "Carlos", "Damien", "Elsa", "Fran", "George"};
		
		List<User> users = new ArrayList<User>();
		
		for (String userName : args) {
			users.add(new User(userName));
		}
		
		Matcher matcher = new RandomMatcherImpl();
		
		matcher.matchUsers(users);
		
		Matcher sequentialMatcher = new SequentialMatcherImpl();
		
		sequentialMatcher.matchUsers(users);
	}

}
