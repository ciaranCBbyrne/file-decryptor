import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class decrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<String> results = new Vector<String>();

		try{
			File file = new File("decryptFile.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			
			Scanner scan = new Scanner(br);
			Vector<String> allword = new Vector<String>();
			while(scan.hasNextLine()){
				String[] word = scan.nextLine().split("");
				for(int letter = 0 ; letter <word.length ; letter++){
					String let = word[letter].toLowerCase();
					allword.add(let);
				}
			}
			int counter = 0;
			int vowelCounter = 0;

			String[] vowels = {"e","a","o","i","u"};
			
			for(int c=0 ; c<vowels.length ; c++){
				for(int d=0 ; d<allword.size(); d++){
					
				}
			}
			
			for(char alpha = 'a' ; alpha<='z' ; alpha++){
				for(int i = 0 ; i<allword.size() ; i++){
					
					if(allword.elementAt(i).equals(String.valueOf(alpha))){		
						counter++;				
					}
				}
				if(counter != 0){
					results.add(String.valueOf(counter));
					results.add(String.valueOf(alpha));
					counter = 0;
				}
			}

			for(int i = 0 ; i<allword.size() ; i++){
				if(allword.elementAt(i).equals("-")){
					counter++;
				}
			}
			if(counter != 0){
				results.add(String.valueOf(counter));
				results.add("-");
				counter = 0;
			}


			for(int i = 0 ; i < results.size(); i++){
				for (int j = 2+i ; j < results.size() ; j++){
					int x = Integer.valueOf(results.elementAt(i));
					int y = Integer.valueOf(results.elementAt(j));
					if(x < y){
						String temp = results.elementAt(i);
						String temp2 = results.elementAt(i+1);
						results.set(i, results.elementAt(j));
						results.set((i+1), results.elementAt(j+1));
						results.set(j, temp);
						results.set((j+1), temp2);						
					}
					j++;
				}
				i++;
			}
			String[] compareLetters = new String[(results.size())/2];
			for(int a = 0 ; a < compareLetters.length ; a++){
				if(a==0){
					compareLetters[a] = results.elementAt(a+1);
				}
				else {
					compareLetters[a] = results.elementAt((a*2)+1);
				}

				System.out.print(compareLetters[a]);
			}

			String[] outWord = new String[allword.size()];
			String[] commonLetters = new String[]{"e","a","o","i","u","t","n","r","s","h","d","l","f","c","m",
					"g","y","p","w","b","v","k","j","x","q","z"};

			System.out.println();
			for(int b=0 ; b<commonLetters.length ; b++){
				System.out.print(commonLetters[b]);
			}

			System.out.println();
			for(int b=0 ; b<allword.size() ; b++){
				System.out.print(allword.elementAt(b));
			}
			for(int a=1 ; a<allword.size() ; a++){
				if(a<allword.size()-2 && allword.elementAt(a).equals(allword.elementAt(a+1))&& allword.elementAt(a+2).equals(" ")){
					String temp = commonLetters[9];
					commonLetters[9] = commonLetters[10];
					commonLetters[10] = temp;
				}
			}

			for(int x=1 ; x<allword.size() ; x++){
				for(int y=0 ; y<compareLetters.length ; y++){
					
					if(allword.elementAt(x).equals(compareLetters[y])){
						outWord[x] = commonLetters[y];
					}

				}

			}
			for(int x=0 ; x<outWord.length ; x++){
				if(outWord[x] == null){
					outWord[x] = allword.elementAt(x);
				}
			}

			System.out.println();

			FileWriter fwriter = new FileWriter("encrypted.txt");
			BufferedWriter out = new BufferedWriter(fwriter);

			String complete = outWord[1];
			int enter=0;

			for(int x = 1 ; x<outWord.length ; x++){
				out.write(outWord[x]);
				if((enter>=120) && outWord[x].equals(" ")){
					out.newLine();
					enter=0;
				}
				enter++;
			}

			out.close();
			scan.close();

		}catch(IOException e){
			e.printStackTrace();
		}


	}

}
