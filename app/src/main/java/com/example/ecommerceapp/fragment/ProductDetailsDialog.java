package com.example.ecommerceapp.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.activity.ShowProductActivity;
import com.example.ecommerceapp.adapter.ProductDetailsAdapter;
import com.example.ecommerceapp.adapter.ShowProductAdapter;
import com.example.ecommerceapp.model.Products;
import com.example.ecommerceapp.model.Variants;
import com.example.ecommerceapp.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsDialog extends DialogFragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Variants> mArrayList=new ArrayList<>();
    private ProductDetailsAdapter mAdapter;
    ProgressBar progressBar;
    Products products;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_product_details, container, false);;

        initViews(view);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            products = (Products) getArguments().getSerializable("mylist");

         //   products = (Products) getActivity(). getIntent().getSerializableExtra("mylist"); //Obtaining data
            processCategories(products.getVariants());

        }else {
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();

        }
        return view;

    }

    private void processCategories(List<Variants> details){

        for (Variants variants :details){

            for (int i=0;i<details.size();i++){
                Variants variants1=new Variants();

                variants1.setColor(variants1.getColor());
                variants1.setPrice(variants1.getSize());
                variants1.setPrice(variants1.getPrice());
            }

            mArrayList.add(variants);

        }


        mAdapter = new ProductDetailsAdapter(getContext(),mArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void initViews(View view){
        mRecyclerView =view.findViewById(R.id.recycler_view);
        progressBar=view.findViewById(R.id.progress_circular);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
