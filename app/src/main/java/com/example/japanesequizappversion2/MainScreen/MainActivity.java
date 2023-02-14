package com.example.japanesequizappversion2.MainScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.japanesequizappversion2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nhat1(View view) {
        Intent intent = new Intent(getApplicationContext(), StudyCategoryActivity.class);
        startActivity(intent);
    }

    public void nhat2(View view) {
        Intent intent = new Intent(getApplicationContext(), StudyCategoryActivity.class);
        startActivity(intent);
    }

    public void nhat3(View view) {
        Intent intent = new Intent(getApplicationContext(), StudyCategoryActivity.class);
        startActivity(intent);
    }

    public void nhat4(View view) {
        Intent intent = new Intent(getApplicationContext(), StudyCategoryActivity.class);
        startActivity(intent);
    }
}