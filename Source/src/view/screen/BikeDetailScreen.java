package view.screen;

import java.io.IOException;

import controller.BarcodeController;
import controller.RentBikeController;
import entity.bike.*;
import entity.dock.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import util.Constants;
import view.screen.box.NotificationBox;


public class BikeDetailScreen {
	int id;
	/**
	 * dock
	 */
	private Dock dock;

	/**
	 * bike information
	 */
	@FXML
	private ListView<String> bikeInfo;

	/**
	 * back button
	 */
	@FXML
	private Button backButton, barcode, rent;

	/**
	 * set bike info
	 * @param bike
	 * @param dock
	 */
	void setBikeInfo(Bike bike, Dock dock) {
		this.dock = dock;

		for (String info : bike.getBikeInfo()) {
			bikeInfo.getItems().add(info);
		}
	}
	
	public void setBikeId(Bike bike) {
		id = bike.getBikeID();
	}

	/**
	 * click back button
	 */
	public void handleBackButtonClick() {
		try {
			System.out.println("user click BackButton");
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.DOCK));
			Parent root = (Parent) loader.load();
			DockScreen dockScreen = loader.getController();
			dockScreen.setDockInfo(dock);

			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene(root));
			stage.setTitle("ViewDockScreen");
			stage.show();

			Stage oldStage = (Stage) backButton.getScene().getWindow();
			oldStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleBarcodeButtonClick() {
		NotificationBox.display("Notification", "Barcode is: " + id + "0");
	}
	
	public void handleRentButtonClick() {
		String message = Integer.toString(id);
		if (RentBikeController.rentalCode == null) {
			//message = Integer.toString(Integer.parseInt(message)/10);
			Pair<Boolean, Bike> p = BarcodeController.getBikeFromBarcode(message);
			if (p.getKey()) {
				System.out.println(p.getValue());
				display(p.getValue());

			} else {
				NotificationBox.display("NotificationBox", "Invalid Barcode");
			}
		} else {
			NotificationBox.display("NotificationBox", "Please return your bike before renting a new one!");
		}
		
	}
	
	public void display(Bike bike) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.RENT_BIKE_INFO));
			Parent root = loader.load();
			RentBikeInfoScreen rentBikeInfoScreen = loader.getController();
			Stage stage = new Stage();
			stage.setTitle("ViewRentBikeInfoScreen");
			rentBikeInfoScreen.setBikeInfo(bike, stage);
			stage.setScene(new Scene(root));
			stage.show();

			Stage oldStage = (Stage) barcode.getScene().getWindow();
			oldStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
