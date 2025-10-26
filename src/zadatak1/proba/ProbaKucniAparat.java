package zadatak1.proba;

import zadatak1.KucniAparat;
import zadatak1.Televizor;

public class ProbaKucniAparat {

	public static void main(String[] args) {

		KucniAparat k1 = new KucniAparat(true, "Laptop Acer A315");
		KucniAparat k2 = new KucniAparat(true, "Laptop Acer A315");
		
		k1.ukljuciIskljuci();
		
		System.out.println(k1.toString());
		System.out.println(k1.equals(k2));
		
		
		Televizor t1 = new Televizor(true, "Samsung UE40", 1);
		
		t1.ukljuciIskljuci();
		t1.promeniProgram(7);
		
		System.out.println(t1.toString());
		
		KucniAparat k3 = t1;
		
		k3.ukljuciIskljuci();
	}

}
