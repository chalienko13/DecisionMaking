package com.chalienko.stp.entity;

/**
 * Created by dmitriy_chalienko on 15.02.16.
 */
public class Evaluation {
    private Expert expert;
    private Target target;
    private int evaluation;

    public Evaluation(int evaluation, Expert expert, Target target) {
        this.evaluation = evaluation;
        this.expert = expert;
        this.target = target;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
    @Override
    public String toString() {
        return  "expert:" + expert +
                ", target:" + target +
                ", evaluation:" + evaluation;
    }
}
