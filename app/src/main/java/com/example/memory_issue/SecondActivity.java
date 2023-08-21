package com.example.memory_issue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.textView).setOnClickListener(view -> {
            setResult(1);
            finish();
        });
        findViewById(R.id.textView1).setOnClickListener(view -> {
            for (int i = 0; i < 200; i++) {
                String[] arrays = new String[10000000];
                System.out.println(i);
            }
        });
    }
}