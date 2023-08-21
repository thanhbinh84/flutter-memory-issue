package com.example.memory_issue;

import android.content.Intent;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

import androidx.annotation.NonNull;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "com.example.app";
    private static int RQ_CODE = 1;
    private MethodChannel.Result _result;

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            _result = result; //Store
                            Intent intent = new Intent(this, SecondActivity.class);
                            startActivityForResult(intent, RQ_CODE);
                        }
                );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.printf("onActivityResult %d %d; %s%n", requestCode, resultCode, this);
        if (requestCode == RQ_CODE && _result != null) {
            _result.success(resultCode);
            System.out.println("_result " + _result.toString());
        } else
            System.out.println("_result null");
    }
}
