package org.uninpahu.Modelo;

public class User {
    private String idUser;
    private String nickname;
    private String password;
    private Rol rol;
    private Person idPerson;
    
    //general contructor
    public User(String idUser, String nickname, String password, Rol rol, Person idPerson) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.password = password;
        this.rol = rol;
        this.idPerson = idPerson;
    }
    //constructor without password
    public User(String idUser, String nickname, Rol rol, Person idPerson) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.rol = rol;
        this.idPerson = idPerson;
    }
    
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }
}
