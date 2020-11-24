import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static java.lang.System.out;

public class Distance {

	ArrayList <Double> distances=new ArrayList<Double>();
	int index;
	int cluster;
	
	void updateCluster() {
		
		Double m=Collections.min(distances);
		this.cluster=distances.indexOf(m)+1;
		out.print("index: "+index+" min= "+m+" cluster= "+this.cluster+"\n");

		if(this.cluster!=Execute.trainVectors.get(index).assignedClass) {KMeans.isChanged=true;}
		int temp=Execute.trainVectors.get(index).assignClass;
		Execute.trainVectors.get(index).assignedClass=temp;
		Execute.trainVectors.get(index).assignClass=this.cluster;
		//out.print("\n"+Execute.trainVectors.get(index).assignedClass+"--->"+Execute.trainVectors.get(index).assignClass);
		
	}
	@SuppressWarnings("deprecation")
	void initDistances(int nb) {
		for (int i=0;i<nb;i++) {
			this.distances.set(i,new Double(0));
		}
	}
}
