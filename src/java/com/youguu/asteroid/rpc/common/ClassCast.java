package com.youguu.asteroid.rpc.common;

import java.util.Date;

import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankGroupThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundConvertThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundDivThrift;
import com.youguu.asteroid.rpc.thrift.gen.MarketWindVanePollVoteThrift;
import com.youguu.asteroid.rpc.thrift.gen.SensitiveWordThrift;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.asteroid.word.pojo.SensitiveWord;

/**
 * 
 * @ClassName: ClassCast
 * @Description: thirfClass 和 pojo转换
 * @author zhanglei
 * @date 2014年11月6日 上午10:47:02
 *
 */
public class ClassCast {
	
	public static SensitiveWord  thriftToPojo(SensitiveWordThrift swt){
		if(swt==null) return null;
		SensitiveWord sw = new SensitiveWord();
		sw.setId(swt.getId());
		sw.setWord(swt.getWord());
		sw.setCreateTime(new Date(swt.getCreateTime()));
		return sw;
	}
	
	
	public static SensitiveWordThrift pojoToThrift(SensitiveWord sw){
		if(sw==null) return null;
		SensitiveWordThrift swt = new SensitiveWordThrift(
				sw.getId(), sw.getWord(), 
				sw.getCreateTime().getTime());
		return swt;
	}

	public static MarketWindVanePollVoteThrift pojoToThrift(MarketWindVanePollVote mwv){
		if(mwv==null) return null;
		MarketWindVanePollVoteThrift swt = new MarketWindVanePollVoteThrift(mwv.getDate(),mwv.getNum(),mwv.getUp(),mwv.getDown(),mwv.getResult());
		return swt;
	}
	
	public static MarketWindVanePollVote  thriftToPojo(MarketWindVanePollVoteThrift mwv){
		if(mwv==null) return null;
		MarketWindVanePollVote sw = new MarketWindVanePollVote(mwv.getDate(),mwv.getNum(),mwv.getUp(),mwv.getDown(),mwv.getResult());
		return sw;
	}
	
	public static AdWall thriftToPojo(AdWallThrift awt){
		if(awt==null) return null;
		AdWall aw = new AdWall();
		aw.setId(awt.getId());
		aw.setAdImage(awt.getAdImage());
		aw.setBeginDate(new Date(awt.getBeginDate()));
		aw.setContent(awt.getContent());
		aw.setContentType(awt.getContentType());
		aw.setCreateTime(new Date(awt.getCreateTime()));
		aw.setEndDate(new Date(awt.getEndDate()));
		aw.setForwardUrl(awt.getForwardUrl());
		aw.setPositionType(awt.getPositionType());
		aw.setRank(awt.getRank());
		aw.setTitle(awt.getTitle());
		return aw;
	}
	
	public static AdWallThrift pojoToThrift(AdWall aw){
		if(aw == null) return null;
		AdWallThrift awt = new AdWallThrift();
		awt.setId(aw.getId());
		awt.setAdImage(aw.getAdImage());
		awt.setBeginDate(aw.getBeginDate().getTime());
		awt.setContent(aw.getContent());
		awt.setContentType(aw.getContentType());
		awt.setCreateTime(aw.getCreateTime().getTime());
		awt.setEndDate(aw.getEndDate().getTime());
		awt.setForwardUrl(aw.getForwardUrl());
		awt.setPositionType(aw.getPositionType());
		awt.setRank(aw.getRank());
		awt.setTitle(aw.getTitle());
		return awt;
	}
	
	public static BankThrift pojoToThrift(Bank bank){
		if(bank == null ) return null;
		BankThrift bt = new BankThrift();
		bt.setBankName(bank.getBankName());
		bt.setBankNameAbbr(bank.getBankNameAbbr());
		bt.setBankLogo(bank.getBankLogo());
		bt.setId(bank.getId());
		return bt;
	}
	
