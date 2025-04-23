package org.uninpahu.Controlers;

import java.util.List;
import java.util.Optional;
import jdk.jfr.internal.Repository;
import org.uninpahu.Modelo.Playlist;
import org.uninpahu.Repository.PlaylistDAO;
import org.uninpahu.Repository.RepositoryPlaylist;
import org.uninpahu.Services.ServicesPlaylist;


public class ControlerPlaylist {
    private ServicesPlaylist servicesPlaylist;
    
    public ControlerPlaylist(){
        RepositoryPlaylist repositoryPlaylist = new PlaylistDAO();
        this.servicesPlaylist = new ServicesPlaylist(repositoryPlaylist);
    }
    
    public void inserPlaylist(Playlist playlist){
        servicesPlaylist.insertPlaylist(playlist);
    }
    
    public Optional<List<Playlist>> listsOfPlaylist(){
        return servicesPlaylist.listOfPlaylists();
    }
    
    public Playlist searchPlaylist(String idPlaylist, String namePlaylist){
        return servicesPlaylist.searchPlaylists(idPlaylist, namePlaylist);
    }
}
