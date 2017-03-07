import java.util.ArrayList;


public class ID3 {

	String [][] data;
	String []labels;
	String meta[][];
	String split;
	String parameter;
	String result;
	double info[];
	ID3[] next;
	ID3(String[][] data,String labels[],String meta[][]){
		this.data = data;
		this.labels = labels;
		this.meta = meta;
		info = new double[labels.length];
	}
	
	void getInitialEntropy(){
		double entropy=0.0;
			//TODO:Calculate Entropy
		info[info.length-1]=entropy;
	}
	
	void generateInfoGains(){
		for(int i=0;i<info.length-1;i++){
			double entropy=0.0;
			//TODO:Caculate Attribute Entropy
			info[i]=info[info.length-1]-entropy;
		}
	}
	
	int getMax(){
		int max=0;
		for(int i=1;i<info.length-1;i++){
			if(info[i]>info[max])max=i;
		}
		return max;
	}
	void setRoot(){
		parameter = "root";
	}
	
	void explore(){
		System.out.println("Starting Exploration");
		getInitialEntropy();
		
		generateInfoGains();
		int splitter = getMax();
		String[][] newmeta= new String[labels.length-1][];
		int index=0;
		for(int i=0;i<labels.length;i++){
			if(i!=splitter){
				newmeta[index++]=meta[i];
			}
		}
		String[] newlabels = new String[labels.length-1];
		index=0;
		for(int i=0;i<labels.length;i++){
			if(i!=splitter){
				newlabels[index++]=labels[i];
			}
		}
		String[][][] newdata= new String[next.length][][];
		for(int i=0;i<next.length;i++){
			newdata[i]=getData(splitter,meta[splitter][i]);
		}
		int truesize=0;
		ArrayList<Integer> indices = new ArrayList<>();
		for(int i=0;i<newdata.length;i++){
			if(newdata[i].length!=0){
				truesize++;
				indices.add(i);
				}
		}
		next = new ID3[truesize];
		for(int i=0;i<truesize;i++){
			next[i] = new ID3(newdata[indices.get(i)],newlabels,newmetas);
		}
		
	}
	
	String[][] getData(int attr,String value){
		String[][] subset;
		ArrayList<String[]> generator = new ArrayList<>();
		for(int i=0;i<data.length;i++){
			if(data[i][attr].equals(value)){
				String[] tupple = new String[labels.length-1];
				int index=0;
				for(int j=0;j<labels.length;j++){
					if(j!=attr)tupple[index++] = data[i][j];
				}
				generator.add(tupple);
			}
		}
		subset=new String[generator.size()][];
		for(int i=0;i<subset.length;i++){
			subset[i]=generator.get(i);
		}
		return subset;
	}
	
	
	void generateNext(){
		
	}
	
	
	
	
	
}
