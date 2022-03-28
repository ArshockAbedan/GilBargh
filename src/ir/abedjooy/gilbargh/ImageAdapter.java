package ir.abedjooy.gilbargh;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageAdapter  extends BaseAdapter {

	private Context context;
	private final String[] ItemsValues;

	public ImageAdapter(Context context, String[] itemsValues) {
		this.context = context;
		this.ItemsValues = itemsValues;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from items.xml
			gridView = inflater.inflate(R.layout.griditem, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			View difinedView = new View(context);
			Typeface tf = Typeface.createFromAsset(difinedView.getContext().getAssets(),"fonts/BYekan.ttf");
			textView.setText(ItemsValues[position]);
			textView.setTypeface(tf,Typeface.BOLD);
			

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String item = ItemsValues[position];

			
			if (item.equals("اطلاعات کنتور")) {
				imageView.setImageResource(R.drawable.energymeter);
			} else if (item.equals("اطلاعات مالک کنتور")) {
				imageView.setImageResource(R.drawable.contacts);
			} else if (item.equals("مصرف دوره های قبل")) {
				imageView.setImageResource(R.drawable.adressbook);
			} else if (item.equals("اداره برق منطقه")) {
				imageView.setImageResource(R.drawable.bargh);
			} else if (item.equals("ثبت قرائت کنتور")) {
				imageView.setImageResource(R.drawable.filesaveas);			
			}else {				
				imageView.setImageResource(R.drawable.ic_launcher);
			}
		
		} else {
			gridView = convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ItemsValues.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}



}
