DROP DATABASE IF EXISTS bd_hayta;
CREATE DATABASE bd_hayta;
USE bd_hayta;

CREATE TABLE envios(
  codigo    CHAR(7)      NOT NULL PRIMARY KEY,
  cliente   VARCHAR(100) NOT NULL,
  producto  VARCHAR(100) NOT NULL,
  direccion VARCHAR(80)  NOT NULL,
  precio    DECIMAL(8,2) NOT NULL,
  fecha     DATE         NOT NULL,
  estado    TINYINT      NOT NULL
);

INSERT INTO envios VALUES ('ENV1729', 'Juan Perez', 'Samsung Galaxy 20', 'Av Rosales 10', 1820.50, curdate(), 1 );
INSERT INTO envios VALUES ('ENV8911', 'Richard Santos', 'TV Oled', 'Buenos Aires 222', 850.50,curdate(), 4 );
INSERT INTO envios VALUES ('ENV1584', 'Sara Fernandez', 'Hyperx Quadcast','Arequipa 50', 420, curdate(), 3 );
INSERT INTO envios VALUES ('ENV7113', 'Jose Robles', 'Blue Yeti', 'Santa Rosa 555', 450, curdate(), 2 );
INSERT INTO envios VALUES ('ENV1881', 'Carla Miranda', 'Logitech g930', 'Miraflores 15', 500, curdate(), 2 );
INSERT INTO envios VALUES ('ENV6617', 'John Snow', 'Iphone 12', 'Puno 20', 3820, curdate(), 1 );
INSERT INTO envios VALUES ('ENV1072', 'Sansa Stark', 'Xbox Serie X', 'Cusco 100', 3100, curdate(), 3 );

SELECT * FROM envios;