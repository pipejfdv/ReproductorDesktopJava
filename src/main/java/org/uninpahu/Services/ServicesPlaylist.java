
package org.uninpahu.Services;

import org.uninpahu.Modelo.Playlist;
import org.uninpahu.Repository.RepositoryPlaylist;


public class ServicesPlaylist {
    private final RepositoryPlaylist repositoryPlaylist;
    
    public ServicesPlaylist(RepositoryPlaylist repositoryPlaylist1){
        this.repositoryPlaylist = repositoryPlaylist1;
    }
    
    public void insertPlaylist(Playlist playlist){
        repositoryPlaylist.createPlaylist(playlist);
    }
}
