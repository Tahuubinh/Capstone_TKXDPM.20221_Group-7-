package entity.invoice;

import entity.DAO.RentBikeInvoiceDAO;

public class RentBikeInvoice {

	// rental code
	private String rentalCode;

	// bike code
	private int bikeCode;

	// type of bike
	private String type;

	// rent cost
	private int rentCost;

	// transaction maker
	private String owner;

	// rent time
	private String rentTime;

	// return time
	private String returnTime;

	// deposit
	private int deposit;

	/**
	 * constructor
	 * 
	 * @param _rentalCode
	 * @param _bikeCode
	 * @param _type
	 * @param _owner
	 * @param _rentTime
	 * @param _deposit
	 */
	public RentBikeInvoice(String _rentalCode, int _bikeCode, String _type, String _owner, String _rentTime,
			int _deposit) {
		this.rentalCode = _rentalCode;
		this.bikeCode = _bikeCode;
		this.type = _type;
		this.rentCost = 0;
		this.owner = _owner;
		this.rentTime = _rentTime;
		this.returnTime = null;
		this.deposit = _deposit;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int _deposit) {
		this.deposit = _deposit;
	}

	public int getBikeCode() {
		return bikeCode;
	}

	public String getRentalCode() {
		return rentalCode;
	}

	public String getType() {
		return type;
	}

	public String getRentTime() {
		return rentTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public int getRentCost() {
		return rentCost;
	}

	public String getOwner() {
		return owner;
	}

	public void setBikeCode(int _bikeCode) {
		this.bikeCode = _bikeCode;
	}

	public void setRentalCode(String _rentalCode) {
		this.rentalCode = _rentalCode;
	}

	public void setType(String _type) {
		this.type = _type;
	}

	public void setRentTime(String _rentTime) {
		this.rentTime = _rentTime;
	}

	public void setReturnTime(String _returnTime) {
		this.returnTime = _returnTime;
	}

	public void setRentCost(int _rentCost) {
		this.rentCost = _rentCost;
	}

	public void setOwner(String _owner) {
		this.owner = _owner;
	}

	/**
	 * @return String: detail of the invoice
	 */
	public String getDetail() {
		String s0 = " Detail of rent bike invoice !";
		String s1 = String.format("  %-30s%-30s", "Rental code", rentalCode);
		String s2 = String.format("  %-30s%-30d", "Bike code", bikeCode);
		String s3 = String.format("  %-30s%-30s", "Type", type);
		String s4 = String.format("  %-30s%-30s", "Owner", owner);
		String s5 = String.format("  %-30s%-30s", "Rent time", rentTime);
		String s6 = String.format("  %-30s%-30s", "Return time", returnTime);
		String s7 = String.format("  %-30s%-30d", "Deposit", deposit);
		String s8 = String.format("  %-30s%-30d", "Rent bike cost", rentCost);

		return s0 + '\n' + s1 + '\n' + s2 + '\n' + s3 + '\n' + s4 + '\n' + s5 + '\n' + s6 + '\n' + s7 + '\n' + s8;
	}

	/**
	 * save rent bike invoice in database
	 */
	public void saveRentBikeInvoice() {
		RentBikeInvoiceDAO.save(bikeCode, rentalCode, type, rentTime, returnTime, rentCost, owner, deposit);
	}

	public void updateAfterReturnBike(String returnTime, int rentCost) {
		this.returnTime = returnTime;
		this.rentCost = rentCost;
		RentBikeInvoiceDAO.updateAfterReturnBike(rentalCode, rentCost, returnTime);
	}
}
