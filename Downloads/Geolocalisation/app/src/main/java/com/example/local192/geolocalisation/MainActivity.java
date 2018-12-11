package com.example.local192.geolocalisation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        citiesAdapter = new CitiesAdapter(this,CitiesData.cities);
        listView.setAdapter(citiesAdapter);
    }

    @OnItemClick(R.id.listView)
    public void onCityClicked(int position){
        City citySelected = citiesAdapter.getItem(position);

        Intent goToMapIntent = new Intent(this, MapActivity.class);
        goToMapIntent.putExtra(MapActivity.CITY_EXTRA_KEY, citySelected);
        startActivity(goToMapIntent);
    }
}
