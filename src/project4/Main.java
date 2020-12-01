package project4;
//kjc190001 kippumchang
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	 
    public static int numberofplayers (String filename) throws IOException
    { // counting the number of player by reading each line of the inputfile
        int countplayer = 0;
        LineNumberReader L1= new LineNumberReader(new FileReader(filename));// reading the lines by using line reader
        while ((L1.readLine())!=null) {};	// reading the line while its not null
        countplayer = L1.getLineNumber(); // number of lines equals the number of player
        L1.close();
        return countplayer;
    }
  public static float[] Findingleader(ArrayList<Boolean> ineligible,ArrayList<Float> battingaverage, int numberofplayer)
    {   // iterating through the array to find the highest value
        float first,second,third; // initializing to negative number, so even a zero can be the leader value
        first=second=third = -100;
        for (int a = 0; a<numberofplayer; a++) // loops till a is less than numofplayer
        {

            if ((first<battingaverage.get(a)||first==battingaverage.get(a))&& ineligible.get(a) != true)// if stat is higher or same as first, and the stat is not empty
            {	if(first==battingaverage.get(a)) { // ignore the tie because the second value will be same as the first value
            	}
            	else {
                third = second; // previous second value becomes third 
                second = first; // previous fisrt value becomes second  now
                first = battingaverage.get(a); // replace the first value with stat[a]
            	}
            }
            else if((second<battingaverage.get(a)||second==battingaverage.get(a))&& ineligible.get(a) != true) { // if stat is higher than or equal to second value
            	if(second==battingaverage.get(a)) { // ignoring the tie 
                	}
                	else {
            	third = second; // previous second value is now assigned to third
            	second = battingaverage.get(a); // second is replaced by the value of stat[a]
                	}
            }
            else if((third<battingaverage.get(a)||third==battingaverage.get(a))&& ineligible.get(a) != true) { // if stat is higher than or equal the third value
            	if(third==battingaverage.get(a)) { // ignoring the tie value
                	}
                	else {
            	third = battingaverage.get(a); // third value is now replaced by the stat[a]
                	}
            }
        }
        float []top3value = {first,second,third}; // using array to return more than 1 value
        return top3value; // top3value array
    }
    public static float[] FindingKleader(ArrayList<Boolean> ineligible, ArrayList<Float> strikeoutarray, int numberofplayer)
    {   //iterating through the array to find the lowest value
        float first,second,third;
        first=second=third = Float.POSITIVE_INFINITY; // assigned positive infinity so any integer lower than infinity can be assigned to leader value
        for (int a = 0; a<numberofplayer; a++) // for number of players
        {

            if ((first>strikeoutarray.get(a)||first==strikeoutarray.get(a)) && ineligible.get(a) != true)// if stat exists and the stat is equal to or greater than first 
            {	if(first==strikeoutarray.get(a)) { // do nothing if the stat is same fisrt value
            	}
            	else { // if not tie
                third = second; // previous second value is assigned to third  
                second = first; // previous first value is now assigned to second
                first = strikeoutarray.get(a); // value of the stat is now assigned to first
            	}
            }
            else if((second>strikeoutarray.get(a)||second==strikeoutarray.get(a)) && ineligible.get(a) != true) {
            	if(second==strikeoutarray.get(a)) {
                	}
                	else {
            	third = second;// previous second value is assigned to third
            	second = strikeoutarray.get(a); // value of second is stat 
                	}
            	}
       	else if((third>strikeoutarray.get(a)||third==strikeoutarray.get(a)) && ineligible.get(a) != true) {
       		if(third==strikeoutarray.get(a)) {
            	}
            	else {
        	third = strikeoutarray.get(a); // value of third is replace by the value of stat
            	}
        }
        }
        float[] top3kleader = {first,second,third};
        return top3kleader;
    }
    public static String[] displayleader(ArrayList<Boolean> ineligible, ArrayList<String> namearray, float []top3, ArrayList<Float> battingaverage, int numberofplayer,ArrayList<String> awaynamearray,ArrayList<String> homenamearray)
    {   //iterating through the array to find the name that matches with the leader value

        String top1name,top2name,top3name;
        top1name = top2name = top3name = ""; // initialize null value of all names 
        int top1counter,top2counter,top3counter;
        top1counter = top2counter = top3counter = 0; // initialize 0 to all counters
        ArrayList<String> top1namearray = new ArrayList<String>(); // arraylist to hold top3 names
        ArrayList<String> top2namearray = new ArrayList<String>();
        ArrayList<String> top3namearray = new ArrayList<String>();
        for (int i=0;i<numberofplayer;i++)
        {	
            if (top3[0]==battingaverage.get(i) && ineligible.get(i) != true) { // if the value of top1 equals the stat of player
                if (top1counter < 1) { // if the first place is only one person
                	top1namearray.add(namearray.get(i)); // putting in array to sort
                    top1name=namearray.get(i); // assign name to top1name array
                } else {
                 top1namearray.add(namearray.get(i)); // if there is more than one person with the top1 value
                 top1name = top1name + ", " + namearray.get(i);//if there is more than one leader, it prints out the names of the leader with comma between.
                }
                top1counter++;
            }
            if (top3[1]==battingaverage.get(i) && ineligible.get(i) != true) { // if the value of top2 equals the stat of player
                if (top2counter < 1) {
                	top2namearray.add(namearray.get(i));
                    top2name=namearray.get(i);
                } else {
                	top2namearray.add(namearray.get(i));
                    top2name = top2name + ", " + namearray.get(i);//if there is more than one leader, it prints out the names of the leader with comma between.
                }
                top2counter++;
            }
            if (top3[2]==battingaverage.get(i) && ineligible.get(i) != true) {// if the value of top1 equals the stat of player
                if (top3counter < 1) {
                	top3namearray.add(namearray.get(i));
                    top3name=namearray.get(i);
                } else {
                	top3namearray.add(namearray.get(i));
                    top3name = top3name + ", " + namearray.get(i);//if there is more than one leader, it prints out the names of the leader with comma between.
                }
                top3counter++;
            }
        }
        ArrayList<String> awaytop1namearray = new ArrayList<String>();// arraylist to hold top3 names of away and home team
        ArrayList<String> hometop1namearray = new ArrayList<String>();
        ArrayList<String> awaytop2namearray = new ArrayList<String>();
        ArrayList<String> hometop2namearray = new ArrayList<String>();
        ArrayList<String> awaytop3namearray = new ArrayList<String>();
        ArrayList<String> hometop3namearray = new ArrayList<String>();
        sortname(top1namearray);// sorting the names of top1players in alphabetical order 
        sortname(top2namearray);// sorting the names of top2players in alphabetical order
        sortname(top3namearray);// sorting the names of top3players in alphabetical order
        for(int x=0;x<top1namearray.size();x++) { // for size of top1namearray
        	if(awaynamearray.contains(top1namearray.get(x))) { //if top1name contains the player of away team
        		awaytop1namearray.add(top1namearray.get(x)); // add the name to awaytop1name arraylist
        	}
        	else if(homenamearray.contains(top1namearray.get(x))) {//if top1name contains the player of home team
        		hometop1namearray.add(top1namearray.get(x));// add the name to hometop1name arraylist
        	}
        }
        for(int x=0;x<top2namearray.size();x++) {
        	if(awaynamearray.contains(top2namearray.get(x))) { //if top2name contains the player of away team
        		awaytop2namearray.add(top2namearray.get(x)); // add the name to awaytop2name arraylist
        	}
        	else if(homenamearray.contains(top2namearray.get(x))) {//if top2name contains the player of home team
        		hometop2namearray.add(top2namearray.get(x));// add the name to hometop2name arraylist
        	}
        }
        for(int x=0;x<top3namearray.size();x++) {
        	if(awaynamearray.contains(top3namearray.get(x))) { //if top3name contains the player of away team
        		awaytop3namearray.add(top3namearray.get(x)); // add the name to awaytop1name arraylist
        	}
        	else if(homenamearray.contains(top3namearray.get(x))) {//if top3name contains the player of home team
        		hometop3namearray.add(top3namearray.get(x));// add the name to hometop3name arraylist
        	}
        }
       awaytop1namearray.addAll(hometop1namearray); // add all the names of hometop3leader to away, so the names of the hometeam players can be printedout after awayteam leaders
       awaytop2namearray.addAll(hometop2namearray);
       awaytop3namearray.addAll(hometop3namearray);
       
        int q =1;
       if(awaytop1namearray.size()>1) { top1name = awaytop1namearray.get(0);} // reassigning name of top 1 value in alphabetical order if there is more than one
        while (q<awaytop1namearray.size()&&top1counter!=1) { // while there is more than 1 player with top1value and while top1name is not null
        	top1name = top1name + ", " + awaytop1namearray.get(q); //inserting comma between names
        	q++;
        }
        q=1;
        if(awaytop2namearray.size()>1) { top2name = awaytop2namearray.get(0);}// reassigning name of top 1 value in alphabetical order if there is more than one
        while (q<awaytop2namearray.size()&&top2counter!=1) { // while there is more than 1 player with top2value and while top2name is not null
        	top2name = top2name + ", " + awaytop2namearray.get(q); //inserting comma between names
        	q++;
        }
        q=1;
        if(awaytop3namearray.size()>1) { top3name = awaytop3namearray.get(0);}// reassigning name of top 1 value in alphabetical order if there is more than one
        while (q<awaytop3namearray.size()&&top3counter!=1) { // while there is more than 1 player with top3value and while top3name is not null
        	top3name = top3name + ", " + awaytop3namearray.get(q); //inserting comma between names
        	q++;
        }
        if(numberofplayer ==1) {top2name = null; top3name = null;} // if there is only one player top2 and top3 does not exist
        else if (numberofplayer==2&&top1counter<2) {top3name =null;} // if there is only 2 players top3 is null
        else if(numberofplayer==2&&top1counter>1) {top2name =null;top3name=null;} // if there is 2 players but 2players have tie value then top2 and top3 is null
        else if(top1counter>2) {top2name=null;top3name=null;} // if there is more than 2 ties with top1value, top2 and top3 does not exist
        else if(top2counter>1||top1counter>1) {top3name=null;} // if there is more than one top1 or top2, then top3 does not exist
        String []top3names = {top1name,top2name,top3name};
     
        return top3names;
    }
    public static ArrayList<String> sortname(ArrayList<String> names) {
    	
		for(int i =0;i<names.size();i++) {// for size of array
		int j =0;
		while(j<names.size()-1&&names.get(j+1)!=null) { // while less than size of array and the next of the array is not null
		if(names.get(j).compareTo(names.get(j+1))<0) { // if its already in alphabetical order do nothing
			//good
		}
		else { // if not in alphabetical order
			String temp = names.get(j); // made temp to temporary hold the firstname
			names.set(j, names.get(j+1)); // assign second names to first
			names.set(j+1, temp); // assign temp that holding firstname to second name
		}
		j++;
		}
		}
    	return names;
    }


    public static void main(String[] args) {                        
        Scanner scan = new Scanner(System.in);
        //String inputfilename = scan.nextLine();
        String inputfilename = "C:\\Users\\kippumchang\\Desktop\\computer science1\\project 4\\src\\project4\\sample.txt";
        scan.close();
        String line;
        int i = 0;
        ArrayList <String> homenamearray = new ArrayList<String>();// arraylist to hold names of hometeam
        ArrayList <String> awaynamearray = new ArrayList<String>();// arraylist to hold away team names
        ArrayList <String> namearray = new ArrayList<String>();  // arraylist to hold all the names of both home and away team
        ArrayList <Float> battingaverage = new ArrayList <Float>(); // arralist to hold BA value;
        ArrayList <Float> onbasepercentage = new ArrayList <Float>(); // arraylist to hold OB value;
        ArrayList <Float> hitarray = new ArrayList <Float>(); // arraylist to hold hit value
        ArrayList <Float> walkarray = new ArrayList <Float>(); // arraylist to hold walk value
        ArrayList <Float> strikeoutarray = new ArrayList <Float>(); // arraylist to hold strikeout value;
        ArrayList <Float> hitbypitcharray = new ArrayList <Float>(); // arraylist to hold HBP value
        ArrayList <Float> sacrificearray = new ArrayList <Float>(); // arraylist to hold sacrifice value
        ArrayList <Boolean> ineligible = new ArrayList <Boolean>(); // arraylist to hold whether each player has any record
        DecimalFormat d1 = new DecimalFormat ();
        d1.setMinimumFractionDigits(3); // forcing it to printout 3 decimal places when needed
        BufferedReader br = null;
        try {
        	int line_count=0; // counting the lines 
        	File file2 = new File("keyfile.txt"); 
        	file2.createNewFile(); // creating a file named keyfile that contains the all the possible plate appearance
        	BufferedReader br1 = new BufferedReader(new FileReader(file2)); // reading file2 which is keyfile 
        	HashMap<String,String> mapresult = new HashMap<String,String> ();// creating new hash map to store all the plate appearance 
        	mapresult.setsize(11); // set the initial size to primenumber 11 to minimize collisions
        	if(file2.exists()!=true) {System.out.println("The file does not exist");}
        	else {while((line = br1.readLine())!=null) { // reading till null
        		 if(line_count>=1&&line_count<=21) { // from line 1 to 21
          		   mapresult.put(line,"O"); // is out
          	   }
          	   else if(line_count==24) { // line 24
          		   mapresult.put(line,"K"); // is strikeout
          	   }
          	   else if(line_count>=27&&line_count<=30) { // line 26 to line 30 
          		   mapresult.put(line,"H"); // is hit
          	   }
          	   else if(line_count==33) { // line 33 
          		   mapresult.put(line,"W"); // is walk
          	   }
          	   else if(line_count>=36&&line_count<=42) { // line 36 to 42
          		   mapresult.put(line,"S"); // are sacrifices
          	   }
          	   else if(line_count==45) { // line 45
          		   mapresult.put(line,"P"); // is hit by pitcher
          	   }
          	   else if(line_count>=47&&line_count<=56) { // line 47 to 56
          		   mapresult.put(line,"E"); // are considered error which counts toward at bat
          	   }
        		 line_count++; // countting lines
        	}}
        	
        	File file1 = new File("leaders.txt"); // output file
        	FileWriter f1 = new FileWriter(file1); // printwriter and filewriter to write outputfile
    		PrintWriter p1 = new PrintWriter(f1);
    		File file3= new File(inputfilename);
    	   br = new BufferedReader (new FileReader(file3)); // reading inputfile by bufferedreader
    	   HashMap<String,Player> away = new HashMap<String,Player>(); // hashmap to store all the names and stat of away team
    	   HashMap<String,Player> home = new HashMap<String,Player>(); // hashmap to store all the names and stat of home team
    	   away.setsize(11); // initialize the size to 11
    	   home.setsize(11);
    	   if(file3.exists()!=true) {System.out.println("The file does not exist");}
    	   else { while ((line= br.readLine()) !=null) {		//reading the organized file line by line till there is nothing
        	   String []info = line.split(" "); // split by space
        	   if(info[0].equals("A")) { // if the first letter is A
        		   if(!awaynamearray.contains(info[1])) { // if the awaynamearray does not contain the player name already 
        			awaynamearray.add(info[1]);away.put(info[1],new Player());away.get(info[1]).setName(info[1]); // add the name, player class
        			}
        		   away.get(info[1]).plateappearance+=1; // +1 to plate appearance 
        		   if(info.length<3) {ineligible.add(true);} // if the plate appearance for the player does not exist
        		   else { // if it exist
        		   ineligible.add(false); // it is eligible
        		   if(mapresult.get(info[2]).equals("H")) {away.get(info[1]).hits+=1;} // insert the plate appearance as a key to mapresult hashmap, and if the output is H, add 1 to hit
        		   else if(mapresult.get(info[2]).equals("O")) {away.get(info[1]).out+=1;}// if the output is O, add 1 to out
        		   else if(mapresult.get(info[2]).equals("K")) {away.get(info[1]).so+=1;} // if the output is k, add 1 to strikeout
        		   else if(mapresult.get(info[2]).equals("W")){away.get(info[1]).walks+=1;} // if the output is W, add 1 to walks
        		   else if(mapresult.get(info[2]).equals("P")) {away.get(info[1]).hbp+=1;} // if the output is P , add 1 to hbp
        		   else if(mapresult.get(info[2]).equals("S")) {away.get(info[1]).sacrifice+=1;} // is the output is S , add 1 to sacrifice
        		   else if(mapresult.get(info[2]).equals("E")) {away.get(info[1]).error+=1;} // is the output is E, add 1 to error
        		   }
        	   }
        	   else if(info[0].equals("H")) { // if the player plays for hometeam
        		   if(!homenamearray.contains(info[1])) { // checking if the name of the player has already been add to hashmap
           			homenamearray.add(info[1]);home.put(info[1],new Player());home.get(info[1]).setName(info[1]); // if not add as new player
           			}
        		   home.get(info[1]).plateappearance+=1; // add 1 to plate appearance, everytime the player's name appears 
        		   if(info.length<3) {ineligible.add(true);} // if no plate appearance exist for the player, the playter is inelgible
        		   else { // if the plate appearance exist
        		   ineligible.add(false); // the player is eliginle
        		   if(mapresult.get(info[2]).equals("H")) {home.get(info[1]).hits+=1;}// insert the plate appearance as a key to mapresult hashmap, and if the output is H, add 1 to hit
        		   else if(mapresult.get(info[2]).equals("O")) {home.get(info[1]).out+=1;}// if the output is O, add 1 to out
        		   else if(mapresult.get(info[2]).equals("K")) {home.get(info[1]).so+=1;}// if the output is k, add 1 to strikeout
        		   else if(mapresult.get(info[2]).equals("W")) {home.get(info[1]).walks+=1;} // if the output is W, add 1 to walks
        		   else if(mapresult.get(info[2]).equals("P")) {home.get(info[1]).hbp+=1;}//if the output is P , add 1 to hbp
        		   else if(mapresult.get(info[2]).equals("S")) {home.get(info[1]).sacrifice+=1;}// is the output is S , add 1 to sacrifice
        		   else if(mapresult.get(info[2]).equals("E")) {home.get(info[1]).error+=1;} // is the output is E, add 1 to error
        		   }
        	   }
        	   
                
            }}
          
           namearray.addAll(awaynamearray);namearray.addAll(homenamearray); // add all the names to namearray
           int numofplayer = namearray.size(); //determine the numofplayer by reading inputfile 
           for(int x=0;x<awaynamearray.size();x++) { // for number of awayteamplayers, add all the stat to array to calculate leaders
        	   battingaverage.add(away.get(awaynamearray.get(x)).BA()); // add all the batting average of away team to the array
        	   onbasepercentage.add(away.get(awaynamearray.get(x)).OB()); // add all the onbasepercentage to the array
        	   hitarray.add(away.get(awaynamearray.get(x)).hits); // add all the hit value to the array
        	   walkarray.add(away.get(awaynamearray.get(x)).walks); // add all the walk value to the array
        	   strikeoutarray.add(away.get(awaynamearray.get(x)).so); // add all the strikeout value to the array
        	   hitbypitcharray.add(away.get(awaynamearray.get(x)).hbp); // add all the hitbypitch value to the array
           }
           for(int x=0;x<homenamearray.size();x++) {
        	   battingaverage.add(home.get(homenamearray.get(x)).BA());// add all the batting average of away team to the array
        	   onbasepercentage.add(home.get(homenamearray.get(x)).OB());// add all the onbasepercentage to the array
        	   hitarray.add(home.get(homenamearray.get(x)).hits);// add all the hit value to the array
        	   walkarray.add(home.get(homenamearray.get(x)).walks);// add all the walk value to the array
        	   strikeoutarray.add(home.get(homenamearray.get(x)).so);// add all the strikeout value to the array
        	   hitbypitcharray.add(home.get(homenamearray.get(x)).hbp);// add all the hitbypitch value to the array
           }
          sortname(awaynamearray); // sorting the names of away team players
          sortname(homenamearray); // sorting the names of home team players
          p1.println("AWAY"); // printout away
          for(int x=0;x<awaynamearray.size();x++) {// for number of awayteam players
        	  p1.println(away.get(awaynamearray.get(x)).toString()); // printout names and stat of each players
          } 
          p1.println(); // printout the line between
          p1.println("HOME"); // printout home
          for(int x=0;x<homenamearray.size();x++) { // for the number of hometeam players
        	  p1.println(home.get(homenamearray.get(x)).toString()); // printout names and stat of each players
          }
          
           i=0;
           float []top3valueBA = Findingleader(ineligible,battingaverage,numofplayer); //calculating top3 values of BA
           String []top3namesBA =displayleader(ineligible,namearray,top3valueBA,battingaverage,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of BA

           float []top3valueOB = Findingleader(ineligible,onbasepercentage,numofplayer);//calculating top3 values of OB
           String []top3namesOB =displayleader(ineligible,namearray,top3valueOB,onbasepercentage,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of OB

           float []top3valueH = Findingleader(ineligible,hitarray,numofplayer);//calculating top3 values of hits
           String []top3namesH =displayleader(ineligible,namearray,top3valueH,hitarray,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of hits

           float []top3valueW = Findingleader(ineligible,walkarray,numofplayer);//calculating top3 values of walks
           String []top3namesW =displayleader(ineligible,namearray,top3valueW,walkarray,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of walks

           float []top3valueSO = FindingKleader(ineligible,strikeoutarray,numofplayer);//calculating top3 values of strikeout
           String []top3namesSO =displayleader(ineligible,namearray,top3valueSO,strikeoutarray,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of strikeout

           float []top3valueHBP = Findingleader(ineligible,hitbypitcharray,numofplayer);//calculating top3 values of hbp
           String []top3namesHBP =displayleader(ineligible,namearray,top3valueHBP,hitbypitcharray,numofplayer,awaynamearray,homenamearray); // calculating top 3 names of hbp
           p1.println();
           p1.println("LEAGUE LEADERS"); // printing to outputfile
           p1.println("BATTING AVERAGE");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueBA,battingaverage,numofplayer,awaynamearray,homenamearray)[i]!=null) { // while the value is not null and its less than 3 
           	 p1.println(d1.format(top3valueBA[i])+"\t"+top3namesBA[i]); // printout top 3 leaders
           	 i++;
           	 }
           p1.println();
           i=0;
           p1.println("ON-BASE PERCENTAGE");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueOB,onbasepercentage,numofplayer,awaynamearray,homenamearray)[i]!=null) { // while the value is not null and its less than 3 
           		 p1.println(d1.format(top3valueOB[i])+"\t"+top3namesOB[i]);// printout top 3 leaders
           		 i++;
           		 }
           p1.println();
           i=0;
           p1.println("HITS");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueH,hitarray,numofplayer,awaynamearray,homenamearray)[i]!=null) {// while the value is not null and its less than 3 
           		 p1.println((int)top3valueH[i]+"\t"+top3namesH[i]);// printout top 3 leaders
           		 i++;
           		 }
           p1.println();
           i=0;
           p1.println("WALKS");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueW,walkarray,numofplayer,awaynamearray,homenamearray)[i]!=null) {// while the value is not null and its less than 3 
           		 p1.println((int)top3valueW[i]+"\t"+top3namesW[i]);// printout top 3 leaders
           		 i++;
           		 }
           p1.println();
           i=0;
           p1.println("STRIKEOUTS");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueSO,strikeoutarray,numofplayer,awaynamearray,homenamearray)[i]!=null) {// while the value is not null and its less than 3 
           		 p1.println((int)top3valueSO[i]+"\t"+top3namesSO[i]);// printout top 3 leaders
           		 i++;
           		 }
           p1.println();
           i=0;
           p1.println("HIT BY PITCH");// printing to outputfile
           while( i<3 && displayleader(ineligible,namearray,top3valueHBP,hitbypitcharray,numofplayer,awaynamearray,homenamearray)[i]!=null) {// while the value is not null and its less than 3 
           		 p1.println((int)top3valueHBP[i]+"\t"+top3namesHBP[i]);// printout top 3 leaders
           		 i++;
           		 }
           p1.println();
           p1.close(); // closing the printwriter
           i=0;

        
         
         

        } catch (IOException e) { 
            e.printStackTrace();
        } finally {	
           
        }

    }
}
