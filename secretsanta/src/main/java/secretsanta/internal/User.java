package secretsanta.internal;

public class User {
	
	final String email;
	
	public User(final String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof User) {
			User user = (User)object;
			return this.email.equals(user.getEmail());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return email;
	}

}
