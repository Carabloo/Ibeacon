package com.example.local192.restaurant;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListRestaurantAdapter extends ArrayAdapter<Restaurant> {

    public ListRestaurantAdapter(Context context, List<Restaurant> allRestaurants) {
        super(context, R.layout.item_restaurant, allRestaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final Restaurant restaurant = getItem(position);
        Log.e("CITY",restaurant.getCity());
        if (restaurant == null){
            throw new IllegalStateException("Null city");
        }

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_restaurant, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
        TextView nameView = (TextView) convertView.findViewById(R.id.name_view);
        TextView countryView = (TextView) convertView.findViewById(R.id.country_view);

        Picasso.get().load(restaurant.getImg_url()).into(imageView);
        nameView.setText(restaurant.getName());
        countryView.setText(restaurant.getCountry());

        return convertView;
    }
}
