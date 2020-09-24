package druckerverwaltung.model;

import java.time.LocalDate;

public abstract class Hardware {
    protected static int anzahl;
    protected final int id;
    protected String seriennummer;
    protected String modell;
    protected String hersteller;
    protected String status;
    protected int herstellergarantie;
    protected LocalDate lieferdatum;

    public Hardware() {
        anzahl++;
        id = anzahl;
        setStatus("ok");
    }

    public Hardware(String seriennummer,
                    String modell,
                    String hersteller,
                    String status,
                    int herstellergarantie,
                    LocalDate lieferdatum) {
        this();
        this.seriennummer = seriennummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellergarantie = herstellergarantie;
        this.lieferdatum = lieferdatum;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public static int getAnzahl() {
        return anzahl;
    }

    protected int getId() {
        return id;
    }

    protected String getSeriennummer() {
        return seriennummer;
    }

    protected String getModell() {
        return modell;
    }

    protected String getHersteller() {
        return hersteller;
    }

    protected String getStatus() {
        return status;
    }

    protected int getHerstellergarantie() {
        return herstellergarantie;
    }

    protected LocalDate getLieferdatum() {
        return lieferdatum;
    }

    protected LocalDate berechneGarantieende() {
        return getLieferdatum().plusMonths(getHerstellergarantie());
    }

    public String toString() {
        return ""
                + getId() + ";"
                + getSeriennummer() + ";"
                + getModell() + ";"
                + getHersteller() + ";"
                + getStatus() + ";"
                + getHerstellergarantie() + ";"
                + getLieferdatum() + ";"
                + toStringExtraParams();
    }

    protected abstract String toStringExtraParams();
}
