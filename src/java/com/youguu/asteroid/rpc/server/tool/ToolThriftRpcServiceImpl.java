package com.youguu.asteroid.rpc.server.tool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.thrift.gen.BenchmarkRateThrift;
import com.youguu.asteroid.rpc.thrift.gen.DepositRateThrift;
import com.youguu.asteroid.rpc.thrift.gen.ForeignCurrencyThrift;
import com.youguu.asteroid.rpc.thrift.gen.LendingRateThrift;
import com.youguu.asteroid.rpc.thrift.gen.RateDiscountThrift;
import com.youguu.asteroid.rpc.thrift.gen.SocialInsuranceThrift;
import com.youguu.asteroid.rpc.thrift.gen.TaxBaseThrift;
import com.youguu.asteroid.rpc.thrift.gen.TaxLevelThrift;
import com.youguu.asteroid.tool.pojo.BenchmarkRate;
import com.youguu.asteroid.tool.pojo.DepositRate;
import com.youguu.asteroid.tool.pojo.ForeignCurrency;
import com.youguu.asteroid.tool.pojo.LendingRate;
import com.youguu.asteroid.tool.pojo.RateDiscount;
import com.youguu.asteroid.tool.pojo.SocialInsurance;
import com.youguu.asteroid.tool.pojo.TaxBase;
import com.youguu.asteroid.tool.pojo.TaxLevel;
import com.youguu.asteroid.tool.service.BenchmarkRateService;
import com.youguu.asteroid.tool.service.DepositRateService;
import com.youguu.asteroid.tool.service.ForeignCurrencyService;
import com.youguu.asteroid.tool.service.LendingRateService;
import com.youguu.asteroid.tool.service.RateDiscountService;
import com.youguu.asteroid.tool.service.SocialInsuranceService;
import com.youguu.asteroid.tool.service.TaxBaseService;
import com.youguu.asteroid.tool.service.TaxLevelService;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;

/**
* @ClassName: ToolThriftRpcServiceImpl 
* @Description: 工具箱 RPC server 
* @author lqipr
* @date 2014年12月4日 下午5:26:47
 */
@Service("toolThriftRpcService")
public class ToolThriftRpcServiceImpl implements com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Iface {
	
	@Resource
	BenchmarkRateService benchmarkRateService;
	@Resource
	DepositRateService depositRateService;
	@Resource
	ForeignCurrencyService foreignCurrencyService;
	@Resource
	LendingRateService lendingRateService;
	@Resource
	RateDiscountService rateDiscountService;
	@Resource
	SocialInsuranceService socialInsuranceService;
	@Resource
	TaxBaseService taxBaseService;
	@Resource
	TaxLevelService taxLevelService;
	
	@Override
	public int saveBenchmarkRate(BenchmarkRateThrift r) throws TException {
		return benchmarkRateService.save(ClassCast.cast(r, BenchmarkRate.class));
	}

	@Override
	public int updateBenchmarkRate(BenchmarkRateThrift r) throws TException {
		return benchmarkRateService.update(ClassCast.cast(r, BenchmarkRate.class));
	}

	@Override
	public int deleteBenchmarkRate(int id) throws TException {
		return benchmarkRateService.delete(id);
	}

	@Override
	public BenchmarkRateThrift getBenchmarkRate(int id) throws TException {
		return ClassCast.cast(benchmarkRateService.get(id), BenchmarkRateThrift.class);
	}

	@Override
	public ByteBuffer queryBenchmarkRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<BenchmarkRate> pageHodler = benchmarkRateService.queryBenchmarkRateList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<BenchmarkRateThrift> findAllBenchmarkRate() throws TException {
		List<BenchmarkRateThrift> result = new ArrayList<BenchmarkRateThrift>();
		List<BenchmarkRate> list = benchmarkRateService.findAll();
		if(list!=null && list.size()>0){
			for(BenchmarkRate dmd:list){
				result.add(ClassCast.cast(dmd, BenchmarkRateThrift.class));
			}
		}
		return result;
	}

	@Override
	public int saveDepositRate(DepositRateThrift r) throws TException {
		return depositRateService.save(ClassCast.cast(r, DepositRate.class));
	}

