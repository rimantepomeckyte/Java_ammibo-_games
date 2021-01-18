package com.amiibo.amiiboGames;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Games> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Games> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_games, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data - cia pildys kortele kiekvienu atveju, kai iskviesim, irasu
    //cia sitoj vietoj issitraukiam is saraso konkretu irasa ir uzpildom kiekviena elementa
    //cia persirasyti reikia kokius duomenis norim issitraukti
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Games current = data.get(position);
        myHolder.textName.setText(current.getName());
        myHolder.textCharacter.setText("Character: " + current.getCharacter());
        myHolder.textGameSeries.setText("Game Series: " + current.getGameSeries());
        myHolder.textType.setText("Type: " + current.getType());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textName;
        TextView textCharacter;
        TextView textGameSeries;
        TextView textType;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textCharacter = (TextView) itemView.findViewById(R.id.textCharacter);
            textGameSeries = (TextView) itemView.findViewById(R.id.textGSeries);
            textType = (TextView) itemView.findViewById(R.id.textType);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        }
    }
}
