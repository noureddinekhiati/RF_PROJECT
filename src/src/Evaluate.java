import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class Evaluate {
	public static ArrayList<Distance> matriceDistance=new ArrayList<Distance>(Execute.testVectors.size());
	public static int  matriceConfusion[][]= new int[20][20];
	public static double  evaluationMC[][]= new double[20][20];
	
	public static void testLaunchKM() {
		
		for(int x=0;x<Execute.k;x++) {
			for(int y=0;y<Execute.k;y++) {
				matriceConfusion[x][y]=0;
			}
		}
		
		
		for (int i=0;i<Execute.testVectors.size();i++) {
			matriceDistance.add(new Distance());
			for (int j=0;j<KMeans.centroidList.size();j++) {
				double moyenne=KMeans.centroidList.get(j).
						getManhattanDistance(Execute.testVectors.get(i));					
					matriceDistance.get(i).distances.add(0.0);
					matriceDistance.get(i).distances.set(j, moyenne);
			}
		}
		out.println("\n*--------AFFICHAGE MATRICE DISTANCE--------*");
		
		for(int i=0;i<matriceDistance.size();i++) {
			
			out.print("\n\n\ni\\C\t");
			for(int iii=0;iii<Execute.k;iii++) {
			
					out.print("C"+(iii+1)+"\t|");
					
				
			}
			out.print("  min\t|");
			out.print("Clu élu\t|\n");
			double min=Collections.min(matriceDistance.get(i).distances);
			int c=matriceDistance.get(i).distances.indexOf(min)+1;
			for(int j=0;j<matriceDistance.get(i).distances.size();j++) {

				
				if(j==0) {
				out.print("N°"+i+"\t");
				}
				out.print(matriceDistance.get(i).distances.get(j)+"\t|");
				
				
				
			}
			out.print(min+"\t|"+c+"\t|");
			out.print("\n");
			//out.println(KMeans.occurences[c-1]);
			int k=Math.max(0, c-1);
			int s=0;
			for(int ii=0;ii<c-1;ii++) {
				
				 s+=KMeans.occurences[ii];
			}
			int deb=s;
			int fin=s+KMeans.occurences[c-1]-1;
			double min_dist=999;
			int min_class=0;
			if(KMeans.centroidList.get(c-1).realClassToAssociateWith==-1) {
				//pour faire le calcul d'une classe UNE SEULE FOIS
				for(int ii=deb;ii<=fin;ii++) {
					double d=Execute.testVectors.get(i).getManhattanDistance(
							Execute.trainVectors.get(deb)
							);
					if(d<min_dist) {
						min_class=Execute.trainVectors.get(deb).classe;
						min_dist=d;
					}
					out.print("\n--||->min=\n\n\n\n"+min_class);

				}
				KMeans.centroidList.get(c-1).realClassToAssociateWith=min_class;
			}
			out.println("Ce vecteur est de classe: "+
						Execute.testVectors.get(i).classe
						+ " est classifié avec ce modèle en classe: "
						+ KMeans.centroidList.get(c-1).realClassToAssociateWith
						);
			matriceConfusion[Execute.testVectors.get(i).classe-1][KMeans.centroidList.get(c-1).realClassToAssociateWith-1]++;
			//out.println("deb: "+ deb+" fin: "+fin);
			
		}
		
		//Affichage de la matrice de Confusion

		displayTestResults();
		
		
		
	}
	
	
	
	public static void  displayTestResults() {
		out.println("\n*--------AFFICHAGE MATRICE CONFUSION--------*\n\n\n");

		for(int x=0;x<Execute.nbr_class;x++) {
			if(x==0) {
				out.print("\t|");
			}
			out.print("C"+(x+1)+"\t|");
		}
		out.print("TRec\t|TConf\t|");
		out.print("\n");
		for(int x=0;x<Execute.nbr_class;x++) {
			out.print("C"+(x+1)+"\t|");
			for(int y=0;y<Execute.nbr_class;y++) {
				out.print(matriceConfusion[x][y]+"\t|");
			}
			double nbr_elts_bien_rec=matriceConfusion[x][x];
			double nbr_elts_test=sumLine(matriceConfusion, x);
			double nbr_elts_mal_rec=nbr_elts_test-nbr_elts_bien_rec;
			double Trec=nbr_elts_bien_rec/nbr_elts_test;
			double Tconf=nbr_elts_mal_rec/nbr_elts_test;
			out.print(	(double) Math.round(Trec * 100) / 100  +"\t|"
					+	(double) Math.round(Tconf * 100) / 100  +"\t|");
			out.print("\n");
		}
			//out.print("C"+(x+1)+"\t|");
				double nbr_elts_bien_rec=sumDiag(matriceConfusion);
				double nbr_elts_test=sumArray(matriceConfusion,Execute.nbr_class);
				double nbr_elts_mal_rec=nbr_elts_test-nbr_elts_bien_rec;
				double Trec=nbr_elts_bien_rec/nbr_elts_test;
				double Tconf=nbr_elts_mal_rec/nbr_elts_test;

				out.print("\nTaux de reconnaissance Totale=\t\t||Elts bien reconnus||÷"
						+ "||Elts Testés||\n\t\t\t\t="+(double) Math.round(Trec * 100) / 100);

				out.print("\nTaux de confusion Totale=\t\t||Elts mal reconnus||÷"
						+ "||Elts Testés||\n\t\t\t\t="+(double) Math.round(Tconf * 100) / 100);

		
		
		
	}
	
	
	
	
	public static double sumLine(int mat[][],int line) {
		int len=mat[0].length;
		double s=0;
		for (int i = 0; i < len; i++) {
			s=s+mat[line][i];
		}
		
		return s;
	}
	
	public static double sumCol(int mat[][],int col) {
		int len=mat.length;
		double s=0;
		for (int i = 0; i < len; i++) {
			s=s+mat[i][col];
		}
		
		return s;
	}
	public static double sumDiag(int mat[][]) {
		int len=mat.length;
		double s=0;
		for (int i = 0; i < len; i++) {
			s=s+mat[i][i];
		}
		
		return s;
	}

	public static double sumArray(int mat[][], int n) {
		double s=0;
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < n; j++) {
				s+=mat[i][j];
			}
		}
		
		return s;
	}
}
