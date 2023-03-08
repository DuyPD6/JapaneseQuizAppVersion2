package com.example.japanesequizappversion2.StudyScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.japanesequizappversion2.R;

public class HiraganaKatakanaSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_katakana_selection);
    }
    public void chooseHiragana(View view){
        Intent intent = new Intent(this, HiraganaAlphabetActivity.class);
        startActivity(intent);
    }
}