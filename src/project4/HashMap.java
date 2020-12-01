package project4;
//kjc190001 kippumchang
import java.util.ArrayList;


	
	class Hashnode<K,V>{ // node to store key and value
		K key; 
		V value;
		Hashnode(K key,V value){
			this.key = key;
			this.value = value;
		}
}
public class HashMap<K,V>  {
	K key;
	V value;
	private int size;
	private int numberofplayer=0;
	final Double loadfactor = 0.5; // constant load factor
	Double count = 0.0; // to count how many are entered
	Double currentload; // to store the value of current loadsize
	Hashnode<K,V> [] hashtable = new Hashnode[size]; // hashtable with the initialsize
	ArrayList keys = new ArrayList<>(); // arraylist to store all the keys
	public void put(K key,V value){ // function to put keys and value in hashmap
		if(keys.contains(key)) { // if the keysarraylist already contains the key, 
			//System.out.println("The key already exist");// printout the key already exist
		}
		else { // if not
			this.key = key;  // assign key
			this.value=value; // assign value
			keys.add(key); // add key to keys arraylist
			Hashnode<K, V> hashnode= new Hashnode<K, V>(key,value); // make a hashnode that contains the key and value
			hashdouble(hashnode,size,hashcode(key)); // hashdouble to insert the node that contains the key and value to hashmap
		}
	}
	public V get(K key) {
		this.key = key; // assign key to key attribute
		int temp = hashcode(key); //temp to store the value of hashcode, so it doesn't change in while loop
		int hashcode = hashcode(key)%hashtable.length; // the hashcode == the hashcode generate by hashfunction mod the size of hashtable
		int i =1; // i increases, everytime there is a collision
		if(keys.contains(key)==false) {System.out.println("key doesnt exist");} // if the key entered doesn't exist, print out the key doesnot exsit
		else if(hashtable[hashcode].key.equals(key)) { // if the key entered matches the key of the hashnode at the index, return the value
		}
		else { // if the entered key does not match the key of hashnode, it means the value has been stored in other index becuase the collision had occured
			while(hashtable[hashcode].key.equals(key)==false) {  // loop till it find the hashnode that matches the key entered
			hashcode = (int) ((temp+i*hash2(temp))%hashtable.length);// quadratic probing, hashcode+(i^2) till the empty spot is found
			i++; // add 1, to add diffrent value to hashcode
			}
		}
		return hashtable[hashcode].value; // when proper hashnode it found, return the value
	}
	public void setsize(int size){ // function to set the initial size of the hashmap
		this.size = size; // size equals the number entered
		hashtable = new Hashnode[size]; // create hashtable of the size 
	}
	
	public  int hashcode(Object k) { // function to generate hashcode for the key entered 
		int hashcode=0; 
		if(k instanceof Integer||k instanceof Float || k instanceof Double) {hashcode = ((Integer) key).intValue() ; } // if the key is number
		else if(k instanceof String){ // if the key is string
		int b = 0;
		for(int x=((String) k).length()-1;x>=0;x--) { // if the key is string
			int a = ((String) k).charAt(x); // get value of each char of string
			a= (int) (a*Math.pow(31,b)); // new a == a times 31^b
			hashcode +=a; // add all the value to hashcode
			b++; // +1 to b so the hashcode can be different when the order of alphabet changes
			}
		}
		else if(k instanceof Character) {
			hashcode = Character.getNumericValue((char) k);
		}
		
		hashcode = Math.abs(hashcode); // generate positive integer, if the value goes higher than the range of integer
		return hashcode; // return hashcode
	}
	public int hash2(int a) { // second hash function for double hashing
		int hash2 =0; 
		final int prime = 7; // primenumber less than size which is 7
		hash2 = prime-(a%prime); // hashcode == 7- (originalhashcode * 7)
		return hash2; // return hash 2
	}
	
	public  int nearestprime(int n) { // finding the nearest primenumber from the numbered entered
		int primenumber = 0; // set it to zero
		if(n<=1) {}// primenumber should be greater than 1
		else {	
			for(int i =2;i<n;i++) {  // starting from 2 to the number entered
			if(n%i==0) { // before it reaches value itself, if its divided by anyother value
			n++;	 // move on to the next number
			}
		}
			}
		
		primenumber =n; // end of the loop the primenumber is the neaerest primenumber from the number entered
		return primenumber; // return primenumber
	}
	public  Object[] hashdouble(Hashnode<K,V> value, int sizeofarray, int hashcode) { // quadratic function to avoid collision
			// after extending the size of array, rehash the element that hasn't been entered with updated size
			int temp = hashcode; // temp to hold value of hashcode
			hashcode = hashcode%hashtable.length; // mode by the size,so it does not exceed the size
			int i =1; 
			while(hashtable[hashcode]!=null) { // if the hashtable is not empty, loop till you find an empty slot
				hashcode = (int) ((temp+i*hash2(temp))%hashtable.length);// double hashing, hashcode+(i*hash2) till the empty spot is found
				i++; // add 1, to add different value to hashcode
				}
			count++; // when value is entered, add one to size 
			currentload = count/hashtable.length; // calculating currentloadfactor by numberofelement entered divided by size
			hashtable[hashcode] = value; // at a hashcode index, store the value
			if(currentload>=loadfactor) { // if currentload exceeds the loadfactor which is .5
			hashtable=rehash(hashtable); // extend the size, and rehash everything
			}
			
		
		return hashtable; // return hashtable
	}
	public  Hashnode<K,V>[] rehash(Hashnode<K,V> [] hashtable) { // rehash fucntion
		ArrayList<Hashnode<K,V>> values = new ArrayList<>(); // arraylist to store all the values entered
			for(int x=0;x<hashtable.length;x++) { // for the length of hashtable
				if(hashtable[x]!=null) {values.add((Hashnode<K, V>) hashtable[x]);} // if the value is not null , add it to the arraylist
			}
			hashtable = new Hashnode [nearestprime(hashtable.length*2)]; // resize it to nearest primenumber from double of the initialsize
			int i =1;
			
			for(int x=0;x<count;x++) {// for the number of element entered
			int temp = hashcode(values.get(x).key)%hashtable.length; // temp to hold hashcode
			int hashcode = temp;
			while(hashtable[hashcode]!=null) { // if the hashtable is not empty, loop till you find an empty slot
				hashcode = (int) ((temp+i*hash2(hashcode(values.get(x).key)))%hashtable.length);//double hashing, hashcode+(i*hash2) till the empty spot is found
				i++; // add 1, to add different value to hashcode
				}
			i=1;
			hashtable[hashcode] =  values.get(x); // store the value
			}
		return (Hashnode<K, V>[]) hashtable;
		
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumberofplayer() {
		return numberofplayer;
	}
	public void setNumberofplayer(int numberofplayer) {
		this.numberofplayer = numberofplayer;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Double getCount() {
		return count;
	}
	public void setCount(Double count) {
		this.count = count;
	}
	public Double getCurrentload() {
		return currentload;
	}
	public void setCurrentload(Double currentload) {
		this.currentload = currentload;
	}
	public Hashnode<K, V>[] getHashtable() {
		return hashtable;
	}
	public void setHashtable(Hashnode<K, V>[] hashtable) {
		this.hashtable = hashtable;
	}
	public ArrayList getKeys() {
		return keys;
	}
	public void setKeys(ArrayList keys) {
		this.keys = keys;
	}
	public Double getLoadfactor() {
		return loadfactor;
	}
	


}
