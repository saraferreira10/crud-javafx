package gui;

import java.io.IOException;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerFirstScene {

	@FXML
	private Button btnSignIn;

	@FXML
	private Button btnCreateAccount;

	@FXML
	private Label labelBack;

	@FXML
	public void onBtnLoginAction() {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/gui/ViewLogin.fxml"));
			Scene scene = new Scene(root);
			App.primaryStage.setScene(scene);
			App.primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void onBtnCreateAccountAction() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/ViewCreateAccount.fxml"));
			Scene scene = new Scene(root);
			App.primaryStage.setTitle("Create Account");
			App.primaryStage.setScene(scene);
			App.primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

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

}
