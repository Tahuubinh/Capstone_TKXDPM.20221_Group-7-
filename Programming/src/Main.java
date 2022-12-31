
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	/**
	 * Start the application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("./views/fxml/Sample.fxml"));
		primaryStage.setTitle("EcoBike");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	/**
	 * Main program
	 * @param args: arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
