package personnages;

import java.util.Arrays;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee newTrophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee]=newTrophee;
		nbTrophee++;
	}
	
	@Override
	public String toString() {
		return "Musee " + Arrays.toString(trophees) + "]";
	}

	private String list="";
	public String extraireInstructionsCaml() {
		for (int i = 0; i<=nbTrophee && trophees[i]!= null;i++) {
			list += "     "+trophees[i].getGaulois().getNom()+","+ trophees[i].getEquipement().nom+";\n";
		}
		return "let musee = [ \n" + list +" ]";
	}
	
	
	
	
	
}

