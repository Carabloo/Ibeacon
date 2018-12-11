package com.example.local192.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listRestaurant)
    ListView list;

    ListRestaurantAdapter restaurantAdapter;
    ArrayList<Restaurant> restaurants = new ArrayList<>();



    RestaurantService restaurantService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activation de butterknife
        ButterKnife.bind(this);

        // Activation de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentable.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restaurantService = retrofit.create(RestaurantService.class);

        getRestaurants();

    }

    public void getRestaurants(){
        Call<ListRestaurant> call = restaurantService.getRestaurants(1,"US");
        call.enqueue(new Callback<ListRestaurant>() {
            @Override
            public void onResponse(Call<ListRestaurant> call, Response<ListRestaurant> response) {
                if (response.isSuccessful()){
                    Log.e("call", "success");
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    Log.e("Msg",response.body().getRestaurants().toString());
                    restaurants.addAll(response.body().getRestaurants());
                    restaurantAdapter = new ListRestaurantAdapter(MainActivity.this,restaurants);
                    list.setAdapter(restaurantAdapter);

                    restaurantAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(MainActivity.this, "Le serveur a retourné une erreur", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ListRestaurant> call, Throwable t) {
                Toast.makeText(MainActivity.this, "L'appel a échoué", Toast.LENGTH_LONG).show();
            }

        });

    }
}
