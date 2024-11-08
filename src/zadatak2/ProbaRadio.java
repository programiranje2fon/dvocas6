package zadatak2;

public class ProbaRadio {

	public static void main(String[] args) {
		Radio r1 = new Radio(true, "Audio sistem Sony MHC", 96.2);
		
		System.out.println(r1.getFrekvencija());
		
		System.out.println(r1.toString());
	}
}
