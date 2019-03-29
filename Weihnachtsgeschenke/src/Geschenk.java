
public class Geschenk {
	// Attributvariablen
	// Hier werden die Attribute deklariert
	private String geschenkeart;
	private String name;
	private String land;

	// Konstruktor deklarieren
	public Geschenk(String geschenkeart, String name, String land) {
		this.geschenkeart = geschenkeart;
		this.name = name;
		this.land = land;
	}

	// Methode gibt Geschenk aus
	public void gebeGeschenkAus() {
		System.out.println(name + " lebt in " + land + " und bekommt ein(e/n) " + geschenkeart + ".");
	}

	// getter-Methode: liefert das Land
	public String getLand() {
		return land;
	}

	// Objekt erstellen und Methode gebeGeschenkAus() anwenden
	public static void main(String[] args) {
		Geschenk g1 = new Geschenk("Dreirad", "Clara", "Finnland");
		g1.gebeGeschenkAus();
	}

}
