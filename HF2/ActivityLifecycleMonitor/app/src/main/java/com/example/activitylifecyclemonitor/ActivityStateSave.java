package com.example.activitylifecyclemonitor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityStateSave extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_state_save);

        setTitle(this.getClass().getSimpleName());

        tv = findViewById(R.id.textView3);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append(String.format("\n %s", tv.getText().toString()));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("Status", this.getClass().getSimpleName() + " - onSaveInstanceState");

        outState.putString("text", tv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("text");
        tv.setText(String.valueOf(text));

        Log.d("Status", this.getClass().getSimpleName() + " - onRestoreInstanceState");

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