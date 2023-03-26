package com.example.springapp.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    int ratingId;
    int userId;
    int productId;
    String ratingDate;
    int score;

  


    public int getRatingId() {
        return ratingId;
    }




    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }




    public int getUserId() {
        return userId;
    }




    public void setUserId(int userId) {
        this.userId = userId;
    }




    public int getProductId() {
        return productId;
    }




    public void setProductId(int productId) {
        this.productId = productId;
    }




    public String getRatingDate() {
        return ratingDate;
    }




    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }




    public int getScore() {
        return score;
    }




    public void setScore(int score) {
        this.score = score;
    }




    public Rating(int ratingId, int userId, int productId, String ratingDate, int score) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.productId = productId;
        this.ratingDate = ratingDate;
        this.score = score;
    }




    public Rating() {
    }
   
    
}
