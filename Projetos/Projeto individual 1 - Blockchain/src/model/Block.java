package model;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Block_IF;
import util.HashUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Block implements Block_IF {
	
	//attributes
	private int id;
	private String timestamp;
	private ArrayList<Transaction> transactions;
	private String previousHash;
	private String hash;
	private int nonce;
	
	//constructor
	public Block(int id, ArrayList<Transaction> transactions, String previousHash) {
		// Guardando atributos já transmitidos
		this.id = id;
		this.transactions = transactions;
        this.previousHash = previousHash;
		
        // Solicita a hora local, formata ela no padrão BR e guarda no carimbo de tempo
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter DTFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.timestamp = DTFormat.format(currentDateTime);
		
        // Gera um número aleatório para o nonce, já que o processo de mineração não está implementado
        Random random = new Random();
        this.nonce = random.nextInt(1000000);
        
        // Calcula o hash do bloco
        this.hash = calculateHash();;
	}
	
	//methods
	@Override
	public String calculateHash() {
		// Concatena todos os dados necessários para gerar o hash do bloco.
		String dataToHash = this.id + this.timestamp + this.transactions 
				+ this.previousHash + this.nonce;
		
		// Envia o hash para a função applySHA256 e retorna o resultado.
		return HashUtil.applySHA256(dataToHash);
	}
	
	//getters and setters
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getPreviousHash() {
		return this.previousHash;
	}

	@Override
	public String getHash() {
		return this.hash;
	}

	@Override
	public String getTimestamp() {
		return this.timestamp;
	}

	@Override
	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	@Override
	public int getNonce() {
		return this.nonce;
	}

}
