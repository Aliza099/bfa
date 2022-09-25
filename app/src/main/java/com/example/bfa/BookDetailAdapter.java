package com.example.bfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class BookDetailAdapter extends RecyclerView.Adapter<BookDetailAdapter.MyViewHolder> {

    int a=0;
    List<Data> items;
    private MyViewHolder.itemClickListener ICL;
    private MyViewHolder.itemLongClickListener ILCL;

    public BookDetailAdapter(List items, MyViewHolder.itemClickListener ICL, MyViewHolder.itemLongClickListener ILCL) {
        this.items = items;
        this.ICL=ICL;
        this.ILCL=ILCL;
    }
    public void setItems(List<Data> list){
        this.items = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.detail,parent,false);
        //view.setOnClickListener(new myOnClickListener());
        return new MyViewHolder(view,ICL,ILCL );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.name1.setText(items.get(position).getTitle());
//        holder.address1.setText(items.get(position).getAuthor());
//        holder.phone.setText(items.get(position).getPublishedAt());
//    }
        holder.Title.setText(items.get(position).getTitle());
        holder.Author.setText(items.get(position).getAuthor());
        holder.Total.setText(items.get(position).getTotalCopies());
        holder.Published.setText(items.get(position).getPublishedAt());
        holder.Description.setText(items.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
//        TextView name1;
//        TextView address1;
//        TextView phone;
        TextInputEditText Title;
        TextInputEditText Category;
        TextInputEditText Author;
        TextInputEditText Total;
        TextInputEditText Published;
        TextInputEditText Description;


        itemLongClickListener ILCL;
        itemClickListener ICL;

        public MyViewHolder(@NonNull View itemView, itemClickListener ICL, itemLongClickListener ILCL) {
            super(itemView);
            this.ICL=ICL;
            this.ILCL=ILCL;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

//            name1 = itemView.findViewById(R.id.name1);
//            address1 = itemView.findViewById(R.id.address1);
//            phone = itemView.findViewById(R.id.phone);

            Title=itemView.findViewById(R.id.Title);
            Category=itemView.findViewById(R.id.Category);
            Author=itemView.findViewById(R.id.Author);
            Total=itemView.findViewById(R.id.Total);
            Published=itemView.findViewById(R.id.Published);
            Description=itemView.findViewById(R.id.Description);



        }

        @Override
        public void onClick(View v) {
            ICL.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            return ILCL.onItemLongClick(getAdapterPosition());
        }

        public interface itemClickListener{
            void onItemClick(int position);
        }
        public interface  itemLongClickListener{
            boolean onItemLongClick(int position);
        }
    }



    }
