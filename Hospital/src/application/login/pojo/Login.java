package application.login.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Login {

	// Login pojo
	private SimpleStringProperty userName;
	private SimpleStringProperty password;

	// Login database
	public Login(String userName, String password) {
		this.userName = new SimpleStringProperty(userName);
		this.password = new SimpleStringProperty(password);
	}

	public SimpleStringProperty getUserNameProperty() {
		return this.userName;
	}

	public String getUserName() {
		return this.userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public SimpleStringProperty getUserPasswordProperty() {
		return this.password;
	}

	public String getPassword() {
		return this.password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}
}
