import java.util.ArrayList;
//import static java.lang.System.out;
public class Image {
	String id;
	int classe;
	ArrayList <Double> GFD = new ArrayList<Double>();
	ArrayList <Double> SA = new ArrayList<Double>();
	ArrayList <Double> F0 = new ArrayList<Double>();
	ArrayList <Double> E34 = new ArrayList<Double>();
	public Image(String id) {
		this.id = id;
		this.classe=Integer.parseInt(id.substring(1,3));
		GFD = new ArrayList<Double>();
		SA = new ArrayList<Double>();
		F0 = new ArrayList<Double>();
		E34 = new ArrayList<Double>();
	}
	public void setId(String id) {
		this.id = id;
		this.classe=Integer.parseInt(id.substring(1,3));

	}

	public void setGFD(Double value) {
		GFD.add(value);
		if(value>Execute.NGFD.max) {Execute.NGFD.max=value;}
		if(value<=Execute.NGFD.min) {Execute.NGFD.min=value;}
		//out.println(value);
	}
	public void setSA(Double value) {
		SA.add(value);
		if(value>Execute.NSA.max) {Execute.NSA.max=value;}
		if(value<=Execute.NSA.min) {Execute.NSA.min=value;}
	}
	public void setF0(Double value) {
		F0.add(value);
		if(value>Execute.NF0.max) {Execute.NF0.max=value;}
		if(value<=Execute.NF0.min) {Execute.NF0.min=value;}
	}
	public void setE34(Double value) {
		E34.add(value);
		if(value>Execute.NE34.max) {Execute.NE34.max=value;}
		if(value<=Execute.NE34.min) {Execute.NE34.min=value;}
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", classe=" + classe + "]\t"+
				"size: " +GFD.size()+"\t"+SA.size()+"\t"+E34.size()+"\t"+F0.size()+"\n" 
				;
	}
	
	
	public ArrayList<String> getFeaturesVector() {
		
		
		return null;
	}
	
	
	public static ArrayList<String> collectionToString(ArrayList<Object> array){
		for (Object one : array) {
			String s=(String)one;
			
			
		}
		return null;
		
	}
	
}
