package papitas.concept;

/**
 * Created by juanm on 13/06/2017.
 */

public class Commerce {

    private Long id;

    private Long nit;

    private String name;

    private String address;

    private String active;

    public Commerce() {

    }

    public Commerce(Long id, Long nit, String name, String address, String active) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
