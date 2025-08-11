package com.example.augustandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Lifecycle","onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lifecycle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Lifecycle","onDestroy");

    }
}