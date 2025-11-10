package personnages;

import java.time.chrono.MinguoChronology;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceAvant = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aie");
		}

		assert force < forceAvant;
		assert isInvariantVerified();
	}

	public static void main(String args[]) {

		Romain minus = new Romain("Minus", 6);

	}
}
