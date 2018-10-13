package secretsanta.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomMatcherImpl implements Matcher {
	
	private final static Logger LOGGER = Logger.getLogger(RandomMatcherImpl.class.getName());

	@Override
	public Map<User, User> matchUsers(List<User> users) {
		
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		LOGGER.addHandler(handler);
		
		LOGGER.log(Level.INFO, "Users for secret santa: " + users.toString());
		
		Random random = new Random();
		int seed = (int) Math.random();
		LOGGER.log(Level.INFO, "Picking random santees with seed " + seed);
		random.setSeed(seed);
		
		// Insert santa/santee pairs into the map
		// The key is the santa, the value is the santee
		List<User> santees = new ArrayList<User>();
		santees.addAll(users);
		
		Map<User, User> pairMap = new HashMap<User, User>();
		
		for (User santa : users) {
			
			User santee = santees.get(random.nextInt(santees.size()));
			santees.remove(santee);
			
			LOGGER.log(Level.INFO, "Pairing: " + santa + " with " + santee + ".");
			pairMap.put(santa, santee);
			
		}
		
		LOGGER.log(Level.INFO, "Pairs: " + pairMap);
		return pairMap;
	}

	
}
