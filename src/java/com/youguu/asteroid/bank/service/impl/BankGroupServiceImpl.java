package com.youguu.asteroid.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.bank.dao.BankGroupDAO;
import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.bank.service.IBankGroupService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("bankGroupService")
public class BankGroupServiceImpl implements IBankGroupService {

	@Resource
	private BankGroupDAO bankGroupDAO;

	private static Log logger = LogFactory.getLog("银行分组信息");

	@Override
	public int addBankGroup(List<BankGroup> list) {
		try {
			if(null != list && list.size()>0){
				return bankGroupDAO.addBankGroup(list);
			}
		} catch (Exception e) {
			logger.error("添加银行分组信息错误:addBankGroup",e);
		}
		return 0;
	}

	@Override
	public int removeBankGroupById(int id) {
		try {
			if(id != 0){
				return bankGroupDAO.removeBankGroupById(id);
			}
		} catch (Exception e) {
			logger.error("删除银行分组信息错误:removeBankGroupById",e);
		}
		return 0;
	}

	@Override
	public int modifyBankGroupById(int id,BankGroup bankGroup) {
		try {
			if(id>0 && null != bankGroup){
				return bankGroupDAO.modifyBankGroupById(id,bankGroup);
			}
		} catch (Exception e) {
			logger.error("修改银行分组信息错误:modifyBankGroupById",e);
		}
		return 0;
	}

	@Override
	public List<Bank> getBankGroupByType(int type) {
		List<Bank> bankList = new ArrayList<Bank>();
		try {
			bankList = bankGroupDAO.getBankGroupByType(type);
			if(null == bankList)bankList = new ArrayList<Bank>(); return bankList;
		} catch (Exception e) {
			logger.error("获取银行分组信息错误:getBankGroupByType",e);
		}
		return bankList;
	}

	@Override
	public List<BankGroup> getBankGroupList(int type,String bankCode){
		List<BankGroup> list = new ArrayList<BankGroup>();
		try {
			list = bankGroupDAO.getBankGroupList(type,bankCode);
			if(null == list) list = new ArrayList<BankGroup>(); return list;
		} catch (Exception e) {
			logger.error("获取银行分组信息错误:getBankGroupList",e);
		}
		return list;
	}

	@Override
	public BankGroup getBankGroupById(int id) {
		BankGroup bg = new BankGroup();
		try {
			if(id > 0){
				bg = bankGroupDAO.getBankGroupById(id);
			}
		} catch (Exception e) {
			logger.error("查询银行信息错误:getBankById",e);
		}
		return bg;
	}

}
