package view.screen;

import java.io.IOException;

import entity.Bike;
import entity.Dock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Constants;

public class BikeDetailScreen {
	
	private Dock dock;

	@FXML
	private ListView<String> bikeInfo;

	@FXML
	private Button backButton;

	void setBikeInfo(Bike bike, Dock dock) {
		this.dock = dock;

		for (String info : bike.getBikeInfo()) {
			bikeInfo.getItems().add(info);
		}
	}

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
}
