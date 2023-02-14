package com.example.japanesequizappversion2.Common.LoginSignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.example.japanesequizappversion2.Database.CheckInternet;
import com.example.japanesequizappversion2.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResetPassword extends AppCompatActivity {
    TextInputLayout passWord, confirmPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        passWord = findViewById(R.id.et_reset_password);
        confirmPassWord = findViewById(R.id.et_confirm_reset_password);
    }

    public void btnSetNewPassword(View view) {
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
            return;
        }

        if (!validatePassword() | !validateConfirmPassword()) {
            return;
        }
        String _newPassword = passWord.getEditText().getText().toString().trim();
        String _userName = getIntent().getStringExtra("userName");
        Toast.makeText(this, "Update Successfully!", Toast.LENGTH_SHORT).show();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(_userName).child("passWord").setValue(_newPassword);

        startActivity(new Intent(getApplicationContext(), ResetPasswordSuccessfully.class));
        finish();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ResetPassword.this);
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

    private boolean validateConfirmPassword() {
        String val = passWord.getEditText().getText().toString().trim();
        String val1 = confirmPassWord.getEditText().getText().toString().trim();
        if (!val1.equals(val)) {
            confirmPassWord.setError("Confirm password must be the password!");
            return false;
        }
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
            confirmPassWord.setError("Password can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            confirmPassWord.setError("Password must have more than 4 characters!");
            return false;
        } else {
            confirmPassWord.setError(null);
            confirmPassWord.setErrorEnabled(false);
            return true;
        }
    }
}