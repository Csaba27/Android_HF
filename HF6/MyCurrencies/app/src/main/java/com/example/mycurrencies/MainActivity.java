package com.example.mycurrencies;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements OnCurrencyClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private static final String FRAG1 = "Fragment1";
    private static final String FRAG2 = "Fragment2";
    private Currency lastCurreny = null;

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
                new Currency("EUR", "Euro", R.drawable.eu, 4.41, 4.55),
                new Currency("USD", "Dolar american", R.drawable.us, 3.975, 4.145),
                new Currency("GBP", "Lira sterlina", R.drawable.gb, 6.125, 6.355),
                new Currency("AUD", "Dolar australian", R.drawable.au, 2.96, 3.06),
                new Currency("CAD", "Dolar canadian", R.drawable.ca, 3.095, 3.265),
                new Currency("CHF", "Franc elvetian", R.drawable.ch, 4.23, 4.33),
                new Currency("DKK", "Corona daneza", R.drawable.dk, 0.585, 0.615),
                new Currency("HUF", "Forint maghiar", R.drawable.hu, 0.0136, 0.0146)
        ));

        Fragment1 f1 = Fragment1.newInstance(currencies);
        Fragment2 f2;

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        if (savedInstanceState != null) {
            lastCurreny = (Currency) savedInstanceState.getSerializable("currency");
        }

        if (lastCurreny != null) {
            f2 = Fragment2.newInstance(lastCurreny);
        } else {
            f2 = new Fragment2();
        }

        ft.replace(R.id.fragment1, f1, FRAG1);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.replace(R.id.fragment2, f2, FRAG2);
        } else {
            Fragment fragment = fm.findFragmentByTag(FRAG2);
            if (fragment != null) {
                ft.remove(fragment);
                fm.popBackStack();
            }
        }
        ft.commit();
    }

    @Override
    public void onCurrencyClick(Currency currency) {
        lastCurreny = currency;

        ft = fm.beginTransaction();
        Fragment2 f2 = Fragment2.newInstance(currency);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.replace(R.id.fragment2, f2, FRAG2);
        } else {
            Toast.makeText(this, currency.getName(), Toast.LENGTH_SHORT).show();
            ft.replace(R.id.fragment1, f2, FRAG2).addToBackStack(null);
        }

        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("currency", lastCurreny);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastCurreny = (Currency) savedInstanceState.getSerializable("currency");
    }
}