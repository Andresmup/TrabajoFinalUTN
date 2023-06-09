/*
	DROP DATABASE control_de_apuestas;
*/
CREATE database IF NOT EXISTS control_de_apuestas;
USE control_de_apuestas;



ALTER DATABASE control_de_apuestas CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE Table IF NOT EXISTS seleccionados (
    SeleccionID varchar(3) NOT NULL,
    Nombre varchar(50) NOT NULL,
	Descripcion varchar(255),
    PRIMARY KEY (SeleccionID)
);
CREATE Table IF NOT EXISTS resultados (
    PartidoID int NOT NULL AUTO_INCREMENT,
    EquipoUno varchar(3) NOT NULL,
    EquipoDos varchar(3) NOT NULL,
    GolesEquipoUno int NOT NULL,
    GolesEquipoDos int NOT NULL,
    Ronda int NOT NULL,
    Fase int NOT NULL,
    Ganador varchar(20),
    PRIMARY KEY (PartidoID)
);

CREATE TRIGGER update_ganador
BEFORE INSERT ON resultados
FOR EACH ROW
SET NEW.ganador = 
    CASE 
        WHEN NEW.golesEquipoUno > NEW.golesEquipoDos THEN NEW.equipoUno 
        WHEN NEW.golesEquipoUno < NEW.golesEquipoDos THEN NEW.equipoDos 
        ELSE 'empate' 
    END;
    
    
    
CREATE Table IF NOT EXISTS apostadores (
    ApostadorID int NOT NULL AUTO_INCREMENT,
    Nombre varchar(255) NOT NULL,
    Apellido varchar(255) NOT NULL,
    Puntos int NOT NULL DEFAULT 0,
    PRIMARY KEY (ApostadorID)
);

CREATE Table IF NOT EXISTS apuestas (
	ApuestaID int NOT NULL AUTO_INCREMENT,
    ApostadorID int NOT NULL,
    PartidoID int NOT NULL,
    ResultadoEsperado varchar(50) NOT NULL,
    PRIMARY KEY (ApuestaID),
    FOREIGN KEY (ApostadorID) REFERENCES apostadores(ApostadorID),
    FOREIGN KEY (PartidoID) REFERENCES resultados(PartidoID)
);


INSERT INTO apostadores (Nombre, Apellido)
VALUES
	('Claudia','Gomez'),
    ('Ricardo','Morales'),
    ('Esteban','Scarlote'),
    ('Paco','Guillan'),
    ('Marcela','Garcia'),
    ('Luis','Williams'),
    ('Pamela','Perez'),
    ('Ramon','Roque');

INSERT INTO seleccionados (SeleccionID, Nombre, Descripcion)
VALUES
	('ECU','ECUADOR','Seleccion latino americana'),
	('NDL','PAÍSES BAJOS','Ex seleccion holandesa'),
    ('QAT','QATAR','Seleccion anfitriona'),
    ('SEN','SENEGAL','Seleccion africana'),
    ('ING','INGLATERRA','Los piratas'),
    ('IRN','IRÁN','Seleccion asiatica'),
    ('USA','ESTADOS UNIDOS','Seleccion norteamericana'),
    ('WAL','GALES','Ex seleccion holandesa'),
    ('ARG','ARGENTINA','Seleccion celeste y blanca'),
    ('MEX','MÉXICO','Seleccion mexicana'),
    ('POL','POLONIA','Seleccion polaca'),
    ('KSA','ARABIA SAUDITA','Seleccionado saudi'),
    ('AUS','AUSTRALIA','Los canguros'),
    ('DEN','DINAMARCA','Seleccion europea'),
    ('FRA','FRANCIA','Ultimos campeones'),
    ('TUN','TÚNEZ','Seleccion africana'),
    ('CRC','COSTA RICA','Seleccion centroamericana'),
    ('GER','ALEMANIA','Seleccion europea'),
    ('JPN','JAPÓN','Seleccion asiatica'),
    ('ESP','ESPAÑA','Seleccion española'),
    ('BEL','BÉLGICA','Seleccion europea'),
    ('CAN','CANADÁ','Seleccion norteamericana'),
    ('CRO','CROACIA','Seleccionado del baltico'),
    ('MAR','MARRUECOS','Seleccion del norte de marruecos'),
    ('BRA','BRASIL','Pentacampeones'),
    ('CMR','CAMERÚN','Seleccion africana'),
    ('SRB','SERBIA','Seleccionado europeo'),
    ('SUI','SUIZA','Seleccion europea'),
    ('GHA','GHANA','Seleccion africana'),
    ('POR','PORTUGAL','Seleccionado lusitano'),
    ('KOR','COREA DEL SUR','Seleccion asiatica'),
    ('URU','URUGUAY','Seleccion bicampeona');
    
