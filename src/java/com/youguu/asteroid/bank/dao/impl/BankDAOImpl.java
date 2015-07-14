package com.youguu.asteroid.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.bank.dao.BankDAO;
import com.youguu.asteroid.bank.dao.BankSqlDAO;
import com.youguu.asteroid.bank.pojo.Bank;

@Repository("bankDAO")
public class BankDAOImpl extends BankSqlDAO<Bank> implements BankDAO {

	@Override
	public int addBank(Bank bank) {
		return this.insert(bank);
	}

	@Override
	public int removeBankById(int id) {
		return this.deleteBy("deleteBankById", id);
	}

	@Override
	public int modifyBankById(int id,Bank bank) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("bank", bank);
		return this.updateBy("updateBankById", map);
	}

	@Override
	public Bank getBankById(int id) {
		return this.findUniqueBy("getBankById", id);
	}

	@Override
	public List<Bank> getBankList() {
		return this.findBy("getBankList", null);
	}

	@Override
	public List<Bank> getBankListById(List<Integer> idList) {
		return this.findBy("getBankListById", idList);
	}

	@Override
	public List<Bank> findBankByTypeBankCode(int type, String bankCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("bankCode", bankCode);
		return this.findBy("findBankByTypeBankCode", map);
	}

	@Override
	public List<Bank> findBankByParams(int id, String bankName,
			String bankNameAbbr) {
	    Map<String, Object> map = new HashMap<String,Object>();
	    map.put("id", id);
	    map.put("bankName", bankName);
	    map.put("bankAbbrName", bankNameAbbr);
		return this.findBy("findBankByParams", map);
	}

}
