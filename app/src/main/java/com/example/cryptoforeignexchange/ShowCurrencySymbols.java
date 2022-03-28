package com.example.cryptoforeignexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ShowCurrencySymbols extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_currency_symbols);

        textView=findViewById(R.id.showCurrnecyText);

        getSymbols();

    }

    public void getSymbols()
    {
        String currencyResult;
        String cryptoResult;
        StringBuilder currencysb = new StringBuilder();
        StringBuilder cryptosb = new StringBuilder();
        String cryptoCurrencySymbols="symbols.json";
        String currencySymbols="currencies.json";
        try {

            InputStream currencyInputStream = getResources().getAssets().open(currencySymbols);
            BufferedInputStream currencyBufferedInputStream = new BufferedInputStream(currencyInputStream);

            InputStreamReader currencyInputStreamReader = new InputStreamReader(currencyBufferedInputStream);
            BufferedReader currencyBufferedReader = new BufferedReader(currencyInputStreamReader);

            String inputLine = currencyBufferedReader.readLine();
            while (inputLine != null) {
                currencysb.append(inputLine);
                inputLine = currencyBufferedReader.readLine();
            }
            currencyResult = currencysb.toString();

            InputStream cryptoInputStream = getResources().getAssets().open(cryptoCurrencySymbols);
            BufferedInputStream cryptoBufferedInputStream = new BufferedInputStream(cryptoInputStream);

            InputStreamReader cryptoInputStreamReader = new InputStreamReader(cryptoBufferedInputStream);
            BufferedReader crytpoBufferedReader = new BufferedReader(cryptoInputStreamReader);

            String inputLine1 = crytpoBufferedReader.readLine();
            while (inputLine1 != null) {
                cryptosb.append(inputLine1);
                inputLine1 = crytpoBufferedReader.readLine();
            }
            cryptoResult = cryptosb.toString();

            createSymbolsList(currencyResult,cryptoResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSymbolsList(String currency,String crypto)
    {
        ArrayList<CurrencySymbol> currencySymbols=new ArrayList<>();

        try {
            JSONArray currencyRoot=new JSONArray(currency);
            for(int i=0;i<currencyRoot.length();i++)
            {
                JSONObject currencyJSON =currencyRoot.getJSONObject(i);
                currencySymbols.add(new CurrencySymbol(currencyJSON.getString("cc"),currencyJSON.getString("symbol"),currencyJSON.getString("name")));
            }
            JSONArray crytoRoot=new JSONArray(crypto);
            for(int i =0;i<crytoRoot.length();i++)
            {
                JSONObject currencyJSON=crytoRoot.getJSONObject(i);
                currencySymbols.add(new CurrencySymbol(currencyJSON.getString("usym"),currencyJSON.getString("symbol"),currencyJSON.getString("name")));
            }
            StringBuilder allSymbolInformation=new StringBuilder();
            for (CurrencySymbol symbol:currencySymbols
                 ) {
                allSymbolInformation.append(symbol.toString());
            }
            textView.setText(allSymbolInformation.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}