package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button EB = findViewById(R.id.EnterButton);
        EB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button();
                Intent intent = new Intent(MainActivity.this, SecondPage.class);
                startActivity(intent);
            }
        });
    }



    public void button() {      //確認權限

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.BLUETOOTH_ADMIN},
                    1);
        }

        permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.BLUETOOTH},
                    1);
        }

        permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        }
    }
}