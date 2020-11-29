import java.util.ArrayList;
import static java.lang.System.out;
import java.lang.reflect.Array;
public class Centroide extends Features {
	//int n=1;
	

	double getManhattanDistance(Features c) {
		double s=0;
		
		for(int i=0;i<this.features.size();i++) {
			//out.print("\n"+c.id+ ": "+this.features.get(i)+"-"+c.features.get(i)+"\n");
			s+=Math.abs(this.features.get(i)-c.features.get(i));
		}
		return  (double) Math.round(s * 100) / 100;
	}
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
	
}
