package com.lgy.part2.trade;

/**
 * @author Johnson
 */
public class TransactionInput {

    /**
     * Reference to TransactionOutputs -> transactionId
     */
    public String transactionOutputId;

    /**
     * Contains the Unspent transaction output
     * From this point on we will follow bitcoins convention and call unspent transaction outputs: UTXO’s.
     */
    public TransactionOutput UTXO;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}
