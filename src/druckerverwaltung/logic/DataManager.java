package druckerverwaltung.logic;

import druckerverwaltung.model.Drucker;
import druckerverwaltung.model.Hardware;
import druckerverwaltung.model.Rechner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataManager {
    private static DataManager dataManager = null;

    private final ObservableList<Drucker> druckerList;
    private final ObservableList<Rechner> rechnerList;

    private DataManager() {
        druckerList = FXCollections.observableArrayList();
        rechnerList = FXCollections.observableArrayList();
    }

    /**
     * Liefert die aktuelle Version des DataManagers
     * @return aktuelle Version des DataManagers
     */
    public static DataManager getInstance() {
        if(DataManager.dataManager == null) {
            DataManager.dataManager = new DataManager();
        }
        return DataManager.dataManager;
    }

    /**
     * Fügt das übergebene Hardware Objekt der Ensprechenden Liste hinzu.
     * @param hw das Hardware Objekt, welches der Liste hinzugefügt werden soll.
     */
    public void add(Hardware hw) {
        if(hw instanceof Drucker) {
            druckerList.add((Drucker)hw);
        } else if(hw instanceof Rechner){
            rechnerList.add((Rechner)hw);
        } else {
            throw new IllegalArgumentException("Keine kompatible Liste gefunden!");
        }
    }

    /**
     * Fügt alle übergebenden Hardware Objekte der Entsprechendem Liste hinzu.
     * @param hw die Hardware Objekte, welche den Listen hinzugefügt werden sollen.
     */
    public void addAll(Hardware... hw) {
        for (Hardware h : hw) {
            this.add(h);
        }
    }

    /**
     * Liefert die Liste mit allen hinzugefügten Druckern
     * @return Liste mit allen hinzugefügten Druckern
     */
    public ObservableList<Drucker> getDruckerList() {
        return druckerList;
    }

    /**
     * Liefert die Liste mit allen hinzugefügten Rechnern
     * @return Liste mit allen hinzugefügten Rechnern
     */
    public ObservableList<Rechner> getRechnerList() {
        return rechnerList;
    }
}
