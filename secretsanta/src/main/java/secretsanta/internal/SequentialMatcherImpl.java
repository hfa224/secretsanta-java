package secretsanta.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SequentialMatcherImpl implements Matcher {

	private final static Logger LOGGER = Logger.getLogger(SequentialMatcherImpl.class.getName());

	@Override
	public Map<User, User> matchUsers(List<User> users) {
		
		LOGGER.log(Level.INFO, "Users for secret santa: " + users.toString());
		
		Collections.shuffle(users);
		
		LOGGER.log(Level.INFO, "Shuffled users: " + users.toString());
		
		// Insert santa/santee pairs into the map
		// The key is the santa, the value is the santee
		List<User> santees = new ArrayList<User>();
		santees.addAll(users);
		
		Map<User, User> pairMap = new HashMap<User, User>();
		
		Iterator<User> iterator = users.listIterator(1);
		
		for (User santa : users) {
	
			User santee;
			if (iterator.hasNext()) {
				santee = iterator.next();
			} else {
				santee = users.get(0);
			}
			
			LOGGER.log(Level.INFO, "Pairing: " + santa + " with " + santee + ".");
			pairMap.put(santa, santee);
			
		}
		
		LOGGER.log(Level.INFO, "Pairs: " + pairMap);
		return pairMap;
	}
}
