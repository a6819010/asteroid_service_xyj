package com.youguu.asteroid.rpc.server.bank;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.bank.service.IBankGroupService;
import com.youguu.asteroid.bank.service.IBankService;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.common.ListCast;
import com.youguu.asteroid.rpc.thrift.gen.BankGroupThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("bankThriftRpcService")
public class BankThriftRpcServiceImpl implements Iface {
	
	private static Log logger = LogFactory.getLog(Constants.BANK_SERVICE);
	
	@Resource
	private IBankService bankS;
	
	@Resource
	private IBankGroupService bankGroupS;
	
	@Override
	public int addBank(BankThrift bankThrift) throws TException {
		return bankS.addBank(ClassCast.thriftToPojo(bankThrift));
	}

	@Override
	public int removeBankById(int id) throws TException {
		return bankS.removeBankById(id);
	}

	@Override
	public int modifyBankById(int id, BankThrift bankThrift) throws TException {
		return bankS.modifyBankById(id, ClassCast.thriftToPojo(bankThrift));
	}

	@Override
	public BankThrift getBankById(int id) throws TException {
		return ClassCast.pojoToThrift(bankS.getBankById(id));
	}

	@Override
	public List<BankThrift> getBankList() throws TException {
		return ListCast.pojoListToBankThriftList(bankS.getBankList());
	}

	@Override
	public int addBankGroup(List<BankGroupThrift> listBankGroup)
			throws TException {
		return bankGroupS.addBankGroup(ListCast.bankGroupThriftToPojoList(listBankGroup));
	}

	@Override
	public int removeBankGroupById(int id) throws TException {
		return bankGroupS.removeBankGroupById(id);
	}

	@Override
	public int modifyBankGroupById(int id, BankGroupThrift bankGroupThrift)
			throws TException {
		return bankGroupS.modifyBankGroupById(id, ClassCast.thriftToPojo(bankGroupThrift));
	}
	
	@Override
	public List<BankThrift> getBankGroupByType(int type) throws TException {
		return ListCast.pojoListToBankThriftList(bankGroupS.getBankGroupByType(type));
	}

	@Override
	public BankGroupThrift getBankGroupById(int id) throws TException {
		return ClassCast.pojoToThrift(bankGroupS.getBankGroupById(id));
	}

	@Override
	public List<BankThrift> getBankListById(List<Integer> id) throws TException {
		return ListCast.pojoListToBankThriftList(bankS.getBankListById(id));
	}

	@Override
	public List<BankGroupThrift> getBankGroupList(int type,String bankCode)
			throws TException {
		return ListCast.pojoListToBankGroupThriftList(bankGroupS.getBankGroupList(type,bankCode));
	}

	@Override
	public List<BankThrift> findBankByGroup(int type, String bankCode)
			throws TException {
		return ListCast.pojoListToBankThriftList(bankS.findBankByTypeBankCode(type, bankCode));
	}

	@Override
	public List<BankThrift> findBankByParams(int id, String bankName,
			String bankNameAbbr) throws TException {
		return ListCast.pojoListToBankThriftList(bankS.findBankByParams(id, bankName, bankNameAbbr));
	}


}
