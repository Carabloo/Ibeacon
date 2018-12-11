package com.example.local192.geolocalisation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CitiesAdapter extends ArrayAdapter<City> {

    public CitiesAdapter(@NonNull Context context, List<City> cities){
        super(context,R.layout.city,cities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        final City city = getItem(position);
        if (city == null){
            throw new IllegalStateException("Null city");
        }

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.city, parent, false);
        }

        //On charge l'image
        ImageView cityImage = convertView.findViewById(R.id.image);
        Picasso.get().load(city.getImageUrl()).into(cityImage);

        //On met en place le nom
        TextView nomVille = convertView.findViewById(R.id.nomVille);
        nomVille.setText(city.getName());

        //ON met en place la population
        TextView population = convertView.findViewById(R.id.population_value);
        population.setText(city.getPopulation() + " habitants");

        return convertView;
    }
}
