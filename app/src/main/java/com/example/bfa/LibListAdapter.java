package com.example.bfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibListAdapter extends RecyclerView.Adapter<LibListAdapter.MyViewHolder> {
    int a=0;
    List<BooksDetailResponse> items;
    private MyViewHolder.itemClickListener ICL;
    private MyViewHolder.itemLongClickListener ILCL;

    public LibListAdapter(List items, MyViewHolder.itemClickListener ICL, MyViewHolder.itemLongClickListener ILCL) {
        this.items = items;
        this.ICL=ICL;
        this.ILCL=ILCL;
    }

    public void setItems(List<BooksDetailResponse> list){
        this.items = list;
        notifyDataSetChanged();
    }
    public List<BooksDetailResponse> getItems(){

        return this.items;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.forbooks,parent,false);
        //view.setOnClickListener(new myOnClickListener());
        return new MyViewHolder(view,ICL,ILCL );
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.author.setText(items.get(position).getAuthor());
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView title;
        TextView author;
        ImageView image;

        itemLongClickListener ILCL;
        itemClickListener ICL;

        public MyViewHolder(@NonNull View itemView, itemClickListener ICL, itemLongClickListener ILCL) {
            super(itemView);
            this.ICL=ICL;
            this.ILCL=ILCL;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            title=itemView.findViewById(R.id.title);
            author=itemView.findViewById(R.id.author);
            image=itemView.findViewById(R.id.image);


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
