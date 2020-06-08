package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;

import java.util.ArrayList;

//public class TaxAdapter extends RecyclerView.Adapter<TaxAdapter.ViewHolder> {
////    private Context context;
////    private ArrayList<Tax> mArrayList;
////
////    public TaxAdapter(Context context, ArrayList<Tax> mArrayList) {
////        this.context = context;
////        this.mArrayList = mArrayList;
////    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tax, parent, false);
//
//        return new ViewHolder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
//
////        viewHolder.tv_tax_name.setText(mArrayList.get(position).getName());
////        viewHolder.tv_tax_value.setText(String.valueOf(mArrayList.get(position).getValue()));
//    }
//
//    @Override
//    public int getItemCount() {
//        return (mArrayList == null) ? 0 : mArrayList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView tv_tax_name,tv_tax_value;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tv_tax_name = itemView.findViewById(R.id.tv_name);
//            tv_tax_value = itemView.findViewById(R.id.tv_value);
//
//        }
//    }
//
//}
