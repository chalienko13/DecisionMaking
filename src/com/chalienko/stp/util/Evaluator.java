package com.chalienko.stp.util;

import com.chalienko.stp.entity.Evaluation;
import com.chalienko.stp.entity.Expert;
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
        for (Target target : targets) {
            for (Evaluation evaluation : evaluations) {
                if (target.equals(evaluation.getTarget())) {
                    resultRating += targets.size() - evaluation.getEvaluation();
                }
            }
            resultRating /= sumNTerm(targets.size() - 1) * expertAmount;
            ratings.add(new Rating(resultRating, target));
            resultRating = 0d;
        }
        return ratings;
    }

    public static List<Rating> rankMethod(List<Evaluation> evaluations, List<Target> targets, List<Expert> experts) {
        List<Rating> ratings = new ArrayList<>();
        Map<Expert, Integer> expertSumEvalMap = new HashMap<>();
        int sumExpertEvaluation = 0;
        for (Expert expert : experts) {
            for (Evaluation evaluation : evaluations) {
                if (expert.equals(evaluation.getExpert())) {
                    sumExpertEvaluation += evaluation.getEvaluation();
                }
            }
            expertSumEvalMap.put(expert, sumExpertEvaluation);
            sumExpertEvaluation = 0;
        }

        for (Expert expert : experts) {
            for (Evaluation evaluation : evaluations) {
                if (expert.equals(evaluation.getExpert())) {
                    double res = evaluation.getEvaluation()/expertSumEvalMap.get(expert);
                    evaluation.setEvaluation(res);
                }
            }
        }

        double resRating = 0;
        for (Target target : targets) {
            for (Evaluation evaluation : evaluations) {
                if (target.equals(evaluation.getTarget())) {
                    resRating += evaluation.getEvaluation();
                }
            }
            ratings.add(new Rating(resRating / experts.size(), target));
            resRating = 0;
        }
        return ratings;
    }

    private static int sumNTerm(int n) {
        return n * (n + 1) / 2;
    }
}
