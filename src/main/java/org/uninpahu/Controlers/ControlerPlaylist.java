package org.uninpahu.Controlers;

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
}
