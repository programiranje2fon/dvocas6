# Laboratorijske vežbe – dvočas br. 6

## Zadatak 1
(radi ga laborant u saradnji sa studentima)

Napraviti klasu **KucniAparat** u paketu **zadatak1** koja ima:

1. Privatni atribut **ukljucen** koji ima vrednost TRUE ako je aparat uključen, a u suprotnom FALSE.
2. Privatni atribut **markaImodel** koji je tekstualnog tipa.
3. Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**.
4. Javnu ,etodu **ukljuciIskljuci** koja ako je aparat uključen, isključuje ga i obratno, ako je isključen, uključuje ga.
5. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: ####".
6. Redefinisanu javnu metodu **equals** klase Object. Metoda prvo proverava da li je uneti objekat klase **KucniAparat**, pa ako nije, vraća FALSE. Metoda vraća TRUE ako su marka i model kućnog aparata jednaki marki i modelu unetog kućnog aparata, a inače vraća FALSE.

Napraviti klasu **zadatak1.ProbaKucniAparat** u paketu **zadatak1.proba** koja kreira dva objekta klase **KucniAparat** koji su inicijalno ukljuceni i marke i modela su "Laptop Acer A315" i "Canon DSLR EOS 5D". Nad prvim objektom pozvati dva puta metodu **ukljuciIskljuci**, ispisati vrednost koju vraćaju metode **toString** i **equals** kojoj je prosleđen drugi objekat. (objasniti da se poziva *javni konstruktor* klase KucniAparat)


Napraviti klasu **Televizor** u paketu **zadatak1** koja nasleđuje klasu **KucniAparat** i ima (ključna reč *extends*, default konstruktor podklase poziva default konstruktor nadklase):
1. Privatni atribut **program** koji predstavlja broj programa koji se trenutno prikazuje.
2. Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i treći ulazni argument koji predstavlja početni broj programa. Ako je uneta vrednost manja od jedan ili veća od 40, ispisuje se "GRESKA" na ekranu, a atribut **program** dobija vrednost 1. U suprotnom, atribut **program** dobija unetu vrednost. (ključna reč *super*)
3. Javnu metodu **promeniProgram** koja kao ulaz dobija novi program koji postavlja kao vrednost atributa **program**. Program mora biti u granicama između 1 i 40.
4. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze svi podaci o kućnom aparatu u formatu "MARKA I MODEL: #### UKLJUCEN: #### PROGRAM: ####". (override - redefinisanje metoda)


U ranije kreiranoj klasi **ProbaKucniAparat** napraviti dva objekta klase **Televizor** koji su inicijalno ukljuceni, imaju istu marku i model "Samsung UE40" i početna vrednost programa im je 1. Nad prvim televizorom pozvati metodu **ukljuciIskljuci**, ispisati vrednost koju vraćaju metode **toString** i **equals** kojoj je prosleđen drugi televizor. (objasniti importovanje klase i kako funkcionišu redefinisane metode)

## Zadatak 2
(rade ga studenti sami)

Napraviti klasu **Radio** u paketu **zadatak2** koja nasleđuje klasu KucniAparat i ima:
1. Privatan atribut **frekvencija** koji predstavlja trenutnu frekvenciju koju pušta radio aparat (npr. 87,5).
2. Javni konstruktor koji kao ulazni argument prima boolean vrednost i String i postavlja ih kao vrednost atributa **ukljucen** i **markaIModel**. Ovaj konstruktor ima i još jedan ulazni argument koji predstavlja početnu frekvenciju radio aparata. Ako je uneta frekvencija van opsega 87.5 – 107.9 ispisuje se poruka o grešci na ekranu, a atribut frekvencija dobija vrednost 87.5. U suprotnom, atribut frekvencija dobija unetu vrednost.
3. Javnu metodu **getFrekvencija*** koja vraća trenutnu vrednost atributa frekvencija.
4. Javnu metodu **setFrekvencija** koja kao ulazni argument prima novu frekvenciju. Ako je uneta frekvencija van opsega 87.5 – 107.9, ispisuje se poruka o grešci na ekranu. U suprotnom, atribut frekvencija dobija unetu vrednost.
4. Redefinisanu javnu metodu **toString** klase Object koja vraća jedan String u kome se nalaze podaci o radio aparatu u formatu "RADIO FREKVENCIJA: #### Mhz".

Napraviti klasu **ProbaRadio** koja kreira jedan objekat klase Radio i poziva redom njegove metode.