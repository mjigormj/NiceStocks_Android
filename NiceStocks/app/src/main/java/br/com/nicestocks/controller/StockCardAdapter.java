package br.com.nicestocks.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.nicestocks.R;
import br.com.nicestocks.model.Stock;

public class StockCardAdapter extends RecyclerView.Adapter<StockCardAdapter.StockViewHolder> {

    private final List<Stock> stocks;

    public StockCardAdapter(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_stock_layout, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        Stock stock = stocks.get(position);
        holder.bind(stock);
    }

    @Override
    public int getItemCount() {
        return stocks.size() ;
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {
        TextView tVStockName;
        TextView tVStockWalletPercent;
        TextView tVStockQtd;
        TextView tVStockAvgPrice;
        TextView tVStockAvgCust;
        TextView tVStockMarcketValue;
        TextView tVStockValueWallet;
        TextView tVStockValueEarned;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            tVStockName = itemView.findViewById(R.id.stockName);
            tVStockWalletPercent = itemView.findViewById(R.id.stockWalletPercent);
            tVStockQtd = itemView.findViewById(R.id.stockQtd);
            tVStockAvgPrice = itemView.findViewById(R.id.stockAvgPrice);
            tVStockAvgCust = itemView.findViewById(R.id.stockAvgCust);
            tVStockMarcketValue = itemView.findViewById(R.id.stockMarcketValue);
            tVStockValueWallet = itemView.findViewById(R.id.stockValueWallet);
            tVStockValueEarned = itemView.findViewById(R.id.stockValueEarned);
        }
        public void bind(@NonNull Stock stock) {
            String name = stock.getName();
            tVStockName.setText(name);
            tVStockWalletPercent.setText("0%");
            tVStockAvgPrice.setText( "price/qtd");
            /*tVStockQtd.setText(stock.getStockQtd());
            tVStockAvgCust.setText(stock.getAvgCust().toString());
            tVStockMarcketValue.setText(stock.getMarcketValue().toString());
            tVStockValueWallet.setText(stock.getTotalPrice().toString());*/
        }


    }


}
