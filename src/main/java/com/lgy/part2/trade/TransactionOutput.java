package com.lgy.part2.trade;

import com.lgy.util.StringUtil;

import java.security.PublicKey;

/**
 * @author Johnson
 */
public class TransactionOutput {

    public String id;

    /**
     * also known as the new owner of these coins.
     */
    public PublicKey reciepient;

    /**
     * the amount of coins they own
     */
    public float value;

    /**
     * the id of the transaction this output was created in
     */
    public String parentTransactionId;

    //Constructor
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+ value +parentTransactionId);
    }

    //Check if coin belongs to you
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }


    public static void main(String[] args) {

    }
}
