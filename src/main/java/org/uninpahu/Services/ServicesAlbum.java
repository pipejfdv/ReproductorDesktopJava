
package org.uninpahu.Services;

import java.util.List;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Repository.RepositoryAlbum;

public class ServicesAlbum {
    private final RepositoryAlbum repositoryAlbum;
    
    public ServicesAlbum(RepositoryAlbum repositoryAlbum){
        this.repositoryAlbum = repositoryAlbum;
    }
    
    public Album searchAlbum(String idAlbum, String nameAlbum){
        return repositoryAlbum.typeAlbum(idAlbum, nameAlbum);
    }
    
    public List<Album> listAlbums(){
        return repositoryAlbum.albumsList();
    };
}
