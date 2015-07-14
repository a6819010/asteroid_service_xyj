package com.youguu.asteroid.rpc.server.fund;

import java.util.List;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.fund.service.FundConvertService;
import com.youguu.asteroid.fund.service.FundDivService;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.ListCast;
import com.youguu.asteroid.rpc.thrift.gen.FundConvertThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundDivThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundService.Iface;

@Service("fundThriftRpcService")
public class FundThriftRpcServiceImpl implements Iface{

	@Resource
	private FundConvertService fcs;
	@Resource
	private FundDivService fds;
	
	@Override
	public List<FundConvertThrift> queryFundConvert(String fundCode,String regDateStart, String regDateEnd,
			String convertDateStart, String convertDateEnd, int convertType,
			int status, int pageStart, int pageSize) throws TException {
		return ListCast.fundCListToFundThriftList(fcs.queryFund(fundCode, regDateStart, regDateEnd, convertDateStart, convertDateEnd, convertType, status, pageStart, pageSize));
	}

	@Override
	public int insertFundConvert(FundConvertThrift fund) throws TException {
		return fcs.insertFund(ClassCast.thriftToPojo(fund));
	}

	@Override
	public int updateFundConvert(FundConvertThrift fund) throws TException {
		return fcs.updateFund(ClassCast.thriftToPojo(fund));
	}

	@Override
	public int deleteFundConvert(int id) throws TException {
		return fcs.deleteFund(id);
	}

	@Override
	public List<FundDivThrift> queryFundDiv(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int divType, int status, int pageStart,
			int pageSize) throws TException {
		return ListCast.fundDListToFundDThriftList(fds.queryFund(fundCode, regDateStart, regDateEnd, convertDateStart, convertDateEnd, divType, status, pageStart, pageSize));
	}

	@Override
	public int insertFundDiv(FundDivThrift fund) throws TException {
		return fds.insertFund(ClassCast.thriftToPojo(fund));
	}

	@Override
	public int updateFundDiv(FundDivThrift fund) throws TException {
		return fds.updateFund(ClassCast.thriftToPojo(fund));
	}

	@Override
	public int deleteFundDiv(int id) throws TException {
		return fds.deleteFund(id);
	}

	@Override
	public FundConvertThrift findCById(int id) throws TException {
		return ClassCast.pojoToThrift(fcs.findById(id));
	}

	@Override
	public FundDivThrift findDById(int id) throws TException {
		return ClassCast.pojoToThrift(fds.findById(id));
	}

}
