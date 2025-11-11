package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement);
			} else {
				equiperRomain(equipement);
			}
			break;
		case 0:
			equiperRomain(equipement);
		}

	}

	private void equiperRomain(Equipement equipement) {
		System.out.println("Le soldat " + nom + "  s’équipe avec un " + equipement);
		equipements[nbEquipement] = equipement;
		nbEquipement++;
	}

	public static void main(String args[]) {

		Romain minus = new Romain("Minus", 6);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
