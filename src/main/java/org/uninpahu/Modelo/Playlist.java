package org.uninpahu.Modelo;

import java.time.LocalDate;

public class Playlist {
    private String idPlaylist;
    private String namePlaylist;
    private User idUser;
    private LocalDate creation;

    public Playlist(String idPlaylist, String namePlaylist, User idUser) {
        this.idPlaylist = idPlaylist;
        this.namePlaylist = namePlaylist;
        this.idUser = idUser;
        this.creation = LocalDate.now();
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }
}
