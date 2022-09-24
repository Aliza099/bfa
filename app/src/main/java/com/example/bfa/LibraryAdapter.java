package com.example.bfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.MyViewHolder> {

    int a=0;
    List<DatumCardList> items;
    private MyViewHolder.itemClickListener ICL;
    private MyViewHolder.itemLongClickListener ILCL;

    public LibraryAdapter(List items, MyViewHolder.itemClickListener ICL, MyViewHolder.itemLongClickListener ILCL) {
        this.items = items;
        this.ICL=ICL;
        this.ILCL=ILCL;
    }

    public void setItems(List<DatumCardList> list){
        this.items = list;
        notifyDataSetChanged();
    }

    public List<DatumCardList> getItems(){

        return this.items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View  view =layoutInflater.inflate(R.layout.singlelibrary,parent,false);
        //view.setOnClickListener(new myOnClickListener());
        return new MyViewHolder(view,ICL,ILCL );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name1.setText(items.get(position).getName());
        holder.address1.setText(items.get(position).getAddress());
        holder.phone.setText(items.get(position).getPhoneNo());
//        holder.name1.setText(items.get(position).getData().get(position).getName());
//        holder.address1.setText(items.get(position).getData().get(position).getAddress());

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView name1;
        TextView address1;
        TextView phone;
        ImageView image1;

        itemLongClickListener ILCL;
        itemClickListener ICL;

        public MyViewHolder(@NonNull View itemView, itemClickListener ICL, itemLongClickListener ILCL) {
            super(itemView);
            this.ICL=ICL;
            this.ILCL=ILCL;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);




            name1=itemView.findViewById(R.id.name1);
            phone = itemView.findViewById(R.id.phone);
            address1=itemView.findViewById(R.id.address1);
            image1 = itemView.findViewById(R.id.image1);



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

