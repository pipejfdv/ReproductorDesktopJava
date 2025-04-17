package org.uninpahu.Modelo;

import java.time.LocalDateTime;

public class SongLikes {
    private Song idSong;
    private User idUser;
    private LocalDateTime addSongDate;

    public SongLikes(Song idSong, User idUser) {
        this.idSong = idSong;
        this.idUser = idUser;
        this.addSongDate = LocalDateTime.now();
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

    public LocalDateTime getAddSongDate() {
        return addSongDate;
    }

    public void setAddSongDate(LocalDateTime addSongDate) {
        this.addSongDate = addSongDate;
    }
}
