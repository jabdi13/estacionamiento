package com.example.jorgealejandro.estacionamiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
    }

    public void menu(View view){
        Intent i =new Intent(this,Menu.class);
        startActivity(i);
    }

}
