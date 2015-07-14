package com.youguu.asteroid.bank.dao;

import java.util.List;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;

public interface BankGroupDAO {
	
	/**
	 * 添加银行分组信息
	 * @param map 需要添加的银行分组list
	 * @return
	 */
	int addBankGroup(List<BankGroup> list);
	
	/**
	 * 通过ID删除银行分组信息
	 * @param id
	 * @return
	 */
	int removeBankGroupById(int id);
	
	/**
	 * 通过id修改银行分组信息
	 * @return
	 */
	int modifyBankGroupById(int id,BankGroup bankGroup);
	
	/**
	 * 通过type查询银行信息
	 * @return
	 */
	List<Bank> getBankGroupByType(int type);
	
	/**
	 * 获取所有银行分组信息
	 * @return
	 */
	List<BankGroup> getBankGroupList(int type,String bankCode);
	
	/**
	 * 通过银行ID删除 bankGroup信息
	 * @param bankId
	 * @return
	 */
	int removeBankGroupByBankId(int bankId);
	
	/**
	 * 
	* @Title: getBankGroupById
	* @Description: 通过ID获取银行分组信息
	* @param id
	* @return    
	* BankGroup    返回类型
	 */
	BankGroup getBankGroupById(int id);

}
