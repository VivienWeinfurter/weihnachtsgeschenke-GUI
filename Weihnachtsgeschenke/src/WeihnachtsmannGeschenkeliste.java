
//Import der ArrayList
import java.util.ArrayList;

public class WeihnachtsmannGeschenkeliste {

	// Attributvariable
	private ArrayList<Geschenk> geschenkeListe;

	// Konstruktor
	public WeihnachtsmannGeschenkeliste() {
		super();
		geschenkeListe = new ArrayList<Geschenk>(); // Initialisierung der Variablen
	}

	public void fuegeGeschenkeHinzu(Geschenk g) {
		// ordnet g der geschenkeliste zu
		geschenkeListe.add(g);
	}

	public void ausgeben() {
		// lokale Hilfsvariablen
		int i = 0;
		int laenge = geschenkeListe.size();

		/*
		 * while Schleife Alle Geschenke der Liste werden durchlaufen und für jedes
		 * Element wird die Methode gebeGeschenkAus() aufgerufen
		 */
		while (i < laenge) {
			Geschenk g0 = geschenkeListe.get(i);
			g0.gebeGeschenkAus();
			i++;
		}

		/*
		 * do-while Schleife Macht das gleiche wie die while Schleife Nun wird die Liste
		 * zweimal ausgegeben
		 */
		do {
			Geschenk g1 = geschenkeListe.get(i);
			g1.gebeGeschenkAus();
			i++;
		} while (laenge > i);

		// for Schleife
		for (i = 0; i < laenge; i++) {
			Geschenk g2 = geschenkeListe.get(i);
			// Ausgabe erfolgt aber nur für Finnland
			if (g2.getLand().equals("Finnland")) {
				g2.gebeGeschenkAus();
			}
		}

		// for-each Schleife
		for (Geschenk g3 : geschenkeListe) {
			g3.gebeGeschenkAus();
		}
	}

	public static void main(String[] args) {
		// Ein Objekt der Klasse WeihnachtsmannGeschenkeliste wird erstellt
		WeihnachtsmannGeschenkeliste gl = new WeihnachtsmannGeschenkeliste();

		// Objekte der Klasse Geschenk werden erstellt und der Arraylist hinzugefügt
		gl.fuegeGeschenkeHinzu(new Geschenk("Dreirad", "Clara", "Finnland"));
		gl.fuegeGeschenkeHinzu(new Geschenk("Drachen", "Matthew", "USA"));
		gl.fuegeGeschenkeHinzu(new Geschenk("Fahrrad", "Linda", "Deutschland"));
		gl.fuegeGeschenkeHinzu(new Geschenk("PlayStation", "Hung", "China"));
		gl.fuegeGeschenkeHinzu(new Geschenk("Farbstifte", "Jussi", "Finnland"));

		// Liste wird ausgegeben
		gl.ausgeben();

	}

}