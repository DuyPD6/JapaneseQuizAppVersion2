package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.japanesequizappversion2.R;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_up);
    }

    public void callLoginActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_login), "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartUpActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callSignupActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_signup), "transition_signup");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartUpActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }
}