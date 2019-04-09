package com.example.jorgealejandro.estacionamiento;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ags = new LatLng(21.8818, -102.291);
        mMap.addMarker(new MarkerOptions().position(ags).draggable(true).title("Ciudad de Aguascalientes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ags));

        //Marcador de Prueba
        LatLng prueba = new LatLng(21.8818, -102.291);
        markerPrueba = googleMap.addMarker(new MarkerOptions().position(prueba).title("Prueba"));

        //Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ags, 7));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        //clic en el marcador
        googleMap.setOnMarkerClickListener(this);
        //arrastrar el marcador
        googleMap.setOnMarkerDragListener(this);
        //Dialog
        googleMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(markerPrueba)){
            String lat,lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toHexString(marker.getPosition().longitude);
            Toast.makeText(this, lat + ", "+ lng, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Aquí me encuentro", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
       /* if (marker.equals(markerDrag)){
            Toast.makeText(this, "Start",Toast.LENGTH_LONG).show();
        }*/

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        /*if (marker.equals(markerDrag)){
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng), marker.getPosition().latitude, marker.getPosition().longitude);
            setTitle(newTitle);
        }*/
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        /*if (marker.equals(markerDrag)){
            Toast.makeText(this, "Finish",Toast.LENGTH_LONG).show();
        }*/

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        /*if (marker.equals(InfoWindow)){
            AgsFragment.newInstance(marker.getTitle(), getString(R.string.AgsInfo)).show(getSupportFragmentManager(), null);
        }*/
    }
}
