package za.co.blockchain;

import static org.junit.Assert.*;

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
		blockchain = new Blockchain();
	}

	@Test
	public void testSize() {
		
		assertEquals(blockchain.getSize(), 1);
	}
	
	@Test
	public void testGenesisBlock() {
		
		Block tail = blockchain.getTail();
		assertEquals(tail.getIndex(), 0);
		System.out.println(tail.toString());
		
	}
	
	@Test
	public void testAddBlock() {
		
		Data data = new Data();
		data.setFrom("000000000000");
		data.setTo("111111111111");
		
		Block block = blockManager.createBlock(blockchain.getSize(), data);
		blockchain.addBlock(block);
		
		System.out.println(blockchain.toString());
		fail("");
	}
}
