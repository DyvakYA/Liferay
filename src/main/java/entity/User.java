package entity;

public class User {

	private String name;

	private String age;

	public User(String string, String string2) {
		this.name = string;
		this.age = string2;
	}
	
	public static class Builder {
		
		User instance = new User();

		public Builder setName(String name) {
			instance.name = name;
			return this;
		}

		public Builder setAge(String age) {
			instance.age = age;
			return this;
		}

		public User build() {
			return instance;
		}

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}
