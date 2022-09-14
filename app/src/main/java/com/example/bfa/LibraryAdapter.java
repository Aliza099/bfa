package com.example.bfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import PojoModels.Library;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.MyViewHolder> {
    int a=0;
    List<Library> items;
//    private MyViewHolder.itemClickListener ICL;
//    private MyViewHolder.itemLongClickListener ILCL;

    public LibraryAdapter(List items) {
        this.items = items;
//        this.ICL=ICL;
//        this.ILCL=ILCL;

    }

    @NonNull
    @Override
    public LibraryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.singlelibrary,parent,false);
        //view.setOnClickListener(new myOnClickListener());
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryAdapter.MyViewHolder holder, int position) {
        holder.name1.setText(items.get(position).getData().get(position).getName());
        holder.address1.setText(items.get(position).getData().get(position).getAddress());

    }


    @Override
    public int getItemCount() {
        return items.size();
    }
static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name1;
    TextView address1;

//    itemLongClickListener ILCL;
//    itemClickListener ICL;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
//        this.ICL = ICL;
//        this.ILCL = ILCL;
//        itemView.setOnClickListener(this);
//        itemView.setOnLongClickListener(this);

        name1 = itemView.findViewById(R.id.name1);
        address1 = itemView.findViewById(R.id.address1);

    }

//    @Override
//    public void onClick(View view) {
//
//        ICL.onItemClick(getAdapterPosition());
//    }
//
//
//    @Override
//    public boolean onLongClick(View view) {
//        return ILCL.onItemLongClick(getAdapterPosition());
//    }
//    public interface itemClickListener{
//        void onItemClick(int position);
//    }
//    public interface  itemLongClickListener{
//        boolean onItemLongClick(int position);
//    }
}
}



