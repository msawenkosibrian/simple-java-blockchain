package za.co.blockchain.manager;

import za.co.blockchain.vo.Block;
import za.co.blockchain.vo.Data;

/**
 * @author Msawenkosi Ntuli
 *
 */
public interface BlockManager {

	public Block createBlock(int index, Data data);
}
