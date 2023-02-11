package entity.bike;

import java.util.ArrayList;

public abstract class Bike {

	public enum type {
		singleNormal,
		doubleNormal,
		singleElectric
	}

	// bike id
	private int bikeID;

	// bike status
	private boolean inUse;

	// bike value
	private int value;

	// number of pedals
	private int numPedal;

	// number of seats
	private int numSeat;

	// dock ID
	private String dockID;

	// bike license
	private String bikeLicense;

	// bike type
	private type bikeType;

	/**
	 * construction
	 */
	public Bike() {
	}

	/**
	 * constructor
	 * 
	 * @param _bike : Arraylist string
	 */
	public Bike(ArrayList<String> _bike) {
		this.setBikeID(Integer.parseInt(_bike.get(0)));
		this.setInUse(_bike.get(1) == "YES");
		this.setValue(Integer.parseInt(_bike.get(2)));
		this.setNumPedal(Integer.parseInt(_bike.get(3)));
		this.setNumSeat(Integer.parseInt(_bike.get(4)));
		this.setDockID(_bike.get(5));
		this.setBikeLicense(_bike.get(6));
	}

	public void setBikeType(type _bikeType) {
		this.bikeType = _bikeType;
	}

	public void setNumPedal(int _numPedal) {
		this.numPedal = _numPedal;
	}

	public void setNumSeat(int _numSeat) {
		this.numSeat = _numSeat;
	}

	public void setBikeID(int _bikeID) {
		this.bikeID = _bikeID;
	}

	public void setInUse(boolean _inUse) {
		this.inUse = _inUse;
	}

	public void setValue(int _value) {
		this.value = _value;
	}

	public void setDockID(String _dockID) {
		this.dockID = _dockID;
	}

	public void setBikeLicense(String _bikeLicense) {
		this.bikeLicense = _bikeLicense;
	}

	public type getBikeType() {
		return bikeType;
	}

	public int getBikeID() {
		return bikeID;
	}

	public int getValue() {
		return value;
	}

	public int getNumPedal() {
		return numPedal;
	}

	public int getNumSeat() {
		return numSeat;
	}

	public String getDockID() {
		return dockID;
	}

	public String getbikeLicense() {
		return bikeLicense;
	}

	/**
	 * calculate deposit of bike
	 * 
	 * @return int: deposit
	 */
	public int calculateDeposit() {
		return 4 * getValue() / 10;
	}

	/**
	 * @return boolean: status of bike
	 */
	public boolean getInUse() {
		return inUse;
	}

	/**
	 * @return String: general information of bike
	 */
	public String getGeneralInfo() {
		return bikeID + " - " + getBikeType().name();
	}

	/**
	 * Update dock status
	 * 
	 * @param inUse
	 * @param dockID
	 */
	public void updateStatus(boolean _inUse, String _dockID) {
		this.inUse = _inUse;
		BikeDAO.updateStatus(this.bikeID, _inUse, _dockID);
	}

	/**
	 * @return result as ArrayList String: general information of bike
	 */
	public ArrayList<String> getBikeInfo() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(String.valueOf(bikeID));
		result.add((this.inUse ? "YES" : "NO"));
		result.add(String.valueOf(value));
		result.add(String.valueOf(numPedal));
		result.add(String.valueOf(numSeat));
		result.add(dockID);
		result.add(bikeLicense);
		result.add(this.getBikeType().name());
		result.add(String.valueOf(this.calculateDeposit()));
		return result;
	}

	/**
	 * Function to calculate rent cost
	 * 
	 * @param _duration: rent time duration (caculated in minutes)
	 * @return rent cost
	 */
	public abstract int caculateRentCost(int _duration);

	/**
	 * Get Bike (similarly to a bike parser)
	 * 
	 * @param _bike
	 * @return bike with exact bikeType
	 */
	public static final Bike getBike(ArrayList<String> _bike) {
		String bikeTypeString = _bike.get(1);
		switch (bikeTypeString) {
			case "singleNormal":
				return new SingleNormalBike(_bike);
			case "doubleNormal":
				return new DoubleNormalBike(_bike);
			case "singleElectric":
				return new SingleElectricBike(_bike);
			default:
				throw new IllegalArgumentException("This type " + bikeTypeString +" is not available");
		}
	}
}
