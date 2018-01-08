package za.co.blockchain;

import org.json.simple.JSONArray;

import za.co.blockchain.manager.BlockManager;
import za.co.blockchain.manager.impl.BlockManagerImpl;
import za.co.blockchain.utils.BlockchainUtils;
import za.co.blockchain.vo.Block;

/**
 * @author Msawenkosi Ntuli
 *
 */
public class Blockchain {

	private int size = 0;
	private Block genesis; // Genesis block.
	private Block tail; // Latest block in the Blockchain.
	private BlockManager blockManager;
	
	public Blockchain() {
		
		blockManager = new BlockManagerImpl();
		genesis = blockManager.createBlock(0, null);
		genesis.setPrevBlock(null);
		tail = genesis;
		size++;
	}
	
	public Block addBlock(Block block) {
		
		assert (block != null);
		block.setPrevBlock(tail);
		tail = block; // Latest block in the Blockchain.
		size++;
		return tail;
	}
	
	/**
	 * Returns the last block on the Blockchain.
	 * 
	 * @return
	 */
	public Block getTail() {
		
		return tail;
	}
	
	public final int getSize() {
		
		return size;
	}
	
	public Blockchain getBlockchain() {
		
		return this;
	}
	
	public String toString() {
		
		Block current = tail;
		JSONArray array = new JSONArray();
		array.add(current);
		while (current.getPrevBlock() != null) {
			current = current.getPrevBlock();
			array.add(current);
		}
		return array.toJSONString();
	}
}
