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
import com.example.ecommerceapp.model.Categories;
import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.model.Variants;

import java.util.ArrayList;

public class ShowProductAdapter extends RecyclerView.Adapter<ShowProductAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Products> mArrayList;

    public ShowProductAdapter(Context context, ArrayList<Products> mArrayList) {
        this.context = context;
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_show_product, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tv_prod_name.setText(mArrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return (mArrayList == null) ? 0 : mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_prod_name;
        private Button btn_details,btn_tax;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_prod_name = itemView.findViewById(R.id.tv_prod_name);


            btn_details=itemView.findViewById(R.id.btn_prod_details);
            btn_tax=itemView.findViewById(R.id.btn_prod_tax);

            btn_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Products products=mArrayList.get(getAdapterPosition());
                    onItemClick.onItem(products);
                }
            });

            btn_tax.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Products products=mArrayList.get(getAdapterPosition());
                    onItemClick.onTaxItem(products);
                }
            });
        }
    }

    public interface onItemClick{
        void onItem(Products products);
        void onTaxItem(Products products);
    }
    private onItemClick onItemClick;

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
