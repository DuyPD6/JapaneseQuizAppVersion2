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
        btnBack = findViewById(R.id.btn_signup1_back);
        btnNext = findViewById(R.id.btn_signup1_next);
        btnLogin = findViewById(R.id.btn_signup1_login);
        textTitle = findViewById(R.id.text_signup_title);

        fullName = findViewById(R.id.signup1_fullname);
        email = findViewById(R.id.signup1_email);
        userName = findViewById(R.id.signup1_username);
        passWord = findViewById(R.id.signup1_password);
    }

    public void callNextSignupScreen(View view) {

        if (!validateEmail() | !validatePassword() | !validateUsername() | !validateFullname()) {
            return;
        }

        Intent intent = new Intent(SignUp.this, SignUp2.class);
        String _fullName = fullName.getEditText().getText().toString();
        String _email = email.getEditText().getText().toString();
        String _userName = userName.getEditText().getText().toString();
        String _passWord = passWord.getEditText().getText().toString();

        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("userName", _userName);
        intent.putExtra("passWord", _passWord);

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

    private boolean validateUsername() {
        String val = userName.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            userName.setError("Username can not be empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username cannot longer than 20 characters");
            return false;
        } else if (!val.matches(checkSpaces)) {
            userName.setError("You cannot use white spaces");
            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Email can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = passWord.getEditText().getText().toString().trim();
        String checkPassword = "^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +//any letter
//                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            passWord.setError("Password can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            passWord.setError("Password must have more than 4 characters!");
            return false;
        } else {
            passWord.setError(null);
            passWord.setErrorEnabled(false);
            return true;
        }
    }

    public void callLoginFromSignUp1(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}