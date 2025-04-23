
package org.uninpahu.Repository;

import java.util.List;
import java.util.Optional;
import org.uninpahu.Modelo.Playlist;


public interface RepositoryPlaylist {
    //create playlist
    void createPlaylist(Playlist playlist);
    //read all playlist
    Optional<List<Playlist>> listOfPlaylist();
    //search playlist by Id or name
    Playlist searchPlaylist(String idPlaylist, String namePlaylist);
}
