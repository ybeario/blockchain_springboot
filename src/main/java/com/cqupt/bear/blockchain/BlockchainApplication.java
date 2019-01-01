package com.cqupt.bear.blockchain;

import java.io.IOException;
import java.math.BigInteger;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.buf.HexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

@SpringBootApplication
public class BlockchainApplication {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private final Web3j web3j;

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

	@Autowired
	public BlockchainApplication(Web3j web3j) {
		super();
		this.web3j = web3j;
	}

	@PostConstruct
	public void listen() {
		web3j.transactionObservable().subscribe(tx -> {
			LOGGER.info("New tx: id={}, block={}, from={}, to={}, value={},data={}", tx.getHash(), tx.getBlockHash(),
					tx.getFrom(), tx.getTo(), tx.getValue().intValue(),
					new String(HexUtils.fromHexString(tx.getInput().substring(2))));
			try {
				EthCoinbase coinbase = web3j.ethCoinbase().send();
				EthGetTransactionCount transactionCount = web3j
						.ethGetTransactionCount(tx.getFrom(), DefaultBlockParameterName.LATEST).send();
				LOGGER.info("Tx count: {}", transactionCount.getTransactionCount().intValue());
				if (transactionCount.getTransactionCount().intValue() % 10 == 0) {

					EthGetTransactionCount tc = web3j
							.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
					Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(),
							tc.getTransactionCount(), tx.getValue(), BigInteger.valueOf(21_000), tx.getFrom(),
							tx.getValue());
					web3j.ethSendTransaction(transaction).send();
				}
			} catch (IOException e) {
				LOGGER.error("Error getting transactions", e);
			}
		});
		LOGGER.info("Subscribed");
	}
}
