package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}
	private String prendreParole() {
		
		return "Le Gaulois" +nom + ":";
	}
	public void frapper(Romain romain) {
		System.out.println(nom +"evoie un grand coup dans la machoire de" +romain.getNom());
		romain.recevoirCoup(force/3);
	}
	
	public static void main(String[] args) {
		//Todo create a main able to test the class Gaulois
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
}


