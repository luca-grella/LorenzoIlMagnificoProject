import java.util.Scanner;

/**
 * Questa classe gestisce una riserva di animali in via di estinzione.
 * In particolare, è in grado di predire l'andamento della popolazione
 * prendendo come imput la popolazione attuale e il suo tasso di crescita.
 * 
 * @author yaz
 * 
 */

public class SpeciePrimaProva {
	
	private String name;
	private int population;
	private double growRate;
	
	public void readImput(){
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the species name?");
		name = keyboard.nextLine();
		System.out.println("What is the population number?");
		population = keyboard.nextInt();
		System.out.println("Insert the grow rate (% grow per year)");
		growRate = keyboard.nextDouble();
	}
	
	public void writeOutput(){
		
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Grow rate = " + growRate);
	}
	
	public int predictPopulation(int year){
		
		int result = 0;
		double totalPopulation = population;
		int count = year;
		
		while((count > 0) && (totalPopulation > 0)){
			totalPopulation = (totalPopulation + (growRate/100) * totalPopulation);
			count--;
		}
		
		if (totalPopulation > 0)
			result = (int) totalPopulation;
		return result;
	}
	
	public void setSpecies(String newName, int newPopulation, double newGrowRate){
		
		name = newName;
		if(newPopulation > 0)
			population = newPopulation;
		else{
			System.out.println("ERROR: negative number!");
			System.exit(0);
		}
		growRate = newGrowRate;
	}
	
	public String getName(){
		return name;
	}
	public int getPopulation(){
		return population;
	}
	public double getGrowRate(){
		return growRate;
	}
	
}
