package com.example.activitylifecyclemonitor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle(this.getClass().getSimpleName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Button btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d("Status", this.getClass().getSimpleName() + " - onSupportNavigateUp");
        finish();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status", this.getClass().getSimpleName() + " - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status", this.getClass().getSimpleName() + " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status", this.getClass().getSimpleName() + " - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status", this.getClass().getSimpleName() + " - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status", this.getClass().getSimpleName() + " - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status", this.getClass().getSimpleName() + " - onDestroy");
    }
}