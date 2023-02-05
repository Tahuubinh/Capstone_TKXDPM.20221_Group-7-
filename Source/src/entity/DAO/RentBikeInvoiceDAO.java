package entity.DAO;

import java.util.ArrayList;

public class RentBikeInvoiceDAO {

	public static void save(int bikeID, String rentalCode, String type, String rentTime, String returnTime,
			int rentBikeCost, String owner, int deposit) {
		String command = "INSERT INTO rentbikeinvoice " + " VALUES " + "(" + '\'' + rentalCode + '\'' + ", " + bikeID
				+ ", " + '\'' + type + '\'' + ", " + rentBikeCost + ", " + '\'' + owner + '\'' + ", " + '\'' + rentTime
				+ '\'' + ", " + '\'' + returnTime + '\'' + ", " + deposit + ")";

		DBConnection.execute(command);
	}

	public static ArrayList<ArrayList<String>> queryByRentalCode(String rentalCode) {
		String command = "SELECT * FROM rentbikeinvoice WHERE rentalCode=" + '\'' + rentalCode + '\'';
		System.out.println(command);
		return DBConnection.query(command);
	}

	public static void updateAfterReturnBike(String rentalCode, int rentBikeCost, String returnTime) {
		String command = "UPDATE rentbikeinvoice SET rentBikeCost=" + rentBikeCost + ", returnTime=" + '\'' + returnTime
				+ '\'' + " WHERE rentalCode=" + '\'' + rentalCode + '\'';
		DBConnection.execute(command);
	}
}
