package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.TradingAdapter;
import com.example.myapplication.model.Stock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TradingAdapter adapter;
    private Button startButton;
    private TextView resultTextView;

    private List<Stock> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        startButton = findViewById(R.id.startButton);
        resultTextView = findViewById(R.id.resultTextView);


        stockList = generateStockList();

        // Setting up RecyclerView
        adapter = new TradingAdapter(stockList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        startButton.setOnClickListener(v -> {
            // Start both trading algorithms
            startTradingProcesses();
        });
    }

    private void startTradingProcesses() {
        // Start both algorithms in separate threads
        new Thread(new PriceOptimizingAlgorithm()).start();
        new Thread(new SpeedFocusedAlgorithm()).start();
    }

    private List<Stock> generateStockList() {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock("AAPL", 150.0));
        stockList.add(new Stock("GOOGL", 2800.0));
        stockList.add(new Stock("AMZN", 3500.0));
        stockList.add(new Stock("TSLA", 1000.0));
        return stockList;
    }

    //     simulating a price-optimizing algorithm (buys the lowest price)
    private class PriceOptimizingAlgorithm implements Runnable {
        @Override
        public void run() {
            try {
                // ssimulate a slower process for price optimization
                Thread.sleep(2000);
                Stock cheapestStock = stockList.stream()
                        .min(Comparator.comparingDouble(Stock::getPrice))
                        .orElse(null);

                if (cheapestStock != null) {
                    String result = "Price Optimizing Algorithm bought: " + cheapestStock.getSymbol() +
                            " at $" + cheapestStock.getPrice();
                    runOnUiThread(() -> resultTextView.setText(result));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //  speed-focused algorithm (!!!!!!!!buys the highest price)
    private class SpeedFocusedAlgorithm implements Runnable {
        @Override
        public void run() {
            try {
                // Simulate a faster process for quick trading
                Thread.sleep(500);
                Stock mostExpensiveStock = stockList.stream()
                        .max(Comparator.comparingDouble(Stock::getPrice))
                        .orElse(null);

                if (mostExpensiveStock != null) {
                    String result = "Speed-Focused Algorithm bought: " + mostExpensiveStock.getSymbol() +
                            " at $" + mostExpensiveStock.getPrice();
                    runOnUiThread(() -> resultTextView.setText(result));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
