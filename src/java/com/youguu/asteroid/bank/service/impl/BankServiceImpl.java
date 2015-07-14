package com.youguu.asteroid.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.bank.dao.BankDAO;
import com.youguu.asteroid.bank.dao.BankGroupDAO;
import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.service.IBankService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("bankService")
public class BankServiceImpl implements IBankService {

	@Resource
	private BankDAO bankDAO;
	
	@Resource
	private BankGroupDAO bankGroupDAO;
	
	private static Log logger = LogFactory.getLog("银行信息");
	
	@Override
	public int addBank(Bank bank) {
		try {
			if(null != bank){
				if(null == bankDAO.getBankById(bank.getId())){
					return bankDAO.addBank(bank);
				}
			}
		} catch (Exception e) {
			logger.error("添加银行信息错误:addBank", e);
		}
		return 0;
	}

	@Override
	public int removeBankById(int id) {
		try {
			if(id > 0){
				bankGroupDAO.removeBankGroupByBankId(id);
				bankDAO.removeBankById(id);
			}
		} catch (Exception e) {
			logger.error("删除银行信息错误:removeBankById",e);
		}
		return 0;
	}

	@Override
	public int modifyBankById(int id,Bank bank) {
		try {
			if(null != bank){
				return bankDAO.modifyBankById(id,bank);
			}
		} catch (Exception e) {
			logger.error("修改银行信息错误:modifyBankById",e);
		}
		return 0;
	}

	@Override
	public Bank getBankById(int id) {
		Bank bank = new Bank();
		try {
			bank = bankDAO.getBankById(id);
		} catch (Exception e) {
			logger.error("查询银行信息错误:getBankById",e);
		}
		return bank;
	}

	@Override
	public List<Bank> getBankList() {
		List<Bank> bank = new ArrayList<Bank>();
		try {
			bank = bankDAO.getBankList();
		} catch (Exception e) {
			logger.error("查询银行信息错误:getBankList",e);
		}
		return bank;
	}

	@Override
	public List<Bank> getBankListById(List<Integer> idList) {
		List<Bank> bankList = new ArrayList<Bank>();
		try {
			bankList = bankDAO.getBankListById(idList);
			if(null == bankList)bankList = new ArrayList<Bank>(); return bankList;
		} catch (Exception e) {
			logger.error("查询银行信息错误:getBankListById",e);
		}
		return bankList;
	}

	@Override
	public List<Bank> findBankByTypeBankCode(int type, String bankCode) {
		List<Bank> bankList = new ArrayList<Bank>();
		try {
			bankList = bankDAO.findBankByTypeBankCode(type, bankCode);
			if(null == bankList)bankList = new ArrayList<Bank>(); return bankList;
		} catch (Exception e) {
			logger.error("查询银行信息错误:findBankByTypeBankCode",e);
		}
		return bankList;
	}

	@Override
	public List<Bank> findBankByParams(int id, String bankName,
			String bankNameAbbr) {
		List<Bank> bankList = new ArrayList<Bank>();
		try {
			bankList = bankDAO.findBankByParams(id, bankName, bankNameAbbr);
			if(null == bankList)bankList = new ArrayList<Bank>(); return bankList;
		} catch (Exception e) {
			logger.error("查询银行信息错误:findBankByParams",e);
		}
		return bankList;
	}
}
