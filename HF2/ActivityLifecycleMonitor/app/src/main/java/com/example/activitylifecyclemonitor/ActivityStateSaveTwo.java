package com.example.activitylifecyclemonitor;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityStateSaveTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_state_save_two);

        setTitle(this.getClass().getSimpleName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Log.d("Status", this.getClass().getSimpleName() + " - onCreate");
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d("Status", this.getClass().getSimpleName() + " - onSupportNavigateUp");
        finish();
        return true;
    }
}