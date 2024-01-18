package com.example.curcolgan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterQuotes extends RecyclerView.Adapter<MyViewHolderQuotes> {

    private Context context;
    private List<DataClassQuotes> dataList;

    public MyAdapterQuotes(Context context, List<DataClassQuotes> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderQuotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_quotes, parent, false);
        return new MyViewHolderQuotes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderQuotes holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recQuote.setText(dataList.get(position).getDataQuote());
        holder.recPencipta.setText(dataList.get(position).getDataPencipta());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailQuotesActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Pencipta", dataList.get(holder.getAdapterPosition()).getDataPencipta());
                intent.putExtra("Quote", dataList.get(holder.getAdapterPosition()).getDataQuote());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClassQuotes> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolderQuotes extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recQuote, recPencipta;
    CardView recCard;

    public MyViewHolderQuotes(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recPencipta = itemView.findViewById(R.id.recPencipta);
        recQuote = itemView.findViewById(R.id.recQuote);
    }
}