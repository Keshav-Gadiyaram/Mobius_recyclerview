package com.keshav.mobius.adapter;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.keshav.mobius.MainActivity;
import com.keshav.mobius.R;
import com.keshav.mobius.model.Slab;
import com.keshav.mobius.model.Voucher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context context;

    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();
    List<Voucher> voucherList;

    public MyAdapter(Context context, List<Voucher> voucherList) {
        this.context = context;
        this.voucherList = voucherList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_item,
                        parent,
                        false);
        // return itemView
        return new MyHolder(itemView);
    }


    public class MyHolder
            extends RecyclerView.ViewHolder {
        TextView code, ribbon_msg, valid_until_deposit_amount, valid_until, valid_until_amount,wager_text,wager_expiry;
        private RecyclerView ChildRecyclerView;


        public MyHolder(View view) {
            super(view);
            code = view.findViewById(R.id.code);
            ribbon_msg = view.findViewById(R.id.ribbon_msg);
            valid_until_deposit_amount = view.findViewById(R.id.valid_until_deposit_amount);
            valid_until = view.findViewById(R.id.valid_until_date);
            valid_until_amount = view.findViewById(R.id.valid_until_amount);
            wager_text = view.findViewById(R.id.wager_text);
            wager_expiry = view.findViewById(R.id.wager_expiry);
            ChildRecyclerView = itemView.findViewById(R.id.rv_slab);

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Voucher voucher = voucherList.get(position);
        holder.code.setText(voucher.getCode());
        holder.ribbon_msg.setText(voucher.getRibbon_msg());
        Date date = voucher.getValid_until();
        DateFormat dateFormat = new SimpleDateFormat("DMMM, y");
        String strDate = dateFormat.format(date);
        holder.valid_until.setText(strDate);
        final ArrayList<Slab> slabList = voucher.getSlabs();
        Slab slab =  Collections.max(slabList, Comparator.comparing(s -> s.getWagered_max()));
        Slab slab1 =  Collections.max(slabList, Comparator.comparing(s -> s.getWagered_percent()));
        if(slab1.getWagered_percent()<100) {
            holder.valid_until_amount.setText("Get " + (int) slab1.getWagered_percent() + "% " + "upto " + "₹" + (int) slab.getWagered_max());
        }
        else {
            holder.valid_until_amount.setText("Get " + 100 + "% " + "upto " + "₹" + (int) slab.getWagered_max());

        }
        Slab slab2 =  Collections.min(slabList, Comparator.comparing(s -> s.getMin()));
        holder.valid_until_deposit_amount.setText("₹"+((int) slab2.getMin()));

        holder.wager_text.setText("For every ₹"+voucher.getWager_to_release_ratio_numerator()+" bet ₹"+voucher.getWager_to_release_ratio_denominator()+" will be released from the bonus amount");
        String days = voucher.getWager_bonus_expiry()+" days";

        holder.wager_expiry.setText(Html.fromHtml("<font color=white>" + "Bonus expiry " + "<font color=yellow>" + days +"</font>"+ "<font color=white>" + " from the issue" + "</font>"));
        holder.wager_text.setText(Html.fromHtml("<font color=white>" + "For every " + "<font color=yellow>" + "₹"+voucher.getWager_to_release_ratio_numerator() +"</font>"+ "<font color=white>"+" bet "+"</font>"+"<font color =yellow"+"<font color=yellow>"+"₹"+voucher.getWager_to_release_ratio_denominator()+"</font>"+ "<font color=white>"+" will be released from the bonus amount" + "</font>"));
       // holder.wager_expiry.setText("Bonus expiry "+voucher.getWager_bonus_expiry()+" days from the issue");
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.ChildRecyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(voucher.getSlabs().size());
        SlabAdapter childItemAdapter = new SlabAdapter(voucher.getSlabs());
        holder.ChildRecyclerView.setLayoutManager(layoutManager);
        holder.ChildRecyclerView.setAdapter(childItemAdapter);
        holder.ChildRecyclerView.setRecycledViewPool(viewPool);
        MainActivity.mProgressDialog.dismiss();

    }




    @Override
    public int getItemCount() {
        return voucherList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("Jnani", String.valueOf(position));
        return super.getItemViewType(position);
    }
}
