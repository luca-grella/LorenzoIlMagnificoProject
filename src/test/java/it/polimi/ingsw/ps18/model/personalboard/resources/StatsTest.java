/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.json.simple.JSONArray;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class StatsTest.
 *
 * @author luca-grella
 */
public class StatsTest {
	
	/**
	 * The rand.
	 */
	Random rand  = new Random();
	
	/**
	 * The wood.
	 */
	int wood = rand.nextInt(1000);
	
	/**
	 * The rock.
	 */
	int rock = rand.nextInt(1000);
	
	/**
	 * The coin.
	 */
	int coin = rand.nextInt(1000);
	
	/**
	 * The servant.
	 */
	int servant = rand.nextInt(1000);
	
	/**
	 * The fp.
	 */
	int fp = rand.nextInt(1000);
	
	/**
	 * The mp.
	 */
	int mp = rand.nextInt(1000);
	
	/**
	 * The vp.
	 */
	int vp = rand.nextInt(1000);


	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#Stats(int, int, int, int, int, int, int)}.
	 */
	@Test
	public void testStatsIntIntIntIntIntIntInt() {
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getWood();
		if(wood!=ris){
			fail("errore in Stats (wood)");
			}
		ris = tester.getRock();
		if(rock!=ris){
			fail("errore in Stats (rock)");
			}
		ris = tester.getCoin();
		if(coin!=ris){
			fail("errore in Stats (coin)");
			}
		ris = tester.getServants();
		if(servant!=ris){
			fail("errore in Stats (servant)");
			}
		ris = tester.getFP();
		if(fp!=ris){
			fail("errore in Stats (fp)");
			}
		ris = tester.getMP();
		if(mp!=ris){
			fail("errore in Stats (mp)");
			}
		ris = tester.getVP();
		if(vp!=ris){
			fail("errore in Stats (vp)");
			}
	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#Stats(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testStatsJSONArray() {
		JSONArray randvet = new JSONArray();
		long wood = rand.nextInt(1000);
		long rock = rand.nextInt(1000);
		long coin = rand.nextInt(1000);
		long servant = rand.nextInt(1000);
		long fp = rand.nextInt(1000);
		long mp = rand.nextInt(1000);
		long vp = rand.nextInt(1000);
		randvet.add(wood);
		randvet.add(rock);
		randvet.add(coin);
		randvet.add(servant);
		randvet.add(vp);
		randvet.add(mp);
		randvet.add(fp);
		
		Stats tester = new Stats(randvet);
		int ris = tester.getWood();
		if(wood!=ris){
			fail("errore in Stats (wood)");
			}
		ris = tester.getRock();
		if(rock!=ris){
			fail("errore in Stats (wood)");
			}
		ris = tester.getCoin();
		if(coin!=ris){
			fail("errore in Stats (coin)");
			}
		ris = tester.getServants();
		if(servant!=ris){
			fail("errore in Stats (servant)");
			}
		ris = tester.getFP();
		if(fp!=ris){
			fail("errore in Stats (fp)");
			}
		ris = tester.getMP();
		if(mp!=ris){
			fail("errore in Stats (mp)");
			}
		ris = tester.getVP();
		if(vp!=ris){
			fail("errore in Stats (vp)");
			}
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		int wood=0;
		int rock=0;
		int coin=0;
		int servant=0;
		int fp=0;
		int mp=0;
		int vp=0;
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		boolean empty = tester.isEmpty();
		assertTrue(empty);
		
		tester = new Stats(1, 0, 0, 0, 0, 0, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));
		
