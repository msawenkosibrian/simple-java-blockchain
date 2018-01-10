package za.co.blockchain;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import za.co.blockchain.manager.BlockManager;
import za.co.blockchain.manager.impl.BlockManagerImpl;
import za.co.blockchain.utils.BlockchainUtils;
import za.co.blockchain.vo.Block;
import za.co.blockchain.vo.Data;

/**
 * @author Msawenkosi Ntuli
 *
 */
public class BlockchainTest {
	
	private Blockchain blockchain;
	private BlockManager blockManager;

	@Before
	public void setUp() throws Exception {
		
		blockManager = new BlockManagerImpl();
		blockchain = new Blockchain(Difficulty.MEDIUM);
	}

	@Test
	public void testSize() {
		
		assertEquals(blockchain.getSize(), 1);
	}
	
	@Test
	public void testGenesisBlock() {
		
		Block tail = blockchain.getTail();
		assertEquals(tail.getIndex(), 0);
		//System.out.println(tail.toString());
		
	}
	
	@Test
	public void testAddBlock() {
		
		Block block = createBlock("000000000000", "111111111111");
		blockchain.addBlock(block);
		
		Block block1 = createBlock("222222222222", "333333333333");
		blockchain.addBlock(block1);
		
		Object obj;
		try {
			obj = (new JSONParser()).parse(blockchain.toString());
			JSONArray array = (JSONArray)obj;
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(blockchain.toString());
		fail("");
	}
	
	@Test
	public void testIsBlockchainValid() {
		
		assertTrue(BlockchainUtils.isBlockchainValid(blockchain));
	}
	
	private Block createBlock(String from, String to) {
		
		Data data = new Data();
		data.setFrom(from);
		data.setTo(to);
		
		Block block = blockManager.createBlock(blockchain.getSize(), data, blockchain.getMiningDifficulty());
		return block;
	}	
}
