package zadatak1;

public class Televizor extends KucniAparat {

	private int program;

	public Televizor(boolean ukljucen, String markaIModel, int program) {
		super(ukljucen, markaIModel);
		
		if ((program < 1) || (program > 40)) {
			System.out.println("GRESKA");
			this.program = 1;
		} else 
			this.program = program;
	}

	public void promeniProgram(int program) {
		if (program >= 1 && program <= 40) {
			this.program = program;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " PROGRAM: " + program;
	}
}
