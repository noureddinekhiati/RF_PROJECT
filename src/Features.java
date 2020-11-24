import java.util.ArrayList;
import static java.lang.System.out;

public class Features {
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
		return "\nclasse=" + classe + "\nfeatures=" + features + "]\n\n";
	}
	
	public void assignClass(int c) {
		this.assignedClass=c;
	}
	
	
}
