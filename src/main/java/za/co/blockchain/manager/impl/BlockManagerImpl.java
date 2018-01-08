package za.co.blockchain.manager.impl;

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
	public Block createBlock(int index, Data data) {

		String timestamp = String.valueOf(BlockchainUtils.getTimestamp());
		Block block = new Block(index, timestamp, data);
		return block;
	}
}
