package entity.dock;

import java.util.ArrayList;

import entity.DBConnection;

public class DockDAO {
	/**
	 * @return all information of docks
	 */
	public static ArrayList<ArrayList<String>> getAllDocks() {
		String command = "SELECT * FROM dock";
		return DBConnection.query(command);
	}

	/**
	 * update remain capacity of a dock
	 * @param dockID
	 * @param difference
	 */
	public static void updateRemainCapacity(String dockID, String difference) {
		String command = "UPDATE dock SET remainCapacity = remainCapacity + " + difference + " WHERE dockID=\"" + dockID
				+ "\"";
		DBConnection.execute(command);
	}
}
