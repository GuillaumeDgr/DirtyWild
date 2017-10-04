package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultAdapter extends BaseAdapter {

    // Attributs
    private Context context;
    private ArrayList<TripResultModel> items;

    // Constructor
    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    // Getters
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.trip_item, parent, false);
        }

        TripResultModel currentItem = (TripResultModel) getItem(position);

        TextView departureResult = (TextView) convertView.findViewById(R.id.departureResult);
        TextView firstNameResult = (TextView) convertView.findViewById(R.id.firstNameResult);
        TextView priceResult = (TextView) convertView.findViewById(R.id.priceResult);

        departureResult.setText(currentItem.getDeparture().toString());
        firstNameResult.setText(currentItem.getPrenom());
        priceResult.setText(String.valueOf(currentItem.getPrice()));

        return convertView;
    }
}