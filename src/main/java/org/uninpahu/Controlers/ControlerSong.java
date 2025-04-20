
package org.uninpahu.Controlers;

import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Song;
import org.uninpahu.Repository.RepositorySong;
import org.uninpahu.Repository.SongDAO;
import org.uninpahu.Services.ServicesSong;


public class ControlerSong {
    private ServicesSong servicesSong;
    
    public ControlerSong(){
        RepositorySong repositorySong = new SongDAO();
        this.servicesSong = new ServicesSong(repositorySong);
    }
    
    public Optional<List<Song>> listSong(){
        return servicesSong.listSong();
    }
    
    public Song searchSong(String idSong, String nameSong){
        return servicesSong.searchSong(idSong, nameSong);
    }
}
