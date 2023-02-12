package controller;

import entity.bike.*;
import entity.dock.Dock;
import entity.DAO.*;

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
			Dock dock = new Dock(dockID, name, address, area, numberOfDockingPoints, bikes);
			docks.add(dock);
		}
		return docks;
	}

	public static ArrayList<Bike> getBikes(String dockID) {
		ArrayList<ArrayList<String>> bikeTable = BikeDAO.queryWithDockID(dockID);
		ArrayList<Bike> bikes = new ArrayList<>();
		for (ArrayList<String> row : bikeTable) {
			Bike bike = Bike.getBike(row);
			bikes.add(bike);
		}
		return bikes;
	}

	public static Dock getDockFromString(String dockInfo) {
		for (Dock dock : getDocks()) {
			String s = dock.toString();
			if (dockInfo.equals(s)) {
				return dock;
			}
		}
		return null;
	}
	
	public static Dock getDockFromName(String name) {
		for (Dock dock : getDocks()) {
			if (dock.getDockID().equals(name)) {
				return dock;
			}
		}
		return null;
	}

	public static Bike getBikeFromID(int id) {
		for (ArrayList<String> bikeString : BikeDAO.getBikes()) {
			Bike bike = Bike.getBike(bikeString);
			if (bike.getBikeID() == id) {
				return bike;
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
