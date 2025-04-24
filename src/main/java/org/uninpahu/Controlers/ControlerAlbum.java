
package org.uninpahu.Controlers;

import java.util.List;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Repository.AlbumDAO;
import org.uninpahu.Repository.RepositoryAlbum;
import org.uninpahu.Services.ServicesAlbum;

public class ControlerAlbum {
    private ServicesAlbum servicesAlbum;
    
    public ControlerAlbum(){
        RepositoryAlbum repositoryAlbum = new AlbumDAO();
        this.servicesAlbum = new ServicesAlbum(repositoryAlbum);
    }
    
    public Album searchAlbum(String idAlbum, String nameAlbum){
        return servicesAlbum.searchAlbum(idAlbum, nameAlbum);
    }
    
    public List<Album> listAlbums(){
        return servicesAlbum.listAlbums();
    }
    
    public void createAlbum(Album album){
        servicesAlbum.createAlbum(album);
    }
}
