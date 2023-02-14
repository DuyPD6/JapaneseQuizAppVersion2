package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ScrollView;

import com.example.japanesequizappversion2.Database.CheckInternet;
import com.example.japanesequizappversion2.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class ForgetPassword extends AppCompatActivity {
    ScrollView scrollView;
    TextInputLayout userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        scrollView = findViewById(R.id.scrollview_forgetpassword);
        userName = findViewById(R.id.username_forget_password);
    }

    public void verifyUserName(View view) {
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
        }
        if (!validateUsername()) {
            return;
        }
        String _userName = userName.getEditText().getText().toString();
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("userName").equalTo(_userName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    userName.setError(null);
                    userName.setErrorEnabled(false);

                    String _phoneNo = snapshot.child(_userName).child("phoneNo").getValue(String.class);
                    Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
                    intent.putExtra("userName", _userName);
                    intent.putExtra("phoneNo", _phoneNo);
                    intent.putExtra("whatToDo", "updatePassword");
                    startActivity(intent);
                    finish();
                } else {
                    userName.setError("User does not exist");
                    userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ForgetPassword.this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), StartUpActivity.class));
                        finish();
                    }
                });
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
}