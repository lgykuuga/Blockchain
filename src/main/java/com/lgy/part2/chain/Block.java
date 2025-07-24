package com.lgy.part2.chain;

import com.lgy.part2.trade.Transaction;
import com.lgy.util.StringUtil;

import java.util.ArrayList;

/**
 * @author Johnson
 */
public class Block {

    public String hash;
    public String previousHash;
    private String merkleRoot;
    public ArrayList<Transaction> transactions = new ArrayList<>();
    private long timeStamp;
    private int nonce;

    //Block Constructor.
    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();

        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        timeStamp +
                        nonce +
                        merkleRoot
        );
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    public boolean addTransaction(Transaction transaction) {

        if (transaction == null) {
            return false;
        }

        if ((previousHash != "0")) {
            if ((transaction.processTransaction() != true)) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }

        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }

}
