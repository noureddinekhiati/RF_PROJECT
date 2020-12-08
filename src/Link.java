import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.out;

public class Link {
	public Features tested;
	public ArrayList<Voisin> nearestNeighbors=new ArrayList<Voisin>();
	public int assignClass;
	
	public void electClass() {
		int occ[]= {0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < nearestNeighbors.size(); i++) {
			occ[nearestNeighbors.get(i).f.classe-1]++;
		}
		int max=0;
		int classe=0;
		int nbr_de_max=0;
		for (int i=0;i<occ.length;i++) {
			if(occ[i]>max) {nbr_de_max=1;max=occ[i];classe=i+1;}
			else {
				if(occ[i]==max)nbr_de_max++;
			}
		}
		if(nbr_de_max!=1) {
			this.assignClass= nearestNeighbors.get(0).f.classe;
			
			
		}else {
			this.assignClass= classe;
		}
		
	}
	@SuppressWarnings("unchecked")
	public void addNeighbor(Features f, double dist,int k) {
		
		//out.println(nearestNeighbors.size()<k);
		if(nearestNeighbors.size()<k) {
			nearestNeighbors.add(new Voisin(f, dist));
		}
		else 
		{
			int index=nearestNeighbors.size()-1;
			if(dist<nearestNeighbors.get(index).dist) {
				nearestNeighbors.remove(index);
				nearestNeighbors.add(new Voisin(f,dist));
			}
		}
		Collections.sort(nearestNeighbors);

		//out.println("size:"+nearestNeighbors.size());
		for (Voisin voisin : nearestNeighbors) {
			out.print(voisin.dist+"\t");
		}
		//out.print(";");
		
		//nearestNeighbors.add(new Voisin(f, dist));
		//out.println("size:"+nearestNeighbors.size());
		
		
		

	}
}
