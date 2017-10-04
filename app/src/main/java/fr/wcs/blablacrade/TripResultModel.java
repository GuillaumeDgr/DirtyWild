package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    // Attributs
    private String prenom;
    private int price;
    private Date depart;

    // Constructor
    public TripResultModel(String prénom, Date depare, int pri) {
        this.prenom = prénom;this.depart = depare;this.price = pri;
    }

    // Getters
    public Date getDeparture() {
        return depart;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getPrice() {return price;}
}
