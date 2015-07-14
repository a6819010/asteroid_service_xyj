package com.youguu.asteroid.rpc.client.fund;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.common.ListCast;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("fundRPCService")
public class FundRPCServiceImpl implements IFundRPCService {

	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	public FundClient getClient(){
		return new FundClient();
	}
	
	@Override
	public List<FundConvert> queryFundConvert(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int convertType, int status, int pageStart,
			int pageSize) {
		try {
			return ListCast.fundCThriftListToFundCList(getClient().queryFundConvert(fundCode,regDateStart, regDateEnd, convertDateStart, convertDateEnd, convertType, status, pageStart, pageSize));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public int insertFundConvert(FundConvert fund) {
		try {
			return getClient().insertFundConvert(ClassCast.pojoToThrift(fund));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int updateFundConvert(FundConvert fund) {
		
		try {
			return getClient().updateFundConvert(ClassCast.pojoToThrift(fund));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int deleteFundConvert(int id) {
		try {
			return getClient().deleteFundConvert(id);
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public List<FundDiv> queryFundDiv(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int divType, int status, int pageStart,
			int pageSize) {
		try {
			return ListCast.fundDThriftToFundDList(getClient().queryFundDiv(fundCode,regDateStart, regDateEnd, convertDateStart, convertDateEnd, divType, status, pageStart, pageSize));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public int insertFundDiv(FundDiv fund) {
		try {
			return getClient().insertFundDiv(ClassCast.pojoToThrift(fund));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int updateFundDiv(FundDiv fund) {
		try {
			return getClient().updateFundDiv(ClassCast.pojoToThrift(fund));
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public int deleteFundDiv(int id) {
		try {
			return getClient().deleteFundDiv(id);
		} catch (TException e) {
			logger.error(e);
		}
		return 0;
	}

	@Override
	public FundConvert findCById(int id) {
		try {
			return ClassCast.thriftToPojo(getClient().findCById(id));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public FundDiv findDById(int id) {
		try {
			return ClassCast.thriftToPojo(getClient().findDById(id));
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

}
