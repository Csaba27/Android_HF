package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn, btnActivityStateSave, btnActivityStateSaveTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         */

        btn = findViewById(R.id.button);
        btnActivityStateSave = findViewById(R.id.button3);
        btnActivityStateSaveTwo = findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        btnActivityStateSave.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ActivityStateSave.class);
            view.getContext().startActivity(intent);
        });

        btnActivityStateSaveTwo.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ActivityStateSaveTwo.class);
            view.getContext().startActivity(intent);
        });

        Log.d("Status", this.getClass().getSimpleName() + " - onCreate");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("Status", this.getClass().getSimpleName() + " - onSaveInstanceState");
        super.onSaveInstanceState(outState);
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