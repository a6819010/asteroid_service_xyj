package com.youguu.asteroid.rpc.client.tool;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.BenchmarkRate;
import com.youguu.asteroid.tool.pojo.DepositRate;
import com.youguu.asteroid.tool.pojo.ForeignCurrency;
import com.youguu.asteroid.tool.pojo.LendingRate;
import com.youguu.asteroid.tool.pojo.RateDiscount;
import com.youguu.asteroid.tool.pojo.SocialInsurance;
import com.youguu.asteroid.tool.pojo.TaxBase;
import com.youguu.asteroid.tool.pojo.TaxLevel;
import com.youguu.core.util.PageHolder;

public interface IToolRPCService {
	int saveBenchmarkRate(BenchmarkRate r);
	int updateBenchmarkRate(BenchmarkRate r);
	int deleteBenchmarkRate(int id);
	BenchmarkRate getBenchmarkRate(int id);
	public PageHolder<BenchmarkRate> queryBenchmarkRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<BenchmarkRate> findAllBenchmarkRate();
	
	int saveDepositRate(DepositRate r);
	int updateDepositRate(DepositRate r);
	int deleteDepositRate(int id);
	DepositRate getDepositRate(int id);
	public PageHolder<DepositRate> queryDepositRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<DepositRate> findAllDepositRate();
	
	int saveForeignCurrency(ForeignCurrency r);
	int updateForeignCurrency(ForeignCurrency r);
	int deleteForeignCurrency(int id);
	ForeignCurrency getForeignCurrency(int id);
	public PageHolder<ForeignCurrency> queryForeignCurrencyList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<ForeignCurrency> findAllForeignCurrency();
	int initForeignCurrency(String currencyCode);
	
	int saveLendingRate(LendingRate r);
	int updateLendingRate(LendingRate r);
	int deleteLendingRate(int id);
	LendingRate getLendingRate(int id);
	public PageHolder<LendingRate> queryLendingRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<LendingRate> findAllLendingRate();
	
	int saveSocialInsurance(SocialInsurance r);
	int updateSocialInsurance(SocialInsurance r);
	int deleteSocialInsurance(int id);
	SocialInsurance getSocialInsurance(int id);
	public PageHolder<SocialInsurance> querySocialInsuranceList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<SocialInsurance> findAllSocialInsurance();
	
	int saveTaxBase(TaxBase r);
	int updateTaxBase(TaxBase r);
	int deleteTaxBase(int id);
	TaxBase getTaxBase(int id);
	public PageHolder<TaxBase> queryTaxBaseList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<TaxBase> findAllTaxBase();
	
	int saveTaxLevel(TaxLevel r);
	int updateTaxLevel(TaxLevel r);
	int deleteTaxLevel(int id);
	TaxLevel getTaxLevel(int id);
	public PageHolder<TaxLevel> queryTaxLevelList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	List<TaxLevel> findAllTaxLevel();
	
	public int addRateDiscount(RateDiscount t);
	public boolean deleteRateDiscount(int id);
	public RateDiscount getRateDiscount(int id);
	public boolean modifyRateDiscount(RateDiscount t);
	public PageHolder<RateDiscount> queryRateDiscountList(HashMap<String, Object> hm, int pageIndex, int pageSize);
	public List<RateDiscount> findAllRateDiscount();
}
