package com.youguu.asteroid.rpc.client.bank;

import java.util.List;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;


public interface IBankRPCService {
	
	/**
	 * 增加银行信息
	 * @param Bank
	 * @return
	 */
	int addBank(Bank bank);
	
	/**
	 * 通过银行ID删除银行信息 
	 * @param id
	 * @return
	 */
	int removeBankById(int id);
	
	/**
	 * 通过银行id修改银行信息
	 * @param id
	 * @param Bank
	 * @return
	 */
	int modifyBankById(int id,Bank bank);
	
	/**
	 * 通过银行ID查找银行信息
	 * @param id
	 * @return
	 */
	Bank getBankById(int id);
	
	/**
	 * 获取银行信息列表
	 * @return
	 */
	List<Bank> getBankList();
	
	/** 
	 * 添加银行分组信息
	 * @param listBankGroup
	 * @return
	 */
	int addBankGroup(List<BankGroup> listBankGroup);
	
	/** 
	 * 通过ID删除银行分组信息
	 * @param id
	 * @return
	 */
	int removeBankGroupById(int id);
	
	/** 
	 * 通过id修改银行分组信息
	 * @param id
	 * @param BankGroup
	 * @return
	 */
	int modifyBankGroupById(int id,BankGroup bankGroup);
	
	/** 
	 * 通过type查询银行分组信息
	 * @param type
	 * @return
	 */
	List<Bank> getBankGroupByType(int type);
	
	/** 
	 * 获取所有银行分组信息
	 * @return
	 */
	List<BankGroup> getBankGroupList(int type,String bankCode);
	
	/**
	 * 
	* @Title: getBankGroupById
	* @Description: 通过ID获取银行分组信息
	* @param id
	* @return    
	* BankGroup    返回类型
	 */
	BankGroup getBankGroupById(int id);
	
	/**
	 * 
	* @Title: getBankListById
	* @Description: TODO通过银行ID列表查询银行卡列表信息
	* @param ids
	* @return    
	* List<Bank>    返回类型
	 */
	List<Bank> getBankListById(List<Integer> ids);
	
	/**
	* @Title: findBankByTypeBankCode
	* @Description: 通过分组类型和分组代码查询银行信息
	* @param type
	* @param bankCode
	* @return    
	* List<BankGroup>    返回类型
	 */
	List<Bank> findBankByTypeBankCode(int type , String bankCode);
	
	/**
	  * 通过参数查询银行信息（参数传空 忽略这个条件查询）
	* @Title: findBankByParams
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param id
	* @param bankName
	* @param bankNameAbbr
	* @return    
	* List<Bank>    返回类型
	 */
	List<Bank> findBankByParams(int id,String bankName,String bankNameAbbr);
}
