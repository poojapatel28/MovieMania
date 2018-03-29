package com.pl.dell.moviemania;

import android.widget.ImageView;

/**
 * Created by DELL on 22-06-2016.
 */
public class ItemModel {

   private String image;
    private String title;
    private int id;
    private String release_date;
  //  private String adult;
    private String overview;
   // private String backdrop;
    //private String original_language;
    //private int vote_count;
    //private double popularity;
    private double vote_average;
    //private String trailerKey;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }


    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }






    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }



    public ItemModel(String image, String title, int id, String release_date,
                     String overview,
                    double vote_average) {
        this.image = image;
        this.title = title;
        this.id = id;
        this.release_date = release_date;
      //  this.adult = adult;
        this.overview = overview;
      //  this.backdrop = backdrop;
        //this.original_language = original_language;
        //this.vote_count = vote_count;
        //this.popularity = popularity;
        this.vote_average = vote_average;
        //this.trailerKey = trailerKey;
    }
    public ItemModel(){

    }
}
