package ir.abedjooy.gilbargh;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "GilBarghDB.db";

	// /////////////////////////////////////////////////////////////////////////////////////

	// Contour table name
	private static final String TABLE_CONTOUR = "Contour";

	// Read table name
	private static final String TABLE_READ = "Read";

	// PowerDepartment table name
	private static final String TABLE_POWERDEPARTMENT = "Power_Department";

	// /////////////////////////////////////////////////////////////////////////////////////

	// CONTOUR Table Columns names
	private static final String KEY_CONTOUR_ID = "id";
	private static final String KEY_CONTOUR_SUBSCRIPTION_ID = "subscription_id";
	private static final String KEY_CONTOUR_CENTER_ID_FK = "center_id_fk";
	private static final String KEY_CONTOUR_FILE_ID = "file_id";
	private static final String KEY_CONTOUR_IDENTIFICATION_ID = "identification_id";
	private static final String KEY_CONTOUR_CONTOUR_BODY_NUMBER = "contour_body_number";
	private static final String KEY_CONTOUR_PHASE = "phase";
	private static final String KEY_CONTOUR_AMPER = "amper";
	private static final String KEY_CONTOUR_INSTALLATION_DATE = "installation_date";
	private static final String KEY_CONTOUR_TARIFF_ID_FK = "tariff_id_fk";
	private static final String KEY_CONTOUR_TARIFF_NAME_FK = "tariff_name";
	private static final String KEY_CONTOUR_NUMBER_OF_HOUSEHOLDS = "number_of_households";
	private static final String KEY_CONTOUR_FIRSTNAME = "firstName";
	private static final String KEY_CONTOUR_LASTNAME = "lastName";
	private static final String KEY_CONTOUR_NATIONAL_CODE = "national_code";
	private static final String KEY_CONTOUR_ADDRESS = "address";
	private static final String KEY_CONTOUR_PHONE = "phone";
	private static final String KEY_CONTOUR_MOBILE = "mobile";
	private static final String KEY_CONTOUR_STATUS = "status";
	private static final String KEY_CONTOUR_DESCRIPTION = "description";
	private static final String KEY_CONTOUR_PASSWORD = "password";
	private static final String KEY_CONTOUR_COUNTOUR_TYPE = "contour_type";

	// Read Table Columns names
	private static final String KEY_READ_ID = "id";
	private static final String KEY_READ_SUBSCRIPTION_ID = "subscription_id";
	private static final String KEY_READ_DATE = "read_date";
	private static final String KEY_READ_LOW = "low";
	private static final String KEY_READ_MEDIUM = "medium";
	private static final String KEY_READ_HIGH = "high";
	private static final String KEY_READ_DESCRIPTION = "description";

	// PowerDepartment Table Columns names
	private static final String KEY_POWERDEPARTMENT_ID = "id";
	private static final String KEY_POWERDEPARTMENT_NAME = "name";
	private static final String KEY_POWERDEPARTMENT_PHONE = "phone";
	private static final String KEY_POWERDEPARTMENT_FAX = "fax";
	private static final String KEY_POWERDEPARTMENT_ADDRESS = "address";
	private static final String KEY_POWERDEPARTMENT_DESCRIPTION = "description";

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	// Table Create Statements

	// CONTOUR table create statement
	String CREATE_CONTOUR_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTOUR
			+ "(" + KEY_CONTOUR_ID + " INTEGER PRIMARY KEY, "
			+ KEY_CONTOUR_SUBSCRIPTION_ID + " TEXT," + KEY_CONTOUR_CENTER_ID_FK
			+ " TEXT," + KEY_CONTOUR_FILE_ID + " TEXT,"
			+ KEY_CONTOUR_IDENTIFICATION_ID + " TEXT,"
			+ KEY_CONTOUR_CONTOUR_BODY_NUMBER + " TEXT," + KEY_CONTOUR_PHASE
			+ " TEXT," + KEY_CONTOUR_AMPER + " TEXT,"
			+ KEY_CONTOUR_INSTALLATION_DATE + " TEXT,"
			+ KEY_CONTOUR_TARIFF_ID_FK + " TEXT," + KEY_CONTOUR_TARIFF_NAME_FK
			+ " TEXT," + KEY_CONTOUR_NUMBER_OF_HOUSEHOLDS + " TEXT,"
			+ KEY_CONTOUR_FIRSTNAME + " TEXT," + KEY_CONTOUR_LASTNAME
			+ " TEXT," + KEY_CONTOUR_NATIONAL_CODE + " TEXT,"
			+ KEY_CONTOUR_ADDRESS + " TEXT," + KEY_CONTOUR_PHONE + " TEXT,"
			+ KEY_CONTOUR_MOBILE + " TEXT," + KEY_CONTOUR_STATUS + " TEXT,"
			+ KEY_CONTOUR_DESCRIPTION + " TEXT," + KEY_CONTOUR_PASSWORD
			+ " TEXT," + KEY_CONTOUR_COUNTOUR_TYPE + " TEXT" + ")";

	// READ table create statement
	String CREATE_READ_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_READ + "("
			+ KEY_READ_ID + " INTEGER PRIMARY KEY, " + KEY_READ_SUBSCRIPTION_ID
			+ " TEXT," + KEY_READ_DATE + " TEXT," + KEY_READ_LOW + " TEXT,"
			+ KEY_READ_MEDIUM + " TEXT," + KEY_READ_HIGH + " TEXT,"
			+ KEY_READ_DESCRIPTION + " TEXT" + ")";

	// POWER DEPARTMENT table create statement
	String CREATE_POWERDEPARTMENT_TABLE = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_POWERDEPARTMENT + "(" + KEY_POWERDEPARTMENT_ID
			+ " TEXT PRIMARY KEY, " + KEY_POWERDEPARTMENT_NAME + " TEXT,"
			+ KEY_POWERDEPARTMENT_PHONE + " TEXT," + KEY_POWERDEPARTMENT_FAX
			+ " TEXT," + KEY_POWERDEPARTMENT_ADDRESS + " TEXT,"
			+ KEY_POWERDEPARTMENT_DESCRIPTION + " TEXT" + ")";

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// creating required tables
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_CONTOUR_TABLE);
		db.execSQL(CREATE_READ_TABLE);
		db.execSQL(CREATE_POWERDEPARTMENT_TABLE);

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed

		if (oldVersion != newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTOUR);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_READ);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_POWERDEPARTMENT);

			// Create tables again
			onCreate(db);

		}
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// ------------------------ "Contour" table methods ----------------//

	// Adding new Contour
	public void addContour(Contour contour) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		// values.put(KEY_CONTOUR_ID, null));
		values.put(KEY_CONTOUR_SUBSCRIPTION_ID, contour.getSubscriptionId());
		values.put(KEY_CONTOUR_CENTER_ID_FK, contour.getCenterID());
		values.put(KEY_CONTOUR_FILE_ID, contour.getFileId());
		values.put(KEY_CONTOUR_IDENTIFICATION_ID, contour.getIdentificationId());
		values.put(KEY_CONTOUR_CONTOUR_BODY_NUMBER,
				contour.getContourBodyNumber());
		values.put(KEY_CONTOUR_PHASE, contour.getPhase());
		values.put(KEY_CONTOUR_AMPER, contour.getAmper());
		values.put(KEY_CONTOUR_INSTALLATION_DATE, contour.getInstallationDate());
		values.put(KEY_CONTOUR_TARIFF_ID_FK, contour.getTariffID());
		values.put(KEY_CONTOUR_TARIFF_NAME_FK, contour.getTariffName());
		values.put(KEY_CONTOUR_NUMBER_OF_HOUSEHOLDS,
				contour.getNumberOfHouseholds());
		values.put(KEY_CONTOUR_FIRSTNAME, contour.getFirstName());
		values.put(KEY_CONTOUR_LASTNAME, contour.getLastName());
		values.put(KEY_CONTOUR_NATIONAL_CODE, contour.getNationalCode());
		values.put(KEY_CONTOUR_ADDRESS, contour.getAddress());
		values.put(KEY_CONTOUR_PHONE, contour.getPhoneNumber());
		values.put(KEY_CONTOUR_MOBILE, contour.getMobile());
		values.put(KEY_CONTOUR_STATUS, contour.getStatus());
		values.put(KEY_CONTOUR_DESCRIPTION, contour.getDescription());
		values.put(KEY_CONTOUR_PASSWORD, contour.getPassword());
		values.put(KEY_CONTOUR_COUNTOUR_TYPE, contour.getContourType());

		// Inserting Row
		db.insert(TABLE_CONTOUR, null, values);
		db.close(); // Closing database connection
	}

	// getSpecificContour by subscription ID (Eshterak id)
	public Contour getContour(String SubscriptionId) {

		String selectQuery = "SELECT  * FROM " + TABLE_CONTOUR + "   WHERE  "
				+ KEY_CONTOUR_SUBSCRIPTION_ID + " = '"
				+ SubscriptionId.toString() + "'";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		Object C = cursor.getCount();
		if (Integer.parseInt(C.toString()) == 0) {
			return null;
		}
		if (cursor != null)
			cursor.moveToFirst();

		Contour contour = new Contour(1, cursor.getString(1),
				cursor.getString(2), cursor.getString(3), cursor.getString(4),
				cursor.getString(5), cursor.getString(6), cursor.getString(7),
				cursor.getString(8), cursor.getString(9), cursor.getString(10),
				cursor.getString(11), cursor.getString(12),
				cursor.getString(13), cursor.getString(14),
				cursor.getString(15), cursor.getString(16),
				cursor.getString(17), cursor.getString(18),
				cursor.getString(19), cursor.getString(20),
				cursor.getString(21));

		db.close(); // Closing database connection
		// return contour
		return contour;

	}

	// Deleting All items of Contour table
	public void deleteAllContour() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTOUR, null, null);
		db.close();
	}

	// ------------------------ "READ" table methods ----------------//

	// Adding new Read
	public void addRead(Read read) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		// values.put(KEY_READ_ID, null));
		values.put(KEY_READ_SUBSCRIPTION_ID, read.getSubscriptionID());
		values.put(KEY_READ_DATE, read.getReadDate());
		values.put(KEY_READ_LOW, read.getLow());
		values.put(KEY_READ_MEDIUM, read.getMedium());
		values.put(KEY_READ_HIGH, read.getHigh());
		values.put(KEY_READ_DESCRIPTION, read.getDescription());

		// Inserting Row
		db.insert(TABLE_READ, null, values);
		db.close(); // Closing database connection
	}

	public List<Read> getAllRead() {
		List<Read> readList = new ArrayList<Read>();
		// Select All query
		String SelectQuery = " SELECT * FROM " + TABLE_READ;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor curser = db.rawQuery(SelectQuery, null);

		// looping through all row and adding to list
		if (curser.moveToFirst()) {
			do {

				Read rd = new Read();
				rd.setID(curser.getInt(0));
				rd.setSubscriptionID(curser.getString(1));
				rd.setReadDate(curser.getString(2));
				rd.setLow(curser.getString(3));
				rd.setMedium(curser.getString(4));
				rd.setHigh(curser.getString(5));
				rd.setDescription(curser.getString(6));

				// Add Read To list
				readList.add(rd);
			} while (curser.moveToNext());
		}

		// return Read list
		return readList;

	}

	
	
	
	// get Last Read Record 
		public Read getLastRead() {

			String SelectQuery = " SELECT * FROM " + TABLE_READ 
					+ " Order by " + KEY_READ_ID + " DESC  LIMIT 1 ";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(SelectQuery, null);

			Object C = cursor.getCount();
			if (Integer.parseInt(C.toString()) == 0) {
				return null;
			}
			if (cursor != null)
				cursor.moveToFirst();

			Read rd = new Read();
			rd.setID(cursor.getInt(0));
			rd.setSubscriptionID(cursor.getString(1));
			rd.setReadDate(cursor.getString(2));
			rd.setLow(cursor.getString(3));
			rd.setMedium(cursor.getString(4));
			rd.setHigh(cursor.getString(5));
			rd.setDescription(cursor.getString(6));

			db.close(); // Closing database connection
			// return Read
			return rd;

		}
	
	
	
	
	// Deleting All items of Read table
	public void deleteAllRead() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_READ, null, null);
		db.close();
	}

	// -------- "Power Department" table methods-------------------//

	// Adding new Power_Department
	public void addPowerDepartment(PowerDepartment pd) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_POWERDEPARTMENT_ID, pd.getID());
		values.put(KEY_POWERDEPARTMENT_NAME, pd.getName());
		values.put(KEY_POWERDEPARTMENT_PHONE, pd.getPhone());
		values.put(KEY_POWERDEPARTMENT_FAX, pd.getFax());
		values.put(KEY_POWERDEPARTMENT_ADDRESS, pd.getAddress());
		values.put(KEY_POWERDEPARTMENT_DESCRIPTION, pd.getDescription());

		// Inserting Row
		db.insert(TABLE_POWERDEPARTMENT, null, values);
		db.close(); // Closing database connection
	}

	// get Specific Power_Department
	public PowerDepartment getPowerDepartment() {

		String selectQuery = "SELECT  * FROM " + TABLE_POWERDEPARTMENT
				+ "  LIMIT 1 ";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		Object C = cursor.getCount();
		if (Integer.parseInt(C.toString()) == 0) {
			return null;
		}
		if (cursor != null)
			cursor.moveToFirst();
		// String[] ssdd = cursor.getColumnNames();

		PowerDepartment powerDepartment = new PowerDepartment();
		powerDepartment.setID(cursor.getString(0).toString());
		powerDepartment.setName(cursor.getString(1));
		powerDepartment.setPhone(cursor.getString(2));
		powerDepartment.setFax(cursor.getString(3));
		powerDepartment.setAddress(cursor.getString(4));
		powerDepartment.setDescription(cursor.getString(5).toString());

		db.close(); // Closing database connection
		// return Power_Department
		return powerDepartment;

	}

	// get Specific Power_Department by ID (Center_id)
	public PowerDepartment getPowerDepartment(String ID) {

		String selectQuery = "SELECT  * FROM " + TABLE_POWERDEPARTMENT
				+ "   WHERE  " + KEY_POWERDEPARTMENT_ID + " = '"
				+ ID.toString() + "'";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		Object C = cursor.getCount();
		if (Integer.parseInt(C.toString()) == 0) {
			return null;
		}
		if (cursor != null)
			cursor.moveToFirst();

		PowerDepartment powerDepartment = new PowerDepartment(
				cursor.getString(0), cursor.getString(1), cursor.getString(2),
				cursor.getString(3), cursor.getString(4), cursor.getString(5));

		db.close(); // Closing database connection
		// return Power_Department
		return powerDepartment;

	}

	// Deleting All items of Power_Department table
	public void deleteAllPowerDepartment() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_POWERDEPARTMENT, null, null);
		db.close();
	}

}
