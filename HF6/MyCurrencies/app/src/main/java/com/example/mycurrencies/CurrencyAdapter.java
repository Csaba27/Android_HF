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

public class CurrencyAdapter extends ArrayAdapter<Currency> {
    private final ArrayList<Currency> currencies;

    public CurrencyAdapter(@NonNull Activity context, ArrayList<Currency> currencies) {
        super(context, R.layout.list_item, currencies);
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.imageView);
        TextView name = convertView.findViewById(R.id.currencyName);
        TextView code = convertView.findViewById(R.id.currencyCode);

        Currency currency = currencies.get(position);

        image.setImageResource(currency.getImage());
        code.setText(currency.getCode());
        name.setText(currency.getName());

        return convertView;
    }
}
