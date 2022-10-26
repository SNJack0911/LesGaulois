package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements =0;
	public Romain(String nom, int force,int nbEquipements ) {
		this.nom = nom;
		this.force = force;
		this.nbEquipements=nbEquipements;
		equipements= new Equipement[2];
		assert force>0;
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}

	private String prendreParole() {
		return "Le romain "+nom +":";
	}
	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int initForce=force;
		force -=forceCoup;
		assert initForce>force;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne");
		}
	}
	
	public void sEquiper( Equipement equipement) {
		switch ( nbEquipements ) {
		case 2:
			System.out.println("Le soldat "+nom+" est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement){
				System.out.println("Le soldat "+nom+" possede deja un "+equipement.nom);
				break;
			}
		default:
			equipements[nbEquipements]=equipement;
			nbEquipements+=1;
			System.out.println("Le soldat "+nom+" s'equipe avec un "+equipement.nom);
		}
	}
	
	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6,0);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
}
