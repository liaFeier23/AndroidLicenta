package com.licenta.liaf.licenta.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.licenta.liaf.licenta.model.Farmer;

import java.util.List;

public class FarmerAdapter extends RecyclerView.Adapter {
    private Context context;

    private List<Farmer> userData;

    public FarmerAdapter(Context context, List<Farmer> userData) {
        this.context = context;
        this.userData = userData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
