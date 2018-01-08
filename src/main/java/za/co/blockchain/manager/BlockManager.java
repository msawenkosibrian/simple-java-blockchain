package za.co.blockchain.manager;

import za.co.blockchain.vo.Block;
import za.co.blockchain.vo.Data;

public interface BlockManager {

	public Block createBlock(int index, Data data);
	//public String mineBlock(Difficulty difficulty, Block block);
}
