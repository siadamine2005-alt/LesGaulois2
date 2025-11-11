package objets;

import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee++;
	}

	public String extraireInstructionsOCaml() {
		String expr = "let musee = [ \n";
		for (int i = 0; i < nbTrophee - 1; i++) {
			expr += ("\t\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\";\n");
		}

		expr += ("\t\"" + trophees[nbTrophee - 1].donnerNom() + "\", \"" + trophees[nbTrophee - 1].getEquipement()
				+ "\"\n]");
		return expr;
	}

	public static void main(String args[]) {
		Musee musee = new Musee();
		Gaulois gaulois = new Gaulois("Astérix", 8);
		gaulois.exempleTrophee();
		gaulois.faireUneDonnation(musee);

		System.out.println(musee.extraireInstructionsOCaml());
	}
}