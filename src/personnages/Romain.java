package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements =0;
	private String texte;
	
	public Romain(String nom, int force ) {
		this.nom = nom;
		this.force = force;
		equipements= new Equipement[2];
	}
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}

	public int getNbEquipements() {
		return nbEquipements;
	}


	public String getTexte() {
		return texte;
	}

	private String prendreParole() {
		return "Le romain "+nom +":";
	}
	// public void recevoirCoup(int forceCoup) {
	// 	assert force>0;
	// 	int initForce=force;
	// 	force -=forceCoup;
	// 	assert initForce>force;
	// 	if (force>0) {
	// 		parler("Aie");
	// 	} else {
	// 		parler("J'abandonne");
	// 	}
	// }
	
	public void sEquiper( Equipement equipement) {
		switch ( nbEquipements ) {
		case 2:
			System.out.println("Le soldat "+nom+" est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement){
				System.out.println("Le soldat "+nom+" possede deja un "+equipement.nom);
			}else {
				equipements[nbEquipements]=equipement;
				nbEquipements+=1;
				System.out.println("Le soldat "+nom+" s'equipe avec un "+equipement.nom);
			}break;
		default:
			equipements[nbEquipements]=equipement;
			nbEquipements+=1;
			System.out.println("Le soldat "+nom+" s'equipe avec un "+equipement.nom);
			break;
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		if (force > 0) {
//				parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		if (force>0) {
			equipementEjecte = ejecterEquipement();
			parler("Aïe");
		}else {
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipements;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + " !";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements ; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		nbEquipements=0;
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
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
