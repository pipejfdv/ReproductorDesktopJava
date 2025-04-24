
package org.uninpahu.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Modelo.Gender;
import org.uninpahu.Modelo.Song;


public interface RepositorySong {
    //list all Song
    Optional<List<Song>> listSongs();
    //read Song
    Song searchSong(String idSong, String nameSong);
    //create song
    void createSong(Song newSong);
}
