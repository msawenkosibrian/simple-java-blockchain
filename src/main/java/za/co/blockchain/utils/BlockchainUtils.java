package za.co.blockchain.utils;

import java.security.MessageDigest;
import java.util.Date;

import za.co.blockchain.Blockchain;
import za.co.blockchain.Difficulty;
import za.co.blockchain.vo.Block;

/**
 * @author Msawenkosi Ntuli
 *
 */
public final class BlockchainUtils {

	private BlockchainUtils() {}
	
	public static final String hash(String...array) {
		
		StringBuilder sb = new StringBuilder();
		for (String s: array) {
			sb.append(s);
		}
		return sha256(sb.toString());
	}
	
	public static final long getTimestamp() {
		
		return new Date().getTime();
	}
	
	private static final String sha256(String base) {
	    
		try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if (hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } 
		catch (Exception ex) {
	        throw new RuntimeException(ex);
	    }
	}
	
	public static final boolean isValidHashDifficulty(String hash, Difficulty level) {
		
		String target = new String(new char[level.getLevel()]).replace('\0', '0');
		return hash.substring(0, level.getLevel()).equals(target);
	}
	
	/**
	 * Checks if the Blockchain is in a consistent state by comparing hashes of consecutive blocks.
	 * 
	 * @param blockchain
	 * @return 
	 */
	public static final boolean isBlockchainValid(Blockchain blockchain) {
		
		Block tail = blockchain.getTail();
		Block current = tail;
		
		while (current.getPrevBlock() != null) {
			// TODO: recalculate block hash and check for integrity
			
			Block prevBlock = current.getPrevBlock();
			if (current.getPrevHash() != prevBlock.getHash()) {
				return false;
			}
			current = prevBlock;
		}		
		return true;
	}
}
