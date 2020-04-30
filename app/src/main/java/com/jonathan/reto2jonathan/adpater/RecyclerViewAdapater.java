package com.jonathan.reto2jonathan.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.jonathan.reto2jonathan.R;
import com.jonathan.reto2jonathan.model.Category;

import java.util.List;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.MyViewHolder> {
    private Context mContext;
    private List<Category> mData;

    public RecyclerViewAdapater(Context mContext, List<Category> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.img_category.setImageResource(mData.get(position).getImg());
        holder.txt_category.setText(mData.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("Ha seleccionado: "+mData.get(position).getName());
            }
        });

    }
    public void displayToast(String message) {
        Toast.makeText(mContext, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txt_category;
        ImageView img_category;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_category = (TextView) itemView.findViewById(R.id.category_name);
            img_category = (ImageView) itemView.findViewById(R.id.category_img);
            cardView = itemView.findViewById(R.id.cardView_id);
        }
    }

}
