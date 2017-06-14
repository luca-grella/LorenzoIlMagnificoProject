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
    
    public boolean isEmpty(){
    	if(this.wood.getQuantity() != 0){
			return false;
		}
		if(this.rock.getQuantity() != 0){
			return false;
		}
		if(this.coin.getQuantity() != 0){
			return false;
		}
		if(this.servant.getQuantity() != 0){
			return false;
		}
		if(this.fp.getQuantity() != 0){
			return false;
		}
		if(this.mp.getQuantity() != 0){
			return false;
		}
		if(this.vp.getQuantity() != 0){
			return false;
		}
    	return true;
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
    
    public String toString(){
    	StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		builder.append("Wood: " + this.getWood() + "\n");
		builder.append("Rock: " + this.getRock() + "\n");
		builder.append("Coin: " + this.getCoin() + "\n");
		builder.append("Servant: " + this.getServants() + "\n");
		builder.append("FP: " + this.getFP() + "\n");
		builder.append("MP: " + this.getMP() + "\n");
		builder.append("VP: " + this.getVP() + "\n");
		builder.append("-----------------\n");
		return builder.toString();
    }
    
    public String toStringCost(){
    	StringBuilder builder = new StringBuilder();
		builder.append("-----------------\n");
		if(this.getWood() != 0){
			builder.append("Wood: " + this.getWood() + "\n");
		}
		if(this.getRock() != 0){
			builder.append("Rock: " + this.getRock() + "\n");
		}
		if(this.getCoin() != 0){
			builder.append("Coin: " + this.getCoin() + "\n");
		}
		if(this.getServants() != 0){
			builder.append("Servant: " + this.getServants() + "\n");
		}
		if(this.getFP() != 0){
			builder.append("FP: " + this.getFP() + "\n");
		}
		if(this.getMP() != 0){
			builder.append("MP: " + this.getMP() + "\n");
		}
		if(this.getVP() != 0){
			builder.append("VP: " + this.getVP() + "\n");
		}
		builder.append("-----------------\n");
		return builder.toString();
    	
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
