package org.uninpahu.Modelo;

import java.time.LocalDateTime;

public class AlmbuLikes {
    private Album idAlbum;
    private User idUser;
    private LocalDateTime addAlbumDate;

    public AlmbuLikes(Album idAlbum, User idUser) {
        this.idAlbum = idAlbum;
        this.idUser = idUser;
        this.addAlbumDate = LocalDateTime.now();
    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getAddAlbumDate() {
        return addAlbumDate;
    }

    public void setAddAlbumDate(LocalDateTime addAlbumDate) {
        this.addAlbumDate = addAlbumDate;
    }
}
