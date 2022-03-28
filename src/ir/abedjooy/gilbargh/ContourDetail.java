package ir.abedjooy.gilbargh;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Typeface;

public class ContourDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contour_detail);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
       //int  width_screen =displaymetrics.widthPixels;
       //int CONST = 20 ;
       //Mytext.setTextSize(TypedValue.COMPLEX_UNIT_PX, (width_screen/CONST));
		
		
		DatabaseHandler db = new DatabaseHandler(this);
		Contour contour = db.getContour(MainMenuActivity.SubscriptionId);
		
		Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BYekan.ttf");
		
		TextView txtsubscription = (TextView) findViewById(R.id.txtsubscriptionValue);
		txtsubscription.setText(contour.getSubscriptionId());
		txtsubscription.setTypeface(tf,Typeface.BOLD);
		//txtsubscription.setTextSize(TypedValue.COMPLEX_UNIT_PX, (width_screen/CONST));
		
		
		TextView txtFile = (TextView) findViewById(R.id.txtFileIdValue);
		txtFile.setText(contour.getFileId());
		txtFile.setTypeface(tf,Typeface.BOLD);
		//txtFile.setTextSize(TypedValue.COMPLEX_UNIT_PX, (width_screen/CONST));
		
		TextView txtIdentification = (TextView) findViewById(R.id.txtIdentificationValue);
		txtIdentification.setText(contour.getIdentificationId());
		txtIdentification.setTypeface(tf,Typeface.BOLD);
		//txtIdentification.setTextSize(TypedValue.COMPLEX_UNIT_PX, (width_screen/CONST));
		
		TextView txtTariffName = (TextView) findViewById(R.id.txtTariffValueName);
		txtTariffName.setText(contour.getTariffName());
		txtTariffName.setTypeface(tf,Typeface.BOLD);
		//txtTariffName.setTextSize(TypedValue.COMPLEX_UNIT_PX, (width_screen/CONST));
		
		TextView txtTariffID = (TextView) findViewById(R.id.txtTariffValueID);
		txtTariffID.setText(contour.getTariffID());
		txtTariffID.setTypeface(tf,Typeface.BOLD);
		
		TextView txtBodyNum = (TextView) findViewById(R.id.txtBodyNumValue);
		txtBodyNum.setText(contour.getContourBodyNumber());
		txtBodyNum.setTypeface(tf,Typeface.BOLD);
		
		TextView txtInstalDate = (TextView) findViewById(R.id.txtInstalDateValue);
		txtInstalDate.setText(contour.getInstallationDate());
		txtInstalDate.setTypeface(tf,Typeface.BOLD);
		
		
		TextView txtHouseholdNum = (TextView) findViewById(R.id.txtHouseholdNumValue);
		txtHouseholdNum.setText(contour.getNumberOfHouseholds());
		txtHouseholdNum.setTypeface(tf,Typeface.BOLD);
		
		TextView txtPhase = (TextView) findViewById(R.id.txtPhaseValue);
		txtPhase.setText(contour.getPhase());
		txtPhase.setTypeface(tf,Typeface.BOLD);
		
		TextView txtAmper = (TextView) findViewById(R.id.txtAmperValue);
		txtAmper.setText(contour.getAmper());
		txtAmper.setTypeface(tf,Typeface.BOLD);
		
		TextView txtContour = (TextView) findViewById(R.id.txtContourTypeValue);
		txtContour.setText(contour.getContourType());
		txtContour.setTypeface(tf,Typeface.BOLD);
		
		TextView txtDescription = (TextView) findViewById(R.id.txtDescriptionValue);
		txtDescription.setText(contour.getDescription());
		txtDescription.setTypeface(tf,Typeface.BOLD);
		
		
		
	}

	

}
