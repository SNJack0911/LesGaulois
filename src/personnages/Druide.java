package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide"+nom+"et ma potion peut aller d'une force "+effetPotionMin
				+ " a "+effetPotionMax+".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}
	private String prendreParole() {
		return "Le druide"+nom+":";
	}
	public void preparerPotion() {
		Random potion=new Random();
		forcePotion= potion.nextInt(effetPotionMin,effetPotionMax);
		if (forcePotion>7) {
			parler("J'ai préparé\r\n"
					+ "une super potion de force "+forcePotion);
		}else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est\r\n"
					+ "seulement de force "+forcePotion);
		}
	}
	public void booster(Gaulois person) {
		if (person.getNom() == "Obelix") {
			parler("Non, Obélix !... Tu n’auras pas de potion\r\n"
					+ "magique !");
		}else {
			person.boirePotion(forcePotion);
		}
	}
	public static void main(String[] args) {
		Druide druide = new Druide(" Panoramix ",5,10);
		druide.preparerPotion();
	}
	@Override
	public String toString() {
		return "Druide [nom=" + nom + ", effetPotionMin=" + effetPotionMin + ", effetPotionMax=" + effetPotionMax
				+ ", forcePotion=" + forcePotion + "]";
	}
	
}
