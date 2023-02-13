package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.japanesequizappversion2.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout userName, passWord;
//    RelativeLayout progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.username_login);
        passWord = findViewById(R.id.password_login);
//        String _userName = userName.getEditText().toString();
//        String _passWord = passWord.getEditText().toString();
//        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("userName").equalTo(_userName);
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    userName.setError(null);
//                    userName.setErrorEnabled(false);
//                    if (snapshot.child(_userName).child("passWord").getValue(String.class).equals(_passWord)) {
//                        passWord.setError(null);
//                        passWord.setErrorEnabled(false);
//
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Password is not correct!", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Username is not existed!", Toast.LENGTH_SHORT).show();
//                }`
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void letTheUserLoggedIn(View view) {

        if (!validateUsername() && !validatePassword()) {
            return;
        }
//        progressBar.setVisibility(View.VISIBLE);
        String _userName = userName.getEditText().getText().toString();
        String _passWord = passWord.getEditText().getText().toString();
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("userName").equalTo(_userName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    userName.setError(null);
                    userName.setErrorEnabled(false);

                    String systemPassword = snapshot.child(_userName).child("passWord").getValue(String.class);
                    if (systemPassword.equals(_passWord)) {
                        passWord.setError(null);
                        passWord.setErrorEnabled(false);

                        String _fullname = snapshot.child(_userName).child("fullName").getValue(String.class);
                        String _email = snapshot.child(_userName).child("email").getValue(String.class);
                        String _phoneNo = snapshot.child(_userName).child("phoneNo").getValue(String.class);
                        String _dateofBirth = snapshot.child(_userName).child("date").getValue(String.class);

                        Toast.makeText(LoginActivity.this, _fullname + "\n" + _phoneNo + "\n" + _email + "\n" + _dateofBirth + "\n", Toast.LENGTH_SHORT).show();
                    } else {
//                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "Please check your password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "User does not exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

//        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//
//
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_login_login), "transition_login");
//
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
//            startActivity(intent, options.toBundle());
//        } else {
//            startActivity(intent);
//        }

    }


    public void callSignUpFromLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
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
}