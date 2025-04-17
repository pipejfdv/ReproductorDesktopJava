package org.uninpahu.Modelo;

public class Person {
    private String idPerson;
    private String names;
    private String lastnames;
    private String email;
    
    //person generic
    public Person(String idPerson, String names, String lastnames, String email) {
        this.idPerson = idPerson;
        this.names = names;
        this.lastnames = lastnames;
        this.email = email;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
