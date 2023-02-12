package view.screen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.DockController;
import entity.dock.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Constants;
import java.util.Random;


public class DockListScreen implements Initializable{
	public static boolean reset = false;
	ArrayList<Dock> docks;
	
	Random rand;

	@FXML
	private Label distanceDCV, distanceLTN, distanceTDN;
	@FXML
	private Button backButton, viewDCV, viewTDN, viewLTN;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		rand = new Random();
		int dcv = rand.nextInt(901) + 100;
		int ltn = rand.nextInt(901) + 100;
		int tdn = rand.nextInt(901) + 100;
		distanceDCV.setText("Distance is: " + Integer.toString(dcv));
		distanceLTN.setText("Distance is: " + Integer.toString(ltn));
		distanceTDN.setText("Distance is: " + Integer.toString(tdn));
	}

	
	public void viewDCV() {
		Dock dock = DockController.getDockFromName("DCV");
		showViewDockScreen(dock);
	}
	
	public void viewLTN() {
		Dock dock = DockController.getDockFromName("LTN");

		showViewDockScreen(dock);
	}
	
	public void viewTDN() {
		Dock dock = DockController.getDockFromName("TDN");

		showViewDockScreen(dock);
	}

	/**
	 * dock screen
	 * @param dock
	 */
	public void showViewDockScreen(Dock dock) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.DOCK));
			Parent root = loader.load();
			DockScreen viewDockController = loader.getController();
			viewDockController.setDockInfo(dock);

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

	/**
	 * back button
	 */
	public void handleBackButtonClick() {
		try {
			System.out.println("user click BackButton");
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
