package com.example.mycurrencies;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Toast toast;

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

        ArrayList<Currency> currencies = new ArrayList<>(Arrays.asList(
                new Currency("EUR", "Euro", R.drawable.eu),
                new Currency("USD", "Dolar american", R.drawable.us),
                new Currency("GBP", "Lira sterlina", R.drawable.gb),
                new Currency("AUD", "Dolar australian", R.drawable.au),
                new Currency("CAD", "Dolar canadian", R.drawable.ca),
                new Currency("CHF", "Franc elvetian", R.drawable.ch),
                new Currency("DKK", "Corona daneza", R.drawable.dk),
                new Currency("HUF", "Forint maghiar", R.drawable.hu)
        ));

        CurrencyAdapter adapter = new CurrencyAdapter(this, currencies);
        ListView listView = findViewById(R.id.currencyList);
        listView.setAdapter(adapter);

        showToast("Árfolyamok frissitése folyamatban...");

        CurrencyApi currencyApi = new CurrencyApi(currencies);
        currencyApi.fetchCurrencyRates(new CurrencyApi.CurrencyCallback() {
            @Override
            public void onSuccess() {
                runOnUiThread(() -> {
                    adapter.notifyDataSetChanged();
                    showToast("Árfolyamok frissítve :)");
                });
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(() -> {
                    showToast("Hiba a lekérésben: " + e.getMessage());
                });
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Currency currency = currencies.get(position);
            Double rate = currency.getRate();

            TextView sellPrice = view.findViewById(R.id.rate);
            TextView rateText = view.findViewById(R.id.rateText);

            if (rate != null) {
                sellPrice.setText(String.format("%.3f RON", rate));
                rateText.setVisibility(View.VISIBLE);
            } else {
                showToast("Árfolyam nem elérhető");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Currency currency = currencies.get(i);
                currencies.remove(currency);
                adapter.notifyDataSetChanged();
                showToast(String.format("Elem eltávolítva: %s", currency.getName()));
                return false;
            }
        });
    }

    private void showToast(String text) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.show();
    }
}