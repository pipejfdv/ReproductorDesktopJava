
package org.uninpahu.Repository;

import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Song;


public interface RepositorySong {
    //list all Song
    Optional<List<Song>> listSongs();
    //read Song
    Song searchSong(String idSong, String nameSong);
}
