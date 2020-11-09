import model.Model;

import javax.swing.*;
import java.util.Date;



public class Students extends Model {

    private String name;
    private String lastName;
    private String surName;
    private Date birthDate;
    private String group;

    public Students (String name, String lastName, String surName, Date birthDate, String group, String id) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Students(String s, String s1) {

    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName () {
        this.lastName = lastName;
    }

    public String getSurName () {
        return surName;
    }

    public void setSurName () {
        this.surName = surName;
    }

    public Date getBirthDate () {
        return birthDate;
    }

    public void setBirthDate () {
        this.birthDate = birthDate;
    }

    public String getGroup () {
        return group;
    }

    public void setGroup () {
        this.group = group;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    @Override
    public String toString () {
        return name + "\t" + lastName + "\t"
                + surName + "\t" + birthDate + "\t"
                + group + "\t" + id + "\t";
    }

}

