package com.example.bfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WriterAdapter extends RecyclerView.Adapter<WriterAdapter.MyViewHolder> {
    int a = 0;
    List<Datum> items;
    private MyViewHolder.itemClickListener ICL;
    private MyViewHolder.itemLongClickListener ILCL;

    public WriterAdapter(List items, MyViewHolder.itemClickListener ICL, MyViewHolder.itemLongClickListener ILCL) {
        this.items = items;
        this.ICL = ICL;
        this.ILCL = ILCL;
    }

    public void setItems(List<Datum> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.singlewriter, parent, false);
        //view.setOnClickListener(new myOnClickListener());
        return new MyViewHolder(view, ICL, ILCL);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(items.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView name;
        ImageView logo;

        itemLongClickListener ILCL;
        itemClickListener ICL;

        public MyViewHolder(@NonNull View itemView, itemClickListener ICL, itemLongClickListener ILCL) {
            super(itemView);
            this.ICL = ICL;
            this.ILCL = ILCL;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            name = itemView.findViewById(R.id.name);
            logo = itemView.findViewById(R.id.logo);


        }

        @Override
        public void onClick(View v) {
            ICL.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            return ILCL.onItemLongClick(getAdapterPosition());
        }

        public interface itemClickListener {
            void onItemClick(int position);
        }

        public interface itemLongClickListener {
            boolean onItemLongClick(int position);
        }
    }
}
