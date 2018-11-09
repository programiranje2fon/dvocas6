# Laboratorijske vežbe – dvočas br. 6

## Zadatak 1
*(radi laborant u saradnji sa studentima)*

Napraviti klasu **KucniAparat** u paketu **zadatak1** koja ima:
1. Privatni atribut **ukljucen** koji ima vrednost TRUE ako je aparat uključen, a u suprotnom FALSE.
2. Privatni atribut **markaIModel** koji je tekstualnog tipa.
3. Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**.
4. Javnu metodu **ukljuciIskljuci** koja ako je aparat uključen, isključuje ga i obratno, ako je isključen, uključuje ga.

Napraviti klasu **ProbaKucniAparat** u paketu **zadatak1.proba** i u njoj kreirati dva objekta klase **KucniAparat** koji su inicijalno ukljuceni i marke i modela "Laptop Acer A315" i "Canon DSLR EOS 5D". Nad prvim objektom pozvati metodu **ukljuciIskljuci**.

Napraviti klasu **Televizor** u paketu **zadatak1** koja nasleđuje klasu **KucniAparat** i ima:
1. Privatni atribut **program** koji predstavlja broj programa koji se trenutno prikazuje.
2. Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i treći ulazni argument koji predstavlja početni broj programa. Ako je uneta vrednost manja od jedan ili veća od 40, ispisuje se "GRESKA" na ekranu, a atribut **program** dobija vrednost 1. U suprotnom, atribut **program** dobija unetu vrednost.
3. Javnu metodu **promeniProgram** koja kao ulaz dobija novi program koji postavlja kao vrednost atributa **program**. Program mora biti u granicama između 1 i 40. U suprotnom, ništa se ne događa.

U prethodno kreiranoj klasi **ProbaKucniAparat** u paketu **zadatak1.proba**: 
- Napraviti dva objekta klase **Televizor** koji su inicijalno ukljuceni, imaju istu marku i model "Samsung UE40" i početna vrednost programa im je 1. 
- Nad prvim televizorom pozvati metode **ukljuciIskljuci** i **promeniProgram**.
- Napraviti referencu klase **KucniAparat** i dodeliti joj prvi televizor. Pozvati metode klase KucniAparat.


U klasi **KucniAparat** dodati sledeće metode:
1. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: ####".
2. Redefinisanu javnu metodu **equals** klase Object. Metoda prvo proverava da li je uneti objekat klase **KucniAparat**, pa ako nije, vraća FALSE. Metoda vraća TRUE ako su marka i model kućnog aparata jednaki marki i modelu unetog kućnog aparata, a inače vraća FALSE.

U klasi **ProbaKucniAparat** nad prvim kucnim aparatom pozvati metode **toString** i **equals** kojoj je prosleđen drugi objekat i ispisati u konzoli povratne vrednosti.

U klasi **Televizor** dodati sledeću metodu:
1. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: #### PROGRAM: ####".

U prethodno kreiranoj klasi **ProbaKucniAparat** nad prvim televizorom pozvati metodu **toString**.

## Zadatak 2
*(studenti rade sami)*

Napraviti klasu **Radio** u paketu **zadatak2** koja nasleđuje klasu KucniAparat i ima:
1. Privatni atribut **frekvencija** koji predstavlja trenutnu frekvenciju koju pušta radio aparat (npr. 87,5).
2. Javni konstruktor koji kao parametre prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i još jedan parametar koji predstavlja početnu frekvenciju radio aparata. Ako je uneta frekvencija van opsega 87.5 – 107.9 ispisuje se reč "GRESKA" na ekranu, a atribut frekvencija dobija vrednost 87.5. U suprotnom, atribut frekvencija dobija unetu vrednost.
3. Javnu metodu **getFrekvencija** koja vraća trenutnu vrednost atributa frekvencija.
4. Javnu metodu **setFrekvencija** koja kao parametar prima novu frekvenciju. Ako je uneta frekvencija van opsega 87.5 – 107.9, ispisuje se reč "GRESKA" na ekranu. U suprotnom, atribut frekvencija dobija unetu vrednost.
4. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze podaci o radio aparatu u formatu "RADIO FREKVENCIJA: #### Mhz".

Napraviti klasu **ProbaRadio** u paketu **zadatak2** koja kreira jedan objekat klase Radio i poziva redom njegove metode.