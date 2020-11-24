import java.util.ArrayList;
import static java.lang.System.out;

public class Execute {
	public static ArrayList<Features> trainVectors= new ArrayList<Features>();
	public static ArrayList<Features> testVectors= new ArrayList<Features>();
	public static Normalisation NE34=new Normalisation();
	public static Normalisation NF0=new Normalisation();
	public static Normalisation NGFD=new Normalisation();
	public static Normalisation NSA=new Normalisation();
	int k=9;
	public static void main(String[] args) {
		//Process data est l'etape de lire les données, 
		//les charger et repartir en train et en test
		//d'initialiser les classes et les caracteristiques
		ProcessData.main(null);
		
		
		//dans cette etapes on construit le vecteur des caractéristiques
		//ces vecteurs seront repartis en train et en test
		//on aura donc 2 tableaux de vecteurs, d'ou ça fera une matrice
		//de taille= nombre_dechantillon * nombre des caractéristiques
		//on fait aussi en sortie de normaliser les valeurs entre 0 et 1
		Features.extractFeatures();
		//out.println(trainVectors);
		KMeans KM = new KMeans(9);
		out.print("hi");
		KM.initCentroids();
		out.print("end");
		KM.startTrain();
	}

}
