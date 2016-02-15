package com.chalienko.stp.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by dmitriy_chalienko on 15.02.16.
 */
public class Expert {
    private String firstName;

    private String lastName;

    public Expert(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName  + "  " + lastName;
    }
}
