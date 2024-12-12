package e.sante;

import java.sql.Date;

public class DonneesPatient {
    private Date date;
    private double poids;
    private double temperature;
    private double tension;
    private double tauxGlycemie;

    public DonneesPatient(Date date, double poids, double temperature, double tension, double tauxGlycemie) {
        this.date = date;
        this.poids = poids;
        this.temperature = temperature;
        this.tension = tension;
        this.tauxGlycemie = tauxGlycemie;
    }

    public Date getDate() {
        return date;
    }

    public double getPoids() {
        return poids;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTension() {
        return tension;
    }

    public double getTauxGlycemie() {
        return tauxGlycemie;
    }
}
