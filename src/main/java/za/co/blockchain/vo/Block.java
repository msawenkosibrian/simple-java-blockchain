package za.co.blockchain.vo;

import org.json.simple.JSONObject;

import za.co.blockchain.Difficulty;
import za.co.blockchain.utils.BlockchainUtils;

/**
 * @author Msawenkosi Ntuli
 *
 */
public class Block {

	private int index;
	private String hash;
	private Block prevBlock;
	private String timestamp;
	private int nonce;
	private Data data;
	
	public Block(int index, String timestamp, Data data) {

		this.index = index;
		this.data = data;
		this.timestamp = timestamp;
		this.hash = hash();
	}

	public final int getIndex() {
		
		return index;
	}

	public String getHash() {
		
		if (hash != null || !hash.isEmpty()) {
			return hash;
		}
		return hash();
	}
	
	public void mine(Difficulty level) {
		
		while (!BlockchainUtils.isValidHashDifficulty(hash, level)) {
			++nonce;
			hash = hash();
		}
	}
	
	private String hash() {
		
		return BlockchainUtils.hash(String.valueOf(index), (prevBlock != null)? prevBlock.getHash(): "", timestamp, (data != null)? data.toString(): "", String.valueOf(nonce));
	}

	public final Block getPrevBlock() {
		
		return prevBlock;
	}

	public void setPrevBlock(Block prevBlock) {
		
		this.prevBlock = prevBlock;
	}

	public final String getPrevHash() {
		
		return this.prevBlock.getHash();
	}

	public final Data getData() {
		
		return data;
	}

	@Override
	public String toString() {
		
		JSONObject obj = new JSONObject();
		obj.put("index", new Integer(index));
		obj.put("hash", hash);
		obj.put("prevHash", (this.prevBlock != null)? this.prevBlock.getHash(): "");
		obj.put("timestamp", timestamp);
		obj.put("data", (this.data != null)? data.toString(): "Genesis block");
		return obj.toJSONString();
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + index;
		result = prime * result + ((prevBlock == null) ? 0 : prevBlock.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (index != other.index)
			return false;
		if (prevBlock == null) {
			if (other.prevBlock != null)
				return false;
		} else if (!prevBlock.equals(other.prevBlock))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