INSERT INTO resultados (EquipoUno, EquipoDos, GolesEquipoUno,GolesEquipoDos,Fase,Ronda)
VALUES
	("QAT","ECU",0,2,1,1),
    ("SEN","NDL",0,2,1,1),
    ("QAT","SEN",1,3,1,2),
    ("NDL","ECU",1,1,1,2),
    ("ECU","SEN",1,2,1,3),
    ("NDL","QAT",2,0,1,3),
    ("ING","IRN",6,2,1,1),
    ("USA","WAL",1,1,1,1),
    ("WAL","IRN",0,2,1,2),
    ("ING","USA",0,0,1,2),
    ("WAL","ING",0,3,1,3),
    ("IRN","USA",0,1,1,3),
    ("ARG","KSA",1,2,1,1),
    ("MEX","POL",0,0,1,1),
    ("POL","KSA",2,0,1,2),
    ("ARG","MEX",2,0,1,2),
    ("POL","ARG",0,2,1,3),
    ("KSA","MEX",1,2,1,3),
    ("DEN","TUN",0,0,1,1),
    ("FRA","AUS",4,1,1,1),
    ("TUN","AUS",0,1,1,2),
    ("FRA","DEN",2,1,1,2),
    ("AUS","DEN",1,0,1,3),
    ("TUN","FRA",0,1,1,3),
    ("GER","JPN",1,2,1,1),
    ("ESP","CRC",7,0,1,1),
    ("JPN","CRC",0,1,1,2),
    ("ESP","GER",1,1,1,2),
    ("JPN","ESP",2,1,1,3),
    ("CRC","GER",2,4,1,3),
    ("MAR","CRO",0,0,1,1),
    ("BEL","CAN",1,0,1,1),
    ("BEL","MAR",0,2,1,2),
    ("CRO","CAN",4,1,1,2),
    ("CRO","BEL",0,0,1,3),
    ("CAN","MAR",1,2,1,3),
    ("SUI","CMR",1,0,1,1),
    ("BRA","SRB",2,0,1,1),
    ("CMR","SRB",3,3,1,2),
    ("BRA","SUI",1,0,1,2),
    ("CMR","BRA",1,0,1,3),
    ("SRB","SUI",2,3,1,3),
    ("URU","KOR",0,0,1,1),
    ("GHA","POR",2,3,1,1),
    ("KOR","GHA",2,3,1,2),
    ("POR","URU",2,0,1,2),
    ("KOR","POR",2,1,1,3),
    ("GHA","URU",0,2,1,3),
    ("NDL","USA",3,1,2,0),
    ("ARG","AUS",2,1,2,0),
    ("FRA","POL",3,1,2,0),
    ("ING","SEN",3,0,2,0),
    ("JPN","CRO",1,3,2,0),
    ("BRA","KOR",4,1,2,0),
    ("MAR","ESP",3,0,2,0),
    ("POR","SUI",6,1,2,0),
    ("CRO","BRA",4,2,3,0),
    ("NDL","ARG",3,4,3,0),
    ("ING","FRA",1,2,3,0),
    ("MAR","POR",1,0,3,0),
    ("ARG","CRO",3,0,4,0),
    ("FRA","MAR",2,0,4,0),
    ("CRO","MAR",2,1,5,0),
    ("ARG","FRA",4,2,5,0);


