package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japanesequizappversion2.R;
import com.google.android.material.textfield.TextInputLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    ImageView btnBack;
    Button btnNext, btnLogin;
    TextView textTitle;
    TextInputLayout fullName, userName, email, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        btnBack = findViewById(R.id.btn_signup_back);
        btnNext = findViewById(R.id.btn_signup_next);
        btnLogin = findViewById(R.id.btn_signup_login);
        textTitle = findViewById(R.id.text_signup_title);

        fullName = findViewById(R.id.signup_fullname);
        email = findViewById(R.id.signup_email);
        userName = findViewById(R.id.signup_username);
        passWord = findViewById(R.id.signup_password);
    }

    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(btnBack, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(btnNext, "transition_login_btn");
        pairs[2] = new Pair<View, String>(btnLogin, "transition_login_btn");
        pairs[3] = new Pair<View, String>(textTitle, "transition_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());
    }

    private boolean validateFullname() {
        String val = fullName.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            fullName.setError("Name can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
}