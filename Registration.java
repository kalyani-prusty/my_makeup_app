package com.example.makeupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    public void login(View view)
    {
        startActivity(new Intent(Registration.this,Login.class));
    }
  {
      Toast.makeText(Registration.this, "successfully register", Toast.LENGTH_LONG).show();
  }

}