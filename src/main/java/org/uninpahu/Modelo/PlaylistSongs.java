package org.uninpahu.Modelo;

import java.time.LocalDate;

public class PlaylistSongs {
    private String idPlaylist;
    private Song idSong;
    private int positionSong;
    private LocalDate addSongDate;

    public PlaylistSongs(String idPlaylist, Song idSong, int positionSong) {
        this.idPlaylist = idPlaylist;
        this.idSong = idSong;
        this.positionSong = positionSong;
        this.addSongDate = LocalDate.now();
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Song getIdSong() {
        return idSong;
    }

    public void setIdSong(Song idSong) {
        this.idSong = idSong;
    }

    public int getPositionSong() {
        return positionSong;
    }

    public void setPositionSong(int positionSong) {
        this.positionSong = positionSong;
    }

    public LocalDate getAddSongDate() {
        return addSongDate;
    }

    public void setAddSongDate(LocalDate addSongDate) {
        this.addSongDate = addSongDate;
    }
}
