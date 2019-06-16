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
			userNameTxt.setStyle(" -fx-text-box-border: #FF1493; -fx-focus-color: #FF1493;");
		} else {
			userNameTxt.setStyle(null);
		}
		if (passwordTxt.getText().trim().isEmpty()) {
			passwordTxt.setStyle(" -fx-text-box-border: #FF1493; -fx-focus-color: #FF1493;");
		} else {
			passwordTxt.setStyle(null);
		}
		if (userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	private ObservableList<Login> loginData() {
		dataLogin.clear();
		dataLogin.addAll(loginDB.getAllUserLogin(userNameTxt.getText()));
		return dataLogin;

	}

	// Login app
	@FXML
	private void loginBtn() {
		if (checkField()) {
			// Database to array
			loginData();
			if (dataLogin.get(0).getUserName().equals(userNameTxt.getText())
					&& dataLogin.get(0).getPassword().equals(passwordTxt.getText())) {
				loginPage.setVisible(false);

			} else {
				passwordTxt.setStyle(" -fx-text-box-border: #FF1493; -fx-focus-color: #FF1493;");
				userNameTxt.setStyle(" -fx-text-box-border: #FF1493; -fx-focus-color: #FF1493;");
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
		// TODO Automatikusan előállított metóduscsonk

	}

}
