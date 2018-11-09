# Laboratorijske vežbe – dvočas br. 6

## Zadatak 1
*(radi laborant u saradnji sa studentima)*

Napraviti klasu **KucniAparat** u paketu **zadatak1** koja ima:
* Privatni atribut **ukljucen** koji ima vrednost TRUE ako je aparat uključen, a u suprotnom FALSE.
* Privatni atribut **markaIModel** koji je tekstualnog tipa.
* Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**.
* Javnu metodu **ukljuciIskljuci** koja ako je aparat uključen, isključuje ga i obratno, ako je isključen, uključuje ga.

Napraviti klasu **ProbaKucniAparat** u paketu **zadatak1.proba** i u njoj kreirati dva objekta klase **KucniAparat** koji su inicijalno ukljuceni i marke i modela su "Laptop Acer A315". Nad prvim objektom pozvati metodu **ukljuciIskljuci**.

Napraviti klasu **Televizor** u paketu **zadatak1** koja nasleđuje klasu **KucniAparat** i ima:
* Privatni atribut **program** koji predstavlja broj programa koji se trenutno prikazuje.
* Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i treći ulazni argument koji predstavlja početni broj programa. Ako je uneta vrednost manja od jedan ili veća od 40, ispisuje se "GRESKA" na ekranu, a atribut **program** dobija vrednost 1. U suprotnom, atribut **program** dobija unetu vrednost.
* Javnu metodu **promeniProgram** koja kao ulaz dobija novi program koji postavlja kao vrednost atributa **program**. Program mora biti u granicama između 1 i 40. U suprotnom, ništa se ne događa.

U prethodno kreiranoj klasi **ProbaKucniAparat** u paketu **zadatak1.proba**: 
* Napraviti objekat klase **Televizor** koji je inicijalno ukljucen, ima marku i model "Samsung UE40" i početna vrednost programa je 1. 
* Nad televizorom pozvati metode **ukljuciIskljuci** i **promeniProgram**.
* Napraviti referencu klase **KucniAparat** i dodeliti joj televizor. Pozvati metode klase KucniAparat.


U klasi **KucniAparat** dodati sledeće metode:
* Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: ####".
* Redefinisanu javnu metodu **equals** klase Object. Metoda prvo proverava da li je uneti objekat klase **KucniAparat**, pa ako nije, vraća FALSE. Metoda vraća TRUE ako su marka i model kućnog aparata jednaki marki i modelu unetog kućnog aparata, a inače vraća FALSE.

U klasi **ProbaKucniAparat** nad prvim kucnim aparatom pozvati metode **toString** i **equals** kojoj je prosleđen drugi objekat i ispisati u konzoli povratne vrednosti.

U klasi **Televizor** dodati sledeću metodu:
* Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: #### PROGRAM: ####".

U prethodno kreiranoj klasi **ProbaKucniAparat** nad televizorom pozvati metodu **toString**.

## Zadatak 2
*(studenti rade sami)*

Napraviti klasu **Radio** u paketu **zadatak2** koja nasleđuje klasu KucniAparat i ima:
* Privatni atribut **frekvencija** koji predstavlja trenutnu frekvenciju koju pušta radio aparat (npr. 87,5).
* Javni konstruktor koji kao parametre prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i još jedan parametar koji predstavlja početnu frekvenciju radio aparata. Ako je uneta frekvencija van opsega 87.5 – 107.9 ispisuje se reč "GRESKA" na ekranu, a atribut frekvencija dobija vrednost 87.5. U suprotnom, atribut frekvencija dobija unetu vrednost.
* Javnu metodu **getFrekvencija** koja vraća trenutnu vrednost atributa frekvencija.
* Javnu metodu **setFrekvencija** koja kao parametar prima novu frekvenciju. Ako je uneta frekvencija van opsega 87.5 – 107.9, ispisuje se reč "GRESKA" na ekranu. U suprotnom, atribut frekvencija dobija unetu vrednost.
* Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze podaci o radio aparatu u formatu "RADIO FREKVENCIJA: #### Mhz".

Napraviti klasu **ProbaRadio** u paketu **zadatak2** koja kreira jedan objekat klase Radio i poziva redom njegove metode.