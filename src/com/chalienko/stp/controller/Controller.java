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
    public void addTarget() {
        targets.add(new Target(targetField.getText()));
        targetChoiceBox.getItems().add(targets.get(targets.size() - 1));
        targetListView.getItems().add(targets.get(targets.size() - 1));
    }

    @FXML
    public void addExpert() {
        experts.add(new Expert(firstNameField.getText(), lastNameField.getText()));
        expertListView.getItems().add(experts.get(experts.size() - 1));
        expertChoiceBox.getItems().add(experts.get(experts.size() - 1));
    }

    @FXML
    public void addEvaluation() {
        evaluations.add(new Evaluation(Integer.parseInt(raitingField.getText()),
                expertChoiceBox.getValue(), targetChoiceBox.getValue()));
        System.out.println(evaluations.get(evaluations.size()-1));
    }

    @FXML
    public void calculateRating(){
        List<Rating> resultRatings = Evaluator.advantageMethod(evaluations, targets, experts.size());
        resultRatings.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
        int row = 0;
        for (Rating rating : resultRatings){
            gridPane.add(new Label(rating.getTarget() + " "),0,row);
            gridPane.add(new Label(rating.getRating().toString()),1,row);
            row++;
        }
    }
}
