package com.example.japanesequizappversion2.StudyScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japanesequizappversion2.DigitalInkRecognize.DrawView;
import com.example.japanesequizappversion2.DigitalInkRecognize.StrokeManager;
import com.example.japanesequizappversion2.R;

public class JapaneseHandWritingActivity extends AppCompatActivity {
    private Button btnRecognize;
    private Button btnClear;
    private DrawView drawView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese_hand_writing);
        btnRecognize = findViewById(R.id.btn_recognize);
        btnClear = findViewById(R.id.btn_clear);
        drawView = findViewById(R.id.draw_view);
        textView = findViewById(R.id.text_recognize);
        hideTitleBar();

        StrokeManager.download();
        btnRecognize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrokeManager.recognize(textView);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawView.clear();
                StrokeManager.clear();
                textView.setText("");
            }
        });
    }

    private void hideTitleBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideTitleBar();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hideTitleBar();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideTitleBar();
    }
}