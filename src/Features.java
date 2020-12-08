import java.util.ArrayList;
import static java.lang.System.out;

public class Features implements Comparable {
	String id;
	int classe;
	ArrayList<Double> features = new ArrayList<Double>();
	public Features() {
		//out.print(this.features.size());
	}
	public Features(Image i) {
		this.id=i.id;
		this.classe=i.classe;
		this.features.addAll(	Execute.NE34.normaliser(i.E34)	);
		this.features.addAll(	Execute.NGFD.normaliser(i.GFD)	);
		this.features.addAll(	Execute.NF0.normaliser(i.F0)	);
		this.features.addAll(	Execute.NSA.normaliser(i.SA)	);
		
		//out.print(this.features.size());
	}
	int assignedClass=-1;
	int assignClass=0;
	public static void extractFeatures() {
		for (Image i : ProcessData.trainSet) {
			Features f= new Features(i);
			Execute.trainVectors.add(f);
		}
		for (Image i : ProcessData.testSet) {
			Features f= new Features(i);
			Execute.testVectors.add(f);
		}

	}

	@Override
	public String toString() {
		return "\nclasse=" + classe +"]\n\n";
	}
	
	public void assignClass(int c) {
		this.assignedClass=c;
	}
	@Override
	public int compareTo(Object arg0) {
		Features f=(Features)arg0;
		return (this.assignClass-f.assignClass);
	}
	
	double getManhattanDistance(Features c) {
		double s=0;
		
		for(int i=0;i<this.features.size();i++) {
			//out.print("\n"+c.id+ ": "+this.features.get(i)+"-"+c.features.get(i)+"\n");
			s+=Math.abs(this.features.get(i)-c.features.get(i));
		}
		return  (double) Math.round(s * 100) / 100;
	}
}
