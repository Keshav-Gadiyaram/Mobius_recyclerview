package com.keshav.mobius;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    Button tryBtn;
    public static ProgressDialog mProgressDialog;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        tryBtn = findViewById(R.id.tryBtn);
        recyclerView = findViewById(R.id.listViewVouchers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Please wait....");
        if(isConnected()) {
            mProgressDialog.show();
            tryBtn.setVisibility(View.GONE);
            new Task().execute();
        }
        else {
            Toast.makeText(this, "Please turn on internet", Toast.LENGTH_SHORT).show();
            mProgressDialog.dismiss();
            tryBtn.setVisibility(View.VISIBLE);
            tryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isConnected()){
                        mProgressDialog.show();
                        tryBtn.setVisibility(View.GONE);
                        new Task().execute();
                    }
                    else{

                        Toast.makeText(MainActivity.this, "Please turn on internet", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            //finish();
        }

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

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
class Task extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        getVouchers();
        return null;
    }
}


}