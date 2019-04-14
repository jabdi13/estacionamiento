package com.example.jorgealejandro.estacionamiento;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback,LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void irllamadas(View view){
        Intent i =new Intent(this,Llamadas.class);
        startActivity(i);
    }
    public void irlugares(View view){
        Intent i =new Intent(this,Lugares.class);
        startActivity(i);
    }

    public void irmensaje(View view){
        Intent i =new Intent(this,Mensajes.class);
        startActivity(i);
    }
    public void irmapas(View view){
        Intent i =new Intent(this,Maps.class);
        startActivity(i);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle extras) {
        Toast.makeText(Menu. this, "Cambios en proveedor"+ s + "Estado-->"+i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(Menu.this, "Proveedor habilitado"+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(Menu.this, "deshabilitado"+s, Toast.LENGTH_SHORT).show();
    }
}
