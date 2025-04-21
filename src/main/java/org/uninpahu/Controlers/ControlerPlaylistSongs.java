
package org.uninpahu.Controlers;

import org.uninpahu.Repository.PlaylistSongsDAO;
import org.uninpahu.Repository.RepositoryPlaylistSongs;
import org.uninpahu.Services.ServicesPlaylistSongs;


public class ControlerPlaylistSongs {
    private ServicesPlaylistSongs servicesPlaylistSongs;
    
    public ControlerPlaylistSongs(){
        RepositoryPlaylistSongs repositoryPlaylistSongs = new PlaylistSongsDAO();
        this.servicesPlaylistSongs = new ServicesPlaylistSongs(repositoryPlaylistSongs);
    }
    
    public void insertSongToPlaylist(String idPlaylist, String idSong){
        servicesPlaylistSongs.addSongToPlaylist(idPlaylist, idSong);
    }
}
