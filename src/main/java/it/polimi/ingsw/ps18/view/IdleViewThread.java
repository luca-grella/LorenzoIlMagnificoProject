package it.polimi.ingsw.ps18.view;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class IdleViewThread implements Runnable {
	IdleView idleview;
	boolean active;
	
	public IdleViewThread(PBoard player, MainController controller){
		this.idleview = new IdleView(controller, player.getPlayer(), player.getPlayercol());
	}
	
	@Override
	public void run(){
		try {
			idleview.getPlayerClient().notify("!!NOTA!!\n"
					+ "\tQuesto thread permette agli utenti non giocanti di richiedere informazioni\n"
					+ "\tsullo stato della board. Purtroppo nel momento in cui il thread viene stoppato\n"
					+ "\tper far cominciare il turno al giocatore, la richiesta di input che è stata fatta dal\n"
					+ "\tThread rimane attiva e non siamo riusciti a chiuderla. Per prosegiore e iniziare il \n"
					+ "\tturno basta inserire un input maggiore di 7.");
		} catch (RemoteException e) {
			System.out.println("\n[IdleViewThread] Error\n");
		}
		this.active = true;
		while(active){
			idleview.init();
		}
	}
	
	public void close(){
//		try {
//			idleview.getPlayerClient().closeScanner();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		synchronized(this){
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		this.active = false;
	}

}
