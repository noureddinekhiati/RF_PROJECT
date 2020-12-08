import java.util.ArrayList;
import static java.lang.System.out;

public class Execute {
	//BASE DE DONNEES GENERALES ACCESSIBLES PAR TOUS LES ALGORITHMES
	public static ArrayList<Features> trainVectors= new ArrayList<Features>();
	public static ArrayList<Features> testVectors= new ArrayList<Features>();
	public static Normalisation NE34=new Normalisation();
	public static Normalisation NF0=new Normalisation();
	public static Normalisation NGFD=new Normalisation();
	public static Normalisation NSA=new Normalisation();
	public static int k=9;
	public static int nbr_class=9;
	public static void main(String[] args) {
	//Process data est l'etape de lire les donn�es, 
	//les charger et repartir en train et en test
	//d'initialiser les classes et les caracteristiques
		ProcessData.main(null);
		
		
	//dans cette etapes on construit le vecteur des caract�ristiques
	//ces vecteurs seront repartis en train et en test (7-4)
	//on aura donc 2 tableaux de vecteurs, d'ou �a fera une matrice
	//de taille= nombre_dechantillon * nombre des caract�ristiques
	//on fait aussi en sortie de normaliser les valeurs entre 0 et 1
		Features.extractFeatures();
	//out.println(trainVectors);
	//On initialise l'algorithme KMeans � 9 classes
		
		
	/*INITIALISATION DE KMEANS*/
		//KMeans KM = new KMeans(9);
		
	//Kmean naif:
			//On initialise les centroides selon la moyenne
		//KM.initCentroids();
		
	//Kmean semi supervis�:
		
			//On initialise les centroides selon la moyenne des classes en informant 
			//l'algorithme
		//KM.initCentroids("semi supervis�");
	//Lancement du mod�le d'apprentissage
		//KM.startTrain();
	//Sauvgarder les r�sultats des clusters obtenus
		//KM.saveModel();
		
	//Charger les donn�es de test, �valuer et afficher
		//Evaluate.testLaunchKM();
	
		
	//
		k=3;
		KNN knn=new KNN(k);
		knn.initAllDistances(k);
		knn.predict(k);
	}

}
