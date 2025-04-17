package org.uninpahu.Modelo;

import java.time.LocalDate;

public class SongArtists {
    private Song idSong;
    private User idUser;
    private LocalDate creation;

    public SongArtists(Song idSong, User idUser) {
        this.idSong = idSong;
        this.idUser = idUser;
        this.creation = LocalDate.now();
    }

    public Song getIdSong() {
        return idSong;
    }

    public void setIdSong(Song idSong) {
        this.idSong = idSong;
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
