package zadatak1.proba;

import zadatak1.KucniAparat;
import zadatak1.Televizor;

public class ProbaKucniAparat {

	public static void main(String[] args) {

		KucniAparat k1 = new KucniAparat(true, "Laptop Acer A315");
		KucniAparat k2 = new KucniAparat(true, "Canon DSLR EOS 5D");
		
		k1.ukljuciIskljuci();
		k1.ukljuciIskljuci();
		
		System.out.println(k1.toString());
		
		System.out.println(k1.equals(k2));
		
		Televizor t1 = new Televizor(true, "Samsung UE40", 1);
		Televizor t2 = new Televizor(true, "Samsung UE40", 1);
		
		t1.ukljuciIskljuci();
		
		System.out.println(t1.toString());
		System.out.println(t1.toString());
		
		System.out.println(t1.equals(t2));
	}

}
