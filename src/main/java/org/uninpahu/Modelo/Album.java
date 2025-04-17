package org.uninpahu.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Album {
    private String idAlbum;
    private String nameAlbum;
    private LocalDate createAlbum;
    private Gender idGender;

    /*
    * Constructor para el objeto tipo Álbum musica
    * @param idAlbum identificador único del album (no nulo)
    * @param nameAlbum nombre del album creado (no nulo)
    * @param createAlbum campo con formato "dd/mm/yyyy" (no nulo)
    * @param gender hace referencia al objeto "Gender" (no nulo)
    * */
    public Album(String idAlbum, String nameAlbum, String creationAlbum, Gender idGender) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        this.createAlbum = LocalDate.parse(creationAlbum, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.idGender = idGender;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public Gender getIdGender() {
        return idGender;
    }

    public void setIdGender(Gender idGender) {
        this.idGender = idGender;
    }

    public LocalDate getCreateAlbum() {
        return createAlbum;
    }

    public void setCreateAlbum(LocalDate createAlbum) {
        this.createAlbum = createAlbum;
    }
}
