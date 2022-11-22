package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}


	private String nom;
	private int force;
	private int nbTrophees=0;
	private int effetPotion = 1;
	private Equipement[] newTrophe = new Equipement[100];

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	// private String prendreParole() {
	// 	return "Le Gaulois " + nom + ":";
	// }
 
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	// public void frapper(Romain romain) {
	// 	System.out.println(nom + " evoie un grand coup dans la machoire de " + romain.getNom());
	// 	romain.recevoirCoup((force / 3)*effetPotion);
	// }

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
			newTrophe[nbTrophees] = trophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		parler(" Merci Druide, je sens que ma force est "+ forcePotion+" décuplée."
					+ "");
		effetPotion=forcePotion;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		System.out.println(asterix);
		asterix.boirePotion(2);
	}
	
	public void faireUneDonnation(Musee musee) {
		if (newTrophe != null) {
			System.out.println("Le gaulois Astérix : « Je donne au musee tous mes trophees :");
			for(int i =0; i<=nbTrophees && newTrophe[i]!= null ;i++) {
				musee.donnerTrophee(this, newTrophe[i]);
				System.out.println("- " + newTrophe[i]);
			}
			nbTrophees=0;
		}
			
	}
	
	
	@Override
	public String toString() { 
		return "Gaulois [nom=" + nom +", force=" + force + ", effetPotion=" + effetPotion + "]"; }
	
}
