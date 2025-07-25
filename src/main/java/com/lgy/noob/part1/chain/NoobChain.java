package com.lgy.noob.part1.chain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * @author Johnson
 */
public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;


    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.getFirst().mineBlock(difficulty);
        blockchain.add(new Block("Yo im the second block",blockchain.getLast().hash));
        blockchain.get(1).mineBlock(difficulty);
        blockchain.add(new Block("Hey im the third block",blockchain.getLast().hash));
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {

        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for (int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ){
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }

        return true;
    }
}
