import java.util.ArrayList;
import static java.lang.System.out;

public class KNN {
	public int k;
	public static ArrayList<Link> links = new ArrayList<Link>();
	
	
	
	public KNN(int k) {
		this.k=k;
	}
	
	@SuppressWarnings("static-access")
	public void initAllDistances(int k)  {
		for (int i = 0; i < Execute.testVectors.size(); i++) {
			Features T=Execute.testVectors.get(i);
			Link l=new Link();
			for (int j = 0; j < Execute.trainVectors.size(); j++) {
				Features Neighbor=Execute.trainVectors.get(j);
				double dist=T.getManhattanDistance(Neighbor);
				l.addNeighbor(Neighbor, dist,k);
				
			}
			l.tested=T;
			l.tested.classe=T.classe;
			links.add(l);
		}
		
	}
	public void predict(int k) {
		for (int i = 0; i < links.size(); i++) {
			Link l=links.get(i);
			l.electClass();
		}
		displayResults();
	}
	
	
	public void displayResults() {
		Evaluate.matriceConfusion=new int[20][20];
		for (int i = 0; i < links.size(); i++) {
			
		 
			//out.println(links.size());
			Link link=links.get(i);
			out.println("Ce vecteur est de classe: "+
					link.tested.classe
					+ " est classifié avec ce modèle KNN en classe: "
					+ link.assignClass
					);
			out.print("("+(link.tested.classe)+","+link.assignClass+")");
			Evaluate.matriceConfusion[link.tested.classe-1][link.assignClass-1]++;

		}
		Evaluate.displayTestResults();

	}
}
