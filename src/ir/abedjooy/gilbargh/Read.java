package ir.abedjooy.gilbargh;

public class Read {

	private int _iD;
	private String _subscription_id;
	private String _read_date;
	private String _low;
	private String _medium;
	private String _high;
	private String _description;

	public Read() {

	}

	public Read(int ID, String SubscriptionId, String ReadDate, String Low,
			String Medium, String High, String Description) {
		this._iD = ID;
		this._subscription_id = SubscriptionId;
		this._read_date = ReadDate;
		this._low = Low;
		this._medium = Medium;
		this._high = High;
		this._description = Description;
	}

	// ////////////////////////////////////////////////////

	public int getID() {
		return this._iD;
	}

	public void setID(int Id) {
		this._iD = Id;
	}

	// ///////////////////////////

	public String getSubscriptionID() {
		return this._subscription_id;
	}

	public void setSubscriptionID(String subscriptionId) {
		this._subscription_id = subscriptionId;
	}

	// ///////////////////////////

	public String getReadDate() {
		return this._read_date;
	}

	public void setReadDate(String readDate) {
		this._read_date = readDate;
	}

	// ///////////////////////////

	public String getLow() {
		return this._low;
	}

	public void setLow(String low) {
		this._low = low;
	}

	// ///////////////////////////

	public String getMedium() {
		return this._medium;
	}

	public void setMedium(String medium) {
		this._medium = medium;
	}

	// ///////////////////////////

	public String getHigh() {
		return this._high;
	}

	public void setHigh(String high) {
		this._high = high;
	}

	// ///////////////////////////

	public String getDescription() {
		return this._description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	// ///////////////////////////

}
