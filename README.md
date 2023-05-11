# kotlin_console_chess
Zurzeit ist das Programm nur für Mac geeignet. Auf Windows Systemen wird
das Board nicht richtig dargestellt.

Nach dem Starten des Spiels kann man seinen Zug eingeben. 
Format ist: Startfeld,Zielfeld
Beispiel: a7,a5


Die meisten Figuren können ziehen aber nicht alle den regeln nach. Der Bauer hat schon regeln implementiert.
Ist aber noch etwas Fehleranfällig. Gleiches gilt für den Turm und den König. Das Pferd kann ziehen hat aber noch keinerlei Zuglogik.

Ich habe heute (11. Mai) festgestellt das ich wohl meine isThereAPiece Funktion
in der Klasse Piece überarbeiten muss. die scheint auch noch recht fehlerhaft zu sein. Die Funktion soll prüfen,
ob von Startfeld hin zum Zielfeld eine Figur im Weg steht. Mir ist auch schon was Besseres eingefallen aber das schaffe ich
zeitlich nicht bis zum Abgabetermin.

Was auch noch nicht richtig geht ist, wenn man einen ungültigen Zug macht, bekommt man aktuell nicht die Chance einen gültigen Zug zu machen.








