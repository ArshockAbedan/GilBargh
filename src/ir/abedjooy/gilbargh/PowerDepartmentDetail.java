package ir.abedjooy.gilbargh;

import ir.abedjooy.gilbargh.R.id;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Typeface;

public class PowerDepartmentDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_power_department_detail);
		
		DatabaseHandler db = new DatabaseHandler(this);
		PowerDepartment powerdepartment = db.getPowerDepartment();
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");
		
		TextView txtDepartmentName = (TextView) findViewById(id.txtDepartmentNameValue);
		txtDepartmentName.setText(powerdepartment.getName());
		txtDepartmentName.setTypeface(tf, Typeface.BOLD);
		
		TextView txtDepartmentAddress = (TextView) findViewById(id.txtDepartmentAddressValue);
		txtDepartmentAddress.setText(powerdepartment.getAddress());
		txtDepartmentAddress.setTypeface(tf);
		
		TextView txtDepartmentPhone = (TextView) findViewById(id.txtDepartmentPhoneValue);
		txtDepartmentPhone.setText(powerdepartment.getPhone());
		txtDepartmentPhone.setTypeface(tf);
		
		TextView txtDepartmentFax = (TextView) findViewById(id.txtDepartmentFaxValue);
		txtDepartmentFax.setText(powerdepartment.getFax());
		txtDepartmentFax.setTypeface(tf);
		
	}

	

}
