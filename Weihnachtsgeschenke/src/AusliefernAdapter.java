import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AusliefernAdapter extends SelectionAdapter {

	// Attributvariablen
	private Steuerungsfenster fenster;

	// Konstruktor
	public AusliefernAdapter(Steuerungsfenster fenster) {
		super();
		this.fenster = fenster;
	}

	public void widgetSelected(SelectionEvent arg0) {
		// Ruft die Methode ausliefern() in der Klasse Steuerungsfenster auf
		fenster.ausliefern();
	}

}
