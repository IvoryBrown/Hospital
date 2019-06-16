package application.login.controller;

import java.net.URL;
import java.util.ResourceBundle;

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

	// check textfield not null
	private boolean checkField() {
		if (userNameTxt.getText().trim().isEmpty()) {
			userNameTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			userNameTxt.setStyle(null);
		}
		if (passwordTxt.getText().trim().isEmpty()) {
			passwordTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			passwordTxt.setStyle(null);
		}
		if (userNameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	// Login app
	@FXML
	private void loginBtn() {
		if (checkField()) {
			loginPage.setVisible(false);
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
