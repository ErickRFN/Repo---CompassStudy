package model;

import java.util.ArrayList;
import interfaces.Blockchain_IF;

public class Blockchain implements Blockchain_IF {
	
	//attributes
	private ArrayList<Block> chain;

	//construct
	public Blockchain() {
        initializeBlockchain();
        createGenesisBlock();
    }
	
	//methods
	private void initializeBlockchain() {
		this.chain = new ArrayList<Block>();
	}
	
    private void createGenesisBlock() {
    	// Criando a coinbase transaction destinada a mim no genesis block
    	Transaction coinBaseTransaction = new Transaction("CoinBase", "Erick", 1000.00);
    	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    	transactions.add(coinBaseTransaction);
    	
    	Block genesisBlock = new Block(0, transactions, "0");
    	
        this.chain.add(genesisBlock);
    }
    
    @Override
	public void addBlock(Block newBlock) {
		this.chain.add(newBlock);
	}
    
    @Override
	public boolean isChainValid() {
    	
    	int indexCurrentBlock; 
    	for(indexCurrentBlock = this.chain.size() - 1; indexCurrentBlock > 0; indexCurrentBlock--) {
    		Block currentBlock = this.chain.get(indexCurrentBlock);
    		Block previousBlock = this.chain.get(indexCurrentBlock - 1);
    		
    		// Atualiza o hash do bloco atual e do anterior por segurança
    		currentBlock.updateHashCode();
    		previousBlock.updateHashCode();
    		
    		// Verifica se a hash do bloco anterior corresponde ao hash que está no bloco atual
    		if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())){
    			return false;
    		}
    	}
    	
    	/*
    	 * Se nenhuma inconsistência for encrontrada, o laço FOR acabará e a blockchain
    	 * será considerada válida.
    	 */
		return true;
		
	}

    //getters and setters
	@Override
	public Block getLatestBlock() {
		return chain.get(chain.size() - 1);
	}

	//toString
	@Override
	public void displayChain() {
		for (Block block : chain) {
            System.out.println("Block ID: " + block.getId());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Nonce: " + block.getNonce());
            System.out.println("-------------------------------");
        }
	}

}
