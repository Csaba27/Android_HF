package com.example.mycontextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.simpleList);
        listItems = new ArrayList<>(Arrays.asList("grape", "elderberry", "banana", "fig", "cherry", "apple", "date"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);

        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.sort) {
            Collections.sort(listItems);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Lista rendezve", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.delete) {
            listItems.clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Listan törölve", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (info != null) {
            View view = listView.getChildAt(info.position - listView.getFirstVisiblePosition());
            TextView textView = view.findViewById(android.R.id.text1);

            if (itemId == R.id.menuGreen) {
                textView.setTextColor(Color.GREEN);
            } else if (itemId == R.id.menuRed) {
                textView.setTextColor(Color.RED);
            } else if (itemId == R.id.menuYellow) {
                textView.setTextColor(Color.YELLOW);
            }
        }

        return super.onContextItemSelected(item);
    }
}