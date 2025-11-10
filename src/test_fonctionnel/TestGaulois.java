package test_fonctionnel;

import java.awt.dnd.DragGestureEvent;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String args[]) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);

		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");

		Romain minus = new Romain("Minus", 6);

		System.out.println("Dans la forêt Astérix et Obélix tombent nez à nez sur le romain Minus.");

		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		
		panoramix.fabriquerPotion(4, 2);
		
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}
}
