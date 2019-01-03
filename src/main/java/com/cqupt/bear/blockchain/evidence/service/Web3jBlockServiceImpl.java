package com.cqupt.bear.blockchain.evidence.service;

import java.io.IOException;

import org.apache.tomcat.util.buf.HexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.EthTransaction;

import com.cqupt.bear.blockchain.evidence.dto.BlockchainTransaction;
import com.cqupt.bear.blockchain.evidence.dto.EvidenceInfo;

/**
 * @author Y.bear
 * @version 创建时间：2018年12月30日 上午11:48:24 类说明
 */
@Service
public class Web3jBlockServiceImpl implements BlockService {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	private Web3j web3j;

	@Override
	public void depoly() {

	}

	@Override
	public BlockchainTransaction upload(BlockchainTransaction trx) throws IOException {
		EthAccounts accounts = web3j.ethAccounts().send();
		Transaction transaction = Transaction.createEthCallTransaction(accounts.getAccounts().get(trx.getFromId()),
				accounts.getAccounts().get(trx.getToId()), HexUtils.toHexString(trx.getData().getBytes("UTF-8")));
		EthSendTransaction response = web3j.ethSendTransaction(transaction).send();
		if (response.getError() != null) {
			trx.setAccepted(false);
			LOGGER.info("Tx rejected: {}", response.getError().getMessage());
			return trx;
		}
		trx.setAccepted(true);
		String txHash = response.getTransactionHash();
		LOGGER.info("Tx hash: {}", txHash);
		trx.setId(txHash);
		EthGetTransactionReceipt receipt = web3j.ethGetTransactionReceipt(txHash).send();
		receipt.getTransactionReceipt().ifPresent(transactionReceipt -> LOGGER.info("Tx receipt:  {}",
				transactionReceipt.getCumulativeGasUsed().intValue()));
		return trx;
	}

	@Override
	public EvidenceInfo query(String txHash) throws Exception {
		EthTransaction transaction = web3j.ethGetTransactionByHash(txHash).send();
		String data = new String(HexUtils.fromHexString(transaction.getResult().getInput().substring(2)));
		String blockHash = transaction.getResult().getBlockHash();
		String height = transaction.getResult().getBlockNumber().toString();
		LOGGER.info("txHash:" + txHash + "----" + "evidenceInput:" + data);
		BlockchainTransaction blockchainTransaction = new BlockchainTransaction();
		blockchainTransaction.setData(data);
		EvidenceInfo evidenceInfo = new EvidenceInfo(data, blockHash, txHash, height);
		evidenceInfo.setTransaction(blockchainTransaction);
		return evidenceInfo;
	}
}
