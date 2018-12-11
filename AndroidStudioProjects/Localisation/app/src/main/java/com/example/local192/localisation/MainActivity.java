package com.example.local192.localisation;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ip1)
    EditText editTextIp1;

    @BindView(R.id.ip2)
    EditText editTextIp2;

    @BindView(R.id.ip3)
    EditText editTextIp3;

    @BindView(R.id.ip4)
    EditText editTextIp4;


    private LocalisationService localisationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activation de butterknife
        ButterKnife.bind(this);

        // Retrofit init
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://freegeoip.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        localisationService = retrofit.create(LocalisationService.class);
    }

    @OnClick(R.id.buttom_get_ip)
    public void getIp(){
        WifiManager wifiMan = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        int ipAdress = wifiInf.getIpAddress();

        editTextIp1.setText(Integer.toString(ipAdress & 0xff));
        editTextIp2.setText(Integer.toString(ipAdress >> 8 & 0xff));
        editTextIp3.setText(Integer.toString(ipAdress >> 16 & 0xff));
        editTextIp4.setText(Integer.toString(ipAdress >> 24 & 0xff));
    }


    @OnClick(R.id.button_get_position)
    public void getPosition(){
        final String ip = editTextIp1.getText().toString() + "." +
                editTextIp2.getText().toString() + "." +
                editTextIp3.getText().toString() + "." +
                editTextIp4.getText().toString();

        Call<Localisation> call = localisationService.getLocalisation(ip);

        call.enqueue(new Callback<Localisation>() {
            @Override
            public void onResponse(Call<Localisation> call, Response<Localisation> response) {
                if (response.isSuccessful()) {
                    Localisation result = response.body();
                    Toast.makeText(MainActivity.this, String.format("%s est localisé dans le pays : %s", ip, result.country_name), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "le serveur a retourné une erreur", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Localisation> call, Throwable t) {
                Toast.makeText(MainActivity.this, "l'appel a échou", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
