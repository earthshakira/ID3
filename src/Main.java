import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File DataFile = new File("data");
		Scanner file = new Scanner(DataFile);
		ArrayList<String[]> data = new ArrayList<>();
		HashSet<String>[] iClasses = null;
		ArrayList<String[]> classes = new ArrayList<>();
		boolean first = true;
		int cols=0;
		String labels[] = file.nextLine().split("\\s+");
		while(file.hasNext()){
			String[] tupple = file.nextLine().split("\\s+");
			data.add(tupple);
			if(first){
				first = false;
				iClasses = new HashSet[tupple.length];
				cols = tupple.length;
				for(int i = 0;i<tupple.length;i++){
					iClasses[i]=new HashSet<String>();
				}
			}
			
			for(int i=0;i<tupple.length;i++){
				System.out.print(tupple[i]);
				iClasses[i].add(tupple[i]);
			}
			System.out.println(" "+tupple.length);
		}
		System.out.println("Individual Classes:"+iClasses.length);
		String[][] initmeta = new String[classes.size()][];
		for(int i = 0 ;i < iClasses.length;i++){
			Object[] x = iClasses[i].toArray();
			initmeta[i] = new String[x.length];
			for(int j=0;j<x.length;j++){
				initmeta[i][j]=(String)x[j];
			}
			System.out.println();
		}
		Object[] temp = data.toArray();
		String[][] initdata = new String[temp.length][];
		for(int i = 0;i<temp.length;i++){
			initdata[i]=(String[]) temp[i];
		}
		//meta built;
		ID3 root = new ID3(initdata,labels,initmeta);
		root.setRoot();
		
	}

}
