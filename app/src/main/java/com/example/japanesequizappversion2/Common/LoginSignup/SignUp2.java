package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.japanesequizappversion2.R;

public class SignUp2 extends AppCompatActivity {
    ImageView btnBack;
    Button btnNext, btnLogin;
    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnBack = findViewById(R.id.btn_signup_back);
        btnNext = findViewById(R.id.btn_signup_next);
        btnLogin = findViewById(R.id.btn_signup_login);
        textTitle = findViewById(R.id.text_signup_title);
    }

    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(btnBack, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(btnNext, "transition_login_btn");
        pairs[2] = new Pair<View, String>(btnLogin, "transition_login_btn");
        pairs[3] = new Pair<View, String>(textTitle, "transition_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2.this, pairs);
        startActivity(intent, options.toBundle());
    }
}