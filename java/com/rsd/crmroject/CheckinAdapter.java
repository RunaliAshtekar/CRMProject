package com.rsd.crmroject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CheckinAdapter extends RecyclerView.Adapter<CheckinAdapter.ViewHolder> {


    private Context context;
    private ArrayList<Model> list;

/*
    public CheckinAdapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;

    }*/

    public CheckinAdapter(Context activity, ArrayList<Model> list, Class<CheckInActivity> checkInActivityClass) {
        this.context = activity;
        this.list = list;
       // this.checkInActivityClass = checkInActivityClass;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.checkin_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescriptiion());
        holder.location.setText(list.get(position).getLocation());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, description, location;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            location = itemView.findViewById(R.id.location);


        }
    }

    public void filterList(ArrayList<Model> filterllist) {
        list = filterllist;
        notifyDataSetChanged();
    }
}