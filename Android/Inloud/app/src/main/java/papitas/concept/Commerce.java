package papitas.concept;

import java.io.Serializable;

/**
 * Created by juanm on 13/06/2017.
 */

public class Commerce implements Serializable{

    /**
     * Attribute that models the commerce's id
     */
    private Long id;

    /**
     * Attribute that models the commerce's nit
     */
    private Long nit;

    /**
     * Attribute that contains the commerce's name
     */
    private String name;

    /**
     * Attribute that shows the commerce's main address
     */
    private String address;

    /**
     * Attribute that shows whether the commerce is active or not
     */
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
