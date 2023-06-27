package dev.android.rodrigues.applistvip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import dev.android.rodrigues.applistvip.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Bem Vindo ao seu app listVip",Toast.LENGTH_LONG).show();
    }
}