package Aufgabenblatt2.p3;

public class Flugzeug extends Thread {
	
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private Status status;
	
	public Flugzeug(String id,Flughafen flughafen,int flugdauer){
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		status = Status.IM_FLUG;
	}
	public void setStatus(Status status){
		this.status = status;
	}
	
	@Override
	public void run(){
		while(flugdauer>0){
			try {
				sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flughafen.landen(this);
		
	}
	public String toString(){
		
		return id+"("+status.toString()+", "+flugdauer+")";
		
	}
	public void tick(){
		if(flugdauer>0){
			flugdauer--;
		}
	}
	public boolean istGelandet(){
		if(status == Status.GELANDET){
			return true;
		}
		return false;
	}

}
