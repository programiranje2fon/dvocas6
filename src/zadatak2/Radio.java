package zadatak2;

import zadatak1.KucniAparat;

public class Radio extends KucniAparat {

	private double frekvencija;

	public Radio(boolean ukljucen, String markaIModel, double frekvencija) {
		super(ukljucen, markaIModel);

		if ((frekvencija < 87.5) || (frekvencija > 107.9)) {
			System.out.println("Greska");
			this.frekvencija = 87.5;
		} else
			this.frekvencija = frekvencija;
	}

	public double getFrekvencija() {
		return frekvencija;
	}

	public void setFrekvencija(double frekvencija) {
		if ((frekvencija >= 87.5) && (frekvencija <= 107.9))
			this.frekvencija = frekvencija;
		else
			System.out.println("Greska");
	}

	@Override
	public String toString() {
		return "RADIO FREKVENCIJA: " + frekvencija + " Mhz";
	}

}
