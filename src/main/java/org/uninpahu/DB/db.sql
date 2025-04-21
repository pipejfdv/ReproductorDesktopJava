-- Eliminar la base de datos existente si existe
DROP DATABASE IF EXISTS SpotifyDB;
CREATE DATABASE SpotifyDB;
USE SpotifyDB;

-- Tabla de Roles
CREATE TABLE Roles (
                       idRol VARCHAR(37) PRIMARY KEY,
                       nameRol VARCHAR(50) NOT NULL
);

-- Tabla de Personas
CREATE TABLE Persons (
                         idPerson VARCHAR(37) PRIMARY KEY,
                         names VARCHAR(50) NOT NULL,
                         lastnames VARCHAR(50),
                         email VARCHAR(100) UNIQUE NOT NULL
);

-- Tabla de Usuarios
CREATE TABLE Users (
                       idUser VARCHAR(37) PRIMARY KEY,
                       nickname VARCHAR(30) UNIQUE NOT NULL,
                       passwordUser VARCHAR(255) NOT NULL,
                       idRolUser VARCHAR(37),
                       idPersonUser VARCHAR(37),
                       registrationDate DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                       FOREIGN KEY (idRolUser) REFERENCES Roles(idRol) ON DELETE SET NULL,
                       FOREIGN KEY (idPersonUser) REFERENCES Persons(idPerson) ON DELETE SET NULL
);

-- Tabla de Géneros Musicales
CREATE TABLE Genders (
                         idGender VARCHAR(37) PRIMARY KEY,
                         nameGender VARCHAR(50) NOT NULL
);

-- Tabla de Álbumes (fecha MANUAL)
CREATE TABLE Albums (
                        idAlbum VARCHAR(37) PRIMARY KEY,
                        nameAlbum VARCHAR(100) NOT NULL,
                        creationAlbum DATE NOT NULL, -- El usuario debe proporcionar la fecha
                        idGenderAlbum VARCHAR(37),
                        FOREIGN KEY (idGenderAlbum) REFERENCES Genders(idGender) ON DELETE SET NULL
);

-- Tabla de Canciones (fecha MANUAL)
CREATE TABLE Songs (
                       idSong VARCHAR(37) PRIMARY KEY,
                       nameSong VARCHAR(100) NOT NULL,
                       creationSong DATE NOT NULL, -- El usuario debe proporcionar la fecha
                       durationSong TIME,
                       idGender VARCHAR(37),
                       idAlbum VARCHAR(37) NULL,
                       pathFile VARCHAR(255) NULL,
                       FOREIGN KEY (idGender) REFERENCES Genders(idGender) ON DELETE SET NULL,
                       FOREIGN KEY (idAlbum) REFERENCES Albums(idAlbum) ON DELETE CASCADE
);

