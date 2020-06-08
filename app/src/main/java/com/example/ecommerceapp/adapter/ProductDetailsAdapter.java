package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.model.Variants;

import java.util.ArrayList;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Variants> mArrayList;

    public ProductDetailsAdapter(Context context, ArrayList<Variants> mArrayList) {
        this.context = context;
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_details_product, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tv_prod_color.setText(mArrayList.get(position).getColor());
        viewHolder.tv_prod_size.setText(String.valueOf(mArrayList.get(position).getSize()));
        viewHolder.tv_prod_price.setText(String.valueOf(mArrayList.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return (mArrayList == null) ? 0 : mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_prod_color,tv_prod_size,tv_prod_price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_prod_color = itemView.findViewById(R.id.tv_color);
            tv_prod_size = itemView.findViewById(R.id.tv_size);
            tv_prod_price = itemView.findViewById(R.id.tv_price);

        }
    }

    public interface onItemClick{
        void onItem(Variants variants);
    }
    private onItemClick onItemClick;

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
