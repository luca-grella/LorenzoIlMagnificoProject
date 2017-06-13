package it.polimi.ingsw.ps18.model.personalboard.resources;

import org.json.simple.JSONArray;

public class Stats {
	private Resources wood;
	private Resources rock;
	private Resources coin;
	private Resources servant;
	private Points vp;
	private Points mp;
	private Points fp;
	
	public Stats(int wood, int rock, int coin, int servant, int fp, int mp, int vp){
		this.wood = new Wood(wood);
		this.rock = new Rock(rock);
		this.coin = new Coins(coin);
		this.servant = new Servants(servant);
		this.fp = new FaithPoints(fp);
		this.mp = new MilitaryPoints(mp);
		this.vp = new VictoryPoints(vp);
	}
	
	
	
    public Stats(JSONArray costs) {
		this.wood = new Wood((long) costs.get(0));
		this.rock = new Rock((long) costs.get(1));
		this.coin = new Coins((long) costs.get(2));
		this.servant = new Servants((long) costs.get(3));
		this.fp = new FaithPoints((long) costs.get(4));
		this.mp = new MilitaryPoints((long) costs.get(5));
		this.vp = new VictoryPoints((long) costs.get(6));
	}
    
    public void addStats(Stats adder){
    	addWood(adder.getWood());
    	addRock(adder.getRock());
    	addCoins(adder.getCoin());
    	addServants(adder.getServants());
    	addFP(adder.getFP());
    	addMP(adder.getMP());
    	addVP(adder.getVP());
    }
    
    public void subStats(Stats subber){
    	addWood(-(subber.getWood()));
    	addRock(-(subber.getRock()));
    	addCoins(-(subber.getCoin()));
    	addServants(-(subber.getServants()));
    	addFP(-(subber.getFP()));
    	addMP(-(subber.getMP()));
    	addVP(-(subber.getVP()));
    }
    
    public boolean enoughStats(Stats neededStats){
		if(this.wood.getQuantity() < neededStats.getWood()){
			return false;
		}
		if(this.rock.getQuantity() < neededStats.getRock()){
			return false;
		}
		if(this.coin.getQuantity() < neededStats.getCoin()){
			return false;
		}
		if(this.servant.getQuantity() < neededStats.getServants()){
			return false;
		}
		if(this.fp.getQuantity() < neededStats.getFP()){
			return false;
		}
		if(this.mp.getQuantity() < neededStats.getMP()){
			return false;
		}
		if(this.vp.getQuantity() < neededStats.getVP()){
			return false;
		}
    	return true;
    }



	public void addWood(int value){
		this.wood.addQuantity(value);
	}
	
    public void addRock(int value){
		this.rock.addQuantity(value);
	}
    
    public void addCoins(int value){
		this.coin.addQuantity(value);
	}
    
    public void addServants(int value){
		this.servant.addQuantity(value);
	}
    
    public void addFP(int value){
		this.fp.addQuantity(value);
	}
    
    public void addVP(int value){
		this.vp.addQuantity(value);
	}
    
    public void addMP(int value){
		this.mp.addQuantity(value);
	}
    
    public int getWood(){
    	return this.wood.getQuantity();
    }
    
    public int getRock(){
    	return this.rock.getQuantity();
    }
    
    public int getCoin(){
    	return this.coin.getQuantity();
    }
    
    public int getServants(){
    	return this.servant.getQuantity();
    }
    
    public int getFP(){
    	return this.fp.getQuantity();
    }
    
    public int getMP(){
    	return this.mp.getQuantity();
    }
    
    public int getVP(){
    	return this.vp.getQuantity();
    }

}
