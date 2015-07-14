package com.youguu.asteroid.rpc.common;

import java.util.ArrayList;
import java.util.List;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.rpc.thrift.gen.BankGroupThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundConvertThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundDivThrift;

/**
 * 
 * @ClassName: ListCast
 * @Description: 将list中存储的类型转换成想要的类型
 * @author zhaozhichao
 * @date 2015年4月29日 上午9:47:02
 *
 */
public class ListCast {
	
	public static List<BankThrift> pojoListToBankThriftList(List<Bank> bankList){
		
		if(null == bankList || bankList.size()<=0) return null;
		List<BankThrift> list = new ArrayList<BankThrift>();
		for(int i = 0 ; i < bankList.size();i++){
			list.add(ClassCast.pojoToThrift(bankList.get(i)));
		}
		return list;
	}
	
	public static List<Bank> bankThriftListToPojoList(List<BankThrift> bankThriftList){
		if(null == bankThriftList || bankThriftList.size()<=0) return null;
		List<Bank> list = new ArrayList<Bank>();
		for(int i = 0 ; i < bankThriftList.size();i++){
			list.add(ClassCast.thriftToPojo(bankThriftList.get(i)));
		}
		return list;
	}
	
	public static List<BankGroupThrift> pojoListToBankGroupThriftList(List<BankGroup> bankGroupList){
		if(null == bankGroupList || bankGroupList.size()<=0) return null;
		List<BankGroupThrift> list = new ArrayList<BankGroupThrift>();
		for(int i = 0 ; i < bankGroupList.size();i++){
			list.add(ClassCast.pojoToThrift(bankGroupList.get(i)));
		}
		return list;
	}
	
	public static List<BankGroup> bankGroupThriftToPojoList(List<BankGroupThrift> bankGroupThriftList){
		if(null == bankGroupThriftList || bankGroupThriftList.size()<=0) return null;
		List<BankGroup> list = new ArrayList<BankGroup>();
		for(int i = 0 ; i < bankGroupThriftList.size();i++){
			list.add(ClassCast.thriftToPojo(bankGroupThriftList.get(i)));
		}
		return list;
	}
	
	public static List<FundConvertThrift> fundCListToFundThriftList(List<FundConvert> pList){
		
		if(null == pList || pList.size()<=0) return null;
		List<FundConvertThrift> list = new ArrayList<FundConvertThrift>();
		for(int i = 0 ; i < pList.size();i++){
			list.add(ClassCast.pojoToThrift(pList.get(i)));
		}
		return list;
		
	}
	
	public static List<FundConvert> fundCThriftListToFundCList(List<FundConvertThrift> tList){
		if(null == tList || tList.size()<=0) return null;
		List<FundConvert> list = new ArrayList<FundConvert>();
		for(int i = 0 ; i < tList.size();i++){
			list.add(ClassCast.thriftToPojo(tList.get(i)));
		}
		return list;
	}
	public static List<FundDivThrift> fundDListToFundDThriftList(List<FundDiv> pList){
		if(null == pList || pList.size()<=0) return null;
		List<FundDivThrift> list = new ArrayList<FundDivThrift>();
		for(int i = 0 ; i < pList.size();i++){
			list.add(ClassCast.pojoToThrift(pList.get(i)));
		}
		return list;
	}
	
	public static List<FundDiv> fundDThriftToFundDList(List<FundDivThrift> tList){
		if(null == tList || tList.size()<=0) return null;
		List<FundDiv> list = new ArrayList<FundDiv>();
		for(int i = 0 ; i < tList.size();i++){
			list.add(ClassCast.thriftToPojo(tList.get(i)));
		}
		return list;
	}
}
