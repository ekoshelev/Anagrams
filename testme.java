import java.util.ArrayList;

public class testme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> anagramqueuee = new ArrayList<String>();
		anagramqueuee.add("1");
		anagramqueuee.add("2");
		anagramqueuee.add("3");
		anagramqueuee.add("4");
		printt(anagramqueuee);
	}
	public static void printt(ArrayList<String> anagramqueue){
	if (anagramqueue.size()==0){
		//System.out.print(anagramqueue.toString());
	}else{
		for (int i=0; i<anagramqueue.size(); i++){
		for (int z=0; z<anagramqueue.size(); z++){
			String number = anagramqueue.get(z);
			anagramqueue.remove(z);
			System.out.println(anagramqueue.toString());
					printt(anagramqueue);
					anagramqueue.add(z,number);
			}
		}
	}
	}
}
