package com.keshav.mobius.adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keshav.mobius.R;
import com.keshav.mobius.model.Slab;

import java.util.List;

public class SlabAdapter
        extends RecyclerView
        .Adapter<SlabAdapter.ChildViewHolder> {

    private List<Slab> ChildItemList;

    // Constuctor
    SlabAdapter(List<Slab> childItemList)
    {
        this.ChildItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.slab_item,
                        viewGroup, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ChildViewHolder childViewHolder,
            int position)
    {
        Slab childItem = ChildItemList.get(position);
        Log.d("Keshav",String.valueOf(position));
if(position==0) {
    childViewHolder.PurchaseAmount.setText("<" + (int)(childItem.getMax()));
}else if(position==1) {
    childViewHolder.PurchaseAmount.setText(">="+(int)(childItem.getMin())+" "+"&"+" "+"<="+String.valueOf(childItem.getMax()));
}
else{
    childViewHolder.PurchaseAmount.setText(">"+(int)(childItem.getMin()));
}
       childViewHolder.BonusAmount.setText((int) (childItem.getWagered_percent())+"%");
       childViewHolder.InstantCash.setText((int)(childItem.getOtc_percent())+"%");
       childViewHolder.Wagered_max.setText("(Max."+(int)(childItem.getWagered_max())+")");
       childViewHolder.Otc_max.setText("(Max."+(int)(childItem.getOtc_max())+")");
    }

    @Override
    public int getItemCount()
    {
        return ChildItemList.size();
    }


    class ChildViewHolder
            extends RecyclerView.ViewHolder {

        TextView PurchaseAmount,InstantCash,BonusAmount,Wagered_max,Otc_max;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            PurchaseAmount = itemView.findViewById(R.id.purchaseAmount);
            InstantCash = itemView.findViewById(R.id.instantCash);
            BonusAmount = itemView.findViewById(R.id.bonusAmount);
            Wagered_max = itemView.findViewById(R.id.wagered_max);
            Otc_max = itemView.findViewById(R.id.otc_max);
        }
    }
}

