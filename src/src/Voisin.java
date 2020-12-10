
@SuppressWarnings("rawtypes")
public class Voisin implements Comparable{
	Features f;
	double dist;
	public Voisin(Features f, double dist) {
		super();
		this.f = f;
		this.dist = dist;
	}
	@Override
	public int compareTo(Object arg0) {
		Voisin v= (Voisin) arg0;
		if(this.dist-v.dist==0)return 0;
		else {
			if(this.dist-v.dist<0)return -1;
			else return 1;
		}
	}
	
}
