package com.example.william.helloworld;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.R.attr.checked;
import static android.R.attr.fragment;
import static com.google.android.gms.internal.a.F;

public class MainActivity extends AppCompatActivity {
    private GoogleMap map;
    TextView lblDireccion;
    private static String pit;
    private LatLng latlong = new LatLng(-12.084013, -77.047722);
    public static double lat = 0;
    public static double lon = 0;
    public static boolean checked = false;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblDireccion = (TextView) findViewById(R.id.lblDireccion);


        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.fragmentMapa)).getMap();

        if (map != null) {
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.birrete))
                    .position(new LatLng(-12.084013, -77.047722))
                    .title("Universidad del Pacífico")
                    .snippet("Av. Salaverry 2020"));
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.mini_pizza3))
                    .position(new LatLng(-12.085213, -77.046915))
                    .title("Canevaro")
                    .snippet("Av César Canevaro 1458"));
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.real_plaza))
                    .position(new LatLng(-12.0566684, -77.03825119999999))
                    .title("Real Plaza")
                    .snippet("Av. Guardia Civil 1035"));
            map.addMarker(new MarkerOptions()

                    .position(new LatLng(-12.064736, -77.03678769999999))
                    .title("UTP")
                    .snippet("Av. 28 de Julio 826"));
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.cerveza))
                    .position(new LatLng(-12.0870088, -77.0337902))
                    .title("Quinto Bar")
                    .snippet("Jirón Tomás Guido 216"));


        }


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlong,10));
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> list = geocoder.getFromLocation(latlong.latitude, latlong.longitude, 1);
            if (!list.isEmpty()) {
                Address address = list.get(0);
                lblDireccion.setText( address.getAddressLine(0));
            }
        } catch (IOException e) {
        e.printStackTrace();
    }



}




}
