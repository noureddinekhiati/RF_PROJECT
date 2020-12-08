import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.out;
import java.lang.reflect.Array;
public class Centroide extends Features {
	//int n=1;
	int realClassToAssociateWith;


	
	
	public static void updateCentroids(){
		int nbr;
		for (int i=0;i<KMeans.centroidList.size();i++) {
			nbr=1;
			for (int j=0;j<Execute.testVectors.size();j++) {
				if(KMeans.centroidList.get(i).classe==Execute.testVectors.get(j).assignClass) {
					for(int k=0;k<KMeans.centroidList.get(i).features.size();k++) {
						//out.print("\n"+center.features.get(i));
						(KMeans.centroidList.get(i).features).set(i,KMeans.centroidList.get(i).features.get(k)+Execute.testVectors.get(j).features.get(k));						
					}
					
					nbr++;
				}

			}
			for(int m=0;m<(KMeans.centroidList.get(i).features).size();m++) {
				(KMeans.centroidList.get(i).features).set(i, (KMeans.centroidList.get(i).features).get(m)/nbr);
				//(center.features).set(i, 0.0);
			}		

		}
		
		
	}
	public static void displayCenters() {
		for (int i = 0; i < KMeans.centroidList.size(); i++) {
			for (int j = 0; j < KMeans.centroidList.get(i).features.size(); j++) {
				//out.print(KMeans.centroidList.get(i).features.get(j)+"\t|");
			}
		}
	}
}
