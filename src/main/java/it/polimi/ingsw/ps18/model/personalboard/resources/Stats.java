package it.polimi.ingsw.ps18.model.personalboard.resources;

import org.json.simple.JSONArray;

/**
 * The Class Stats.
 */
public class Stats {
	
	/**
	 * The wood.
	 */
	private Resources wood;
	
	/**
	 * The rock.
	 */
	private Resources rock;
	
	/**
	 * The coin.
	 */
	private Resources coin;
	
	/**
	 * The servant.
	 */
	private Resources servant;
	
	/**
	 * The fp.
	 */
	private Points fp;
	
	/**
	 * The mp.
	 */
	private Points mp;
	
	/**
	 * The vp.
	 */
	private Points vp;
	
	/**
	 * Instantiates a new stats.
	 *
	 * @param wood
	 *            the wood
	 * @param rock
	 *            the rock
	 * @param coin
	 *            the coin
	 * @param servant
	 *            the servant
	 * @param fp
	 *            the fp
	 * @param mp
	 *            the mp
	 * @param vp
	 *            the vp
	 */
	public Stats(int wood, int rock, int coin, int servant, int fp, int mp, int vp){
		this.wood = new Wood(wood);
		this.rock = new Rock(rock);
		this.coin = new Coins(coin);
		this.servant = new Servants(servant);
		this.fp = new FaithPoints(fp);
		this.mp = new MilitaryPoints(mp);
		this.vp = new VictoryPoints(vp);
	}
	
	public Stats(Stats stat){
		this.wood = new Wood(stat.getWood());
		this.rock = new Rock(stat.getRock());
		this.coin = new Coins(stat.getCoin());
		this.servant = new Servants(stat.getServants());
		this.fp = new FaithPoints(stat.getFP());
		this.mp = new MilitaryPoints(stat.getMP());
		this.vp = new VictoryPoints(stat.getVP());
	}
	
    /**
	 * Instantiates a new stats.
	 *
	 * @param costs
	 *            the costs
	 */
    public Stats(JSONArray costs) {
		this.wood = new Wood((long) costs.get(0));
		this.rock = new Rock((long) costs.get(1));
		this.coin = new Coins((long) costs.get(2));
		this.servant = new Servants((long) costs.get(3));
		this.fp = new FaithPoints((long) costs.get(6));
		this.mp = new MilitaryPoints((long) costs.get(5));
		this.vp = new VictoryPoints((long) costs.get(4));
	}
    
    /**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
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
    
    /**
	 * Adds the stats.
	 *
	 * @param adder
	 *            the adder
	 */
    public void addStats(Stats adder){
    	addWood(adder.getWood());
    	addRock(adder.getRock());
    	addCoins(adder.getCoin());
    	addServants(adder.getServants());
    	addFP(adder.getFP());
    	addMP(adder.getMP());
    	addVP(adder.getVP());
    }
    
    /**
	 * Sub stats.
	 *
	 * @param subber
	 *            the subber
	 */
    public void subStats(Stats subber){
    	addWood(-(subber.getWood()));
    	addRock(-(subber.getRock()));
    	addCoins(-(subber.getCoin()));
    	addServants(-(subber.getServants()));
    	addFP(-(subber.getFP()));
    	addMP(-(subber.getMP()));
    	addVP(-(subber.getVP()));
    }
    
    /**
	 * Enough stats.
	 *
	 * @param neededStats
	 *            the needed stats
	 * @return true, if successful
	 */
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
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
    
    /**
	 * To string cost.
	 *
	 * @return the string
	 */
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



	/**
	 * Adds the wood.
	 *
	 * @param value
	 *            the value
	 */
	public void addWood(int value){
		this.wood.addQuantity(value);
	}
	
    /**
	 * Adds the rock.
	 *
	 * @param value
	 *            the value
	 */
    public void addRock(int value){
		this.rock.addQuantity(value);
	}
    
    /**
	 * Adds the coins.
	 *
	 * @param value
	 *            the value
	 */
    public void addCoins(int value){
		this.coin.addQuantity(value);
	}
    
    /**
	 * Adds the servants.
	 *
	 * @param value
	 *            the value
	 */
    public void addServants(int value){
		this.servant.addQuantity(value);
	}
    
    /**
	 * Adds the FP.
	 *
	 * @param value
	 *            the value
	 */
    public void addFP(int value){
		this.fp.addQuantity(value);
	}
    
    /**
	 * Adds the VP.
	 *
	 * @param value
	 *            the value
	 */
    public void addVP(int value){
		this.vp.addQuantity(value);
	}
    
    /**
	 * Adds the MP.
	 *
	 * @param value
	 *            the value
	 */
    public void addMP(int value){
		this.mp.addQuantity(value);
	}
    
    /**
	 * Gets the wood.
	 *
	 * @return the wood
	 */
    public int getWood(){
    	return this.wood.getQuantity();
    }
    
    /**
	 * Gets the rock.
	 *
	 * @return the rock
	 */
    public int getRock(){
    	return this.rock.getQuantity();
    }
    
    /**
	 * Gets the coin.
	 *
	 * @return the coin
	 */
    public int getCoin(){
    	return this.coin.getQuantity();
    }
    
    /**
	 * Gets the servants.
	 *
	 * @return the servants
	 */
    public int getServants(){
    	return this.servant.getQuantity();
    }
    
    /**
	 * Gets the fp.
	 *
	 * @return the fp
	 */
    public int getFP(){
    	return this.fp.getQuantity();
    }
    
    /**
	 * Gets the mp.
	 *
	 * @return the mp
	 */
    public int getMP(){
    	return this.mp.getQuantity();
    }
    
    /**
	 * Gets the vp.
	 *
	 * @return the vp
	 */
    public int getVP(){
    	return this.vp.getQuantity();
    }

	/**
	 * @param wood the wood to set
	 */
	public void setWood(Resources wood) {
		this.wood = wood;
	}

	/**
	 * @param rock the rock to set
	 */
	public void setRock(Resources rock) {
		this.rock = rock;
	}

	/**
	 * @param coin the coin to set
	 */
	public void setCoin(Resources coin) {
		this.coin = coin;
	}

	/**
	 * @param servant the servant to set
	 */
	public void setServant(Resources servant) {
		this.servant = servant;
	}

	/**
	 * @param fp the fp to set
	 */
	public void setFp(Points fp) {
		this.fp = fp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(Points mp) {
		this.mp = mp;
	}

	/**
	 * @param vp the vp to set
	 */
	public void setVp(Points vp) {
		this.vp = vp;
	}

	public void fixStats() {
		if(this.getWood() < 0){
			this.setWood(new Wood(0));
		}
		if(this.getRock() < 0){
			this.setRock(new Rock(0));
		}
		if(this.getCoin() < 0){
			this.setCoin(new Coins(0));
		}
		if(this.getServants() < 0){
			this.setServant(new Servants(0));
		}
		if(this.getFP() < 0){
			this.setFp(new FaithPoints(0));
		}
		if(this.getMP() < 0){
			this.setMp(new MilitaryPoints(0));
		}
		if(this.getVP() < 0){
			this.setVp(new VictoryPoints(0));
		}
		
	}
    
    

}
