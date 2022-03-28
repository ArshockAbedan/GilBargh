package ir.abedjooy.gilbargh;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;

public class MainMenuActivity extends Activity {

	public static String SubscriptionId;
	GridView gridView;
	
	static final String[] Items = {"اطلاعات کنتور","اطلاعات مالک کنتور","مصرف دوره های قبل", "اداره برق منطقه" ,"ثبت قرائت کنتور" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		DatabaseHandler db = new DatabaseHandler(this);
		
		
		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BYekan.ttf");

		// Setting OperatorName On Bottom of Page
		Contour contour = db.getContour(SubscriptionId);
		String firstname = contour.getFirstName();
		String lastname = contour.getLastName();
		String opName = firstname + " " + lastname;
		
		

		TextView txtOperator = (TextView) findViewById(R.id.txtOprtNameValue);
		txtOperator.setText(opName);
		txtOperator.setTypeface(tf,Typeface.BOLD);
		

		// Set today's Date in Main Menu (Down)
		TextView txtTodayDateValue = (TextView) findViewById(R.id.txtTodayDateValue);
		

		com.ghasemkiani.util.SimplePersianCalendar c = new com.ghasemkiani.util.SimplePersianCalendar();
		com.ghasemkiani.util.DateFields t = c.getDateFields();

		@SuppressWarnings("static-access")
		String month = (String) (c.getPersianMonthName(t.getMonth()))
				.toString();
		String CurrentDate = t.getDay() + " " + month.toString() + " "
				+ t.getYear();

		txtTodayDateValue.setText(CurrentDate);
		txtTodayDateValue.setTypeface(tf,Typeface.BOLD);
		
		// version TxtView
		//TextView txtVersion = (TextView) findViewById(R.id.txtVersion);
		//txtVersion.setTypeface(tf);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		//View realv = (View) findViewById(R.id.LinearLayoutOFMainGrid);
		
		gridView.setAdapter(new ImageAdapter(gridView.getContext(), Items));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				
				Toast.makeText(getApplicationContext(), ((TextView) v.findViewById(R.id.grid_item_label)).getText(), Toast.LENGTH_SHORT).show();
				String Itemstring = ((TextView) v.findViewById(R.id.grid_item_label)).getText().toString();
				if ( Itemstring == "اطلاعات کنتور")
				{
					Intent intent = new Intent(getApplicationContext(), ContourDetail.class);
					startActivity(intent);
				}
				
				if (Itemstring == "اطلاعات مالک کنتور")
				{
					Intent intent = new Intent(getApplicationContext(), ContourOwnerDetail.class);
					startActivity(intent);
				}
				
				
				if ( Itemstring == "مصرف دوره های قبل")
				{
					Intent intent = new Intent(getApplicationContext(), LastPeriodsRead.class);
					startActivity(intent);
				}
				
				if ( Itemstring == "اداره برق منطقه")
				{
					Intent intent = new Intent(getApplicationContext(), PowerDepartmentDetail.class);
					startActivity(intent);
				}
				
				if ( Itemstring == "ثبت قرائت کنتور")
				{
					Intent intent = new Intent(getApplicationContext(), RegisterRead.class);
					RegisterRead.SubscriptionId = MainMenuActivity.SubscriptionId;
					startActivity(intent);
				}
				
			}
		});
		
	}

}
