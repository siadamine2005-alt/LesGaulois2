package personnages;

import objets.Equipement;
import objets.Musee;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];

	public void setVillage(Village village) {
		this.village = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force * effetPotion / 3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + "Je voyage de villages en villages");
		} else if (this.equals(village.getChef())) {
			System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom
					+ ". Je suis le chef du village " + village.getNom() + ".\"");
		} else {
			System.out.println("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". J'habite le village "
					+ village.getNom() + ".\"");
		}

	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0) {
			parler("« Je donne au musee tous mes trophees : ");
			for (int i = 0; i < nbTrophees; i++) {
				System.out.println(trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
			}
			System.out.println(">>");
			nbTrophees = 0;
		}
	}

	public void exempleTrophee() {
		Equipement[] trophee = { Equipement.BOUCLIER, Equipement.CASQUE, Equipement.CASQUE };
		trophees = trophee;
		nbTrophees = 3;
	}
}
