package ir.abedjooy.gilbargh;

import ir.abedjooy.gilbargh.R.id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;

public class LastPeriodsRead extends Activity {

	public static final String FIRST_COLUMN = "First";
	public static final String SECOND_COLUMN = "Second";
	public static final String THIRD_COLUMN = "Third";
	public static final String FOURTH_COLUMN = "Fourth";
	public static final String FIFTH_COLUMN = "Fifth";
	public static final String SIXTH_COLUMN = "Sixth";
	public static final String SEVENTH_COLUMN = "Seventh";

	private ArrayList<HashMap<Object, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_periods_read);

		DatabaseHandler db = new DatabaseHandler(this);
		List<Read> readList = db.getAllRead();

		
		ListView lview = (ListView) findViewById(id.listViewRead);

		Contour contour = db.getContour(MainMenuActivity.SubscriptionId);
		list = GridAdapterList(readList, contour.getContourType());

		ListviewAdapterRead adapter = new ListviewAdapterRead(this, list);
		lview.setAdapter(adapter);
	}

	// making header & Contents of grid's Adapter
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList<HashMap<Object, Object>> GridAdapterList(List<Read> read, String Contourtype) {
		list = new ArrayList<HashMap<Object, Object>>();

		// Adding Items
		for (Read rd : read) {

			HashMap temp = new HashMap();
			temp.put(FIRST_COLUMN, String.valueOf(rd.getID()));
			temp.put(SECOND_COLUMN, rd.getReadDate());
			temp.put(THIRD_COLUMN, rd.getLow());
			temp.put(FOURTH_COLUMN, rd.getMedium());
			temp.put(FIFTH_COLUMN, rd.getHigh());
			temp.put(SIXTH_COLUMN, rd.getDescription());
			temp.put(SEVENTH_COLUMN, Contourtype);
			list.add(temp);
		}

		return list;

	}

}
