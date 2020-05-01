
public class Gun extends Clip{
	private Firemode mode=Firemode.SINGLE;
 private Clip clip=new Clip(); 
	private void FireSimglebullet() {
		if(!clip.isEmpty()) 
			clip.incBullets(-1);
		
		
	}
	protected void fire() {
		switch (mode) {
		case SINGLE:
			FireSimglebullet();
		break;
		case TRIPLE:
			for(int i=0;i<3;i++) {
				FireSimglebullet();
				
			}
			break;
		case AUTOMATIC:
			while (!clip.isEmpty())
				FireSimglebullet();
			break;
		}
	}
	public void reload() {
		clip=new Clip();
	}
 protected void printSyate() {
		System.out.println("FireMode is:"+mode.toString());
		System.out.println("Num of bullets"+clip.getbullets());
	}
	public void setFiremode(Firemode mode) {
		this.mode=mode;
	}

}
