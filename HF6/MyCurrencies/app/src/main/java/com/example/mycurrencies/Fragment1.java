package com.example.mycurrencies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    private OnCurrencyClickListener listener;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private static final String ARG_PARAM1 = "currencies";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCurrencyClickListener) {
            listener = (OnCurrencyClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCurrencyClickListener");
        }
    }

    public static Fragment1 newInstance(ArrayList<Currency> currencies) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, currencies);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currencies = (ArrayList<Currency>) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        ListView listView = view.findViewById(R.id.currency_list);
        listView.setAdapter(new CurrencyAdapter(getActivity(), currencies));

        listView.setOnItemClickListener((adapterView, view1, position, id) -> {
            Currency selectedCurrency = (Currency) adapterView.getItemAtPosition(position);
            listener.onCurrencyClick(selectedCurrency);
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
