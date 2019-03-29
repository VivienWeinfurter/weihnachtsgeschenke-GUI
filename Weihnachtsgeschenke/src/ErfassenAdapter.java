import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ErfassenAdapter extends SelectionAdapter {

	// Attributvariablen
	private Steuerungsfenster fenster;

	// Konstruktor
	public ErfassenAdapter(Steuerungsfenster fenster) {
		super();
		this.fenster = fenster;
	}

	public void widgetSelected(SelectionEvent arg0) {
		// Ruft die Methode erfassen() in der Klasse Steuerungsfenster auf
		fenster.erfassen();

	}

}
