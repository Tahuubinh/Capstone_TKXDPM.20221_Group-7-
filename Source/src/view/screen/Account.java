package view.screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import util.Constants;


/**
 * @author duydc
 *
 */
public class Account implements Initializable{
	
	public static int acc = 100000000;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Label account;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		account.setText(String.valueOf(acc) + " dong");
	}
	/**
	 * click back
	 */
	public static void Change(int x) {
		acc -= x;
	}
	
	public void handleBackButtonClick() {
		try {
			System.out.println("--user click back button--");
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.MAIN));
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene(root));
			stage.setTitle("MainScreen");
			stage.show();
			Stage oldStage = (Stage) backButton.getScene().getWindow();
			oldStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
