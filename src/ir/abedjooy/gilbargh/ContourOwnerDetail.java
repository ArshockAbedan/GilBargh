package ir.abedjooy.gilbargh;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Typeface;

public class ContourOwnerDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contour_owner_detail);
		
		
		DatabaseHandler db = new DatabaseHandler(this);
		Contour contour =db.getContour(MainMenuActivity.SubscriptionId);
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");
		
		TextView txtSubscriptionFirstName = (TextView) findViewById(R.id.txtSubscriptionFirstNameValue);
		txtSubscriptionFirstName.setText(contour.getFirstName());
		txtSubscriptionFirstName.setTypeface(tf, Typeface.BOLD);
		
		TextView txtSubscriptionLastName = (TextView) findViewById(R.id.txtSubscriptionLastNameValue);
		txtSubscriptionLastName.setText(contour.getLastName());
		txtSubscriptionLastName.setTypeface(tf, Typeface.BOLD);
		
		TextView txtNationalCode = (TextView) findViewById(R.id.txtNationalCodeValue);
		txtNationalCode.setText(contour.getNationalCode());
		txtNationalCode.setTypeface(tf, Typeface.BOLD);
		
		TextView txtMobile = (TextView) findViewById(R.id.txtMobileValue);
		txtMobile.setText(contour.getMobile());
		txtMobile.setTypeface(tf, Typeface.BOLD);
		
		TextView txtPhone = (TextView)  findViewById(R.id.txtPhoneValue);
		txtPhone.setText(contour.getPhoneNumber());
		txtPhone.setTypeface(tf, Typeface.BOLD);
		
		TextView txtAddress = (TextView) findViewById(R.id.txtAddressValue);
		txtAddress.setText(contour.getAddress());
		txtAddress.setTypeface(tf, Typeface.BOLD);
	}

	
}
