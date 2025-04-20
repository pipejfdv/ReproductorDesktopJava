
package org.uninpahu.Repository;

import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Song;


public interface RepositorySong {
    //read all Song
    Optional<List<Song>> listSongs();
            
}
