package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private int nbVillageoisMaximum;
	private Gaulois[] villageois;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Village(String nom, Chef chef, int nbVillageois, int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		this.nbVillageois = 0;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		villageois= new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois+=1;
	}
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	public void afficherVillage(Village village) {
		System.out.println("Dans village du chef "+village.chef.getNom()+" vivent les legendaires gaulois :");
		for (int i=0; i<village.nbVillageois;i++) {
			System.out.println("- "+village.trouverHabitant(i).getNom());
		}
	}
	public static void main(String[] args) {
		Chef chef = new Chef("Abraracourcix",6,1, null);
		Village village = new Village("Village des Irreductibles",chef,0,30);
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelisk = new Gaulois("Obelisk",25);
		village.setChef(chef);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelisk);
		village.afficherVillage(village);
	}
	
}
