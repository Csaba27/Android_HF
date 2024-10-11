package com.example.mycurrencies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CurrencyAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<Currency> currencies;

    public CurrencyAdapter(@NonNull Activity context, ArrayList<Currency> currencies) {
        super(context, R.layout.list_item, currencies);
        this.context = context;
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.list_item, null, true);

        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.currencyName);
        TextView code = view.findViewById(R.id.currencyCode);

        Currency currency = currencies.get(position);

        image.setImageResource(currency.getImage());
        code.setText(currency.getCode());
        name.setText(currency.getName());

        return view;
    }
}
