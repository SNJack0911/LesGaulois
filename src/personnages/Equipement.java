package personnages;

public enum Equipement {
 CASQUE("Casque"),BOUCLIER("Bouclier");
	public String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	private Equipement(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

	
	
}
