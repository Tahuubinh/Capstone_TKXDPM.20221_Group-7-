package controller;

import entity.bike.Bike;
import entity.bike.BikeDAO;
import entity.dock.Dock;

import java.util.ArrayList;

public class DockController {
	
	public static ArrayList<Dock> getDocks() {
		ArrayList<Dock> docks = new ArrayList<>();
		ArrayList<ArrayList<String>> dockTable = Dock.getDockTable();
		for (ArrayList<String> row : dockTable) {
			String dockID = row.get(0);
			String name = row.get(1);
			String area = row.get(2);
			String address = row.get(3);
			int numberOfDockingPoints = Integer.parseInt(row.get(5));
			ArrayList<Bike> bikes = getBikes(dockID);
			docks.add(new Dock(dockID, name, address, area, numberOfDockingPoints, bikes));
		}
		return docks;
	}

	public static ArrayList<Bike> getBikes(String _dockID) {
		ArrayList<ArrayList<String>> bikeTable = BikeDAO.queryWithDockID(_dockID);
		ArrayList<Bike> bikes = new ArrayList<>();
		try {
			for (ArrayList<String> row : bikeTable) {
//				for (String x: row) {
//					System.out.println(x);
//				}
				bikes.add(Bike.getBike(row));
			}
		} catch (Exception e) {
			System.err.println("Cannot get some types of bikes from database!");
			e.printStackTrace();
		}
		return bikes;
	}

	public static Dock getDockFromString(String _dockInfo) {
		for (Dock dock : getDocks()) {
			String s = dock.toString();
			if (_dockInfo.equals(s)) {
				return dock;
			}
		}
		return null;
	}

	public static Bike getBikeFromID(int _id) {
		for (ArrayList<String> bikeString : BikeDAO.getBikes()) {
			if (Bike.getBike(bikeString).getBikeID() == _id) {
				return Bike.getBike(bikeString);
			}
		}
		return null;
	}
	
	public static boolean checkBikeIsInUse(int id) {
		for (ArrayList<String> bikeString : BikeDAO.getBikes()) {
			Bike bike = Bike.getBike(bikeString);
			if (bike.getBikeID() == id) {
				return bike.getInUse();
			}
		}
		return true;
	}
}
