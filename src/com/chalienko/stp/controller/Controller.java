package com.chalienko.stp.controller;

import com.chalienko.stp.entity.Evaluation;
import com.chalienko.stp.entity.Expert;
import com.chalienko.stp.entity.Rating;
import com.chalienko.stp.entity.Target;
import com.chalienko.stp.util.Evaluator;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.*;


public class Controller {
    @FXML
    public GridPane gridPane;
    @FXML
    public ChoiceBox<Target> targetChoiceBox;
    @FXML
    public ChoiceBox<Expert> expertChoiceBox;
    @FXML
    public TextField targetField;
    @FXML
    public TextField raitingField;
    @FXML
    public ListView<Target> targetListView;
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public ListView<Expert> expertListView;

    private List<Expert> experts = new ArrayList<>();
    private List<Target> targets = new ArrayList<>();
    private List<Evaluation> evaluations = new ArrayList<>();

    @FXML
    public void initialize(){
        for(int i = 1; i <= 6; i++ ){
            addTargetToList(new Target("Target " + i));
        }
        for(int i = 1 ; i <= 3; i++){
            addExpertToList(new Expert("Expert ", "" + i));
        }
        for (Expert expert : experts){
            for (Target target : targets){
                addEvaluationToList(new Evaluation((int) (Math.random()*10 + 1),expert,target));
            }
        }
    }

    private void addTargetToList(Target target){
        targets.add(target);
        targetChoiceBox.getItems().add(targets.get(targets.size() - 1));
        targetListView.getItems().add(targets.get(targets.size() - 1));
    }
    @FXML
    public void addTarget() {
        addTargetToList(new Target(targetField.getText()));
    }
    private void addExpertToList(Expert expert){
        experts.add(expert);
        expertListView.getItems().add(experts.get(experts.size() - 1));
        expertChoiceBox.getItems().add(experts.get(experts.size() - 1));

    }

    @FXML
    public void addExpert() {
        addExpertToList(new Expert(firstNameField.getText(),lastNameField.getText()));
    }

    @FXML
    public void addEvaluation() {
        addEvaluationToList(new Evaluation(Integer.parseInt(raitingField.getText()),
                expertChoiceBox.getValue(), targetChoiceBox.getValue()));
        System.out.println(evaluations.get(evaluations.size()-1));
    }
    private void addEvaluationToList(Evaluation evaluation){
        evaluations.add(evaluation);
        System.out.println(evaluations.get(evaluations.size()-1));
    }

    private void inputToWindow(List<Rating> resultRatings) {
        int row = 0;
        gridPane.getChildren().clear();
        resultRatings.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
        for (Rating rating : resultRatings){
            gridPane.add(new Label(rating.getTarget() + " "),0,row);
            gridPane.add(new Label(rating.getRating().toString()),1,row);
            row++;
        }
    }

    @FXML
    public void calculateRatingRank(){
        List<Rating> resultRatings = Evaluator.rankMethod(evaluations, targets, experts);
        inputToWindow(resultRatings);
    }

    @FXML
    public void calculateRating(){
        List<Rating> resultRatings = Evaluator.advantageMethod(evaluations, targets, experts.size());
        inputToWindow(resultRatings);
    }
}