	public static Bank thriftToPojo(BankThrift bt){
		if(bt == null) return null;
		Bank bank = new Bank();
		bank.setBankName(bt.getBankName());
		bank.setBankNameAbbr(bt.getBankNameAbbr());
		bank.setBankLogo(bt.getBankLogo());
		bank.setId(bt.getId());
		return bank;
	}
	
	public static BankGroupThrift pojoToThrift(BankGroup bg){
		if(bg == null) return null;
		BankGroupThrift bgt = new BankGroupThrift();
		bgt.setBankId(bg.getBankId());
		bgt.setGroupType(bg.getGroupType());
		bgt.setId(bg.getId());
		bgt.setBankCode(bg.getBankCode());
		return bgt;
	}
	
	public static BankGroup thriftToPojo(BankGroupThrift bgt){
		if(bgt == null) return null;
		BankGroup bg = new BankGroup();
		bg.setBankId(bgt.getBankId());
		bg.setId(bgt.getId());
		bg.setGroupType(bgt.getGroupType());
		bg.setBankCode(bgt.getBankCode());
		return bg;
	}
	
	public static FundConvert thriftToPojo(FundConvertThrift fct){
		
		if(null == fct)return null;
		FundConvert fc = new FundConvert();
		fc.setId(fct.getId());
		fc.setAfundCode(fct.getAfundCode());
		fc.setBfundCode(fct.getBfundCode());
		fc.setConvertType(fct.getConvertType());
		fc.setAconvertRate(fct.getAconvertRate());
		fc.setBconvertRate(fct.getBconvertRate());
		fc.setAbRatio(fct.getAbRatio());
		fc.setRegDate(fct.getRegDate());
		fc.setConvertDate(fct.getConvertDate());
		fc.setStatus(fct.getStatus());
		fc.setImportTime(fct.getImportTime());
		return fc;
	}
	
	public static FundConvertThrift pojoToThrift(FundConvert fct){
		
		if(null == fct)return null;
		FundConvertThrift fc = new FundConvertThrift();
		fc.setId(fct.getId());
		fc.setAfundCode(fct.getAfundCode());
		fc.setBfundCode(fct.getBfundCode());
		fc.setConvertType(fct.getConvertType());
		fc.setAconvertRate(fct.getAconvertRate());
		fc.setBconvertRate(fct.getBconvertRate());
		fc.setAbRatio(fct.getAbRatio());
		fc.setRegDate(fct.getRegDate());
		fc.setConvertDate(fct.getConvertDate());
		fc.setStatus(fct.getStatus());
		fc.setImportTime(fct.getImportTime());
		return fc;
	}
	
	public static FundDiv thriftToPojo(FundDivThrift fdt){
		if(null == fdt)return null;
		FundDiv fd = new FundDiv();
		
		fd.setId(fdt.getId());
		fd.setFundCode(fdt.getFundCode());
		fd.setDivType(fdt.getDivType());
		fd.setCashBT(fdt.getCashBT());
		fd.setCashAT(fdt.getCashAT());
		fd.setFundRatio(fdt.getFundRatio());
		fd.setRegDate(fdt.getRegDate());
		fd.setExdivDate(fdt.getExdivDate());
		fd.setStatus(fdt.getStatus());
		fd.setImportTime(fdt.getImportTime());
		
		return fd;
	}
	
	public static FundDivThrift pojoToThrift(FundDiv fdt){
		if(null == fdt)return null;
		FundDivThrift fd = new FundDivThrift();
		
		fd.setId(fdt.getId());
		fd.setFundCode(fdt.getFundCode());
		fd.setDivType(fdt.getDivType());
		fd.setCashBT(fdt.getCashBT());
		fd.setCashAT(fdt.getCashAT());
		fd.setFundRatio(fdt.getFundRatio());
		fd.setRegDate(fdt.getRegDate());
		fd.setExdivDate(fdt.getExdivDate());
		fd.setStatus(fdt.getStatus());
		fd.setImportTime(fdt.getImportTime());
		
		return fd;
	}
}
