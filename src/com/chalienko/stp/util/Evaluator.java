package com.chalienko.stp.util;

import com.chalienko.stp.entity.Evaluation;
import com.chalienko.stp.entity.Rating;
import com.chalienko.stp.entity.Target;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitriy_chalienko on 16.02.16.
 */
public class Evaluator {

    public static List<Rating> advantageMethod(List<Evaluation> evaluations, List<Target> targets, int expertAmount) {
        List<Rating> ratings = new ArrayList<>();
        Double resultRating = 0d;
        for(Target target: targets) {
            for (Evaluation evaluation : evaluations) {
                if (target.equals(evaluation.getTarget())){
                    resultRating += targets.size() - evaluation.getEvaluation();
                    System.out.println(resultRating + " " + target);
                }
            }
            resultRating /= sumNTerm(targets.size()-1) * expertAmount;
            ratings.add(new Rating(resultRating, target));
            resultRating = 0d;
        }
        return ratings;
    }

    private static int sumNTerm(int n){
        return n*(n+1)/2;
    }
}
