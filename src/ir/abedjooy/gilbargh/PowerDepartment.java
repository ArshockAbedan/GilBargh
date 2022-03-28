package ir.abedjooy.gilbargh;

public class PowerDepartment {
	
	private String _iD;
	private String _name;
	private String _phone;
	private String _fax;
	private String _address;
	private String _description;
	
	public PowerDepartment()
	{
		
	}
	
	public PowerDepartment(String ID, String Name, String Phone,
			String Fax, String Address, String Description)
	{
		this._iD = ID;
		this._name = Name;
		this._phone = Phone;
		this._fax  = Fax;
		this._address = Address;
		this._description = Description;
	}
	
	/////////////////////////////////////////////
	
	public String getID()
	{
		return this._iD;
	}

	public void setID(String ID)
	{
		this._iD = ID;
	}
	
	/////////////////////////////
	
	public String getName()
	{
		return this._name;
	}

	public void setName(String Name)
	{
		this._name = Name;
	}
	
	/////////////////////////////
	
	public String getPhone()
	{
		return this._phone;
	}

	public void setPhone(String Phone)
	{
		this._phone = Phone;
	}
	
	/////////////////////////////
	
	public String getFax()
	{
		return this._fax;
	}

	public void setFax(String Fax)
	{
		this._fax = Fax;
	}
	
	/////////////////////////////
	
	public String getAddress()
	{
		return this._address;
	}

	public void setAddress(String Address)
	{
		this._address = Address;
	}
	
	/////////////////////////////
	
	public String getDescription()
	{
		return this._description;
	}

	public void setDescription(String DescriptionStr)
	{
		this._description = DescriptionStr;
	}
	
	/////////////////////////////
	
	
}
