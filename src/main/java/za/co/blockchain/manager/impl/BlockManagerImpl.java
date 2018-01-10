package za.co.blockchain.manager.impl;

import za.co.blockchain.Difficulty;
import za.co.blockchain.manager.BlockManager;
import za.co.blockchain.utils.BlockchainUtils;
import za.co.blockchain.vo.Block;
import za.co.blockchain.vo.Data;

/**
 * @author Msawenkosi Ntuli
 *
 */
public class BlockManagerImpl implements BlockManager {

	@Override
	public Block createBlock(int index, Data data, Difficulty level) {

		String timestamp = String.valueOf(BlockchainUtils.getTimestamp());
		Block block = new Block(index, timestamp, data);
		block.mine(level);
		return block;
	}
}
