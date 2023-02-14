package com.example.japanesequizappversion2.MainScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.japanesequizappversion2.Database.SessionManager;
import com.example.japanesequizappversion2.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView8);

        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> usersDetails = sessionManager.getUsersDetailFromSession();

        String fullName = usersDetails.get(SessionManager.KEY_FULLNAME);
        String phoneNumber = usersDetails.get(SessionManager.KEY_PHONENUMBER);

        textView.setText(fullName + "\n" + phoneNumber);
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