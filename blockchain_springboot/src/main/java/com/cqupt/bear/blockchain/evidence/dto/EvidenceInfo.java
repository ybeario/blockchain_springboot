package com.cqupt.bear.blockchain.evidence.dto;

/**
 * @author Y.bear
 * @version 创建时间：2018年12月20日 上午9:51:55 类说明
 */
public class EvidenceInfo {
    private String MD5;
    private String blockId;
    private String transactionId;
    private String height;
    private BlockchainTransaction transaction;

    public EvidenceInfo(String MD5, String blockId, String transactionId, String height) {
        super();
        this.MD5 = MD5;
        this.blockId = blockId;
        this.transactionId = transactionId;
        this.height = height;
    }

    public EvidenceInfo(String mD5, String blockId, String transactionId, String height,
                        BlockchainTransaction transaction) {
        super();
        MD5 = mD5;
        this.blockId = blockId;
        this.transactionId = transactionId;
        this.height = height;
        this.transaction = transaction;
    }

    public String getMD5() {
        return MD5;
    }

    public BlockchainTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(BlockchainTransaction transaction) {
        this.transaction = transaction;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "EvidenceInfo [MD5=" + MD5 + ", blockId=" + blockId + ", transactionId=" + transactionId + ", height="
                + height + "]";
    }

}
