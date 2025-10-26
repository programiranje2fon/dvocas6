package zadatak1;

public class KucniAparat {
	
	private boolean ukljucen;
	private String markaIModel;
	
	public KucniAparat(boolean ukljucen, String markaIModel) {
		this.ukljucen = ukljucen;
		this.markaIModel = markaIModel;
	}

	public void ukljuciIskljuci() {
		ukljucen = !ukljucen;
	}

	@Override
	public String toString() {
		return "MARKA I MODEL: " + markaIModel + " UKLJUCEN: " + ukljucen;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof KucniAparat)) {
			return false;
		}
		
		KucniAparat k = (KucniAparat) obj;
		
		return this.markaIModel.equals(k.markaIModel);
	}
}
