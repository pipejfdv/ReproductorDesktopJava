
package org.uninpahu.Services;

import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Song;
import org.uninpahu.Repository.RepositorySong;


public class ServicesSong {
    private final RepositorySong repositorySong;
    
    public ServicesSong(RepositorySong repositorySong){
        this.repositorySong = repositorySong;
    }
    
    public Optional<List<Song>> listSong(){
        return repositorySong.listSongs();
    }
}
