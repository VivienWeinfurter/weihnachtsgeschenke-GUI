import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;

public class Steuerungsfenster {

	// Attributvariablen
	protected Shell shell;
	private Text textName;
	private Text textGeschenk;
	private Text textSchlitten;

	private Combo comboLand;
	private Combo comboAusliefern;

	// Initialisierung der Attributvariable mittels Aufruf des Konstruktors
	private ArrayList<Geschenk> geschenkeListe = new ArrayList<Geschenk>();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Steuerungsfenster window = new Steuerungsfenster();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Weihnachtsgeschenkelieferung");
		shell.setLayout(new GridLayout(2, false));

		Label lblGeschenkeErfassen = new Label(shell, SWT.NONE);
		lblGeschenkeErfassen.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeschenkeErfassen.setAlignment(SWT.RIGHT);
		lblGeschenkeErfassen.setText("Geschenke erfassen:");
		new Label(shell, SWT.NONE);

		Label lblName = new Label(shell, SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name:");

		textName = new Text(shell, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblGeschenk = new Label(shell, SWT.NONE);
		lblGeschenk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeschenk.setAlignment(SWT.RIGHT);
		lblGeschenk.setText("Geschenk:");

		textGeschenk = new Text(shell, SWT.BORDER);
		textGeschenk.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblLand = new Label(shell, SWT.NONE);
		lblLand.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLand.setAlignment(SWT.RIGHT);
		lblLand.setText("Land:");

		comboLand = new Combo(shell, SWT.NONE);
		comboLand.setItems(
				new String[] { "China", "Deutschland", "England", "Finnland", "Frankreich", "Spanien", "USA" });
		comboLand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);

		Button btnGeschenkeErfassen = new Button(shell, SWT.NONE);
		btnGeschenkeErfassen.setText("Geschenke erfassen");
		/*
		 * Listener Objekt der Klasse ErfassenAdapter wird erstellt
		 */
		btnGeschenkeErfassen.addSelectionListener(new ErfassenAdapter(this));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		Label lblGeschenkeAusliefern = new Label(shell, SWT.NONE);
		lblGeschenkeAusliefern.setAlignment(SWT.RIGHT);
		lblGeschenkeAusliefern.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeschenkeAusliefern.setText("Geschenke ausliefern:");
		new Label(shell, SWT.NONE);

		Button btnAusliefernFr = new Button(shell, SWT.NONE);
		btnAusliefernFr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAusliefernFr.setText("ausliefern für:");
		/*
		 * Listener. Objekt der Klasse AusliefernAdapter wird erstellt
		 */
		btnAusliefernFr.addSelectionListener(new AusliefernAdapter(this));

		comboAusliefern = new Combo(shell, SWT.NONE);
		comboAusliefern.setItems(
				new String[] { "China", "Deutschland", "England", "Finnland", "Frankreich", "Spanien", "USA" });
		comboAusliefern.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSchlittengre = new Label(shell, SWT.NONE);
		lblSchlittengre.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSchlittengre.setAlignment(SWT.RIGHT);
		lblSchlittengre.setText("Schlittengröße:");

		textSchlitten = new Text(shell, SWT.BORDER);
		textSchlitten.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textSchlitten.setText("-");

	}

	public void erfassen() {
		String name, geschenkeart, land;
		// Eigegebene Werte aus dem GUI werden gelesen
		name = textName.getText();
		geschenkeart = textGeschenk.getText();
		land = comboLand.getText();

		// Ein entsprechendes Objekt der KLasse Geschenk wird erzeugt
		Geschenk g = new Geschenk(geschenkeart, name, land);
		// Objekt wird der geschenkeListe zugeordnet
		geschenkeListe.add(g);
	}

	public void ausliefern() {

		String ausliefernLand;
		// Ermittelt die Auswahl des Landes
		ausliefernLand = comboAusliefern.getText();
		// Ermittelt die Anzahl der aktuell enthaltenden Elemente
		int laenge = geschenkeListe.size();
		int count = 0;
		/*
		 * Mittels einer for Schleife wird die geschenkeListe durchlaufen und die Anzahl
		 * der Geschenke gezählt
		 */

		for (int i = 0; i < laenge; i++) {
			Geschenk g = geschenkeListe.get(i);

			// Nur für das angegebene Land wird die Methode gebeGeschenkAus() ausgeführt
			if (g.getLand().equals(ausliefernLand)) {
				g.gebeGeschenkAus();
				count++;

			}
			// Schlittengröße wird ermittelt
			if (count <= 3 && count > 0) {
				textSchlitten.setText("Klein");
			} else if (count == 0) {
				textSchlitten.setText("-");
			} else {
				textSchlitten.setText("Groß");
			}
		}
	}

}
