package com.example.japanesequizappversion2.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japanesequizappversion2.Database.SessionManager;
import com.example.japanesequizappversion2.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView8);

        SessionManager sessionManager = new SessionManager(MainActivity.this, SessionManager.SESSION_USERSESSION);
        HashMap<String, String> usersDetails = sessionManager.getUsersDetailFromSession();

        String fullName = usersDetails.get(SessionManager.KEY_FULLNAME);
        String phoneNumber = usersDetails.get(SessionManager.KEY_PHONENUMBER);

        textView.setText(fullName + "\n" + phoneNumber);
    }

    public void nhat1(View view) {
        Intent intent = new Intent(getApplicationContext(), Nhat1Activity.class);
        startActivity(intent);
    }

    public void nhat2(View view) {
        Intent intent = new Intent(getApplicationContext(), Nhat1Activity.class);
        startActivity(intent);
    }

    public void nhat3(View view) {
        Intent intent = new Intent(getApplicationContext(), Nhat1Activity.class);
        startActivity(intent);
    }

    public void trainingSelection(View view) {
        Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
        startActivity(intent);
    }
}