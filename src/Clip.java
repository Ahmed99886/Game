
public class Clip {
public static final int max_numofbullets=15;
private int bullets=max_numofbullets;
public void incBullets(int value) {
	bullets +=value;
}
public int getbullets() {
	return bullets;
}
public boolean isEmpty() {
	return bullets==0;
}
}
