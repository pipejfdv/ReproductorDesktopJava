
package org.uninpahu.Repository;

import java.util.List;
import org.uninpahu.Modelo.Album;


public interface RepositoryAlbum {
    //read album by id and name
    Album typeAlbum(String idAlbum, String nameAlbum);
    //list of albums
    List<Album> albumsList();
    //create album
    void createAlbum(Album album);
}
