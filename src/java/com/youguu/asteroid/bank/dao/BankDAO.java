package com.youguu.asteroid.bank.dao;

import java.util.List;

import com.youguu.asteroid.bank.pojo.Bank;

public interface BankDAO {
	
	/**
	 * 增加银行信息
	 * @param bank
	 * @return int
	 */
	int addBank(Bank bank);
	
	/**
	 * 通过银行ID删除银行信息
	 * @param id
	 * @return int
	 */
	int removeBankById(int id);
	
	/**
	 * 通过银行id修改银行信息
	 * @param bank
	 * @return int
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
	 * 通过银行ID集合查询银行列表
	* @Title: getBankListById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param id
	* @return    
	* List<Bank>    返回类型
	 */
	List<Bank> getBankListById(List<Integer> id);
	
	/**
	* @Title: findBankByTypeBankCode
	* @Description: 通过分组ID和分组代码查询银行信息
	* @param type
	* @param bankCode
	* @return    
	* List<BankGroup>    返回类型
	 */
	List<Bank> findBankByTypeBankCode(int type , String bankCode);
	
	/**
	 * 通过参数查询银行信息
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