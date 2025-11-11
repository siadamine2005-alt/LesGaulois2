package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public boolean vainqueur() {
		return vainqueur;
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

//	public void recevoirCoup(int forceCoup) {
//		int forceAvant = force;
//		force -= forceCoup;
//		if (force < 1) {
//			force = 0;
//			parler("J'abandonne !");
//		} else {
//			parler("Aie");
//		}
//
//	}

	public Equipement[] recevoirCoup(int forceCoup) {

		Equipement[] equipementEjecte = null;
		if (vainqueur) {
			parler("je suis déjà vainque !");
		} else {
			forceCoup = calculResistanceEquipement(forceCoup);
			assert forceCoup > 0;
			int forceAvant = force;
			force -= forceCoup;
			if (force < 1) {
				force = 0;
				vainqueur = true;
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			} else {
				parler("Aïe");
			}
			assert force < forceAvant;
			assert isInvariantVerified();
		}

		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null)) {
					resistanceEquipement += equipements[i].equals(Equipement.BOUCLIER) ? 8 : 5;
					System.out.println("Equipement " + equipements[i]);
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup < 2 ? 1 : forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {

				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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

	public int getForce() {
		return force;
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
