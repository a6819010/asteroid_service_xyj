package com.youguu.asteroid.bank.service;

import java.util.List;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;

/**
 * 
* @Title: IBankService.java 
* @Package com.youguu.asteroid.bank.service
* @Description: 银行分组信息
* @author zhaozhichao
* @date 2015年4月27日 下午5:19:12
* @version V1.0
 */
public interface IBankGroupService {
	
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
	 * 
	* @Title: getBankGroupById
	* @Description: 通过ID获取银行分组信息
	* @param id
	* @return    
	* BankGroup    返回类型
	 */
	BankGroup getBankGroupById(int id);
	
}
