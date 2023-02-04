package entity.dock;

import java.util.ArrayList;
import entity.bike.Bike;

public class Dock {

	// dock ID
	private String dockID;

	// dock name
	private String name;

	// dock address
	private String address;

	// dock area
	private String area;

	// number of docking points
	private int numberOfDockingPoints;

	// list of bikes
	private ArrayList<Bike> bikes;

	/**
	 * constructor
	 * 
	 * @param _dockID
	 * @param _name
	 * @param _address
	 * @param _area
	 * @param _numberOfDockingPoints
	 * @param _bikes:                Array list Bike
	 */
	public Dock(String _dockID, String _name, String _address, String _area, int _numberOfDockingPoints,
			ArrayList<Bike> _bikes) {
		this.dockID = _dockID;
		this.name = _name;
		this.address = _address;
		this.area = _area;
		this.numberOfDockingPoints = _numberOfDockingPoints;
		this.bikes = _bikes;
	}

	public ArrayList<Bike> getBikes() {
		return bikes;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getArea() {
		return area;
	}

	public String getDockID() {
		return dockID;
	}

	public void setDockID(String _dockID) {
		this.dockID = _dockID;
	}

	public int getNumberOfDockingPoints() {
		return numberOfDockingPoints;
	}

	public int getNumberOfBikes() {
		return this.bikes.size();
	}

	/**
	 * @return int: number of bikes not in use
	 */
	public int getNumberOfBikesNotInUse() {
		int count = 0;

		for (Bike bike : this.getBikes()) {
			if (!bike.getInUse())
				count += 1;
		}

		return count;
	}

	/**
	 * @param _bikeID: bike ID (int)
	 * @return Bike in this dock
	 */
	public Bike getBikeByID(int _bikeID) {
		for (Bike bike : this.getBikes()) {
			if (_bikeID == bike.getBikeID()) {
				return bike;
			}
		}
		return null;
	}

	/**
	 * @return boolean: if this dock has spare points
	 */
	public boolean checkSparePoints() {
		return this.getNumberOfDockingPoints() - this.getBikes().size() > 0;
	}

	/**
	 * @return general information of dock
	 */
	public ArrayList<String> getDockInfo() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(dockID); // dock ID
		result.add(name); // name
		result.add(address); // address
		result.add(Integer.toString(this.getBikes().size())); // total bikes
		result.add(Integer.toString(getNumberOfDockingPoints())); // docking points
		result.add(Integer.toString(getNumberOfBikesNotInUse())); // bikes available
		return result;
	}

}
