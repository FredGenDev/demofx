package com.example.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Participant> tvParticipants;

    @FXML
    protected void onHelloButtonClick() {
        this.showTextIfTrue();
    }

    private List<Participant> participants = new ArrayList<>();

    private Boolean currentState = false;

    @FXML
    public void initialize() {
        Participant p1 = new Participant(UUID.randomUUID(),"Riri", true);
        Participant p2= new Participant(UUID.randomUUID(),"Fifi", true);
        Participant p3 = new Participant(UUID.randomUUID(),"Loulou", true);
        participants.add(p1);
        participants.add(p2);
        participants.add(p3);

        tvParticipants.getItems().setAll(participants);
    }

    private void showTextIfTrue(){
        this.currentState =!this.currentState;
        if(this.currentState) {
            welcomeText.setText("Welcome to JavaFX Application!");
        } else {
            welcomeText.setText("");
        }
    }
}