package druckerverwaltung.controller;

import druckerverwaltung.logic.DataManager;
import druckerverwaltung.model.Hardware;
import druckerverwaltung.model.Rechner;
import druckerverwaltung.model.RechnerBuilder;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerRechner extends ControllerHardware{
    @FXML
    private TextField textfieldCPU;
    @FXML
    private TextField textfieldArbeitsspeicher;
    @FXML
    private TextField textfieldBetriebssystem;
    @FXML
    private ChoiceBox<String> choiceboxTyp;
    @FXML
    private TextField textfieldGrafikkarte;
    @FXML
    private TextField textfieldSSD;
    @FXML
    private TextField textfieldHDD;

    @FXML
    private ListView<Rechner> listview;



    @Override
    protected Hardware generateHardware() {
        return new RechnerBuilder()
                .setSeriennummer(textfieldSeriennummer.getText())
                .setModell(textfieldModell.getText())
                .setHersteller(textfieldHersteller.getText())
                .setStatus(choiceboxStatus.getValue())
                .setHerstellergarantie(textfieldHerstellergarantie.getText())
                .setLieferdatum(datepickerLieferdatum.getValue())
                .setCpu(textfieldCPU.getText())
                .setArbeitsspeicher(textfieldArbeitsspeicher.getText())
                .setBetriebssystem(textfieldBetriebssystem.getText())
                .setTyp(choiceboxTyp.getValue())
                .setGrafikkarte(textfieldGrafikkarte.getText())
                .setFestplatteSSD(textfieldSSD.getText())
                .setFestplatteHDD(textfieldHDD.getText())
                .createRechner();
    }

    @Override
    protected void clearFields() {
        textfieldCPU.clear();
        textfieldArbeitsspeicher.clear();
        textfieldBetriebssystem.clear();
        choiceboxTyp.setValue(null);
        textfieldGrafikkarte.clear();
        textfieldSSD.clear();
        textfieldHDD.clear();
    }

    @Override
    protected void loadHardware() {

    }

    @Override
    protected void setup() {
        listview.setItems(DataManager.getInstance().getRechnerList());

        choiceboxTyp.setItems(FXCollections.observableArrayList(
                "Gamning-PC",
                "Multimedia-PC",
                "Office-PC"
        ));
    }
}
