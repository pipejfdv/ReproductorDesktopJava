package org.uninpahu.Services;

import org.uninpahu.Repository.RepositoryPlaylistSongs;


public class ServicesPlaylistSongs {
    private final RepositoryPlaylistSongs repositoryPlaylistSongs;
    
    public ServicesPlaylistSongs(RepositoryPlaylistSongs playlistSongs){
        this.repositoryPlaylistSongs = playlistSongs;
    }
    
    public void addSongToPlaylist(String idPlaylist, String idSong){
        repositoryPlaylistSongs.addSongToPlaylist(idPlaylist, idSong);
    }
}
