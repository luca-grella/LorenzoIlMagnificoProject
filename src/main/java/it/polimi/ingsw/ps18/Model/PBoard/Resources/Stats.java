package it.polimi.ingsw.ps18.Model.PBoard.Resources;

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
