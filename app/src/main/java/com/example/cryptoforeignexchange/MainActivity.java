package com.example.cryptoforeignexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //TextView textView;
    TextView _fromCurrencySymbol;
    TextView _fromCurrencyName;
    TextView _toCurrencySymbol;
    TextView _toCurrencyName;
    TextView _exchangeRate;
    TextView _lastRefreshed;
    TextView _timeZone;
    TextView _bidPrice;
    TextView _askPrice;
//            "5. Exchange Rate": "282984.96349800",
//                    "6. Last Refreshed": "2022-03-26 23:23:37",
//                    "7. Time Zone": "UTC",
//                    "8. Bid Price": "282984.89983500",
//                    "9. Ask Price": "282984.96349800"
    EditText enteredFromCurrency,enteredToCurreny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      enteredFromCurrency=findViewById(R.id.fromCurrency);
      enteredToCurreny=findViewById(R.id.toCurrency);

        _fromCurrencySymbol=findViewById(R.id.FromCurrencyCode);
        _fromCurrencyName=findViewById(R.id.FromCurrencyName);
        _toCurrencySymbol=findViewById(R.id.ToCurrencyCode);
        _toCurrencyName=findViewById(R.id.ToCurrencyName);
        _exchangeRate=findViewById(R.id.ExchangeRate);
        _lastRefreshed=findViewById(R.id.LastRefreshed);
        _timeZone=findViewById(R.id.TimeZone);
        _bidPrice=findViewById(R.id.BidPrice);
        _askPrice=findViewById(R.id.AskPrice);

//        //Create new async task
//        CrytproForeignExchangeSearchTask companyStockSearchTask=new CrytproForeignExchangeSearchTask();
//        //Set Search Symbol
//        //Start api connection
//        companyStockSearchTask.execute();
    }

    public void ExchangeCurrency(View view) {
//                CrytproForeignExchangeSearchTask crytproForeignExchangeSearchTask=new CrytproForeignExchangeSearchTask();
//        //Set from company & to company
//        crytproForeignExchangeSearchTask.setFromCurrency(enteredFromCurrency.getText().toString());
//        crytproForeignExchangeSearchTask.setToCurrency(enteredToCurreny.getText().toString());
//        //Start api connection
//        crytproForeignExchangeSearchTask.execute();
    }

    public void ShowCurrency(View view) {
        Intent intent = new Intent(MainActivity.this,ShowCurrencySymbols.class);
        startActivity(intent);
    }


//    public class CrytproForeignExchangeSearchTask extends AsyncTask<String, String, String> {
//        String result;
//        String SYMBOL;
//
//        String fromCurrency = "";
//        String toCurrency = "";
//        //MUST INSERT YOUR OWN KEY TO USE
//        //GET KEY FROM https://www.alphavantage.co/support/#api-key
//        String APIKey = "50BZM4QNXYEYF7K3";
//
//        public void setFromCurrency(String fromCurrency) {
//            this.fromCurrency = fromCurrency;
//        }
//
//        public void setToCurrency(String toCurrency) {
//            this.toCurrency = toCurrency;
//        }
//
//        //Start connecting to internet and retrieve data
//        @Override
//        protected String doInBackground(String... strings) {
//            StringBuilder sb = new StringBuilder();
//            URL url;
//            HttpURLConnection urlConnection = null;
//            try {
//                //String uri = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=CNY&apikey=" + APIKey;
//                  String uri="https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency="+fromCurrency+"&to_currency="+toCurrency+"&apikey="+APIKey;
//                //String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + SYMBOL + "&apikey=" + APIKey;
//                url = new URL(uri);
//                urlConnection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = urlConnection.getInputStream();
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//
//                InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//                String inputLine = bufferedReader.readLine();
//                while (inputLine != null) {
//                    sb.append(inputLine);
//                    inputLine = bufferedReader.readLine();
//                }
//                result = sb.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                urlConnection.disconnect();
//            }
//            //nonsense return because of String return type
//            return sb.toString();
//        }
//
//        //after internet connection is established
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//                JSONObject root = new JSONObject(result);
//                JSONObject foriengExchangeRate = root.getJSONObject("Realtime Currency Exchange Rate");
//
//                String fromCurrencyCode = foriengExchangeRate.getString("1. From_Currency Code");
//                String fromCurrencyName = foriengExchangeRate.getString("2. From_Currency Name");
//                String toCurrencyCode = foriengExchangeRate.getString("3. To_Currency Code");
//                String toCurrecnyName = foriengExchangeRate.getString("4. To_Currency Name");
//                String exchangeRate = foriengExchangeRate.getString("5. Exchange Rate");
//                String lastRefreshed = foriengExchangeRate.getString("6. Last Refreshed");
//                String timeZone = foriengExchangeRate.getString("7. Time Zone");
//                String bidPrice = foriengExchangeRate.getString("8. Bid Price");
//                String askPrice = foriengExchangeRate.getString("9. Ask Price");
//
//                //_fromCurrencySymbol.setText("dsfsadfsdfsafd");
//                _fromCurrencySymbol.setText(fromCurrencyCode);
//                _fromCurrencyName.setText(fromCurrencyName);
//                _toCurrencySymbol.setText(toCurrencyCode);
//                _toCurrencyName.setText(toCurrecnyName);
//                _exchangeRate.setText(exchangeRate);
//                _lastRefreshed.setText(lastRefreshed);
//                _timeZone.setText(timeZone);
//                _bidPrice.setText(bidPrice);
//                _askPrice.setText(askPrice);
//
////                JSONObject metaData = root.getJSONObject("Meta Data");
////                JSONObject timeSeriesDaily = root.getJSONObject("Time Series (Daily)");
////
////                String companySymbol = metaData.getString("2. Symbol");
////                String lastRefreshed = metaData.getString("3. Last Refreshed");
////                String timeZone = metaData.getString("5. Time Zone");
////
////                JSONArray dates = timeSeriesDaily.names();
////
////                //put all data into a list
////                ArrayList<StockData> dailyStock = new ArrayList<>();
////
////                for (int i = 0; i < dates.length(); i++) {
////                    String stockDate = dates.getString(i);
////                    String openValue = timeSeriesDaily.getJSONObject(stockDate).getString("1. open");
////                    String highValue = timeSeriesDaily.getJSONObject(stockDate).getString("2. high");
////                    String lowValue = timeSeriesDaily.getJSONObject(stockDate).getString("3. low");
////                    String closeValue = timeSeriesDaily.getJSONObject(stockDate).getString("4. close");
////                    String volumeValue = timeSeriesDaily.getJSONObject(stockDate).getString("5. volume");
////
////                    float iOpenValue = Float.parseFloat(openValue);
////                    float iHighValue = Float.parseFloat(highValue);
////                    float iLowValue = Float.parseFloat(lowValue);
////                    float iCloseValue = Float.parseFloat(closeValue);
////                    int iVolumeValue = Integer.parseInt(volumeValue);
////
////                    //create a daily stock
////                    dailyStock.add(new StockData(stockDate, iOpenValue, iHighValue, iLowValue, iCloseValue, iVolumeValue));
////                }
//                //create company's information from data obtained
//                // Company currentCompany = new Company(SYMBOL, dailyStock);
//                //populate the chart with the company's data
//                // setCandleStickChart(currentCompany);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}