package com.pl.dell.moviemania;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by DELL on 22-06-2016.
 */



public class Adapter extends BaseAdapter{

private Context c;
   private ArrayList<ItemModel> arrayList=new ArrayList<>();
    LayoutInflater inflater;


    public Adapter(Context c, ArrayList<ItemModel> a) {
        this.c = c;
        this.arrayList=a;
         inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        View grid;

        if(view==null)
                    grid=new View(c);
            grid= inflater.inflate(R.layout.gridview_item,null);
            TextView tv=(TextView)grid.findViewById(R.id.tv);

            ImageView iv=(ImageView)grid.findViewById(R.id.iv);
            ItemModel item=arrayList.get(position);
            tv.setText(item.getTitle());
            Picasso.with(c).load(item.getImage()).into(iv);
           // System.out.println("asdf");

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemModel item=arrayList.get(position);
                Intent i= new Intent(c,NextScreen.class);
                i.putExtra("Image",item.getImage());
                i.putExtra("Title",item.getTitle());
                i.putExtra("Rating",item.getVote_average());
                i.putExtra("Overview",item.getOverview());

                Log.d("xz","Adapter:" +item.getVote_average());
                c.startActivity(i);
            }
        });





        return grid;
    }

    public void setData(ArrayList<ItemModel> arrayList)
    {
        this.arrayList=arrayList;
    }


}