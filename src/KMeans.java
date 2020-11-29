import java.util.ArrayList;
import static java.lang.System.out;

public class KMeans {
	public static ArrayList<Centroide> centroidList=new ArrayList<Centroide>();
	//nombre de classe
	// récuperer le nombre de centroids
	int NbCenteroids=Execute.trainVectors.get(0).features.size();
	public static Boolean isChanged=true;

	// nombre de tuples
	int NbrTrainEntries=Execute.trainVectors.size();
	int k;
	public static ArrayList<Distance> matriceDistance=new ArrayList<Distance>(Execute.trainVectors.size());
	public KMeans(int k) {
		this.k=k;
	}
	void initCentroids() {
		double step=0.005;
		out.print(NbCenteroids);
		for (int kk=0;kk<k;kk++) {
			Centroide c=new Centroide();
			for(int i=0;i<NbCenteroids;i++) {
				double x=Math.pow(1, kk);
				c.features.add(computeMoy(i)+(x*kk*step));
				//out.print(Double.toString(x*kk*step));
				//out.print("\n");
			}
			centroidList.add(c);
		}
		//out.print(k+"\n");

	}
	
	double computeMoy(int n) {
		return (sumColonne(n,NbrTrainEntries)/NbrTrainEntries);
	}
	
	double sumColonne(int n,int nbr) {
		double somme=0;
		for(int i=0;i<nbr;i++) {
			//tuple i, la valeur n
			somme=somme+Execute.trainVectors.get(i).features.get(n);
		}
		//out.print("\n"+somme);
		return somme;

	}
	
	
	void startTrain() {
		Boolean firstIteration=true;
		int I=0;
		while(isChanged) {
			I++;
			out.print("\n\n***----ITERATION--- "+I+" *** \n\n");
			isChanged=false;
			for (int i=0;i<Execute.trainVectors.size();i++) {
				if(firstIteration) {matriceDistance.add(new Distance());}
				for (int j=0;j<centroidList.size();j++) {
					double moyenne=centroidList.get(j).
							getManhattanDistance(Execute.trainVectors.get(i));					
					if(firstIteration) {matriceDistance.get(i).distances.add(0.0);}
					matriceDistance.get(i).distances.set(j, moyenne);
				}
				matriceDistance.get(i).index=i;
				//out.print("avant "+matriceDistance.get(i).cluster+"\t");
				matriceDistance.get(i).updateCluster();
				//out.print("après "+matriceDistance.get(i).cluster+"\n");

			}
			firstIteration=false;
			for (Distance dis : matriceDistance) {
				out.print(dis.index+" ");
				for(Double val:dis.distances) {
					out.print(val+" ");
				}
				out.print("\n");

			}
			out.print("END");
			Centroide.updateCentroids();
			
		}
	}
}
