package com.chalienko.stp.controller;

import com.chalienko.stp.entity.Expert;
import com.chalienko.stp.entity.Raiting;
import com.chalienko.stp.entity.Target;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class Controller {
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
    private List<Raiting> raitings = new ArrayList<>();


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
    public void addRaiting() {
        if (raitings.size() != 0) {
            for (Raiting raiting : raitings) {
                if (raiting.getExpert().equals(expertChoiceBox.getValue())) {
                    if (raiting.getTarget().equals(targetChoiceBox.getValue())) {
                        System.out.println("error");
                    } else {
                        raitings.add(new Raiting(Integer.parseInt(raitingField.getText()),
                                expertChoiceBox.getValue(), targetChoiceBox.getValue()));
                    }
                } else {
                    raitings.add(new Raiting(Integer.parseInt(raitingField.getText()),
                            expertChoiceBox.getValue(), targetChoiceBox.getValue()));
                }
            }
        } else {
            raitings.add(new Raiting(Integer.parseInt(raitingField.getText()),
                    expertChoiceBox.getValue(), targetChoiceBox.getValue()));
        }
    }
}
