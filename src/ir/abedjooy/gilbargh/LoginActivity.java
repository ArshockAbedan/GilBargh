package ir.abedjooy.gilbargh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.R.color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

public class LoginActivity extends Activity {

	 ProgressDialog dialog;  
	 boolean showingInvalidUserToast = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		this.setTitle("احراز هویت");
		this.setTitleColor(color.white);
	}

	// ////////////////////////////////////////////////
	public void EnterApp(View view) {
		if (isNetworkAvailable() == true) {
		
			log_in l = new log_in();
			l.execute(new String[] { "http://www.abedjooy.ir" });


		} else if (isNetworkAvailable() == false) {
			Toast.makeText(getApplicationContext(),
					"ارتباط با اینترنت برقرار نیست", Toast.LENGTH_SHORT).show();
		}
		
		
		
		
        

		
	}

	// A function for authentication of user in server side 
	// And add that user crossponding contour in Contour Table ( in SQLite)
	private boolean AuthenticationFunc(String userName, String passWord) {

		boolean returnedValue = false;
		// Declare the JDBC objects.
		Connection DbConn = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			// Establish the connection.

			DatabaseHandler db = new DatabaseHandler(getApplicationContext());

			// Delete All Items in Contour Table
			db.deleteAllContour();

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
							+ Database + ";user=" + username + ";password="
							+ password + ";");

			stmt = DbConn.createStatement();
			// ResultSet reset =
			// stmt.executeQuery(" INSERT INTO TEST (id,Title) Values (1,N'عارف');");

			resultSet = stmt
					.executeQuery(" SELECT * FROM  v_Android_ReadKontoor "
							+ " WHERE eshterak_id = N'" + userName
							+ "' AND pass = N'" + passWord + "' ");

			while (resultSet.next()) {
				Contour contour = new Contour();

				String subscriptionId = "";
				try {
					if (resultSet.getString(1).trim().length() != 0) {
						subscriptionId = resultSet.getString(1).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setSubscriptionId(subscriptionId);

				String centerID = "";
				try {
					if (resultSet.getString(2).trim().length() != 0) {
						centerID = resultSet.getString(2).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setCenterID(centerID);

				String fileId = "";
				try {
					if (resultSet.getString(3).trim().length() != 0) {
						fileId = resultSet.getString(3).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setFileId(fileId);

				String identificationId = "";
				try {
					if (resultSet.getString(4).trim().length() != 0) {
						identificationId = resultSet.getString(4).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setIdentificationId(identificationId);

				String contourBodyNumber = "";
				try {
					if (resultSet.getString(5).trim().length() != 0) {
						contourBodyNumber = resultSet.getString(5).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setContourBodyNumber(contourBodyNumber);

				String phase = "";
				try {
					if (resultSet.getString(6).trim().length() != 0) {
						phase = resultSet.getString(6).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setPhase(phase);

				String amper = "";
				try {
					if (resultSet.getString(7).trim().length() != 0) {
						amper = resultSet.getString(7).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setAmper(amper);

				String installationDate = "";
				try {
					if (resultSet.getString(8).trim().length() != 0) {
						installationDate = resultSet.getString(8).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setInstallationDate(installationDate);

				String tariffID = "";
				try {
					if (resultSet.getString(9).trim().length() != 0) {
						tariffID = resultSet.getString(9).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setTariffID(tariffID);

				String tariffName = "";
				try {
					if (resultSet.getString(10).trim().length() != 0) {
						tariffName = resultSet.getString(10).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setTariffName(tariffName);

				String numberOfHouseholds = "";
				try {
					if (resultSet.getString(11).trim().length() != 0) {
						numberOfHouseholds = resultSet.getString(11).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setNumberOfHouseholds(numberOfHouseholds);

				String firstName = "";
				try {
					if (resultSet.getString(12).trim().length() != 0) {
						firstName = resultSet.getString(12).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setFirstName(firstName);

				String lastName = "";
				try {
					if (resultSet.getString(13).trim().length() != 0) {
						lastName = resultSet.getString(13).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setLastName(lastName);

				String nationalCode = "";
				try {
					if (resultSet.getString(14).trim().length() != 0) {
						nationalCode = resultSet.getString(14).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setNationalCode(nationalCode);

				String address = "";
				try {
					if (resultSet.getString(15).trim().length() != 0) {
						address = resultSet.getString(15).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setAddress(address);

				String phoneNumber = "";
				try {
					if (resultSet.getString(16).trim().length() != 0) {
						phoneNumber = resultSet.getString(16).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setPhoneNumber(phoneNumber);

				String mobile = "";
				try {
					if (resultSet.getString(17).trim().length() != 0) {
						mobile = resultSet.getString(17).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setMobile(mobile);

				String status = "";
				try {
					if (resultSet.getString(18).trim().length() != 0) {
						if (resultSet.getString(18).toString()
								.equalsIgnoreCase("1")) {
							status = "فعال";
						} else if (resultSet.getString(18).toString()
								.equalsIgnoreCase("0")) {
							status = "غیر فعال";
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setStatus(status);

				String description = "";
				try {
					if (resultSet.getString(19).trim().length() != 0) {
						description = resultSet.getString(19).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setDescription(description);

				String pass = "";
				try {
					if (resultSet.getString(20).trim().length() != 0) {
						pass = resultSet.getString(20).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setPassword(pass);

				String contourType = "";
				try {
					if (resultSet.getString(21).trim().length() != 0) {

						if (resultSet.getString(21).toString()
								.equalsIgnoreCase("1")) {
							contourType = "دیجیتال";
						} else if (resultSet.getString(21).toString()
								.equalsIgnoreCase("0")) {
							contourType = "غیر دیجیتال";
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				contour.setContourType(contourType);

				// Add New readed record in empty Contour Table
				db.addContour(contour);

				if (contour.getSubscriptionId().isEmpty()) {
					returnedValue = false;
				} else {
					returnedValue = true;
				}
			}

			DbConn.close();

		} catch (Exception e) {
			Log.w("Error connection", "" + e.getMessage());

		}
		return returnedValue;
	}

	// A function For checking IS Internet Available or not
	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		// NetworkInfo activeNetworkInfo =
		// connectivityManager.getActiveNetworkInfo();

		if (connectivityManager != null) {
			NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}

		}
		return false;

		// return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	// A funtion For fill PowerDepartment ( edareye bargh) Table From Server
	// By it's available ID in Contour Table as Foreign Key
	private void FillPowerDepartmentTable(String PowerDepartmentID) {

		// Declare the JDBC objects.
		Connection DbConn = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			// Establish the connection.

			DatabaseHandler db = new DatabaseHandler(getApplicationContext());

			// Delete All Items in Power_Department Table
			db.deleteAllPowerDepartment();

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
							+ Database + ";user=" + username + ";password="
							+ password + ";");

			stmt = DbConn.createStatement();

			resultSet = stmt.executeQuery(" SELECT * FROM  t_edc "
					+ " WHERE center_id = N'" + PowerDepartmentID + "' ");

			while (resultSet.next()) {
				PowerDepartment pd = new PowerDepartment();

				String iD = "1";
				try {
					if (resultSet.getString(1).trim().length() != 0) {
						iD = resultSet.getString(1).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setID(iD);

				String name = "";
				try {
					if (resultSet.getString(2).trim().length() != 0) {
						name = resultSet.getString(2).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setName(name);

				String phone = "";
				try {
					if (resultSet.getString(3).trim().length() != 0) {
						phone = resultSet.getString(3).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setPhone(phone);

				String fax = "";
				try {
					if (resultSet.getString(4).trim().length() != 0) {
						fax = resultSet.getString(4).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setFax(fax);

				String address = "";
				try {
					if (resultSet.getString(5).trim().length() != 0) {
						address = resultSet.getString(5).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setAddress(address);

				String description = "";
				try {
					if (resultSet.getString(6).trim().length() != 0) {
						description = resultSet.getString(6).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				pd.setDescription(description);

				// Add New readed record in empty Power_Department Table
				db.addPowerDepartment(pd);

			}

			DbConn.close();

		} catch (Exception e) {
			Log.w("Error connection", "" + e.getMessage());

		}
	}

	// A funtion For fill read ( khandane kontoor dar yek tarikh moshakhas )
	// Table From Server
	// By it's available subscription ID in Contour Table as primary Key
	private void FillReadTable(String SubscriptionID) {

		// Declare the JDBC objects.
		Connection DbConn = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			// Establish the connection.

			DatabaseHandler db = new DatabaseHandler(getApplicationContext());

			// Delete All Items in READ Table
			db.deleteAllRead();

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
							+ Database + ";user=" + username + ";password="
							+ password + ";");

			stmt = DbConn.createStatement();

			resultSet = stmt.executeQuery(" SELECT * FROM  t_read "
					+ " WHERE eshterak_id = N'" + SubscriptionID
					+ "' order by read_date ");

			while (resultSet.next()) {
				Read rd = new Read();

				String subscriptionId = "";
				try {
					if (resultSet.getString(1).trim().length() != 0) {
						subscriptionId = resultSet.getString(1).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setSubscriptionID(subscriptionId);

				String readDate = "";
				try {
					if (resultSet.getString(2).trim().length() != 0) {
						readDate = resultSet.getString(2).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setReadDate(readDate);

				String low = "";
				try {
					if (resultSet.getString(3).trim().length() != 0) {
						low = resultSet.getString(3).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setLow(low);

				String medium = "";
				try {
					if (resultSet.getString(4).trim().length() != 0) {
						medium = resultSet.getString(4).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setMedium(medium);

				String high = "";
				try {
					if (resultSet.getString(5).trim().length() != 0) {
						high = resultSet.getString(5).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setHigh(high);

				String description = "";
				try {
					if (resultSet.getString(6).trim().length() != 0) {
						description = resultSet.getString(6).toString();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				rd.setDescription(description);

				// Add New readed record in empty READ Table
				db.addRead(rd);

			}

			DbConn.close();

		} catch (Exception e) {
			Log.w("Error connection", "" + e.getMessage());

		}

	}
	
	
	private void login()
	{
		DatabaseHandler db = new DatabaseHandler(this);
		int CurrentworkedDBVersion = 1;
		db.onUpgrade(db.getReadableDatabase(), CurrentworkedDBVersion, db
				.getWritableDatabase().getVersion());

		EditText userNameEditTxt = (EditText) findViewById(R.id.editTextUserNameInLogin);
		String userNameStr = userNameEditTxt.getText().toString();

		EditText passwordEditTxt = (EditText) findViewById(R.id.editTextPassInLogin);
		String passwordStr = passwordEditTxt.getText().toString();

			if (AuthenticationFunc(userNameStr, passwordStr) == true) {
				Contour contour = db.getContour(userNameStr);

				FillReadTable(contour.getSubscriptionId());

				FillPowerDepartmentTable(contour.getCenterID());
				
				showingInvalidUserToast = false;
				
				Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
				MainMenuActivity.SubscriptionId = userNameStr;
	            startActivity(intent); 

			} else if (AuthenticationFunc(userNameStr, passwordStr) == false) {
				if (dialog.isShowing()) {
	            	dialog.dismiss();
	            }
				
				
				
				showingInvalidUserToast = true;
				//Toast.makeText(LoginActivity.this, "شماره اشتراک یا رمز عبور صحیح نمی باشد", Toast.LENGTH_SHORT).show();
			}

		
		
		

	}
	
	
	 private class log_in extends AsyncTask<String,Void,String>{
	        @Override
	         protected void onPreExecute(){

	        	dialog= new ProgressDialog(LoginActivity.this);
	            //dialog.setIndeterminate(true);
	            //dialog.setIndeterminateDrawable(getResources().getDrawable(R.anim.progress_dialog_anim));
	            dialog.setCancelable(false);
	            dialog.setMessage("در حال ارتباط با سرور ...");
	            dialog.show();
	
	         }
	        @Override
	        protected String doInBackground(String... params) {
	            login();
	            return "";
	        }
	        protected void onPostExecute(String params){
	            super.onPostExecute(params);
	            if (dialog.isShowing()) {
	            	dialog.dismiss();
	            }
	            
	            if (showingInvalidUserToast == true)
	            {
	            	EditText passwordEditTxt = (EditText) findViewById(R.id.editTextPassInLogin);
	            	passwordEditTxt.setText("");
	            	Toast.makeText(LoginActivity.this, "شماره اشتراک یا رمز عبور صحیح نمی باشد", Toast.LENGTH_SHORT).show();
	            }
	            
	            

	        }

	     }
}
