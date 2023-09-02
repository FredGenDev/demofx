package com.example.demofx;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import org.controlsfx.control.ToggleSwitch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Participant> tvParticipants;

    @FXML
    private TableColumn<Participant, UUID> colUuid;

    @FXML
    private TableColumn<Participant, String> colName;

    @FXML
    private TableColumn<Participant, Boolean> colPresent;

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

        colPresent.setCellFactory(col -> {
            TableCell<Participant, Boolean> cell = new TableCell<>();
            cell.itemProperty().addListener((obs, old, newVal) -> {
                if (newVal != null) {
                    Node centreBox = createPriorityGraphic(newVal);
                    cell.graphicProperty().bind(Bindings.when(cell.emptyProperty()).then((Node) null).otherwise(centreBox));
                }
            });
            return cell;
        });
    }

    private void showTextIfTrue(){
        this.currentState =!this.currentState;
        if(this.currentState) {
            welcomeText.setText("Welcome to JavaFX Application!");
        } else {
            welcomeText.setText("");
        }
    }

    private Node createPriorityGraphic(Boolean toggleSwitchState){
        HBox graphicContainer = new HBox();
        ToggleSwitch toggleSwitch = new ToggleSwitch();
        graphicContainer.getChildren().add(toggleSwitch);
        return graphicContainer;
    }
}