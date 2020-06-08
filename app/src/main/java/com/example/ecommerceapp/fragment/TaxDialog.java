package com.example.ecommerceapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;

import com.example.ecommerceapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class TaxDialog extends DialogFragment {


    private TextView tv_tax_name,tv_tax_value;
    Products products;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_tax, container, false);;

        initViews(view);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            products = (Products) getArguments().getSerializable("mylist");
            tv_tax_name.setText("Name: "+products.getTax().name);
            tv_tax_value.setText("Value: "+products.getTax().value);

        }else {
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();

        }
        return view;

    }


    private void initViews(View view){
        tv_tax_name = view.findViewById(R.id.tv_name);
        tv_tax_value = view.findViewById(R.id.tv_value);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }






}
