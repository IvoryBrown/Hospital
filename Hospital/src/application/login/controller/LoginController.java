package application.login.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.login.database.LoginDB;
import application.login.pojo.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {
	@FXML
	private TextField userNameTxt; // username
	@FXML
	private PasswordField passwordTxt; // password
	@FXML
	private AnchorPane loginPage;// login page true/false
	private final ObservableList<Login> dataLogin = FXCollections.observableArrayList(); // arraylist login
	private LoginDB loginDB = new LoginDB();

	// check textfield not null
	private boolean checkField() {
		if (userNameTxt.getText().trim().isEmpty()) {
			userNameTxt.setStyle(" -fx-border-color: #e62200; -fx-focus-color: #e62200;");
		} else {
			userNameTxt.setStyle(null);
		}
		if (passwordTxt.getText().trim().isEmpty()) {
			passwordTxt.setStyle(" -fx-border-color: #e62200; -fx-focus-color: #e62200;");
		} else {
			passwordTxt.setStyle(null);
		}
		if (userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	// arraylist database text username
	private ObservableList<Login> loginData() {
		dataLogin.clear();
		dataLogin.addAll(loginDB.getAllUserLogin(userNameTxt.getText()));
		return dataLogin;

	}

	// Login app button
	@FXML
	private void loginBtn() {
		login();
	}

	// Login app
	private void login() {
		if (checkField()) {
			// Database to array
			loginData();
			if (dataLogin.get(0).getUserName().equals(userNameTxt.getText())
					&& dataLogin.get(0).getPassword().equals(passwordTxt.getText())) {
				loginPage.setVisible(false);

			} else {
				passwordTxt.setStyle(" -fx-border-color: #e62200; -fx-focus-color: #e62200;");
				userNameTxt.setStyle(" -fx-border-color: #e62200; -fx-focus-color: #e62200;");
			}
		}
	}

	// Exit app
	@FXML
	private void exitBtn() {
		System.exit(0);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Textfield enter
		userNameTxt.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				login();
			}
		});
		// Textfield enter
		passwordTxt.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				login();
			}
		});
	}

}
