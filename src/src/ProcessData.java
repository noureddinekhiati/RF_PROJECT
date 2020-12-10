import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;
	


public class ProcessData {
	public static String path="C:/Users/costa/Desktop/Projet RF/data/";
	public static ArrayList<String> folders= new ArrayList<String>();
	public static ArrayList<String> instances= new ArrayList<String>();
	public static ArrayList<Image> dataset= new ArrayList<Image>();
	public static ArrayList<Image> trainSet= new ArrayList<Image>();
	public static ArrayList<Image> testSet= new ArrayList<Image>();

	public static void main(String[] args) {
		//Lecture des fichiers
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isDirectory()) {
		    folders.add(listOfFiles[i].getName());
		  }
		}
		
		File instance = new File(path+folders.get(0));
		listOfFiles = instance.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
			    //System.out.println("file " + listOfFiles[i].getName().substring(0,7));
			    instances.add(listOfFiles[i].getName().substring(0,7));
			  }
			}
		
			for (String fichier : instances) {
				Image i=new Image(fichier);
				i.setId(fichier);
				for (String repertoire : folders) {
					ArrayList<String> result;
					result=readFile(path, fichier, repertoire);
					for (String res : result) {
						
					//Affectation des valeurs lues selon leurs repertoire source!
						switch(repertoire) {
						  case "E34":
							  i.setE34( Double.parseDouble(res));
						    break;
						  case "F0":
							  i.setF0( Double.parseDouble(res));
						    break;
						  case "SA":
							  i.setSA( Double.parseDouble(res));
							break;
						  case "GFD":
							  i.setGFD( Double.parseDouble(res));
						    break;		
						}
						}
				}
				dataset.add(i);
			}
			//cette fonction permet de diviser les données en test et en train!
			repartirData();
	    
	}
	
public static ArrayList<String> readFile(String path,String name, String extension) {
		ArrayList<String> dataReaded=new ArrayList<String>();
		
		try {
			File myObj = new File(path+extension+"/"+name+"."+extension);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        dataReaded.add(data);
		        //out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
			return dataReaded;
		  }


public static void repartirData() {
	for (int i=0;i<dataset.size();i++) {
		//Chaque modulo 3 on aura des données pour test!
		if((i+1)%3==0) {
			testSet.add(dataset.get(i));
		}
		else {
			trainSet.add(dataset.get(i));
		}
	
	}
	//out.print(trainData);
	//out.print(trainData.size());
	
}
			


}

