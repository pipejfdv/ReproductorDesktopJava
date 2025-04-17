package org.uninpahu.Modelo;

import java.time.Duration;
import java.time.LocalDate;

public class Song {
    private String idSong;
    private String nameSong;
    private LocalDate creationSong;
    private Duration duration;
    private Gender idGender;
    private Album idAlbum;
    private String pathFile;

    public Song(String idSong, String nameSong, LocalDate creationSong, Duration duration, Gender idGender, Album idAlbum, String pathFile) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.creationSong = creationSong;
        this.duration = duration;
        this.idGender = idGender;
        this.idAlbum = idAlbum;
        this.pathFile = pathFile;
    }

    public String getIdSong() {
        return idSong;
    }

    public void setIdSong(String idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public LocalDate getCreationSong() {
        return creationSong;
    }

    public void setCreationSong(LocalDate creationSong) {
        this.creationSong = creationSong;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Gender getIdGender() {
        return idGender;
    }

    public void setIdGender(Gender idGender) {
        this.idGender = idGender;
    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
