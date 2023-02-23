package com.example.japanesequizappversion2.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japanesequizappversion2.R;
import com.example.japanesequizappversion2.StudyScreen.HiraganaKatakanaSelectionActivity;
import com.example.japanesequizappversion2.StudyScreen.JapaneseHandWritingActivity;

public class Nhat1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_nhat1);
    }

    public void btn_hiragana_katakana(View view) {
        Intent intent = new Intent(getApplicationContext(), HiraganaKatakanaSelectionActivity.class);
        startActivity(intent);
    }

    public void handWriting(View view) {
        Intent intent = new Intent(getApplicationContext(), JapaneseHandWritingActivity.class);
        startActivity(intent);
    }
}