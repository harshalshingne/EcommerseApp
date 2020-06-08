package com.example.ecommerceapp.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.ShowProductAdapter;
import com.example.ecommerceapp.fragment.ProductDetailsDialog;
import com.example.ecommerceapp.fragment.TaxDialog;
import com.example.ecommerceapp.model.Categories;
import com.example.ecommerceapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ShowProductActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Products> mArrayList=new ArrayList<>();
    private ShowProductAdapter mAdapter;
    Categories categories;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        initViews();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            categories = (Categories) getIntent().getSerializableExtra("mylist"); //Obtaining data

            if (isNetworkConnected()){

                processCategories(categories.getProducts());

            }else {

                Toast.makeText(ShowProductActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(ShowProductActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();

        }



    }
    private void processCategories(List<Products> details){

        for (Products products :details){

            for (int i=0;i<details.size();i++){
                Products products1=new Products();

                products1.setId(products1.getId());
                products1.setName(products1.getName());
                products1.setVariants(products1.getVariants());
                products1.setTax(products1.getTax());
            }

            mArrayList.add(products);

        }


        mAdapter = new ShowProductAdapter(ShowProductActivity.this,mArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClick(new onItemClickListener());
    }
    private void initViews(){
        mRecyclerView =findViewById(R.id.recycler_view);
        progressBar=findViewById(R.id.progress_circular);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ShowProductActivity.this));
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    public class onItemClickListener implements ShowProductAdapter.onItemClick{

        @Override
        public void onItem(Products products) {
            DialogFragment dialogFragment = new ProductDetailsDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mylist",products);
            dialogFragment.setArguments(bundle);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);

            dialogFragment.show(ft, "dialog");
            Toast.makeText(ShowProductActivity.this, products.getName(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTaxItem(Products products) {
            DialogFragment dialogFragment = new TaxDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mylist",products);
            dialogFragment.setArguments(bundle);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);

            dialogFragment.show(ft, "dialog");
            Toast.makeText(ShowProductActivity.this, products.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}