

# Backlog:

Blockblast-like Game mit Single und multiplayer 

**Aufbau:**
-  Main/Controller
-  Test class
-  GUI - Magdalena, Luzia
-  Game Logic - Maurice, Liam
-  Network - Luca
-  Storage - Luca


Feld: 8 x 8 Felder

Mögliche Blöcke: siehe [Bild](https://github.com/Ashefromapex/Competitive-Blockblast/blob/main/blocks.jpg) 
Man muss alle 3 gegebenen Blöcke platzieren (Maybe mit Time limit)
Wenn eine Reihe komplett ausgefüllt ist, wird sie gecleared 

Multiplayer:
-  Turn based
-  Wenn man eine Line cleared schickt man "Angriff" zum Gegner

# Communication:

Algo: 
returnSeed() --> returns seed
getState() --> returned array (feld der Blöcke)
placeBlock() --> von Gui zu Algo, welcher Block, wo platziert Wurde
getscore() --> score für gui
run() --> startet spiel und returned score am ende 
returnBlocks() --> gibt drei neue Blöcke aus

Storage:
pushScore() --> score senden, wird in history gespeichert + mybe highscore
pushName() --> name angeben 
fetch(name) --> stats zu name asugeben 
reset() --> reset 
pushScore() --> für multiplayer --> ggn wen und ob gewonnen 
fetchHist(name) --> history von multiplayer ausgeben 

IP:
getIp() --> ip von Gerät ausgeben 
connect(ip) --> mit ip verbinden 
send()
receive()

# Questions:
Blöcke in Algo feld einzeln bennen --> für GUI?

## How to commit:

  Repository pullen
-  lokale Branch erstellen
-  Änderungen durchführen --> **TESTEN!!**
-  lokale Kopie updaten
-  committen und pushen 


