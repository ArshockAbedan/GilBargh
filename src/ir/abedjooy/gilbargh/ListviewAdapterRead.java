package ir.abedjooy.gilbargh;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListviewAdapterRead extends BaseAdapter {
	
	public static final String FIRST_COLUMN = "First";
	public static final String SECOND_COLUMN = "Second";
	public static final String THIRD_COLUMN = "Third";
	public static final String FOURTH_COLUMN = "Fourth";
	public static final String FIFTH_COLUMN = "Fifth";
	public static final String SIXTH_COLUMN = "Sixth";
	public static final String SEVENTH_COLUMN = "Seventh";
	
	public ArrayList<HashMap<Object, Object>> list;
    Activity activity;
	
	 public ListviewAdapterRead(Activity activity, ArrayList<HashMap<Object, Object>> list) {
	        super();
	        this.activity = activity;
	        this.list = list;
	    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private class ViewHolder
	{
		TextView txtFirst ;
		TextView txtSecond ;
		TextView txtThird ;
		TextView txtFourth ;
		TextView txtFifth ;
		TextView txtSixth ;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		
		if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.readlistview_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
            holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
            holder.txtFourth = (TextView) convertView.findViewById(R.id.FourthText);
            holder.txtFifth = (TextView) convertView.findViewById(R.id.FifthText);
            holder.txtSixth = (TextView) convertView.findViewById(R.id.SixthText);
            convertView.setTag(holder);
        }
        else
        {
        	 holder = (ViewHolder) convertView.getTag();
        }
		
		Typeface tf = Typeface.createFromAsset(convertView.getContext().getAssets(),
        		"fonts/BYekan.ttf");
		
		HashMap<Object, Object> map = list.get(position);
		if (! map.get(FIRST_COLUMN).equals(null))
		{
			holder.txtFirst.setText(map.get(FIRST_COLUMN).toString());
			holder.txtFirst.setTypeface(tf);	
		}
		if (! map.get(SECOND_COLUMN).equals(null))
		{
			holder.txtSecond.setText(map.get(SECOND_COLUMN).toString());
			holder.txtSecond.setTypeface(tf);	
		}
		if (! map.get(THIRD_COLUMN).equals(null))
		{
			holder.txtThird.setText(map.get(THIRD_COLUMN).toString());
			holder.txtThird.setTypeface(tf);
			if (! map.get(SEVENTH_COLUMN).equals(null))
			{
				if (!map.get(SEVENTH_COLUMN).toString().equalsIgnoreCase("دیجیتال"))
				{	
					holder.txtThird.setText("");
				}
			
			}
		}
		if (! map.get(FOURTH_COLUMN).equals(null))
		{
			holder.txtFourth.setText(map.get(FOURTH_COLUMN).toString());
			holder.txtFourth.setTypeface(tf);	
		}
		if (! map.get(FIFTH_COLUMN).equals(null))
		{
			holder.txtFifth.setText(map.get(FIFTH_COLUMN).toString());
			holder.txtFifth.setTypeface(tf);	
			if (! map.get(SEVENTH_COLUMN).equals(null))
			{
				if (! map.get(SEVENTH_COLUMN).toString().equalsIgnoreCase("دیجیتال"))
				{	
					holder.txtFifth.setText("");
				}
			
			}
		}
		if (! map.get(SIXTH_COLUMN).equals(null))
		{
			holder.txtSixth.setText(map.get(SIXTH_COLUMN).toString());
			holder.txtSixth.setTypeface(tf);	
		}
		
		
		
		return convertView;
	}

}
