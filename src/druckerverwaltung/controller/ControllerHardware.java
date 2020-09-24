package druckerverwaltung.controller;

import druckerverwaltung.logic.DataManager;
import druckerverwaltung.logic.ViewManager;
import druckerverwaltung.model.Drucker;
import druckerverwaltung.model.Hardware;
import druckerverwaltung.util.AlertWindow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ControllerHardware implements Initializable {
    @FXML
    protected TextField textfieldId;
    @FXML
    protected TextField textfieldSeriennummer;
    @FXML
    protected TextField textfieldModell;
    @FXML
    protected TextField textfieldHersteller;
    @FXML
    protected ChoiceBox<String> choiceboxStatus;
    @FXML
    protected TextField textfieldHerstellergarantie;
    @FXML
    protected DatePicker datepickerLieferdatum;

    /**
     * Generiert das Hardware Objekt und sichert es im DataManager
     * @param e das Button event
     */
    @FXML
    protected void handleButtonSichern(ActionEvent e) {
        try {
            DataManager.getInstance().add(this.generateHardware());
            clear();
        } catch (IllegalArgumentException err) {
            AlertWindow.createErrorWindow(err.getMessage());
        }
        e.consume();
    }

    /**
     * Leert alle Felder.
     * @param e das Button event
     */
    @FXML
    protected void handleButtonAbbrechen(ActionEvent e) {
        clear();
        e.consume();
    }

    /**
     * Leert alle Felder und wechselt die View zum Dashboard.
     * @param e das Button event
     */
    @FXML
    protected void handleButtonDashboard(ActionEvent e) {
        clear();
        ViewManager.getInstance().activateScene(ViewManager.getInstance().getSceneDashboard());
        e.consume();
    }

    /**
     * Leert alle Felder
     */
    private void clear() {
        textfieldSeriennummer.clear();
        textfieldModell.clear();
        textfieldHersteller.clear();
        choiceboxStatus.setValue(null);
        textfieldHerstellergarantie.clear();
        datepickerLieferdatum.setValue(null);
        clearFields();

        updateId();
    }

    /**
     * Aktualisiert das Textfeld ID mit der neuen zu vergebenden ID.
     */
    public void updateId() {
        textfieldId.setText(String.valueOf(Drucker.getAnzahl() + 1));
    }

    /**
     * ügt vordefinierte Objekte vom Typ Hardware dem Drucker hinzu und bereitet den Controller vor
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadHardware();
        setup();
        updateId();
        choiceboxStatus.setItems(FXCollections.observableArrayList(
                "ok",
                "in Reperatur",
                "defekt"));
    }

    /**
     * Leert alle weiteren Felder
     */
    protected abstract void clearFields();

    /**
     * Generiert ein Objekt vom Typ Hardware
     * @return
     */
    protected abstract Hardware generateHardware();

    /**
     * Bereitet den Controller vor
     */
    protected abstract void setup();

    /**
     * Fügt vordefinierte Objekte vom Typ Hardware dem Drucker hinzu
     */
    protected abstract void loadHardware();

}
