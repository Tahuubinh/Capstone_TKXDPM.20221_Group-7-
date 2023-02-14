package view.screen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.CardController;
import controller.RentBikeController;
import entity.card.CreditCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import util.Constants;
import util.HandleException;
import view.screen.box.NotificationBox;


public class Account {
	
	public static int acc = 100000000;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private TextField cardcode, cvv, owner, exp;
	/**
	 * click back
	 */
	

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
	
	public void handleConfirmButtonClick() {
		confirmButton.setOnAction(e -> {
			if (cardcode.getText().isEmpty() || owner.getText().isEmpty() || cvv.getText().isEmpty()
					|| exp.getText().isEmpty()) {
				NotificationBox.display("Notification", "Please fill in all information!");
			} else {
				if (!CardController.validateCardInfo(cardcode.getText(), owner.getText(), exp.getText(),
						exp.getText())) {
					NotificationBox.display("Notification", "Information entered isn't in right format!");
					HandleException.getException(Constants.INVALID_CARD_INFO);
				} else {
					ArrayList<ArrayList<String>> s = new ArrayList<ArrayList<String>>();
					s = CreditCard.getRemain(cardcode.getText(), owner.getText());
					if (s == null) {
						NotificationBox.display("Notification", "Invalid Card");
					}
					else NotificationBox.display("Notification", "Your balance account is: " + s.get(0).get(0));
				}
			}
		});
	}
	
	
}