	@Override
	public int updateDepositRate(DepositRateThrift r) throws TException {
		return depositRateService.update(ClassCast.cast(r, DepositRate.class));
	}

	@Override
	public int deleteDepositRate(int id) throws TException {
		return depositRateService.delete(id);
	}

	@Override
	public DepositRateThrift getDepositRate(int id) throws TException {
		return ClassCast.cast(depositRateService.get(id), DepositRateThrift.class);
	}

	@Override
	public ByteBuffer queryDepositRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<DepositRate> pageHodler = depositRateService.queryDepositRateList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<DepositRateThrift> findAllDepositRate() throws TException {
		List<DepositRateThrift> result = new ArrayList<DepositRateThrift>();
		List<DepositRate> list = depositRateService.findAll();
		if(list!=null && list.size()>0){
			for(DepositRate dmd:list){
				result.add(ClassCast.cast(dmd, DepositRateThrift.class));
			}
		}
		return result;
	}

	@Override
	public int saveForeignCurrency(ForeignCurrencyThrift r) throws TException {
		return foreignCurrencyService.save(ClassCast.cast(r, ForeignCurrency.class));
	}

	@Override
	public int updateForeignCurrency(ForeignCurrencyThrift r) throws TException {
		return foreignCurrencyService.update(ClassCast.cast(r, ForeignCurrency.class));
	}

	@Override
	public int deleteForeignCurrency(int id) throws TException {
		return foreignCurrencyService.delete(id);
	}

	@Override
	public ForeignCurrencyThrift getForeignCurrency(int id) throws TException {
		return ClassCast.cast(foreignCurrencyService.get(id), ForeignCurrencyThrift.class);
	}

	@Override
	public ByteBuffer queryForeignCurrencyList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<ForeignCurrency> pageHodler = foreignCurrencyService.queryForeignCurrencyList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<ForeignCurrencyThrift> findAllForeignCurrency()
			throws TException {
		List<ForeignCurrencyThrift> result = new ArrayList<ForeignCurrencyThrift>();
		List<ForeignCurrency> list = foreignCurrencyService.findAll();
		if(list!=null && list.size()>0){
			for(ForeignCurrency dmd:list){
				result.add(ClassCast.cast(dmd, ForeignCurrencyThrift.class));
			}
		}
		return result;
	}

	@Override
	public int initForeignCurrency(String currencyCode) throws TException {
		return foreignCurrencyService.init(currencyCode);
	}

	@Override
	public int saveLendingRate(LendingRateThrift r) throws TException {
		return lendingRateService.save(ClassCast.cast(r, LendingRate.class));
	}

	@Override
	public int updateLendingRate(LendingRateThrift r) throws TException {
		return lendingRateService.update(ClassCast.cast(r, LendingRate.class));
	}

	@Override
	public int deleteLendingRate(int id) throws TException {
		return lendingRateService.delete(id);
	}

	@Override
	public LendingRateThrift getLendingRate(int id) throws TException {
		return ClassCast.cast(lendingRateService.get(id), LendingRateThrift.class);
	}

	@Override
	public ByteBuffer queryLendingRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<LendingRate> pageHodler = lendingRateService.queryLendingRateList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<LendingRateThrift> findAllLendingRate() throws TException {
		List<LendingRateThrift> result = new ArrayList<LendingRateThrift>();
		List<LendingRate> list = lendingRateService.findAll();
		if(list!=null && list.size()>0){
			for(LendingRate dmd:list){
				result.add(ClassCast.cast(dmd, LendingRateThrift.class));
			}
		}
		return result;
	}

	@Override
	public int addRateDiscount(RateDiscountThrift t) throws TException {
		return rateDiscountService.addRateDiscount(ClassCast.cast(t, RateDiscount.class));
	}

	@Override
	public boolean deleteRateDiscount(int id) throws TException {
		return rateDiscountService.deleteRateDiscount(id);
	}

	@Override
	public RateDiscountThrift getRateDiscount(int id) throws TException {
		return ClassCast.cast(rateDiscountService.getRateDiscount(id), RateDiscountThrift.class);
	}

	@Override
	public boolean modifyRateDiscount(RateDiscountThrift t) throws TException {
		return rateDiscountService.modifyRateDiscount(ClassCast.cast(t, RateDiscount.class));
	}

