package com.youguu.asteroid.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.bank.dao.BankGroupDAO;
import com.youguu.asteroid.bank.dao.BankSqlDAO;
import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;

@Repository("bankGroupDAO")
public class BankGroupDAOImpl extends BankSqlDAO<BankGroup> implements BankGroupDAO {

	@Override
	public int addBankGroup(List<BankGroup> list) {
		return this.batchInsert(list, "insertList");
	}

	@Override
	public int removeBankGroupById(int id) {
		return this.deleteBy("deleteById", id);
	}

	@Override
	public int modifyBankGroupById(int id,BankGroup bankGroup) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("bankGroup", bankGroup);
		return this.updateBy("updateBankGroupById", map);
	}

	@Override
	public List<Bank> getBankGroupByType(int type) {
		return this.findBy("findBankByType", type);
	}

	@Override
	public List<BankGroup> getBankGroupList(int type,String bankCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupType", type);
		params.put("bankCode", bankCode);
		return this.findBy("findBankGroupList", params);
	}

	@Override
	public int removeBankGroupByBankId(int bankId) {
		return this.deleteBy("deleteByBankId", bankId);
	}

	@Override
	public BankGroup getBankGroupById(int id) {
		return this.findUniqueBy("getBankGroupById", id);
	}

}
