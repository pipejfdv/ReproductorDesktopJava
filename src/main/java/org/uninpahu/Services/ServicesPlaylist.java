
package org.uninpahu.Services;

import java.util.List;
import java.util.Optional;
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
    
    public Optional<List<Playlist>> listOfPlaylists(){
        return repositoryPlaylist.listOfPlaylist();
    }
    
    public Playlist searchPlaylists(String idPlaylist,String namePlaylist){
        return repositoryPlaylist.searchPlaylist(idPlaylist, namePlaylist);
    }
}
