create database cine_creizy;

use cine_creizy;


create table roles(
idrol int NOT NULL identity,
rol varchar(45) NOT NULL,
PRIMARY KEY(idrol)
);

INSERT INTO roles VALUES('Admin');
INSERT INTO roles VALUES('User');

create table paises(
idpais int NOT NULL identity,
pais varchar(50) NOT NULL,
PRIMARY KEY(idpais)
);

INSERT INTO paises VALUES('El Salvador');
INSERT INTO paises VALUES('Nicaragua');
INSERT INTO paises VALUES('Costa Rica');
INSERT INTO paises VALUES('Guatemala');
INSERT INTO paises VALUES('Panama');
INSERT INTO paises VALUES('Honduras');
INSERT INTO paises VALUES('Belice');

CREATE TABLE usuario (
  idusuario varchar(30) NOT NULL,
  nombres varchar(45) NOT NULL,
  apellidos varchar(45) NOT NULL,
  email varchar(100) NOT NULL,
  clave varchar(100) NOT NULL,
  idpais int NOT NULL,
  idrol int NOT NULL,
  PRIMARY KEY (idusuario),
  FOREIGN KEY (idrol) REFERENCES roles (idrol),
  FOREIGN KEY (idpais) REFERENCES paises (idpais)
);

INSERT INTO usuario VALUES('wolf','Kevin','Magaña','kevin@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),1,1);
INSERT INTO usuario VALUES('Abraham','Oscar','Magaña','lm17i04001@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'oscar'),2)),1,2);
INSERT INTO usuario VALUES('Kookie','Estefany','Hernandez','Grecia@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'tiziano'),2)),1,1);

INSERT INTO usuario VALUES('Usuario1','Nombre1','Apellido1','Correo1@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),2,2);
INSERT INTO usuario VALUES('Usuario2','Nombre2','Apellido2','Correo2@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),3,2);
INSERT INTO usuario VALUES('Usuario3','Nombre3','Apellido3','Correo3@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),4,2);
INSERT INTO usuario VALUES('Usuario4','Nombre4','Apellido4','Correo4@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),5,2);
INSERT INTO usuario VALUES('Usuario5','Nombre5','Apellido5','Correo5@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),6,2);
INSERT INTO usuario VALUES('Usuario6','Nombre6','Apellido6','Correo6@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),7,2);
INSERT INTO usuario VALUES('Usuario7','Nombre7','Apellido7','Correo7@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),7,2);
INSERT INTO usuario VALUES('Usuario8','Nombre8','Apellido8','Correo8@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),7,2);
INSERT INTO usuario VALUES('Usuario9','Nombre9','Apellido9','Correo9@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),1,2);
INSERT INTO usuario VALUES('Usuario10','Nombre10','Apellido10','Correo10@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),2,2);
INSERT INTO usuario VALUES('Usuario11','Nombre11','Apellido11','Correo11@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),3,2);
INSERT INTO usuario VALUES('Usuario12','Nombre12','Apellido12','Correo12@usonsonate.edu.sv', lower(CONVERT(VARCHAR(64),HashBytes('SHA2_256', 'admin'),2)),4,2);



create table menu(
idmenu int NOT NULL identity,
menu varchar(50) NOT NULL,
descripcion varchar(100),
url varchar(300),
idpadre int,
PRIMARY KEY(idmenu),
FOREIGN KEY (idpadre) REFERENCES menu (idmenu)
);

create table permiso(
idpermiso int NOT NULL identity,
idmenu int NOT NULL,
idrol int NOT NULL,
PRIMARY KEY (idpermiso),
FOREIGN KEY (idmenu) REFERENCES menu (idmenu),
FOREIGN KEY (idrol) REFERENCES roles (idrol)
);

set identity_insert menu on;
insert into menu(idmenu, menu, descripcion, url, idpadre) values(1, 'Vender Boletos', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(2, 'Vender Comida', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(3, 'Peliculas', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(4, 'Cartelera', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(5, 'Comida', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(6, 'Boletos', '','/Principal', null);
insert into menu(idmenu, menu, descripcion, url, idpadre) values(7, 'Usuarios', '','/Principal', null);

insert into permiso(idmenu, idrol) select idmenu, 1 from menu;
insert into permiso(idmenu, idrol) select idmenu, 2 from menu where idmenu in(1,2);


CREATE TABLE peliculas (
  idpelicula INT NOT NULL identity,
  titulo VARCHAR(200) NOT NULL,
  duracion VARCHAR(9) NOT NULL,
  sinopsis VARCHAR(500) NOT NULL,
  clasificacion VARCHAR(1) NOT NULL,
  generos VARCHAR(300) NULL,
  fecha_De_Llegada VARCHAR(45) NOT NULL,
  fecha_De_Salida VARCHAR(45) NOT NULL,
  PRIMARY KEY (idpelicula));


  insert peliculas VALUES('La mejor pelicula del mundo','2:45:0','Esta es la sinopsis mas prrona que podras leer','C','Accion','2019-10-05','2019-12-21');
  insert peliculas VALUES('La mejor pelicula del mundo parte 2','2:15:17','Esta es una sinopsis aun mejor que la de la primera pelicula','D','Accion','2020-7-14','2020-9-01');
  insert peliculas VALUES('Una muy buena pelicula','2:10:23','Ocurrira algo interesante y para saberlo, deberas ver la pelicula','A','Comedia','2019-05-23','2019-6-21');
  insert peliculas VALUES('Pelicula mala','1:56:59','Esta es la sinopsis de una pelicula que sera aburrida','A','Romance','2019-10-04','2019-11-1');
  insert peliculas VALUES('La mejor pelicula del mundo parte 3','2:15:22','La mejor pelicula regresa y como es de costumbre, la sinopsis tambien es muy prrona','C','Accion','2021-04-05','2021-07-21');

CREATE TABLE salas (
  idsala INT NOT NULL identity,
  sala VARCHAR(2) NOT NULL,
  PRIMARY KEY (idsala));

  insert salas values('A');
  insert salas values('B');
  insert salas values('C');
  insert salas values('D');

CREATE TABLE proyecciones (
  idproyeccion INT NOT NULL identity,
  horainicio VARCHAR(20) NOT NULL,
  horafin VARCHAR(20) NOT NULL,
  idsala INT NOT NULL,
  idpelicula INT NOT NULL,
  PRIMARY KEY (idproyeccion),
  FOREIGN KEY (idsala) REFERENCES salas (idsala),
  FOREIGN KEY (idpelicula) REFERENCES peliculas (idpelicula));

  Insert into proyecciones values('9:17','10:24',2,1);
  Insert into proyecciones values('10:30','11:45',3,1);
  Insert into proyecciones values('12:35','2:02',1,1);
  Insert into proyecciones values('9:17','10:24',3,2);
  Insert into proyecciones values('9:17','10:24',4,3);
  Insert into proyecciones values('9:17','10:24',4,4);
  Insert into proyecciones values('9:17','10:24',1,1);
  Insert into proyecciones values('9:17','10:24',1,1);


CREATE TABLE asientos (
  idasiento INT NOT NULL identity,
  asiento VARCHAR(7) NOT NULL,
  idsala INT NOT NULL,
  disponible INT NOT NULL,
  PRIMARY KEY (idasiento),
  FOREIGN KEY (idsala) REFERENCES salas(idsala));


INSERT INTO asientos values('A1',1,1);
INSERT INTO asientos values('A2',1,1);
INSERT INTO asientos values('A3',1,1);
INSERT INTO asientos values('A4',1,1);
INSERT INTO asientos values('A5',1,1);
INSERT INTO asientos values('A6',1,1);
INSERT INTO asientos values('A7',1,1);
INSERT INTO asientos values('A8',1,1);
INSERT INTO asientos values('A9',1,1);
INSERT INTO asientos values('A10',1,1);
INSERT INTO asientos values('B1',1,1);
INSERT INTO asientos values('B2',1,1);
INSERT INTO asientos values('B3',1,1);
INSERT INTO asientos values('B4',1,1);
INSERT INTO asientos values('B5',1,1);
INSERT INTO asientos values('B6',1,1);
INSERT INTO asientos values('B7',1,1);
INSERT INTO asientos values('B8',1,1);
INSERT INTO asientos values('B9',1,1);
INSERT INTO asientos values('B10',1,1);
INSERT INTO asientos values('C1',1,1);
INSERT INTO asientos values('C2',1,1);
INSERT INTO asientos values('C3',1,1);
INSERT INTO asientos values('C4',1,1);
INSERT INTO asientos values('C5',1,1);
INSERT INTO asientos values('C6',1,1);
INSERT INTO asientos values('C7',1,1);
INSERT INTO asientos values('C8',1,1);
INSERT INTO asientos values('C9',1,1);
INSERT INTO asientos values('C10',1,1);
INSERT INTO asientos values('D1',1,1);
INSERT INTO asientos values('D2',1,1);
INSERT INTO asientos values('D3',1,1);
INSERT INTO asientos values('D4',1,1);
INSERT INTO asientos values('D5',1,1);
INSERT INTO asientos values('D6',1,1);
INSERT INTO asientos values('D7',1,1);
INSERT INTO asientos values('D8',1,1);
INSERT INTO asientos values('D9',1,1);
INSERT INTO asientos values('D10',1,1);
INSERT INTO asientos values('E1',1,1);
INSERT INTO asientos values('E2',1,1);
INSERT INTO asientos values('E3',1,1);
INSERT INTO asientos values('E4',1,1);
INSERT INTO asientos values('E5',1,1);
INSERT INTO asientos values('E6',1,1);
INSERT INTO asientos values('E7',1,1);
INSERT INTO asientos values('E8',1,1);
INSERT INTO asientos values('E9',1,1);
INSERT INTO asientos values('E10',1,1);
INSERT INTO asientos values('F1',1,1);
INSERT INTO asientos values('F2',1,1);
INSERT INTO asientos values('F3',1,1);
INSERT INTO asientos values('F4',1,1);
INSERT INTO asientos values('F5',1,1);
INSERT INTO asientos values('F6',1,1);
INSERT INTO asientos values('F7',1,1);
INSERT INTO asientos values('F8',1,1);
INSERT INTO asientos values('F9',1,1);
INSERT INTO asientos values('F10',1,1);
INSERT INTO asientos values('G1',1,1);
INSERT INTO asientos values('G2',1,1);
INSERT INTO asientos values('G3',1,1);
INSERT INTO asientos values('G4',1,1);
INSERT INTO asientos values('G5',1,1);
INSERT INTO asientos values('G6',1,1);
INSERT INTO asientos values('G7',1,1);
INSERT INTO asientos values('G8',1,1);
INSERT INTO asientos values('G9',1,1);
INSERT INTO asientos values('G10',1,1);
INSERT INTO asientos values('H1',1,1);
INSERT INTO asientos values('H2',1,1);
INSERT INTO asientos values('H3',1,1);
INSERT INTO asientos values('H4',1,1);
INSERT INTO asientos values('H5',1,1);
INSERT INTO asientos values('H6',1,1);
INSERT INTO asientos values('H7',1,1);
INSERT INTO asientos values('H8',1,1);
INSERT INTO asientos values('H9',1,1);
INSERT INTO asientos values('H10',1,1);
INSERT INTO asientos values('I1',1,1);
INSERT INTO asientos values('I2',1,1);
INSERT INTO asientos values('I3',1,1);
INSERT INTO asientos values('I4',1,1);
INSERT INTO asientos values('I5',1,1);
INSERT INTO asientos values('I6',1,1);
INSERT INTO asientos values('I7',1,1);
INSERT INTO asientos values('I8',1,1);
INSERT INTO asientos values('I9',1,1);
INSERT INTO asientos values('I10',1,1);
INSERT INTO asientos values('J1',1,1);
INSERT INTO asientos values('J2',1,1);
INSERT INTO asientos values('J3',1,1);
INSERT INTO asientos values('J4',1,1);
INSERT INTO asientos values('J5',1,1);
INSERT INTO asientos values('J6',1,1);
INSERT INTO asientos values('J7',1,1);
INSERT INTO asientos values('J8',1,1);
INSERT INTO asientos values('J9',1,1);
INSERT INTO asientos values('J10',1,1);
INSERT INTO asientos values('A1',2,1);
INSERT INTO asientos values('A2',2,1);
INSERT INTO asientos values('A3',2,1);
INSERT INTO asientos values('A4',2,1);
INSERT INTO asientos values('A5',2,1);
INSERT INTO asientos values('A6',2,1);
INSERT INTO asientos values('A7',2,1);
INSERT INTO asientos values('A8',2,1);
INSERT INTO asientos values('A9',2,1);
INSERT INTO asientos values('A10',2,1);
INSERT INTO asientos values('B1',2,1);
INSERT INTO asientos values('B2',2,1);
INSERT INTO asientos values('B3',2,1);
INSERT INTO asientos values('B4',2,1);
INSERT INTO asientos values('B5',2,1);
INSERT INTO asientos values('B6',2,1);
INSERT INTO asientos values('B7',2,1);
INSERT INTO asientos values('B8',2,1);
INSERT INTO asientos values('B9',2,1);
INSERT INTO asientos values('B10',2,1);
INSERT INTO asientos values('C1',2,1);
INSERT INTO asientos values('C2',2,1);
INSERT INTO asientos values('C3',2,1);
INSERT INTO asientos values('C4',2,1);
INSERT INTO asientos values('C5',2,1);
INSERT INTO asientos values('C6',2,1);
INSERT INTO asientos values('C7',2,1);
INSERT INTO asientos values('C8',2,1);
INSERT INTO asientos values('C9',2,1);
INSERT INTO asientos values('C10',2,1);
INSERT INTO asientos values('D1',2,1);
INSERT INTO asientos values('D2',2,1);
INSERT INTO asientos values('D3',2,1);
INSERT INTO asientos values('D4',2,1);
INSERT INTO asientos values('D5',2,1);
INSERT INTO asientos values('D6',2,1);
INSERT INTO asientos values('D7',2,1);
INSERT INTO asientos values('D8',2,1);
INSERT INTO asientos values('D9',2,1);
INSERT INTO asientos values('D10',2,1);
INSERT INTO asientos values('E1',2,1);
INSERT INTO asientos values('E2',2,1);
INSERT INTO asientos values('E3',2,1);
INSERT INTO asientos values('E4',2,1);
INSERT INTO asientos values('E5',2,1);
INSERT INTO asientos values('E6',2,1);
INSERT INTO asientos values('E7',2,1);
INSERT INTO asientos values('E8',2,1);
INSERT INTO asientos values('E9',2,1);
INSERT INTO asientos values('E10',2,1);
INSERT INTO asientos values('F1',2,1);
INSERT INTO asientos values('F2',2,1);
INSERT INTO asientos values('F3',2,1);
INSERT INTO asientos values('F4',2,1);
INSERT INTO asientos values('F5',2,1);
INSERT INTO asientos values('F6',2,1);
INSERT INTO asientos values('F7',2,1);
INSERT INTO asientos values('F8',2,1);
INSERT INTO asientos values('F9',2,1);
INSERT INTO asientos values('F10',2,1);
INSERT INTO asientos values('G1',2,1);
INSERT INTO asientos values('G2',2,1);
INSERT INTO asientos values('G3',2,1);
INSERT INTO asientos values('G4',2,1);
INSERT INTO asientos values('G5',2,1);
INSERT INTO asientos values('G6',2,1);
INSERT INTO asientos values('G7',2,1);
INSERT INTO asientos values('G8',2,1);
INSERT INTO asientos values('G9',2,1);
INSERT INTO asientos values('G10',2,1);
INSERT INTO asientos values('H1',2,1);
INSERT INTO asientos values('H2',2,1);
INSERT INTO asientos values('H3',2,1);
INSERT INTO asientos values('H4',2,1);
INSERT INTO asientos values('H5',2,1);
INSERT INTO asientos values('H6',2,1);
INSERT INTO asientos values('H7',2,1);
INSERT INTO asientos values('H8',2,1);
INSERT INTO asientos values('H9',2,1);
INSERT INTO asientos values('H10',2,1);
INSERT INTO asientos values('I1',2,1);
INSERT INTO asientos values('I2',2,1);
INSERT INTO asientos values('I3',2,1);
INSERT INTO asientos values('I4',2,1);
INSERT INTO asientos values('I5',2,1);
INSERT INTO asientos values('I6',2,1);
INSERT INTO asientos values('I7',2,1);
INSERT INTO asientos values('I8',2,1);
INSERT INTO asientos values('I9',2,1);
INSERT INTO asientos values('I10',2,1);
INSERT INTO asientos values('J1',2,1);
INSERT INTO asientos values('J2',2,1);
INSERT INTO asientos values('J3',2,1);
INSERT INTO asientos values('J4',2,1);
INSERT INTO asientos values('J5',2,1);
INSERT INTO asientos values('J6',2,1);
INSERT INTO asientos values('J7',2,1);
INSERT INTO asientos values('J8',2,1);
INSERT INTO asientos values('J9',2,1);
INSERT INTO asientos values('J10',2,1);
INSERT INTO asientos values('A1',3,1);
INSERT INTO asientos values('A2',3,1);
INSERT INTO asientos values('A3',3,1);
INSERT INTO asientos values('A4',3,1);
INSERT INTO asientos values('A5',3,1);
INSERT INTO asientos values('A6',3,1);
INSERT INTO asientos values('A7',3,1);
INSERT INTO asientos values('A8',3,1);
INSERT INTO asientos values('A9',3,1);
INSERT INTO asientos values('A10',3,1);
INSERT INTO asientos values('B1',3,1);
INSERT INTO asientos values('B2',3,1);
INSERT INTO asientos values('B3',3,1);
INSERT INTO asientos values('B4',3,1);
INSERT INTO asientos values('B5',3,1);
INSERT INTO asientos values('B6',3,1);
INSERT INTO asientos values('B7',3,1);
INSERT INTO asientos values('B8',3,1);
INSERT INTO asientos values('B9',3,1);
INSERT INTO asientos values('B10',3,1);
INSERT INTO asientos values('C1',3,1);
INSERT INTO asientos values('C2',3,1);
INSERT INTO asientos values('C3',3,1);
INSERT INTO asientos values('C4',3,1);
INSERT INTO asientos values('C5',3,1);
INSERT INTO asientos values('C6',3,1);
INSERT INTO asientos values('C7',3,1);
INSERT INTO asientos values('C8',3,1);
INSERT INTO asientos values('C9',3,1);
INSERT INTO asientos values('C10',3,1);
INSERT INTO asientos values('D1',3,1);
INSERT INTO asientos values('D2',3,1);
INSERT INTO asientos values('D3',3,1);
INSERT INTO asientos values('D4',3,1);
INSERT INTO asientos values('D5',3,1);
INSERT INTO asientos values('D6',3,1);
INSERT INTO asientos values('D7',3,1);
INSERT INTO asientos values('D8',3,1);
INSERT INTO asientos values('D9',3,1);
INSERT INTO asientos values('D10',3,1);
INSERT INTO asientos values('E1',3,1);
INSERT INTO asientos values('E2',3,1);
INSERT INTO asientos values('E3',3,1);
INSERT INTO asientos values('E4',3,1);
INSERT INTO asientos values('E5',3,1);
INSERT INTO asientos values('E6',3,1);
INSERT INTO asientos values('E7',3,1);
INSERT INTO asientos values('E8',3,1);
INSERT INTO asientos values('E9',3,1);
INSERT INTO asientos values('E10',3,1);
INSERT INTO asientos values('F1',3,1);
INSERT INTO asientos values('F2',3,1);
INSERT INTO asientos values('F3',3,1);
INSERT INTO asientos values('F4',3,1);
INSERT INTO asientos values('F5',3,1);
INSERT INTO asientos values('F6',3,1);
INSERT INTO asientos values('F7',3,1);
INSERT INTO asientos values('F8',3,1);
INSERT INTO asientos values('F9',3,1);
INSERT INTO asientos values('F10',3,1);
INSERT INTO asientos values('G1',3,1);
INSERT INTO asientos values('G2',3,1);
INSERT INTO asientos values('G3',3,1);
INSERT INTO asientos values('G4',3,1);
INSERT INTO asientos values('G5',3,1);
INSERT INTO asientos values('G6',3,1);
INSERT INTO asientos values('G7',3,1);
INSERT INTO asientos values('G8',3,1);
INSERT INTO asientos values('G9',3,1);
INSERT INTO asientos values('G10',3,1);
INSERT INTO asientos values('H1',3,1);
INSERT INTO asientos values('H2',3,1);
INSERT INTO asientos values('H3',3,1);
INSERT INTO asientos values('H4',3,1);
INSERT INTO asientos values('H5',3,1);
INSERT INTO asientos values('H6',3,1);
INSERT INTO asientos values('H7',3,1);
INSERT INTO asientos values('H8',3,1);
INSERT INTO asientos values('H9',3,1);
INSERT INTO asientos values('H10',3,1);
INSERT INTO asientos values('I1',3,1);
INSERT INTO asientos values('I2',3,1);
INSERT INTO asientos values('I3',3,1);
INSERT INTO asientos values('I4',3,1);
INSERT INTO asientos values('I5',3,1);
INSERT INTO asientos values('I6',3,1);
INSERT INTO asientos values('I7',3,1);
INSERT INTO asientos values('I8',3,1);
INSERT INTO asientos values('I9',3,1);
INSERT INTO asientos values('I10',3,1);
INSERT INTO asientos values('J1',3,1);
INSERT INTO asientos values('J2',3,1);
INSERT INTO asientos values('J3',3,1);
INSERT INTO asientos values('J4',3,1);
INSERT INTO asientos values('J5',3,1);
INSERT INTO asientos values('J6',3,1);
INSERT INTO asientos values('J7',3,1);
INSERT INTO asientos values('J8',3,1);
INSERT INTO asientos values('J9',3,1);
INSERT INTO asientos values('J10',3,1);
INSERT INTO asientos values('A1',4,1);
INSERT INTO asientos values('A2',4,1);
INSERT INTO asientos values('A3',4,1);
INSERT INTO asientos values('A4',4,1);
INSERT INTO asientos values('A5',4,1);
INSERT INTO asientos values('A6',4,1);
INSERT INTO asientos values('A7',4,1);
INSERT INTO asientos values('A8',4,1);
INSERT INTO asientos values('A9',4,1);
INSERT INTO asientos values('A10',4,1);
INSERT INTO asientos values('B1',4,1);
INSERT INTO asientos values('B2',4,1);
INSERT INTO asientos values('B3',4,1);
INSERT INTO asientos values('B4',4,1);
INSERT INTO asientos values('B5',4,1);
INSERT INTO asientos values('B6',4,1);
INSERT INTO asientos values('B7',4,1);
INSERT INTO asientos values('B8',4,1);
INSERT INTO asientos values('B9',4,1);
INSERT INTO asientos values('B10',4,1);
INSERT INTO asientos values('C1',4,1);
INSERT INTO asientos values('C2',4,1);
INSERT INTO asientos values('C3',4,1);
INSERT INTO asientos values('C4',4,1);
INSERT INTO asientos values('C5',4,1);
INSERT INTO asientos values('C6',4,1);
INSERT INTO asientos values('C7',4,1);
INSERT INTO asientos values('C8',4,1);
INSERT INTO asientos values('C9',4,1);
INSERT INTO asientos values('C10',4,1);
INSERT INTO asientos values('D1',4,1);
INSERT INTO asientos values('D2',4,1);
INSERT INTO asientos values('D3',4,1);
INSERT INTO asientos values('D4',4,1);
INSERT INTO asientos values('D5',4,1);
INSERT INTO asientos values('D6',4,1);
INSERT INTO asientos values('D7',4,1);
INSERT INTO asientos values('D8',4,1);
INSERT INTO asientos values('D9',4,1);
INSERT INTO asientos values('D10',4,1);
INSERT INTO asientos values('E1',4,1);
INSERT INTO asientos values('E2',4,1);
INSERT INTO asientos values('E3',4,1);
INSERT INTO asientos values('E4',4,1);
INSERT INTO asientos values('E5',4,1);
INSERT INTO asientos values('E6',4,1);
INSERT INTO asientos values('E7',4,1);
INSERT INTO asientos values('E8',4,1);
INSERT INTO asientos values('E9',4,1);
INSERT INTO asientos values('E10',4,1);
INSERT INTO asientos values('F1',4,1);
INSERT INTO asientos values('F2',4,1);
INSERT INTO asientos values('F3',4,1);
INSERT INTO asientos values('F4',4,1);
INSERT INTO asientos values('F5',4,1);
INSERT INTO asientos values('F6',4,1);
INSERT INTO asientos values('F7',4,1);
INSERT INTO asientos values('F8',4,1);
INSERT INTO asientos values('F9',4,1);
INSERT INTO asientos values('F10',4,1);
INSERT INTO asientos values('G1',4,1);
INSERT INTO asientos values('G2',4,1);
INSERT INTO asientos values('G3',4,1);
INSERT INTO asientos values('G4',4,1);
INSERT INTO asientos values('G5',4,1);
INSERT INTO asientos values('G6',4,1);
INSERT INTO asientos values('G7',4,1);
INSERT INTO asientos values('G8',4,1);
INSERT INTO asientos values('G9',4,1);
INSERT INTO asientos values('G10',4,1);
INSERT INTO asientos values('H1',4,1);
INSERT INTO asientos values('H2',4,1);
INSERT INTO asientos values('H3',4,1);
INSERT INTO asientos values('H4',4,1);
INSERT INTO asientos values('H5',4,1);
INSERT INTO asientos values('H6',4,1);
INSERT INTO asientos values('H7',4,1);
INSERT INTO asientos values('H8',4,1);
INSERT INTO asientos values('H9',4,1);
INSERT INTO asientos values('H10',4,1);
INSERT INTO asientos values('I1',4,1);
INSERT INTO asientos values('I2',4,1);
INSERT INTO asientos values('I3',4,1);
INSERT INTO asientos values('I4',4,1);
INSERT INTO asientos values('I5',4,1);
INSERT INTO asientos values('I6',4,1);
INSERT INTO asientos values('I7',4,1);
INSERT INTO asientos values('I8',4,1);
INSERT INTO asientos values('I9',4,1);
INSERT INTO asientos values('I10',4,1);
INSERT INTO asientos values('J1',4,1);
INSERT INTO asientos values('J2',4,1);
INSERT INTO asientos values('J3',4,1);
INSERT INTO asientos values('J4',4,1);
INSERT INTO asientos values('J5',4,1);
INSERT INTO asientos values('J6',4,1);
INSERT INTO asientos values('J7',4,1);
INSERT INTO asientos values('J8',4,1);
INSERT INTO asientos values('J9',4,1);
INSERT INTO asientos values('J10',4,1);


CREATE TABLE comidas (
  idcomida INT NOT NULL identity,
  nombre VARCHAR(100) NOT NULL,
  precio float NOT NULL,
  existencia INT NOT NULL,
  PRIMARY KEY (idcomida));

  insert into comidas values('Palomitas',1.00,45);
  insert into comidas values('Soda pequeña',0.50,12);
  insert into comidas values('Soda grande',0.75,37);
  insert into comidas values('Dulces',0.25,78);
  insert into comidas values('Crepas',1.50,12);
  insert into comidas values('Hot dogg',1.50,36);
  insert into comidas values('Nachos',1.75,42);

  CREATE TABLE tipodeboletos (
  idtipodeboleto INT NOT NULL identity,
  formato VARCHAR(20) NOT NULL,
  tipo VARCHAR(40) NOT NULL,
  precio float NOT NULL,
  PRIMARY KEY (idtipodeboleto));
  
  insert into tipodeboletos values('2D','Niño',2.00);
  insert into tipodeboletos values('2D','Adulto',3.00);
  insert into tipodeboletos values('2D','Adulto Mayor',2.50);
  insert into tipodeboletos values('3D','Niño',2.00);
  insert into tipodeboletos values('3D','Adulto',3.00);
  insert into tipodeboletos values('3D','Adulto Mayor',2.50);
  insert into tipodeboletos values('4D','Niño',2.00);
  insert into tipodeboletos values('4D','Adulto',3.00);
  insert into tipodeboletos values('4D','Adulto Mayor',2.50);

CREATE TABLE ventaboletos(
  idventaboleto int NOT NULL identity,
  vendedor Varchar(500) NOT NULL,
  total float NOT NULL,
  PRIMARY KEY (idventaboleto)
);
CREATE TABLE boletos (
  idboleto int NOT NULL identity,
  idtipodeboleto INT NOT NULL,
  idproyeccion INT NOT NULL,
  idasiento INT NOT NULL,
  idventaboleto int NOT NULL,
  PRIMARY KEY (idboleto),
  FOREIGN KEY (idtipodeboleto) REFERENCES tipodeboletos (idtipodeboleto),
  FOREIGN KEY (idproyeccion) REFERENCES proyecciones (idproyeccion),
  FOREIGN KEY (idasiento) REFERENCES asientos (idasiento),
  FOREIGN KEY (idventaboleto) REFERENCES ventaboletos(idventaboleto));



  CREATE TABLE ventacomida(
  idventacomida INT NOT NULL identity,
  vendedor Varchar(500) NOT NULL,
  total float NOT NULL,
  PRIMARY KEY (idventacomida));
 
CREATE TABLE detalleventacomida (
  iddetallecomida INT NOT NULL identity,
  idcomida INT NOT NULL,
  cantidadcomida INT NOT NULL,
  idventacomida INT NOT NULL,
  total float NOT NULL,
  PRIMARY KEY (iddetallecomida),
  FOREIGN KEY (idcomida) REFERENCES comidas (idcomida),
  FOREIGN KEY (idventacomida) REFERENCES ventacomida (idventacomida));

