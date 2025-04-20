package org.uninpahu.Modelo;

public class Gender {
    private String idGender;
    private String nameGender;

    public Gender(String idGender, String nameGender) {
        this.idGender = idGender;
        this.nameGender = nameGender;
    }

    public String getIdGender() {
        return idGender;
    }

    public void setIdGender(String idGender) {
        this.idGender = idGender;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
