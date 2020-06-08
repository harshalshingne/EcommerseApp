package com.example.ecommerceapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.CategoryAdapter;
import com.example.ecommerceapp.model.Result;
import com.example.ecommerceapp.model.Categories;
import com.example.ecommerceapp.retrofit.APIClient;
import com.example.ecommerceapp.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Categories> mArrayList=new ArrayList<>();
    private CategoryAdapter mAdapter;
    APIInterface apiInterface;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if (isNetworkConnected()){

           loadData();

        }else {

            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

        }
    }
    private void initViews(){
        mRecyclerView =findViewById(R.id.recycler_view);
        progressBar=findViewById(R.id.progress_circular);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    private void loadData(){
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Result> call = apiInterface.getProduct();
        progressBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                Log.e("Responses ",result+"");

                if (result != null) {

                    if (result.getCategories().size() > 1) {
                        processCategories(result.getCategories());
                        progressBar.setVisibility(View.GONE);

                    } else {
                        Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                call.cancel();
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Log.d("TAGG ", t.getMessage());
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void processCategories(List<Categories> details){

        for (Categories categories :details){

            for (int i=0;i<details.size();i++){
                Categories categories1=new Categories();

                categories1.setId(categories1.getId());
                categories1.setName(categories1.getName());
                categories1.setProducts(categories1.getProducts());
            }

            mArrayList.add(categories);

        }


        mAdapter = new CategoryAdapter(MainActivity.this,mArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClick(new onItemClickListener());
    }

    public class onItemClickListener implements CategoryAdapter.onItemClick{

        @Override
        public void onItem(Categories categories) {

            Toast.makeText(MainActivity.this, categories.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,ShowProductActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("mylist",categories);
            intent.putExtras(bundle);
            startActivity(intent);


        }
    }
}