package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.model.Categories;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Categories> mArrayList;

    public CategoryAdapter(Context context, ArrayList<Categories> mArrayList) {
        this.context = context;
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_categories, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        if ( mArrayList.get(position).getName()!=null ){

            viewHolder.tv_category.setVisibility(View.VISIBLE);
            viewHolder.tv_category.setText(mArrayList.get(position).getName());
        }else {
            viewHolder.tv_category.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return (mArrayList == null) ? 0 : mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_category = itemView.findViewById(R.id.tv_category);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Categories categories=mArrayList.get(getAdapterPosition());
                    onItemClick.onItem(categories);
                }
            });
        }
    }

    public interface onItemClick{
        void onItem(Categories categories);
    }
    private onItemClick onItemClick;

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
