package ir.abedjooy.gilbargh;

public class Contour {

	private int _iD;
	private String _subscription_id;
	private String _center_id;
	private String _file_id;
	private String _identificatin_id;
	private String _contour_body_number;
	private String _phase;
	private String _amper;
	private String _installation_date;
	private String _tariff_id;
	private String _tariff_name;
	private String _number_of_households;
	private String _fname;
	private String _lname;
	private String _national_code;
	private String _address;
	private String _phone_number;
	private String _mobile;
	private String _status;
	private String _description;
	private String _pass;
	private String _contour_type;

	public Contour() {

	}

	public Contour(int Id, String SubscriptionId, String CenterID,
			String FileId, String IdentificationId, String ContourBodyNumber,
			String Phase, String Amper, String InstallationDate, String TariffID,
			String TariffName, String NumberOfHouseholds, String FirstName,
			String LastName, String NationalCode, String Address, String PhoneNumber,
			String Mobile, String Status, String Description, String Password,
			String ContourType) {

		this._iD = Id;
		this._subscription_id = SubscriptionId;
		this._center_id = CenterID;
		this._file_id = FileId;
		this._identificatin_id = IdentificationId;
		this._contour_body_number = ContourBodyNumber;
		this._phase = Phase;
		this._amper = Amper;
		this._installation_date = InstallationDate;
		this._tariff_id = TariffID;
		this._tariff_name = TariffName;
		this._number_of_households = NumberOfHouseholds;
		this._fname = FirstName;
		this._lname = LastName;
		this._national_code = NationalCode;
		this._address = Address;
		this._phone_number = PhoneNumber;
		this._mobile = Mobile;
		this._status = Status;
		this._description = Description;
		this._pass = Password;
		this._contour_type = ContourType;

	}

	// ----------------------------------------------//

	// /////////////////////////////////////////
	public int getID() {
		return this._iD;
	}

	public void setID(int ID) {
		this._iD = ID;
	}

	// EshterakId /////////////////////////////////////////

	
	public String getSubscriptionId() {
		return this._subscription_id;
	}

	public void setSubscriptionId(String SubscriptionId) {
		this._subscription_id = SubscriptionId;
	}

	// /////////////////////////////////////////

	public String getCenterID() {
		return this._center_id;
	}

	public void setCenterID(String CenterID) {
		this._center_id = CenterID;
	}

	// ParvandeId   /////////////////////////////////

	public String getFileId() {
		return this._file_id;
	}

	public void setFileId(String FileId) {
		this._file_id = FileId;
	}

	// ShenasaeeId /////////////////////////////////////////
	
	public String getIdentificationId() {
		return this._identificatin_id;
	}

	public void setIdentificationId(String IdentificationId) {
		this._identificatin_id = IdentificationId;
	}

	//   BadaneKontoor ///////////////////////////////////
	
	public String getContourBodyNumber() {
		return this._contour_body_number;
	}

	public void setContourBodyNumber(String ContourBodyNumber) {
		this._contour_body_number = ContourBodyNumber;
	}

	// /////////////////////////////////////////

	public String getPhase() {
		return this._phase;
	}

	public void setPhase(String Phase) {
		this._phase = Phase;
	}

	// /////////////////////////////////////////
	
	public String getAmper() {
		return this._amper;
	}

	public void setAmper(String Amper) {
		this._amper = Amper;
	}

	//   TarikhNasb  //////////////////////////////////////

	public String getInstallationDate() {
		return this._installation_date;
	}

	public void setInstallationDate(String InstallationDate) {
		this._installation_date = InstallationDate;
	}

	// TarefeID /////////////////////////////////////////

	public String getTariffID() {
		return this._tariff_id;
	}

	public void setTariffID(String TariffID) {
		this._tariff_id = TariffID;
	}

	// TarefeName /////////////////////////////////////////

	public String getTariffName() {
		return this._tariff_name;
	}

	public void setTariffName(String TariffName) {
		this._tariff_name = TariffName;
	}

	//  TedadKHanevar /////////////////////////////////////////

	public String getNumberOfHouseholds() {
		return this._number_of_households;
	}

	public void setNumberOfHouseholds(String NumberOfHouseholds) {
		this._number_of_households = NumberOfHouseholds;
	}

	// /////////////////////////////////////////

	public String getFirstName() {
		return this._fname;
	}

	public void setFirstName(String FirstName) {
		this._fname = FirstName;
	}

	// /////////////////////////////////////////

	public String getLastName() {
		return this._lname;
	}

	public void setLastName(String LastName) {
		this._lname = LastName;
	}

	// MelliCode /////////////////////////////////////////

	public String getNationalCode() {
		return this._national_code;
	}

	public void setNationalCode(String NationalCode) {
		this._national_code = NationalCode;
	}

	// /////////////////////////////////////////	

	public String getAddress() {
		return this._address;
	}

	public void setAddress(String Address) {
		this._address = Address;
	}

	// Tell /////////////////////////////////////////

	public String getPhoneNumber() {
		return this._phone_number;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this._phone_number = PhoneNumber;
	}

	// /////////////////////////////////////////

	public String getMobile() {
		return this._mobile;
	}

	public void setMobile(String Mobile) {
		this._mobile = Mobile;
	}

	// /////////////////////////////////////////

	public String getStatus() {
		return this._status;
	}

	public void setStatus(String Status) {
		this._status = Status;
	}

	// /////////////////////////////////////////

	public String getDescription() {
		return this._description;
	}

	public void setDescription(String Description) {
		this._description = Description;
	}

	// /////////////////////////////////////////

	public String getPassword() {
		return this._pass;
	}

	public void setPassword(String Password) {
		this._pass = Password;
	}

	//  DigitalOrAnalog /////////////////////////////////////////
	

	public String getContourType() {
		return this._contour_type;
	}

	public void setContourType(String ContourType) {
		this._contour_type = ContourType;
	}

	// /////////////////////////////////////////

}
