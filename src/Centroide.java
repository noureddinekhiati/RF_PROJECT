import java.util.ArrayList;

public class Centroide extends Features {
	//int n=1;
	

	double getManhattanDistance(Features c) {
		double s=0;
		
		for(int i=0;i<this.features.size();i++) {
			s+=Math.abs(this.features.get(i)-c.features.get(i));
		}
		return  (double) Math.round(s * 100) / 100;
	}
	public static void updateCentroids(){
		for (Centroide center : KMeans.centroidList) {
			int nbr=1;
			for (Features entry :Execute.testVectors) {
				if(center.classe==entry.assignClass) {
					for(int i=0;i<center.features.size();i++) {
						center.features.set(i, center.features.get(i)+entry.features.get(i));
						nbr++;
					}
				}
			}
			for(int i=0;i<center.features.size();i++) {
				center.features.set(i, center.features.get(i)/nbr);
			}		
		}
		
		
	}
	
}
