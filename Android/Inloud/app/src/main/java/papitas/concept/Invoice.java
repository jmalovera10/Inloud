package papitas.concept;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by juanm on 13/06/2017.
 */

public class Invoice implements Serializable{

    /**
     * Attribute that models the invoice's id
     */
    private Long id;

    /**
     * Attribute that models the invoice's serial id given by the commerce
     */
    private Long serialID;

    /**
     * Attribute that models the date in which the invoice was emitted
     */
    private Timestamp date;

    /**
     * Attribute that contains the purchase's total cost
     */
    private Double totalCost;

    /**
     * Attribute that shows the purchase's tax
     */
    private Double tax;

    /**
     * Attribute that models the items included on the invoice
     */
    private List<Item> items;

    /**
     * Attribute that shows the commerce from which the invoice comes
     */
    private Commerce commerce;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }
}
