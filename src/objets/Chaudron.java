package objets;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public void remplirChaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public int prendrelouche() {
		int force = forcePotion;
		quantitePotion--;
		if (quantitePotion == 0) {
			forcePotion = 0;
		}

		return force;

	}
}
