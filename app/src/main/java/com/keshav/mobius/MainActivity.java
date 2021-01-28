package com.keshav.mobius;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.keshav.mobius.adapter.MyAdapter;
import com.keshav.mobius.model.Voucher;
import com.keshav.mobius.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.listViewVouchers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getVouchers();

    }

    private void getVouchers() {
        Call<List<Voucher>> call = ApiClient.getInstance().getMyApi().getVouchers();
        call.enqueue(new Callback<List<Voucher>>() {
            @Override
            public void onResponse(Call<List<Voucher>> call, Response<List<Voucher>> response) {
                List<Voucher> voucherList = response.body();

                //Creating an String array for the ListView
                String[] vouchers = new String[voucherList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < voucherList.size(); i++) {
                    vouchers[i] = voucherList.get(i).getId();
                }

                //displaying the string array into listview
                recyclerView.setAdapter(new MyAdapter(context,voucherList));
            }

            @Override
            public void onFailure(Call<List<Voucher>> call, Throwable t) {

            }

        });
    }

}