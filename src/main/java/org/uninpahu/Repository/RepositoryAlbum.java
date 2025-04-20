
package org.uninpahu.Repository;

import org.uninpahu.Modelo.Album;


public interface RepositoryAlbum {
    //read album by id and name
    Album typeAlbum(String idAlbum, String nameAlbum);
}
