package decc_cli;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import decc.DeccInstance;
import decc.IDeccUser;

public class DeccUser implements IDeccUser{

	private DeccInstance decc;
	
	public DeccUser() {
		try{
			decc = new DeccInstance(4242,  "", this);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private String getCurrentDate(){
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date());
	}
	
	private void log(String mess){
		System.out.println(getCurrentDate() + " : " + mess);
	}
	
	@Override
	public void onNewPeer(String host) {
		log("Peer connected : " + host);
	}

	@Override
	public void onPeerDeco(String host) {
		log("Peer disconnected : " + host);
	}

	@Override
	public void onNewCom(String comid) {
		decc.closeCom(comid);
		log("Communication receivec : refused " + comid);
	}

	@Override
	public void onComEnd(String comid) {
		log("Communication closed : " + comid);
	}

	@Override
	public void onNewRoad(String comid, String hosta, String hostb) {
		log("New road traced for : " + comid);
	}

	@Override
	public void onEroute(String comid, String hosta, String hostb) {
		log("Road aborted for : " + comid);
	}

	@Override
	public void onMess(String comid, String mess) {
		log("Message received : " + comid);
	}

}
