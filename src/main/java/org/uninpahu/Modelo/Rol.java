package org.uninpahu.Modelo;

public class Rol {
    private String idRol;
    private String nameRol;
    public Rol(String idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
}
