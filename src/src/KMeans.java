import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class KMeans {
	public static ArrayList<Centroide> centroidList=new ArrayList<Centroide>();
	public static int[] occurences = {0,0,0,0,0,0,0,0,0};

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
	
	
	//Initialisation des centres des k clusters pour Kmeans
	void initCentroids() {
		double step=0.03;
		out.print(NbCenteroids);
		for (int kk=0;kk<k;kk++) {
			Centroide c=new Centroide();
			for(int i=0;i<NbCenteroids;i++) {
				double x=Math.pow(-1, kk);
				c.features.add(computeMoy(i)+(x*kk*step));
				//out.print(Double.toString(x*kk*step));
				//out.print("\n");
			}
			c.realClassToAssociateWith=-1;
			centroidList.add(c);
		}
		//out.print(k+"\n");

	}
	
	//Initialisation des cluster de façon semi supervisé
	void initCentroids(String s) {
		out.print(NbCenteroids);
		for (int kk=0;kk<k;kk++) {
			
			Centroide c=new Centroide();
					for(int j=0;j<NbCenteroids;j++) {
						c.features.add(computeMoy(j,kk+1));

					}
				
				//out.print(Double.toString(x*kk*step));
				//out.print("\n");
			
			c.realClassToAssociateWith=kk+1;
			c.classe=kk+1;
			centroidList.add(c);
			out.print(c.features.get(0)+"\n");
		}
		//out.print(k+"\n");
	}
	
	// Lancement de l'apprentissage
	void startTrain() {
		Boolean firstIteration=true;
		int I=0;
		while(isChanged) {// cette condition permet d'arreter l'algo en cas de stabilité sur les clusters
			I++;
			out.print("\n\n***----ITERATION--- "+I+" *** \n\n");
			isChanged=false;
			for (int i=0;i<Execute.trainVectors.size();i++) {
				if(firstIteration) {matriceDistance.add(new Distance());}
				for (int j=0;j<centroidList.size();j++) {
					double moyenne=centroidList.get(j).
							getManhattanDistance(Execute.trainVectors.get(i));
							//getCosineSimilarity(Execute.trainVectors.get(i));	
					//Le choix de distance se fait ici!
					
					if(firstIteration) {matriceDistance.get(i).distances.add(0.0);}
					matriceDistance.get(i).distances.set(j, moyenne);
				}
				matriceDistance.get(i).index=i;
				out.print("avant "+matriceDistance.get(i).cluster+"\t");
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
			//Ici on mets a jour les centre de cluster!
			Centroide.updateCentroids();
			
		}
	}

	// sauvgarder les clusters obtenus, avec leurs centres ..
	@SuppressWarnings("unchecked")
	void saveModel() {
		Collections.sort(Execute.trainVectors);
		for(int i=0;i<Execute.trainVectors.size();i++) {
			out.println("-->"+Execute.trainVectors.get(i).assignClass);
		}
		int counter=1;
		int currentClass=Execute.trainVectors.get(0).assignClass;
		//int nextClass;

		for(int i=0;i<Execute.trainVectors.size();i++) {
			occurences[Execute.trainVectors.get(i).assignClass-1]++;
		}
		for(int i=0;i<occurences.length;i++) {
			out.println(occurences[i]);
		}
		for(int i=0;i<=Execute.testVectors.size();i++) {
			
		}

	}


	
	//primitives
	double computeMoy(int n) {
		return (sumColonne(n,NbrTrainEntries)/NbrTrainEntries);
	}
	double computeMoy(int n, int classe) {
		int nbr=0;
		for(int i=0;i<Execute.trainVectors.size();i++) {
			if(Execute.trainVectors.get(i).classe==classe) {
				nbr++;
			}
		}
		return (sumColonne(n,nbr,classe)/nbr);
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

	double sumColonne(int n,int nbr, int classe) {
		double somme=0;
		
		for(int i=0;i<Execute.trainVectors.size();i++) {
			
			//tuple i, la valeur n
			if(Execute.trainVectors.get(i).classe==classe) {
			somme=somme+Execute.trainVectors.get(i).features.get(n);
			}
			if(Execute.trainVectors.get(i).classe>classe) {
				break;
			}
		}
		//out.print("\n"+somme);
		return somme;

	}

	
	
}
