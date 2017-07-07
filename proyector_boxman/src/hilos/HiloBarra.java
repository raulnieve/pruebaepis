package hilos;

import formularios.frmLogin;

public class HiloBarra extends Thread {
	
	public void run(){
		
	for(int i=0; i<=100; i++){
		frmLogin.pbCargar.setValue(i);
		
		try {
			
			Thread.sleep(50);
			
		} catch (InterruptedException	 e) {
			e.printStackTrace();
		}
		
		
		
	}
		
	}

}
