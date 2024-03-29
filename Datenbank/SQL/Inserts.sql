INSERT INTO VereinsAbteilung (VA_ID, Name) VALUES
	(0, 'Keine Abteilung'),
	(1, 'Fußball')
;

INSERT INTO Mitglied (M_ID, Vorname, Nachname, TelefonNR, Email, Adresse, Abteilungs_ID, Passwort, Verwalter) VALUES
	(1, 'Max', 'Mustermann', '080056782', 'Max@Mustermann.de', 'Musterstraße 2', 1, '1234567890', 0),
	(2, 'Maxi', 'Mustermann', '0800567822', 'Maxi@Mustermann.de', 'Musterstraße 2', 0, '2345678901', 1),
	(3, 'Maxii', 'Mustermann', '08005678222', 'Maxii@Mustermann.de', 'Musterstraße 2', 0, '3456789012', 0),
	(4, 'Maxiii', 'Mustermann', '080056782222', 'Maxiii@Mustermann.de', 'Musterstraße 2', 0, '4567890234', 0),
	(5, 'Maxiiii', 'Mustermann', '0800567822222', 'Maxiiii@Mustermann.de', 'Musterstraße 2', 0, '5678901234', 0)
;
INSERT INTO Trainer (T_ID, kompBereich, M_ID) VALUES
	(1, 'Laufen', 3)
;

INSERT INTO EhemaligesMitglied (EM_ID, ausgetretenAm, M_ID) VALUES
	(1, CURRENT_DATE, 4)
;

INSERT INTO PassivMitglied (PM_ID, inaktivSeit, M_ID) VALUES
	(1, CURRENT_DATE, 5)
;