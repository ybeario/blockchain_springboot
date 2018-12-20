package com.cqupt.bear.blockchain.evidence.service;
/**
* @author Y.bear
* @version 创建时间：2018年12月17日 上午9:48:54
* 类说明
* 面向接口编程，完成基于以太坊和布比区块链的智能合约调用
*/
public interface BlockService {
	void depoly();
	String upload(String address,String md5);
	
}