	@Override
	public ByteBuffer queryRateDiscountList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<RateDiscount> pageHodler = rateDiscountService.queryRateDiscountList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<RateDiscountThrift> findAllRateDiscount() throws TException {
		List<RateDiscountThrift> result = new ArrayList<RateDiscountThrift>();
		List<RateDiscount> list = rateDiscountService.findAll();
		if(list!=null && list.size()>0){
			for(RateDiscount dmd:list){
				result.add(ClassCast.cast(dmd, RateDiscountThrift.class));
			}
		}
		return result;
	}

	@Override
	public int saveSocialInsurance(SocialInsuranceThrift r) throws TException {
		return socialInsuranceService.save(ClassCast.cast(r, SocialInsurance.class));
	}

	@Override
	public int updateSocialInsurance(SocialInsuranceThrift r) throws TException {
		return socialInsuranceService.update(ClassCast.cast(r, SocialInsurance.class));
	}

	@Override
	public int deleteSocialInsurance(int id) throws TException {
		return socialInsuranceService.delete(id);
	}

	@Override
	public SocialInsuranceThrift getSocialInsurance(int id) throws TException {
		return ClassCast.cast(socialInsuranceService.get(id), SocialInsuranceThrift.class);
	}

	@Override
	public ByteBuffer querySocialInsuranceList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<SocialInsurance> pageHodler = socialInsuranceService.querySocialInsuranceList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<SocialInsuranceThrift> findAllSocialInsurance()
			throws TException {
		List<SocialInsuranceThrift> result = new ArrayList<SocialInsuranceThrift>();
		List<SocialInsurance> list = socialInsuranceService.findAll();
		if(list!=null && list.size()>0){
			for(SocialInsurance dmd:list){
				result.add(ClassCast.cast(dmd, SocialInsuranceThrift.class));
			}
		}
		return result;
	}

	@Override
	public int saveTaxBase(TaxBaseThrift r) throws TException {
		return taxBaseService.save(ClassCast.cast(r, TaxBase.class));
	}

	@Override
	public int updateTaxBase(TaxBaseThrift r) throws TException {
		return taxBaseService.update(ClassCast.cast(r, TaxBase.class));
	}

	@Override
	public int deleteTaxBase(int id) throws TException {
		return taxBaseService.delete(id);
	}

	@Override
	public TaxBaseThrift getTaxBase(int id) throws TException {
		return ClassCast.cast(taxBaseService.get(id), TaxBaseThrift.class);
	}

	@Override
	public ByteBuffer queryTaxBaseList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<TaxBase> pageHodler = taxBaseService.queryTaxBaseList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<TaxBaseThrift> findAllTaxBase() throws TException {
		List<TaxBaseThrift> result = new ArrayList<TaxBaseThrift>();
		List<TaxBase> list = taxBaseService.findAll();
		if(list!=null && list.size()>0){
			for(TaxBase dmd:list){
				result.add(ClassCast.cast(dmd, TaxBaseThrift.class));
			}
		}
		return result;
	}

	@Override
	public int saveTaxLevel(TaxLevelThrift r) throws TException {
		return taxLevelService.save(ClassCast.cast(r, TaxLevel.class));
	}

	@Override
	public int updateTaxLevel(TaxLevelThrift r) throws TException {
		return taxLevelService.update(ClassCast.cast(r, TaxLevel.class));
	}

	@Override
	public int deleteTaxLevel(int id) throws TException {
		return taxLevelService.delete(id);
	}

	@Override
	public TaxLevelThrift getTaxLevel(int id) throws TException {
		return ClassCast.cast(taxLevelService.get(id), TaxLevelThrift.class);
	}

	@Override
	public ByteBuffer queryTaxLevelList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		PageHolder<TaxLevel> pageHodler = taxLevelService.queryTaxLevelList((HashMap<String, Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<TaxLevelThrift> findAllTaxLevel() throws TException {
		List<TaxLevelThrift> result = new ArrayList<TaxLevelThrift>();
		List<TaxLevel> list = taxLevelService.findAll();
		if(list!=null && list.size()>0){
			for(TaxLevel dmd:list){
				result.add(ClassCast.cast(dmd, TaxLevelThrift.class));
			}
		}
		return result;
	}

}
