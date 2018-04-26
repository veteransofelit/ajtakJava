# AjtakJava

Textová hra.

## Jak zkompilovat a spustit

* Stažení klonu repozitáře  
`$  git clone https://github.com/veteransofelit/ajtakJava`  
* Kompilace  
`$  cd ajtakJava/`  
`$  mvn assembly:assembly`  
* Spuštění  
`$  java -jar target/Ajtak-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Úprava mapy

* Cesta k txt mapě  
  `ajtakJava/src/main/resources/textovka.txt`
* Skladba řádku  
'číslo místnosti'.'typ řádku' 'text'  
  * číslo - 01 - 99  
  * typ řádku - roomName (název místnostni) / roomDesc (popis místnosti) / roomEqip (vybavení) / roomExit (cesty ven)  
  * text - hodnoty  
* Příklad  
`01.roomName	Kuchyňka`  
`01.roomDesc	Malá kuchyňka s kávovarem.`  
`01.roomEqip	kávovar,hrníček,káva;skříňka,---,hrneček`  
`02.roomExit	01,02,05`



  
