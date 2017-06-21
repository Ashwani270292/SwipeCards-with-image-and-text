package com.edcams.swipecardlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edcams.swipecardlibrary.R;
import com.edcams.swipecardlibrary.model.Cars;

import java.util.List;

/**
 * Created by hp on 6/21/2017.
 */

public class SwipeCardAdapter extends BaseAdapter {

    private List<Cars> carsList;
    private Context context;

    public SwipeCardAdapter(List<Cars> carsList, Context context){
        this.context = context;
        this.carsList = carsList;
    }


    @Override
    public int getCount() {
        return carsList.size();
    }

    @Override
    public Object getItem(int position) {
        return carsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.carImageView = (ImageView)view.findViewById(R.id.carImageView);
            viewHolder.carname = (TextView)view.findViewById(R.id.carName);
            viewHolder.carDesc = (TextView)view.findViewById(R.id.carDesc);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Cars cars = carsList.get(position);

        viewHolder.carname.setText(cars.getName());
        viewHolder.carDesc.setText(cars.getDescription());

        //using glide to load image from url
        Glide.with(context).load(cars.getImageUrl()).into(viewHolder.carImageView);

        return view;
    }

    public class ViewHolder{
        public ImageView carImageView;
        public TextView carname;
        public TextView carDesc;
    }
}