-- Tabla de Artistas de Canciones (Muchos a Muchos)
CREATE TABLE SongArtists (
                             idSong VARCHAR(37),
                             idUser VARCHAR(37),
                             assignmentDate DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                             PRIMARY KEY (idSong, idUser),
                             FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE,
                             FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- Tabla de Playlists, se une con la tabla PlaylistSongs para tener una tabla independiente
CREATE TABLE Playlists (
                           idPlaylist VARCHAR(37) PRIMARY KEY,
                           namePlaylist VARCHAR(100) NOT NULL,
                           idUserPlaylist VARCHAR(37),
                           creationDate DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                           FOREIGN KEY (idUserPlaylist) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- Tabla de Canciones en Playlists (fecha automática)
CREATE TABLE PlaylistSongs (
                               idPlaylist VARCHAR(37),
                               idSong VARCHAR(37),
                               position INT, -- Poisición de la canción en la playlist
                               addedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (idPlaylist, idSong),
                               FOREIGN KEY (idPlaylist) REFERENCES Playlists(idPlaylist) ON DELETE CASCADE,
                               FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE
);

-- Tabla de Comentarios (fecha automática)
CREATE TABLE Comments (
                          idComment VARCHAR(37) PRIMARY KEY,
                          contentComment VARCHAR(500) NOT NULL,
                          idUserComment VARCHAR(37),
                          idSong VARCHAR(37),
                          commentDate DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                          FOREIGN KEY (idUserComment) REFERENCES Users(idUser) ON DELETE CASCADE,
                          FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE
);

-- Tabla de Likes en Álbumes (fecha automática)
CREATE TABLE AlbumLikes (
                            idAlbum VARCHAR(37),
                            idUser VARCHAR(37),
                            fechaLike DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                            PRIMARY KEY (idAlbum, idUser),
                            FOREIGN KEY (idAlbum) REFERENCES Albums(idAlbum) ON DELETE CASCADE,
                            FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- Tabla de Likes en Canciones (fecha automática)
CREATE TABLE SongLikes (
                           idSong VARCHAR(37),
                           idUser VARCHAR(37),
                           fechaLike DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha automática
                           PRIMARY KEY (idSong, idUser),
                           FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE,
                           FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- Inserción de géneros musicales (corregido para usar UUIDs consistentes)
INSERT INTO Genders (idGender, nameGender) VALUES
                                               ('550e8400-e29b-41d4-a716-446655440000', 'Pop'),
                                               ('550e8400-e29b-41d4-a716-446655440001', 'Rock'),
                                               ('550e8400-e29b-41d4-a716-446655440002', 'Hip Hop'),
                                               ('550e8400-e29b-41d4-a716-446655440003', 'Electrónica'),
                                               ('550e8400-e29b-41d4-a716-446655440004', 'Reggaetón'),
                                               ('550e8400-e29b-41d4-a716-446655440005', 'Jazz'),
                                               ('550e8400-e29b-41d4-a716-446655440006', 'Clásica'),
                                               ('550e8400-e29b-41d4-a716-446655440007', 'Metal'),
                                               ('550e8400-e29b-41d4-a716-446655440008', 'Blues'),
                                               ('550e8400-e29b-41d4-a716-446655440009', 'Salsa'),
                                               ('550e8400-e29b-41d4-a716-446655440010', 'Indie Rock'),
                                               ('550e8400-e29b-41d4-a716-446655440011', 'Trap'),
                                               ('550e8400-e29b-41d4-a716-446655440012', 'House'),
                                               ('550e8400-e29b-41d4-a716-446655440013', 'K-Pop');

-- Roles
INSERT INTO Roles (idRol, nameRol) VALUES
                                       ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Admin'),
                                       ('b1ffc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Usuario'),
                                       ('c2ddbc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Artista');
-- Person
INSERT INTO Persons (idPerson, names, lastnames, email) VALUES
                                                            ('6a3eebc9-9c0b-4ef8-bb6d-6bb9bd380a17', 'Dolores', 'O''Riordan', 'dolores@cranberries.com'),
                                                            ('7b4ffc99-9c0b-4ef8-bb6d-6bb9bd380a18', 'Lou', 'Reed', 'lou@velvetunderground.com'),
                                                            ('8c5ddbc9-9c0b-4ef8-bb6d-6bb9bd380a19', 'Iñaki', 'Antón', 'inaki@launion.com');
-- Usuarios
INSERT INTO Users (idUser, nickname, passwordUser, idRolUser, idPersonUser) VALUES
                                                                                ('9d6eebc9-9c0b-4ef8-bb6d-6bb9bd380a20', 'dolores_cran', 'hashed_pass', 'c2ddbc99-9c0b-4ef8-bb6d-6bb9bd380a13', '6a3eebc9-9c0b-4ef8-bb6d-6bb9bd380a17'),
                                                                                ('0e7ffc99-9c0b-4ef8-bb6d-6bb9bd380a21', 'lou_reed', 'hashed_pass', 'c2ddbc99-9c0b-4ef8-bb6d-6bb9bd380a13', '7b4ffc99-9c0b-4ef8-bb6d-6bb9bd380a18'),
                                                                                ('1f8ddbc9-9c0b-4ef8-bb6d-6bb9bd380a22', 'inaki_anton', 'hashed_pass', 'c2ddbc99-9c0b-4ef8-bb6d-6bb9bd380a13', '8c5ddbc9-9c0b-4ef8-bb6d-6bb9bd380a19');
-- Albumes
INSERT INTO Albums (idAlbum, nameAlbum, creationAlbum, idGenderAlbum) VALUES
                                                                          ('2a9eebc9-9c0b-4ef8-bb6d-6bb9bd380a23', 'No Need to Argue', '1994-10-03', '550e8400-e29b-41d4-a716-446655440001'),
                                                                          ('3b0ffc99-9c0b-4ef8-bb6d-6bb9bd380a24', 'Mil Siluetas', '1984-06-01', '550e8400-e29b-41d4-a716-446655440010'),
                                                                          ('4c0ffc99-9c0b-4ef8-bb6d-6bb9bd380a30', 'Singles Collection', '2025-04-20', NULL);
-- Canciones
INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) 
VALUES ('4c1ddbc9-9c0b-4ef8-bb6d-6bb9bd380a25', 'Zombie', '1994-01-01', '00:05:06', '550e8400-e29b-41d4-a716-446655440001', '2a9eebc9-9c0b-4ef8-bb6d-6bb9bd380a23', 'src/main/java/org/uninpahu/Music/Zombie.mp3');

INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) 
VALUES ('5d2eebc9-9c0b-4ef8-bb6d-6bb9bd380a26', 'Who Loves the Sun', '1970-01-01', '00:02:38', '550e8400-e29b-41d4-a716-446655440012', '4c0ffc99-9c0b-4ef8-bb6d-6bb9bd380a30', 'src/main/java/org/uninpahu/Music/Who love the sun.mp3');

INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) 
VALUES ('6e3ffc99-9c0b-4ef8-bb6d-6bb9bd380a27', 'Hombre Lobo en París', '1984-01-01', '00:03:53', '550e8400-e29b-41d4-a716-446655440010', '3b0ffc99-9c0b-4ef8-bb6d-6bb9bd380a24', 'src/main/java/org/uninpahu/Music/hombre lobo en Paris.mp3');

INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) 
VALUES ('d3a7b8c2-4e5f-11ee-be56-0242ac120002', 'Psycho (Acoustic)', '2021-10-05', '00:03:06', '550e8400-e29b-41d4-a716-446655440000', '4c0ffc99-9c0b-4ef8-bb6d-6bb9bd380a30', 'src/main/java/org/uninpahu/Music/Psycho (Acoustic).mp3');

-- Relación de artistas y canciones
INSERT INTO SongArtists (idSong, idUser, assignmentDate) VALUES
                                                             ('4c1ddbc9-9c0b-4ef8-bb6d-6bb9bd380a25', '9d6eebc9-9c0b-4ef8-bb6d-6bb9bd380a20', '1994-01-01'), -- Dolores - Zombie
                                                             ('5d2eebc9-9c0b-4ef8-bb6d-6bb9bd380a26', '0e7ffc99-9c0b-4ef8-bb6d-6bb9bd380a21', '1970-01-01'), -- Lou Reed - Who Loves...
                                                             ('6e3ffc99-9c0b-4ef8-bb6d-6bb9bd380a27', '1f8ddbc9-9c0b-4ef8-bb6d-6bb9bd380a22', '1984-01-01');
