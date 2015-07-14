package com.youguu.asteroid.rpc.client.bank;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.common.ListCast;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("bankRPCService")
public class BankRPCServiceImpl implements IBankRPCService {
	
	private static final Log logger = LogFactory.getLog(Constants.BANK_CLIENT);

	public BankClient getClient(){
		return new BankClient();
	}
	
	@Override
	public int addBank(Bank bank) {
		try {
			return getClient().addBank(ClassCast.pojoToThrift(bank));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int removeBankById(int id) {
		try {
			return getClient().removeBankById(id);
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int modifyBankById(int id, Bank bank) {
		try {
			return getClient().modifyBankById(id, ClassCast.pojoToThrift(bank));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public Bank getBankById(int id) {
		try {
			return ClassCast.thriftToPojo(getClient().getBankById(id));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<Bank> getBankList() {
		try {
			return ListCast.bankThriftListToPojoList(getClient().getBankList());
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public int addBankGroup(List<BankGroup> listBankGroup) {
		try {
			return getClient().addBankGroup(ListCast.pojoListToBankGroupThriftList(listBankGroup));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int removeBankGroupById(int id) {
		try {
			return getClient().removeBankGroupById(id);
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int modifyBankGroupById(int id, BankGroup bankGroup) {
		try {
			return getClient().modifyBankGroupById(id, ClassCast.pojoToThrift(bankGroup));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public List<Bank> getBankGroupByType(int type) {
		try {
			return ListCast.bankThriftListToPojoList(getClient().getBankGroupByType(type));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<BankGroup> getBankGroupList(int type,String bankCode) {
		try {
			return ListCast.bankGroupThriftToPojoList(getClient().getBankGroupList(type,bankCode));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public BankGroup getBankGroupById(int id) {
		try {
			return ClassCast.thriftToPojo(getClient().getBankGroupById(id));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<Bank> getBankListById(List<Integer> ids) {
		try {
			return ListCast.bankThriftListToPojoList(getClient().getBankListById(ids));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<Bank> findBankByTypeBankCode(int type, String bankCode) {
		try {
			return ListCast.bankThriftListToPojoList(getClient().findBankByGroup(type, bankCode));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<Bank> findBankByParams(int id, String bankName,
			String bankNameAbbr) {
		try {
			return ListCast.bankThriftListToPojoList(getClient().findBankByParams(id, bankName, bankNameAbbr));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}
}
