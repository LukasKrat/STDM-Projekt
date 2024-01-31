CREATE TABLE IF NOT EXISTS 'VereinsAbteilung' (
	'VA_ID' INT NOT NULL PRIMARY KEY,
	'Name' char(50)
);

CREATE TABLE IF NOT EXISTS 'Mitglied'(
	'M_ID' INT NOT NULL PRIMARY KEY,
	'Vorname' char(50) NOT NULL,
	'Nachname' char(50) NOT NULL,
	'TelefonNR' char(20),
	'E-Mail' char(50) NOT NULL,
	'Adresse' char(100) NOT NULL,
	'Abteilungs_ID' INT,
	'Passwort' char(10) PRIMARY KEY,
	FOREIGN KEY('Abteilungs_ID') REFERENCES VereinsAbteilung(VA_ID)
);

CREATE TABLE IF NOT EXISTS 'PassivMitglied'(
	'PM_ID' INT NOT NULL PRIMARY KEY,
	'inaktivSeit' date NOT NULL,
	'M_ID' INT NOT NULL,
	FOREIGN KEY('M_ID') REFERENCES Mitglied('M_ID')
);

CREATE TABLE IF NOT EXISTS 'Trainer'(
	'T_ID' INT NOT NULL PRIMARY KEY,
	'kompBereich' char(50) NOT NULL,
	'M_ID' INT NOT NULL,
	FOREIGN KEY('M_ID') REFERENCES Mitglied('M_ID')
);

CREATE TABLE IF NOT EXISTS 'EhemaligesMitglied'(
	'EM_ID' INT NOT NULL PRIMARY KEY,
	'ausgetretenAm' date NOT NULL,
	'M_ID' INT NOT NULL,
	FOREIGN KEY('M_ID') REFERENCES Mitglied('M_ID')
);