package com.example.mycurrencies;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private static final String ARG_CURRENCY = "currency";
    private Currency currency;

    public static Fragment2 newInstance(Currency currency) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CURRENCY, currency);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currency = (Currency) getArguments().getSerializable(ARG_CURRENCY);
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        TextView txtBuyPrice = view.findViewById(R.id.txtBuyPrice);
        TextView txtSellPrice = view.findViewById(R.id.txtSellPrice);

        if (currency != null) {
            txtBuyPrice.setText(String.format("%.4f RON", currency.getBuyPrice()));
            txtSellPrice.setText(String.format("%.4f RON", currency.getSellPrice()));
        }

        return view;
    }
}
