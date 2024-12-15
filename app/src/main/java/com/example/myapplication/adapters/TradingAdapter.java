package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Stock;
import java.util.List;

public class TradingAdapter extends RecyclerView.Adapter<TradingAdapter.StockViewHolder> {

    private List<Stock> stockList;

    // Constructor that accepts the correct type of Stock
    public TradingAdapter(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the stock_item layout and return a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R .layout.stock_item, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StockViewHolder holder, int position) {
        // Bind the Stock data to the ViewHolder
        Stock stock = stockList.get(position);
        holder.stockSymbol.setText(stock.getSymbol());
        holder.stockPrice.setText(String.format("$%.2f", stock.getPrice()));
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    // ViewHolder class to hold views for stock items
    static class StockViewHolder extends RecyclerView.ViewHolder {

        TextView stockSymbol;
        TextView stockPrice;

        public StockViewHolder(View itemView) {
            super(itemView);
            stockSymbol = itemView.findViewById(R.id.stockSymbol);
            stockPrice = itemView.findViewById(R.id.stockPrice);
        }
    }
}
