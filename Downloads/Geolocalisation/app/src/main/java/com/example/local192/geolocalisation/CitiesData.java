package com.example.local192.geolocalisation;

import com.google.android.gms.maps.model.LatLng;

import java.util.Arrays;
import java.util.List;

public class CitiesData {

    public static List cities = Arrays.asList(
            new City("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Paris_-_Eiffelturm_und_Marsfeld2.jpg/280px-Paris_-_Eiffelturm_und_Marsfeld2.jpg", "Paris",2220445, new LatLng(48.855675, 2.341222)),
            new City("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Coat_of_arms_of_Berlin.svg/65px-Coat_of_arms_of_Berlin.svg.png", "Berlin",3520031, new LatLng(52.518603, 13.392027)),
            new City("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/London_Montage_L.jpg/280px-London_Montage_L.jpg", "Londres",8673713, new LatLng(51.504202, -0.133877)),
            new City("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/La_Rochelle_Vieux-Port.JPG/280px-La_Rochelle_Vieux-Port.JPG", "La Rochelle",74998, new LatLng(46.157532, -1.148796)),
            new City("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Lyon-Paysages.jpg/280px-Lyon-Paysages.jpg", "Lyon",506615, new LatLng(45.759611, 4.833746)));
}