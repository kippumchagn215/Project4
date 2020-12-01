package project4;
//kjc190001 kippumchang
import java.text.DecimalFormat;

public class Player {
	private String name; 
	float hits;
	float walks;
	float so;
	float out;
	float hbp;
	float sacrifice;
	float plateappearance;
	float error;
	public String toString()
	{   //printing out the stat of each player
    	DecimalFormat df = new DecimalFormat();
    	df.setMinimumFractionDigits(3); // forcing to printout 3 decimal points// below return string that includes all the data for the player
    	return name+"\t"+Math.round(atbat())+"\t"+Math.round(hits)+"\t"+Math.round(walks)+"\t"+Math.round(so)+"\t"+Math.round(hbp)+"\t"+Math.round(sacrifice)+"\t"+df.format(BA())+"\t"+df.format(OB());
	}
	float atbat() { // to calculate atbat
		return hits+out+so;
	}
	float BA() { // function to calculate the batting average and return the batting average
		float battingaverage = 0;
		if (atbat() > 0) { // if at bat is higher than 0
            battingaverage = (hits/(atbat())); // batting average is calculated by dividing atbat() by hits
            return battingaverage;
        } 
		else {//if at-bat value is zero, then set the value of battingaverage to zero
            battingaverage = 0;
            return battingaverage;
        }
	}
	float OB() { // function to calculate on base percentage
		float OB = (hits+walks+hbp)/plateappearance; // on base percentage is calculated by dividing h+w+hbp by the plateappearance
		if(plateappearance==0) {OB=0;} // if the plate appearance is zero, then ob is automatically zero, and this prevents dividing by zero error
		return OB; // return on base percentage
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHits() {
		return hits;
	}
	public void setHits(float hits) {
		this.hits = hits;
	}
	public float getWalks() {
		return walks;
	}
	public void setWalks(float walks) {
		this.walks = walks;
	}
	public float getSo() {
		return so;
	}
	public void setSo(float so) {
		this.so = so;
	}
	public float getOut() {
		return out;
	}
	public void setOut(float out) {
		this.out = out;
	}
	public float getHbp() {
		return hbp;
	}
	public void setHbp(float hbp) {
		this.hbp = hbp;
	}
	public float getSacrifice() {
		return sacrifice;
	}
	public void setSacrifice(float sacrifice) {
		this.sacrifice = sacrifice;
	}
	public float getPlateappearance() {
		return plateappearance;
	}
	public void setPlateappearance(float plateappearance) {
		this.plateappearance = plateappearance;
	}
	public float getError() {
		return error;
	}
	public void setError(float error) {
		this.error = error;
	}
	
}
	