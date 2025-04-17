package org.uninpahu.Modelo;

import java.time.LocalDateTime;

public class Comment {
    private String idComment;
    private String content;
    private User idUser;
    private Song idSong;
    private LocalDateTime creationDateComment;

    public Comment(String idComment, String content, User idUser, Song idSong) {
        this.idComment = idComment;
        this.content = content;
        this.idUser = idUser;
        this.idSong = idSong;
        this.creationDateComment = LocalDateTime.now();
    }

    public String getIdComment() {
        return idComment;
    }

    public void setIdComment(String idComment) {
        this.idComment = idComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Song getIdSong() {
        return idSong;
    }

    public void setIdSong(Song idSong) {
        this.idSong = idSong;
    }

    public LocalDateTime getCreationDateComment() {
        return creationDateComment;
    }

    public void setCreationDateComment(LocalDateTime creationDateComment) {
        this.creationDateComment = creationDateComment;
    }
}
