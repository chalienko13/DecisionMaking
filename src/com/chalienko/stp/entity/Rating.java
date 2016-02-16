package com.chalienko.stp.entity;

import com.chalienko.stp.Main;

/**
 * Created by dmitriy_chalienko on 16.02.16.
 */
public class Rating implements Comparable{
    private Double rating;
    private Target target;

    public Rating(Double rating, Target target) {
        this.rating = rating;
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Double getRating() {
        return (double) Math.round(rating);
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", target=" + target +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Rating compRating = (Rating) o;
        return rating.compareTo(compRating.getRating());
    }
}
