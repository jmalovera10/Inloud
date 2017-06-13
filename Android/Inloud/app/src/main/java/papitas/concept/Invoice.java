package papitas.concept;

import java.sql.Timestamp;

/**
 * Created by juanm on 13/06/2017.
 */

public class Invoice {

    private Long id;

    private Long serialID;

    private Timestamp date;

    private Double totalCost;

    private Double tax;

    public Invoice() {
    }

    public Invoice(Long id, Long serialID, Timestamp date, Double totalCost, Double tax) {
        this.id = id;
        this.serialID = serialID;
        this.date = date;
        this.totalCost = totalCost;
        this.tax = tax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerialID() {
        return serialID;
    }

    public void setSerialID(Long serialID) {
        this.serialID = serialID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}
