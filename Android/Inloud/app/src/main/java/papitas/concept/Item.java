package papitas.concept;

/**
 * Created by juanm on 13/06/2017.
 */

public class Item {

    private Long id;

    private String name;

    private Long barcode;

    private Double cost;

    public Item() {
    }

    public Item(Long id, String name, Long barcode, Double cost) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
