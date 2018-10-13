package secretsanta.internal;

import java.util.List;
import java.util.Map;

public interface Matcher {

	public Map<User, User> matchUsers(List<User> users);
}
