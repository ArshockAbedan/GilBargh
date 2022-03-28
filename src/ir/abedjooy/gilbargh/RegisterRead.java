package ir.abedjooy.gilbargh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import ir.abedjooy.gilbargh.R.id;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;

public class RegisterRead extends Activity {

	public static String SubscriptionId;

	public String CurrentDateNum = "";
	public String CurrentYearMonthNum = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_read);

		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		Contour contour = db.getContour(SubscriptionId);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");

		com.ghasemkiani.util.SimplePersianCalendar calendergh = new com.ghasemkiani.util.SimplePersianCalendar();
		com.ghasemkiani.util.DateFields t = calendergh.getDateFields();

		@SuppressWarnings("static-access")
		String month = (String) (calendergh.getPersianMonthName(t.getMonth()))
				.toString();
		// م 3 مرداد 1393
		String CurrentDate = t.getDay() + " " + month.toString() + " "
				+ t.getYear();

		String DayCorr = CorrectDateOneDigit(String.valueOf(t.getDay()));
		String monthNum = String.valueOf(t.getMonth() + 1);
		String MonthCorr = CorrectDateOneDigit(monthNum);
		// 1393/05/03
		CurrentDateNum = String.valueOf(t.getYear()) + "/" + MonthCorr + "/"
				+ DayCorr;

		// 1393/05
		CurrentYearMonthNum = String.valueOf(t.getYear()) + "/" + MonthCorr;

		TextView txtTarikh = (TextView) findViewById(id.txtTarikhInReg);
		txtTarikh.setText(CurrentDate);
		txtTarikh.setTypeface(tf);

		if (!contour.getContourType().equalsIgnoreCase("دیجیتال")) {
			EditText EditTxtHigh = (EditText) findViewById(id.EditTxtHigh);
			if (EditTxtHigh.isEnabled()) {
				EditTxtHigh.setEnabled(false);
				EditTxtHigh.setBackgroundColor(Color.GRAY);
			}

			EditText EditTxtLow = (EditText) findViewById(id.EditTxtlow);
			if (EditTxtLow.isEnabled()) {
				EditTxtLow.setEnabled(false);
				EditTxtLow.setBackgroundColor(Color.GRAY);
			}
		}

	}

	public void RegisterFunc(View view) {
		if (CheckIsRegisterdBefore(CurrentYearMonthNum)) {
			Toast.makeText(getApplicationContext(),
					"در این ماه ارقام کنتور پیش تر ثبت شده اند.",
					Toast.LENGTH_LONG).show();
		} else {
			EditText EditTxtHigh = (EditText) findViewById(id.EditTxtHigh);
			String High = EditTxtHigh.getText().toString();

			EditText EditTxtMid = (EditText) findViewById(id.EditTxtMid);
			String Mid = EditTxtMid.getText().toString();

			EditText EditTxtLow = (EditText) findViewById(id.EditTxtlow);
			String Low = EditTxtLow.getText().toString();

			EditText EditTxtDescription = (EditText) findViewById(id.editTextDescription);
			String Description = EditTxtDescription.getText().toString();

			Connection DbConn = null;
			Statement stmt = null;
			// ResultSet resultSet = null;

			try {
				// Establish the connection.

				DatabaseHandler db = new DatabaseHandler(
						getApplicationContext());

				Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();

				String username = "sa";
				String password = "[OSmehdi123]guilan";
				String Database = "PowerStationDB";

				if (android.os.Build.VERSION.SDK_INT > 9) {
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
							.permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}

				DbConn = DriverManager
						.getConnection("jdbc:jtds:sqlserver://217.11.23.244:1433/"
								+ Database
								+ ";user="
								+ username
								+ ";password="
								+ password + ";");

				stmt = DbConn.createStatement();

				String TableName = "t_read";

				String Query = " INSERT INTO " + TableName
						+ "( eshterak_id, read_date,"
						+ " low, mid, high, description)" + " Values ( "
						+ " N'" + SubscriptionId + "' , N'" + CurrentDateNum
						+ "' , N'" + Low + "' , N'" + Mid + "' , N'" + High
						+ "' , N'" + Description + "' " + ");";
				stmt.execute(Query);
				DbConn.close();

				Read read = new Read();
				read.setSubscriptionID(SubscriptionId);
				read.setReadDate(CurrentDateNum);
				read.setLow(Low);
				read.setMedium(Mid);
				read.setHigh(High);
				read.setDescription(Description);
				db.addRead(read);

			} catch (Exception e) {
				Log.w("Error connection", "" + e.getMessage());

			}

			Toast.makeText(getApplicationContext(),
					"ارقام  فعلی کنتور قرائت شد", Toast.LENGTH_LONG).show();
			RegisterRead.this.finish();
		}
	}

	private boolean CheckIsRegisterdBefore(String yearMonth) {
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		Read read = db.getLastRead();
		if (read == null)
		{
			return false;
		}
		String LastReadedDate = read.getReadDate();

		char arr[] = LastReadedDate.toCharArray();

		String cuttedLastReadedDate = Character.toString(arr[0])
				+ Character.toString(arr[1]) + Character.toString(arr[2])
				+ Character.toString(arr[3]) + Character.toString(arr[4])
				+ Character.toString(arr[5]) + Character.toString(arr[6]);

		if (cuttedLastReadedDate.equalsIgnoreCase(yearMonth)) {
			return true;
		} else {
			return false;
		}

	}

	// a function for Converting one digit Day/Month to 2 digits
	private String CorrectDateOneDigit(String Digit) {
		String CorrectedDigit;
		if (Digit.length() == 1) {
			CorrectedDigit = '0' + Digit;
		} else {
			CorrectedDigit = Digit;
		}

		return CorrectedDigit;

	}
}
