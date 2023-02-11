package entity.bike;

import java.util.ArrayList;

import entity.DBConnection;

public class BikeDAO {

	public static void updateStatus(int bikeID, boolean inUse, String dockID) {
		int status = inUse ? 1 : 0;
		String command = "UPDATE bike SET inUse=" + status + ", dockID=" + '\'' + dockID + '\'' + " WHERE bikeID="
				+ bikeID;
		DBConnection.execute(command);
	}

	public static ArrayList<ArrayList<String>> queryWithDockID(String dockID) {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT * from bike WHERE dockID=" + '\'' + dockID + '\'';
		s = DBConnection.query(command);
		return s;
	}

	public static ArrayList<ArrayList<String>> queryWithBikeCode(int bikeCode) {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT * from bike WHERE bikeID=" + '\'' + bikeCode + '\'';
		s = DBConnection.query(command);
		System.out.println(s);
		return s;
	}

	public static ArrayList<ArrayList<String>> getBikes() {
		ArrayList<ArrayList<String>> s = new ArrayList<>();
		String command = "SELECT * from bike";
		try {
			s = DBConnection.query(command);
		} catch (Exception e) {
			System.err.println("Cannot get all bikes from database!");
		}
		return s;
	}

}
