/* ============================================================
   CREACIÓN DE BASE DE DATOS - FILMOTEKA
   ============================================================ */


CREATE DATABASE IF NOT EXISTS peliculas_db;
USE peliculas_db;

CREATE TABLE actor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    pais_nacimiento VARCHAR(255) NOT NULL
);

CREATE TABLE pelicula (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    duracion INT NOT NULL,
    pais VARCHAR(255),
    direccion VARCHAR(255),
    genero VARCHAR(255),
    sinopsis TEXT,
    portada VARCHAR(500)
);

CREATE TABLE pelicula_actor (
    pelicula_id BIGINT NOT NULL,
    actor_id BIGINT NOT NULL,
    PRIMARY KEY (pelicula_id, actor_id),
    FOREIGN KEY (pelicula_id) REFERENCES pelicula(id),
    FOREIGN KEY (actor_id) REFERENCES actor(id)
);

INSERT INTO actor (id, nombre, fecha_nacimiento, pais_nacimiento) VALUES
(1, 'Jennifer Lawrence', '1990-08-15', 'United States'),
(2, 'Josh Hutcherson', '1992-10-12', 'United States'),
(3, 'Liam Hemsworth', '1990-01-13', 'Australia'),
(4, 'Cillian Murphy', '1976-05-25', 'Ireland'),
(5, 'Emily Blunt', '1983-02-23', 'United Kingdom'),
(6, 'Matt Damon', '1970-10-08', 'United States'),
(7, 'Matthew McConaughey', '1969-11-04', 'United States'),
(8, 'Anne Hathaway', '1982-11-12', 'United States'),
(9, 'Jessica Chastain', '1977-03-24', 'United States'),
(10, 'Patrick Wilson', '1973-07-03', 'United States'),
(11, 'Vera Farmiga', '1973-08-06', 'United States'),
(12, 'Macaulay Culkin', '1980-08-26', 'United States'),
(13, 'Joe Pesci', '1943-02-09', 'United States'),
(14, 'Margot Robbie', '1990-07-02', 'Australia'),
(15, 'Ryan Gosling', '1980-11-12', 'Canada');


INSERT INTO pelicula (id, titulo, year, duracion, pais, direccion, genero, sinopsis, portada) VALUES
(1, 'The Hunger Games', 2012, 142, 'USA', 'Gary Ross', 'Action', 'Katniss Everdeen volunteers as tribute...', 'https://i.ibb.co/YZt7B8v/hunger-games.jpg'),
(2, 'Oppenheimer', 2023, 180, 'USA', 'Christopher Nolan', 'Drama', 'The story of J. Robert Oppenheimer...', 'https://i.ibb.co/rcLqbtk/oppenheimer.jpg'),
(3, 'Interstellar', 2014, 169, 'USA', 'Christopher Nolan', 'Sci-Fi', 'A team travels through a wormhole...', 'https://i.ibb.co/r2D0wG8/interstellar.jpg'),
(4, 'The Conjuring: The Devil Made Me Do It', 2021, 112, 'USA', 'Michael Chaves', 'Horror', 'A chilling story of possession...', 'https://i.ibb.co/CMhsw0c/conjuring3.jpg'),
(5, 'Home Alone', 1990, 103, 'USA', 'Chris Columbus', 'Comedy', 'Kevin is left home alone...', 'https://i.ibb.co/pvnBpKs/home-alone.jpg'),
(6, 'Fast & Furious: Tokyo Drift', 2006, 104, 'USA', 'Justin Lin', 'Action', 'A teen learns drift racing in Tokyo...', 'https://i.ibb.co/njdx0y4/tokyo-drift.jpg'),
(7, 'Dune', 2021, 155, 'USA', 'Denis Villeneuve', 'Sci-Fi', 'Paul Atreides leads a dangerous mission...', 'https://i.ibb.co/Bq4d3GV/dune.jpg'),
(8, 'Barbie', 2023, 114, 'USA', 'Greta Gerwig', 'Comedy', 'Barbie enters the real world...', 'https://i.ibb.co/5rJbVKr/barbie.jpg');


INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
(1, 1), (1, 2), (1, 3),   -- Hunger Games
(2, 4), (2, 5), (2, 6),   -- Oppenheimer
(3, 7), (3, 8), (3, 9),   -- Interstellar
(4, 10), (4, 11),         -- Conjuring 3
(5, 12), (5, 13),         -- Home Alone
(6, 6), (6, 13),          -- Tokyo Drift 
(7, 7), (7, 9),           -- Dune
(8, 14), (8, 15);         -- Barbie