		tester = new Stats(0, 1, 0, 0, 0, 0, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));

		tester = new Stats(0, 0, 1, 0, 0, 0, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));
		
		tester = new Stats(0, 0, 0, 1, 0, 0, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));
		
		tester = new Stats(0, 0, 0, 0, 1, 0, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));
		
		tester = new Stats(0, 0, 0, 0, 0, 1, 0);
		empty = tester.isEmpty();
		assertTrue(!(empty));
		
		tester = new Stats(0, 0, 0, 0, 0, 0, 1);
		empty = tester.isEmpty();
		assertTrue(!(empty));
	}
	
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addStats(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testAddStats() {
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		int wood2 = rand.nextInt(1000);
		int rock2 = rand.nextInt(1000);
		int coin2 = rand.nextInt(1000);
		int servant2 = rand.nextInt(1000);
		int fp2 = rand.nextInt(1000);
		int mp2 = rand.nextInt(1000);
		int vp2 = rand.nextInt(1000);	
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		Stats tester2 = new Stats(wood2, rock2, coin2, servant2, fp2, mp2, vp2);
		int ris = tester.getWood();
		int ris1 = tester.getRock();
		int ris2 = tester.getCoin();
		int ris3 = tester.getServants();
		int ris4 = tester.getFP();
		int ris5 = tester.getMP();
		int ris6 = tester.getVP();
		int ris7 = tester2.getWood();
		int ris8 = tester2.getRock();
		int ris9 = tester2.getCoin();
		int ris10 = tester2.getServants();
		int ris11 = tester2.getFP();
		int ris12 = tester2.getMP();
		int ris13 = tester2.getVP();
		tester.addStats(tester2);
		int ri = tester.getWood();
		int ri1 = tester.getRock();
		int ri2 = tester.getCoin();
		int ri3 = tester.getServants();
		int ri4 = tester.getFP();
		int ri5 = tester.getMP();
		int ri6 = tester.getVP();
				
		assertEquals(ris+ris7, ri);
		assertEquals(ris1+ris8, ri1);
		assertEquals(ris2+ris9, ri2);
		assertEquals(ris3+ris10, ri3);
		assertEquals(ris4+ris11, ri4);
		assertEquals(ris5+ris12, ri5);
		assertEquals(ris6+ris13, ri6);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#subStats(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSubStats() {
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		int wood2 = rand.nextInt(1000);
		int rock2 = rand.nextInt(1000);
		int coin2 = rand.nextInt(1000);
		int servant2 = rand.nextInt(1000);
		int fp2 = rand.nextInt(1000);
		int mp2 = rand.nextInt(1000);
		int vp2 = rand.nextInt(1000);	
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		Stats tester2 = new Stats(wood2, rock2, coin2, servant2, fp2, mp2, vp2);
		int ris = tester.getWood();
		int ris1 = tester.getRock();
		int ris2 = tester.getCoin();
		int ris3 = tester.getServants();
		int ris4 = tester.getFP();
		int ris5 = tester.getMP();
		int ris6 = tester.getVP();
		int ris7 = tester2.getWood();
		int ris8 = tester2.getRock();
		int ris9 = tester2.getCoin();
		int ris10 = tester2.getServants();
		int ris11 = tester2.getFP();
		int ris12 = tester2.getMP();
		int ris13 = tester2.getVP();
		tester.subStats(tester2);
		int ri = tester.getWood();
		int ri1 = tester.getRock();
		int ri2 = tester.getCoin();
		int ri3 = tester.getServants();
		int ri4 = tester.getFP();
		int ri5 = tester.getMP();
		int ri6 = tester.getVP();
				
		assertEquals(ris-ris7, ri);
		assertEquals(ris1-ris8, ri1);
		assertEquals(ris2-ris9, ri2);
		assertEquals(ris3-ris10, ri3);
		assertEquals(ris4-ris11, ri4);
		assertEquals(ris5-ris12, ri5);
		assertEquals(ris6-ris13, ri6);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#enoughStats(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testEnoughStats() {
		int wood=5;
		int rock=7;
		int coin=14;
		int servant=24;
		int fp=10;
		int mp=9;
		int vp=33;
		int woodneeded=1;
		int rockneeded=2;
		int coinneeded=4;
		int servantneeded=4;
		int fpneeded=3;
		int mpneeded=2;
		int vpneeded=2;
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		Stats neededStats = new Stats(woodneeded, rockneeded, coinneeded, servantneeded, fpneeded, mpneeded, vpneeded);
		boolean isenough = tester.enoughStats(neededStats);
		assertTrue(isenough);
		
		int zero = 0;
		tester = new Stats(zero, rock, coin, servant, fp, mp, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, zero, coin, servant, fp, mp, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, rock, zero, servant, fp, mp, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, rock, coin, zero, fp, mp, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, rock, coin, servant, zero, mp, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, rock, coin, servant, fp, zero, vp);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
		
		tester = new Stats(wood, rock, coin, servant, fp, mp, zero);
		isenough = tester.enoughStats(neededStats);
		assertTrue(!(isenough));
	}
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addWood(int)}.
	 */
	@Test
	public void testAddWood() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getWood();
		tester.addWood(a);
		int ris2 = tester.getWood();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addRock(int)}.
	 */
	@Test
	public void testAddRock() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getRock();
		tester.addRock(a);
		int ris2 = tester.getRock();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addCoins(int)}.
	 */
	@Test
	public void testAddCoins() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getCoin();
		tester.addCoins(a);
		int ris2 = tester.getCoin();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addServants(int)}.
	 */
	@Test
	public void testAddServants() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getServants();
		tester.addServants(a);
		int ris2 = tester.getServants();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addFP(int)}.
	 */
	@Test
	public void testAddFP() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getFP();
		tester.addFP(a);
		int ris2 = tester.getFP();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addVP(int)}.
	 */
	@Test
	public void testAddVP() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getVP();
		tester.addVP(a);
		int ris2 = tester.getVP();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#addMP(int)}.
	 */
	@Test
	public void testAddMP() {
		
		int a = rand.nextInt(1000);
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);

		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getMP();
		tester.addMP(a);
		int ris2 = tester.getMP();
		assertEquals(ris + a, ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getWood()}.
	 */
	@Test
	public void testGetWood() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getWood();
		if(wood!=ris){
			fail("errore nel getWood");
		}}
	

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getRock()}.
	 */
	@Test
	public void testGetRock() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getRock();
		if(rock!=ris){
			fail("errore nel getRock");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getCoin()}.
	 */
	@Test
	public void testGetCoin() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getCoin();
		if(coin!=ris){
			fail("errore nel getCoin");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getServants()}.
	 */
	@Test
	public void testGetServants() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getServants();
		if(servant!=ris){
			fail("errore nel getServants");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getFP()}.
	 */
	@Test
	public void testGetFP() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getFP();
		if(fp!=ris){
			fail("errore nel getFP");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getMP()}.
	 */
	@Test
	public void testGetMP() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getMP();
		if(mp!=ris){
			fail("errore nel getMP");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Stats#getVP()}.
	 */
	@Test
	public void testGetVP() {
		
		int wood = rand.nextInt(1000);
		int rock = rand.nextInt(1000);
		int coin = rand.nextInt(1000);
		int servant = rand.nextInt(1000);
		int fp = rand.nextInt(1000);
		int mp = rand.nextInt(1000);
		int vp = rand.nextInt(1000);
		
		Stats tester = new Stats(wood, rock, coin, servant, fp, mp, vp);
		int ris = tester.getVP();
		if(vp!=ris){
			fail("errore nel getVP");
		}}
	
	@Test
	public void testToString() {
		
		int wood1 = rand.nextInt(1000);
		int rock1 = rand.nextInt(1000);
		int coin1 = rand.nextInt(1000);
		int fp1 = rand.nextInt(1000);
		int mp1 = rand.nextInt(1000);
		int vp1 = rand.nextInt(1000);
		
		Stats tester = new Stats(wood1, rock1, coin1, 0, fp1, mp1, vp1);
		tester.toStringServants();
		
		
		
			int wood=0;
			int rock=0;
			int coin=0;
			int servant=0;
			int fp=0;
			int mp=0;
			int vp=0;
			
			
			
			tester = new Stats(1, 0, 0, 0, 0, 0, 0);
			tester.toStringCost();
			
			tester = new Stats(0, 1, 0, 0, 0, 0, 0);
			tester.toStringCost();

			tester = new Stats(0, 0, 1, 0, 0, 0, 0);
			tester.toStringCost();
			
			tester = new Stats(0, 0, 0, 1, 0, 0, 0);
			tester.toStringCost();
			
			tester = new Stats(0, 0, 0, 0, 1, 0, 0);
			tester.toStringCost();
			
			tester = new Stats(0, 0, 0, 0, 0, 1, 0);
			tester.toStringCost();
			
			tester = new Stats(0, 0, 0, 0, 0, 0, 1);
			tester.toStringCost();
	
	}
	
	@Test(expected = AssertionError.class)
	public void testFixStats() {
		
		Stats tester = new Stats(-1, -1, -1, -1, -1, -1, -1);
		Stats prova = new Stats(0,0,0,0,0,0,0);
		tester.fixStats();
		
		assertEquals(prova, tester);
		
		}
	
	@Test(expected = AssertionError.class)
	public void testSets() {
		
		
		Stats tester = new Stats(0,0,0,0,0,0,0);
		Resources wood = new Wood(1);
		tester.setWood(wood);
		
		Resources rock = new Rock(1);
		tester.setRock(rock);
		
		Resources coin = new Coins(1);
		tester.setCoin(coin);
		
		Resources servant = new Servants(1);
		tester.setServant(servant);
		
		Points fp = new FaithPoints(1);
		tester.setFp(fp);
		
		Points mp = new MilitaryPoints(1);
		tester.setMp(mp);
		
		Points vp = new VictoryPoints(1);
		tester.setVp(vp);
		
		assertEquals(new Stats(1,1,1,1,1,1,1), tester);
		
		}
	

}
