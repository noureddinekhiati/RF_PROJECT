import java.util.ArrayList;

public class Normalisation {
	double min=10000000;
	double max=-1;
	@Override
	public String toString() {
		return "Normalisation [min=" + min + ", max=" + max + "]";
	}
	
	ArrayList<Double> normaliser(ArrayList<Double> values) {
		ArrayList<Double> normalizedData=new ArrayList<Double>();
		for (Double value : values) {
			normalizedData.add(Math.exp(2*(value-this.min)/(this.max-this.min)));
		}
		return normalizedData;
	}
}
