package gui;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.CreateAccountDAO;
import model.Usuario;

public class ControllerCreateAccount {

	@FXML
	private PasswordField txtPassword;

	@FXML
	private PasswordField txtConfirmPassword;

	@FXML
	private Button btnCreate;
	
	@FXML
	private TextField txtEmail = new TextField("");

	@FXML
	public void onLabelBackSceneClicked() {
		try {
			App main = new App();
			main.start(App.primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@FXML
	public void onBtnCreateAction() {
		Alert alert;
		if (txtPassword.getText().equals(txtConfirmPassword.getText()) && txtEmail.getText() != "") {
			alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Account created!");
			
			Usuario user = new Usuario(txtEmail.getText(), txtPassword.getText());
			
			CreateAccountDAO.createAccount(user);
			
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("Account can't be created!");
		}

		alert.show();
	}

}
