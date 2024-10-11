package com.example.mycurrencies;

import androidx.annotation.NonNull;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CurrencyApi {
    private static final String API_URL = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/ron.json";
    private final OkHttpClient client;
    private final ArrayList<Currency> currencies;

    public CurrencyApi(ArrayList<Currency> currencies) {
        this.client = new OkHttpClient();
        this.currencies = currencies;
    }

    public void fetchCurrencyRates(final CurrencyCallback callback) {
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String responseData = response.body().string();
                    JSONObject jsonObject = null;
                    JSONObject rates = null;
                    try {
                        jsonObject = new JSONObject(responseData);
                        rates = jsonObject.getJSONObject("ron");
                    } catch (JSONException e) {
                        callback.onError(new IOException("Unexpected code json"));
                        return;
                    }

                    for (Currency currency : currencies) {
                        double rate;
                        try {
                            rate = rates.getDouble(currency.getCode().toLowerCase());
                            rate = 1.0 / rate;
                            currency.setRate(rate);
                        } catch (JSONException e) {
                        }
                    }
                    callback.onSuccess();
                } else {
                    callback.onError(new IOException("Unexpected code " + response));
                }
            }
        });
    }

    public interface CurrencyCallback {
        void onSuccess();

        void onError(Exception e);
    }
}