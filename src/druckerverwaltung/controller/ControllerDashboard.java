package druckerverwaltung.controller;


import druckerverwaltung.logic.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerDashboard {
    /**
     * Ruft die DruckerView auf
     * @param e das Button event
     */
    @FXML
    private void handleButtonDruckerverwaltung(ActionEvent e) {
        ViewManager.getInstance().activateScene(ViewManager.getInstance().getSceneDrucker());
        e.consume();
    }

    /**
     * Ruft die RechnerView auf
     * @param e das Button event
     */
    @FXML
    public void handleButtonRechnerverwaltung(ActionEvent e) {
        ViewManager.getInstance().activateScene(ViewManager.getInstance().getSceneRechner());
    }
}
