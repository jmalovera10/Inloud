package papitas.concept;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by juanm on 13/06/2017.
 */

public class Client implements Serializable{

    /**
     * Attribute that models the client's id
     */
    private Long id;

    /**
     * Attribute that models the client's login
     */
    private String login;

    /**
     * Attribute that models the client's name
     */
    private String name;

    /**
     * Attribute that contains the client's email
     */
    private String email;

    /**
     * Attribute that states the client's personal id number
     */
    private String idNumber;

    /**
     * Attribute that contains the id type
     */
    private String idType;

    /**
     * Attribute that models the client's birth date
     */
    private Date birthDate;

    public Client(){

    }

    public Client(Long id, String login, String name, String email, String idNumber,
                  String idType, Date birthDate) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
        this.idNumber = idNumber;
        this.idType = idType;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