INSERT INTO apuestas (ResultadoEsperado, ApostadorID, PartidoID)
VALUES
	("QAT",1,1),
    ("SEN",1,2),
    ("QAT",1,3),
    ("NDL",1,4),
    ("ECU",1,5),
    ("NDL",1,6),
    ("ING",1,7),
    ("USA",1,8),
    ("WAL",1,9),
    ("ING",1,10),
    ("WAL",1,11),
    ("IRN",1,12),
    ("ARG",1,13),
    ("MEX",1,14),
    ("POL",1,15),
    ("ARG",1,16),
    ("POL",1,17),
    ("KSA",1,18),
    ("DEN",1,19),
    ("FRA",1,20),
    ("TUN",1,21),
    ("FRA",1,22),
    ("AUS",1,23),
    ("TUN",1,24),
    ("GER",1,25),
    ("ESP",1,26),
    ("JPN",1,27),
    ("ESP",1,28),
    ("JPN",1,29),
    ("CRC",1,30),
    ("MAR",1,31),
    ("BEL",1,32),
    ("BEL",1,33),
    ("CRO",1,34),
    ("CRO",1,35),
    ("CAN",1,36),
    ("SUI",1,37),
    ("BRA",1,38),
    ("CMR",1,39),
    ("BRA",1,40),
    ("CMR",1,41),
    ("SRB",1,42),
    ("URU",1,43),
    ("GHA",1,44),
    ("KOR",1,45),
    ("POR",1,46),
    ("KOR",1,47),
    ("GHA",1,48),
    ("NDL",1,49),
    ("ARG",1,50),
    ("FRA",1,51),
    ("ING",1,52),
    ("JPN",1,53),
    ("BRA",1,54),
    ("MAR",1,55),
    ("POR",1,56),
    ("CRO",1,57),
    ("NDL",1,58),
    ("ING",1,59),
    ("MAR",1,60),
    ("ARG",1,61),
    ("FRA",1,62),
    ("CRO",1,63),
    ("ARG",1,64),
	("ECU",2,1),
    ("NDL",2,2),
    ("SEN",2,3),
    ("ECU",2,4),
    ("SEN",2,5),
    ("QAT",2,6),
    ("IRN",2,7),
    ("WAL",2,8),
    ("IRN",2,9),
    ("USA",2,10),
    ("ING",2,11),
    ("USA",2,12),
    ("KSA",2,13),
    ("POL",2,14),
    ("KSA",2,15),
    ("MEX",2,16),
    ("ARG",2,17),
    ("MEX",2,18),
    ("TUN",2,19),
    ("AUS",2,20),
    ("AUS",2,21),
    ("DEN",2,22),
    ("DEN",2,23),
    ("FRA",2,24),
    ("JPN",2,25),
    ("CRC",2,26),
    ("CRC",2,27),
    ("GER",2,28),
    ("ESP",2,29),
    ("GER",2,30),
    ("CRO",2,31),
    ("CAN",2,32),
    ("MAR",2,33),
    ("CAN",2,34),
    ("BEL",2,35),
    ("MAR",2,36),
    ("CMR",2,37),
    ("SRB",2,38),
    ("SRB",2,39),
    ("SUI",2,40),
    ("BRA",2,41),
    ("SUI",2,42),
    ("KOR",2,43),
    ("POR",2,44),
    ("GHA",2,45),
    ("URU",2,46),
    ("POR",2,47),
    ("URU",2,48),
    ("USA",2,49),
    ("AUS",2,50),
    ("POL",2,51),
    ("SEN",2,52),
    ("CRO",2,53),
    ("KOR",2,54),
    ("ESP",2,55),
    ("SUI",2,56),
    ("BRA",2,57),
    ("ARG",2,58),
    ("FRA",2,59),
    ("POR",2,60),
    ("CRO",2,61),
    ("MAR",2,62),
    ("MAR",2,63),
    ("FRA",2,64),
    ("NDL",3,49),
    ("ARG",3,50),
    ("FRA",3,51),
    ("ING",3,52),
    ("JPN",3,53),
    ("BRA",3,54),
    ("ESP",3,55),
    ("POR",3,56),    
	("QAT",4,1),
    ("SEN",4,2),
    ("QAT",4,3),
    ("NDL",4,4),
    ("SEN",4,5),
    ("NDL",4,6),
    ("ING",4,7),
    ("USA",4,8),
    ("WAL",4,9),
    ("ING",4,10),
    ("ING",4,11),
    ("USA",4,12),
    ("ARG",4,13),
    ("MEX",4,14),
    ("POL",4,15),
    ("ARG",4,16),
    ("ARG",4,17),
    ("MEX",4,18),
    ("DEN",4,19),
    ("FRA",4,20),
    ("TUN",4,21),
    ("FRA",4,22),
    ("AUS",4,23),
    ("FRA",4,24),
    ("GER",4,25),
    ("ESP",4,26),
    ("JPN",4,27),
    ("ESP",4,28),
    ("JPN",4,29),
    ("GER",4,30),
    ("MAR",4,31),
    ("BEL",4,32),
    ("BEL",4,33),
    ("CRO",4,34),
    ("empate",4,35),
    ("MAR",4,36),
    ("SUI",4,37),
    ("BRA",4,38),
    ("CMR",4,39),
    ("BRA",4,40),
    ("CMR",4,41),
    ("SUI",4,42),
    ("URU",4,43),
    ("GHA",4,44),
    ("KOR",4,45),
    ("POR",4,46),
    ("KOR",4,47),
    ("URU",4,48),
    ("CRO",5,57),
    ("ARG",5,58),
    ("FRA",5,59),
    ("MAR",5,60),
    ("CRO",5,61),
    ("FRA",5,62),
    ("CRO",5,63),
    ("ARG",5,64),
	("ARG",6,13),
    ("ARG",6,16),
    ("ARG",6,17),
    ("ARG",6,50),
    ("ARG",6,58),
    ("ARG",6,61),
    ("ARG",6,64),
	("empate",7,1),
    ("empate",7,2),
    ("empate",7,3),
    ("empate",7,4),
    ("USA",7,8),
    ("WAL",7,9),
    ("ING",7,10),
    ("WAL",7,11),
    ("empate",7,15),
    ("empate",7,16),
    ("empate",7,17),
    ("KSA",7,18),
    ("FRA",7,22),
    ("BEL",7,33),
    ("CRO",7,34),
    ("CRO",7,35),
    ("empate",7,48),
    ("JPN",7,53),
    ("CRO",7,57),
    ("ARG",7,64),
    ("CRO",8,63),
    ("ARG",8,64);
    
SELECT * FROM apostadores;


