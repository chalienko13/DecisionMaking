package com.chalienko.stp.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitriy_chalienko on 15.02.16.
 */
public class Target {
    private String targetName;

    public Target(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }


    @Override
    public String toString() {
        return  targetName;
    }
}
