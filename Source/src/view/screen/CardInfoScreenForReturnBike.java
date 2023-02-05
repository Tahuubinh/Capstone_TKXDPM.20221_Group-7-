package view.screen;

import java.net.URL;
import java.util.ResourceBundle;

import controller.CardController;
import entity.card.CreditCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Constants;
import util.HandleException;
import view.screen.box.NotificationBox;

public class CardInfoScreenForReturnBike implements Initializable {
	/**
	 * card
	 */
	public static CreditCard card = CreditCard.getCard();

	/**
	 * some text field
	 */
	@FXML
	private TextField cardNumber, owner, ccvCode, expDate;

	@FXML
	private Button confirmButton, cancelButton;

	/**
	 * init
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		cardNumber.setText(card.getCardNumber());
		owner.setText(card.getOwner());
		ccvCode.setText(card.getCVV());
		expDate.setText(card.getExpiredDate());
		card = null;
	}

	/**
	 * confirm card
	 * @param cardInfoStage
	 */
	public void confirmCard(Stage cardInfoStage) {
		confirmButton.setOnAction(e -> {
			if (cardNumber.getText().isEmpty() || owner.getText().isEmpty() || ccvCode.getText().isEmpty()
					|| expDate.getText().isEmpty()) {
				NotificationBox.display("Notification", "Please fill in all information!");
			} else {
				if (!CardController.validateCardInfo(cardNumber.getText(), owner.getText(), ccvCode.getText(),
						expDate.getText())) {
					NotificationBox.display("Notification", "Information entered isn't in right format!");
					HandleException.getException(Constants.INVALID_CARD_INFO);
				} else {
					card = new CreditCard(cardNumber.getText(), owner.getText(), ccvCode.getText(), expDate.getText());
					cardInfoStage.close();
				}
			}
		});
		cancelButton.setOnAction(e -> cardInfoStage.close());
	}

	/**
	 * get information of card
	 * @return
	 */
	public CreditCard getCardInfo() {
		return card;
	}
}
