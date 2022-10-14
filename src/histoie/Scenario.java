package histoie;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Asterix", 8);
		Romain minus = new Romain ("Minus",6);
		Druide druid = new Druide ("Panoramix",5,10);
		Gaulois obelix= new Gaulois("Obelix",100);
		druid.parler("Je vais aller préparer une petite potion...");
		druid.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.parler("Bonjour a tous");
		minus.parler("UN GAU.... UN GAUGAU...");
		asterix.frapper(minus);

		asterix.frapper(minus);

		asterix.frapper(minus);
		

	}

}
