package entity.data;

import java.util.ArrayList;

public class DockDAO {
	public static ArrayList<ArrayList<String>> getAllDocks() {
		String command = "SELECT * FROM dock";
		return DBBinder.query(command);
	}

	public static void updateRemainCapacity(String dockID, String difference) {
		String command = "UPDATE dock SET remainCapacity = remainCapacity + " + difference + " WHERE dockID=\"" + dockID
				+ "\"";
		DBBinder.execute(command);
	}
}
