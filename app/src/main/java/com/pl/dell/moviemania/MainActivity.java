package com.pl.dell.moviemania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    GridView view;
    Adapter adapter;
    double voteaverage;
   ArrayList<ItemModel> arrayList=new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter= new Adapter(MainActivity.this,arrayList);
        view=(GridView)findViewById(R.id.gridview);
        view.setAdapter(adapter);
        FetchMethod();


       /* view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

              //  Toast.makeText(MainActivity.this,"You clicked at "+movieName[+position],Toast.LENGTH_LONG).show();
                FetchMethod();

            }
        });*/

    }


    public void FetchMethod()
    {
        Log.d("MainActivity","fetch method");
        String url="http://api.themoviedb.org/3/movie/popular?api_key=94084731ec97b254d7b15dcabaa5c5d9";
        Log.d("MainActivity","URL "+url);

        final StringRequest stringRequest=new StringRequest(Request.Method.GET,url,new Response.Listener<String>(){
            @Override
            public void onResponse(String response)
            {
                Log.d("MainActivity","Response "+response);

                   try {
                       JSONObject jsonObject=new JSONObject(response);

                       int page=jsonObject.getInt("page");

                       if(page==1){
                           Toast.makeText(MainActivity.this,"SUCCESS",Toast.LENGTH_SHORT).show();


                          // Log.d("Hi","Done1");

                           JSONArray movieArray=jsonObject.optJSONArray("results");

                        //   Log.d("Hi","Done2");

                           Log.d("MainActivity.this","Total movies: "+movieArray.length());
                           for(int i=0;i<movieArray.length();i++){

                               Log.d("Hi","Done3");
                                ItemModel item=new ItemModel();
                               JSONObject currentRow=movieArray.optJSONObject(i);
                               int id=currentRow.optInt("id");
                               item.setId(id);
                               String image=currentRow.optString("poster_path");
                               image = "http://image.tmdb.org/t/p/w500/"+image.substring(1);
                               item.setImage(image);
                               String title=currentRow.optString("original_title");
                               item.setTitle(title);
                               String releasedate=currentRow.optString("release_date");
                               item.setRelease_date(releasedate);
                               String overview=currentRow.optString("overview");
                               item.setOverview(overview);
                               voteaverage=currentRow.optDouble("vote_average");
                               item.setVote_average(voteaverage);
                                arrayList.add(item);
                               //float temp_votecount=Float.parseFloat(currentRow.getString("vote_average"));
                              // String temp_originaltitle=currentRow.getString("original_title");
                             //  String temp_releasedate=currentRow.getString("release_date");
                               //String temp_overview=currentRow.getString("overview");

                             //  Toast.makeText(MainActivity.this," "+title+" "+releasedate+" "+overview+" "+voteaverage+" ",Toast.LENGTH_SHORT).show();

                           }

                       }
                       adapter.setData(arrayList);

                       Log.d("Adapter"," " +voteaverage);
                     /*  else {
                           Toast.makeText(MainActivity.this,"FAIL",Toast.LENGTH_SHORT).show();

                       }*/


                   } catch (JSONException e) {
                       e.printStackTrace();
                   }

            }
        },
        new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
               Log.d("MainActivity.this","errrrorrr");
                Log.d("Adapter"," " +voteaverage);

            }
        })
        {
            @Override
            protected Map<String,String>getParams(){
                Map<String,String> params= new HashMap<String, String>();
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest,"req_fetch");
    }
}
