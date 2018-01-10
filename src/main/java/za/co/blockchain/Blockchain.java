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
	private Difficulty level = Difficulty.EASY;
	
	public Blockchain(Difficulty level) {
		
		this.level = level;
		blockManager = new BlockManagerImpl();
		genesis = blockManager.createBlock(0, null, level);
		genesis.setPrevBlock(null);
		tail = genesis;
		size++;
	}
	
	public Difficulty getMiningDifficulty() {
		
		return level;
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
	
	/**
	 * JSON String representation of Blockchain object.
	 * 
	 * e.g:
	   [
		  {
		    "data": "Genesis block",
		    "prevHash": "",
		    "index": 0,
		    "hash": "0ff2dff8fbb9ae9e7a75821515f4e13542a47d7b0e2f2165dcd3775ef5427a1e",
		    "timestamp": "1515486310545"
		  },
		  {
		    "data": "{\"amount\":0.0,\"balance\":0.0,\"from\":\"000000000000\",\"to\":\"111111111111\"}",
		    "prevHash": "0ff2dff8fbb9ae9e7a75821515f4e13542a47d7b0e2f2165dcd3775ef5427a1e",
		    "index": 1,
		    "hash": "06b14692bed3b43a595eaadb5b36bf4deffe253a67f047a1d225ef999fbb14c6",
		    "timestamp": "1515486310546"
		  },
		  {
		    "data": "{\"amount\":0.0,\"balance\":0.0,\"from\":\"222222222222\",\"to\":\"333333333333\"}",
		    "prevHash": "f8f670879de0d1c8e766f4f83a3480ef604dcc71f56297ba27bf8e6dff424ba0",
		    "index": 2,
		    "hash": "041e57521543787bce927f70e163d0cc98a6926430ca1616f5842ad798fc4b69",
		    "timestamp": "1515486310549"
		  }
		  ...
		]
	 * 
	 * @return A string representing the object.
	 */
	public String toString() {
		
		int position = size - 1;
		Block current = tail;
		JSONArray array = new JSONArray();
		array.add(current);
		while (current.getPrevBlock() != null) {
			current = current.getPrevBlock();
			position=-1;
			array.add(0, current);
		}
		return array.toJSONString();
	}
}
