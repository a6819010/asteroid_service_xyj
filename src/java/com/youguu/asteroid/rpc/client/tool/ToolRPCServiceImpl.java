package com.youguu.asteroid.rpc.client.tool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
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
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;

public class ToolRPCServiceImpl implements IToolRPCService {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private ToolClient getClient() {
		return new ToolClient();
	}
	@Override
	public int saveBenchmarkRate(BenchmarkRate r) {
		try {
			return getClient().saveBenchmarkRate(ClassCast.cast(r, BenchmarkRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateBenchmarkRate(BenchmarkRate r) {
		try {
			return getClient().updateBenchmarkRate(ClassCast.cast(r, BenchmarkRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteBenchmarkRate(int id) {
		try {
			return getClient().deleteBenchmarkRate(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public BenchmarkRate getBenchmarkRate(int id) {
		try {
			return ClassCast.cast(getClient().getBenchmarkRate(id),BenchmarkRate.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<BenchmarkRate> queryBenchmarkRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryBenchmarkRateList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<BenchmarkRate>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<BenchmarkRate> findAllBenchmarkRate() {
		List<BenchmarkRate> result = new ArrayList<BenchmarkRate>();
		List<BenchmarkRateThrift> list = null;
		try {
			list = getClient().findAllBenchmarkRate();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (BenchmarkRateThrift dmd : list) {
				result.add(ClassCast.cast(dmd, BenchmarkRate.class));
			}
		}
		return result;
	}

	@Override
	public int saveDepositRate(DepositRate r) {
		try {
			return getClient().saveDepositRate(ClassCast.cast(r, DepositRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateDepositRate(DepositRate r) {
		try {
			return getClient().updateDepositRate(ClassCast.cast(r, DepositRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteDepositRate(int id) {
		try {
			return getClient().deleteDepositRate(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public DepositRate getDepositRate(int id) {
		try {
			return ClassCast.cast(getClient().getDepositRate(id),DepositRate.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<DepositRate> queryDepositRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryDepositRateList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<DepositRate>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<DepositRate> findAllDepositRate() {
		List<DepositRate> result = new ArrayList<DepositRate>();
		List<DepositRateThrift> list = null;
		try {
			list = getClient().findAllDepositRate();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (DepositRateThrift dmd : list) {
				result.add(ClassCast.cast(dmd, DepositRate.class));
			}
		}
		return result;
	}

	@Override
	public int saveForeignCurrency(ForeignCurrency r) {
		try {
			return getClient().saveForeignCurrency(ClassCast.cast(r, ForeignCurrencyThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateForeignCurrency(ForeignCurrency r) {
		try {
			return getClient().updateForeignCurrency(ClassCast.cast(r, ForeignCurrencyThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteForeignCurrency(int id) {
		try {
			return getClient().deleteForeignCurrency(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public ForeignCurrency getForeignCurrency(int id) {
		try {
			return ClassCast.cast(getClient().getForeignCurrency(id),ForeignCurrency.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<ForeignCurrency> queryForeignCurrencyList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryForeignCurrencyList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<ForeignCurrency>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<ForeignCurrency> findAllForeignCurrency() {
		List<ForeignCurrency> result = new ArrayList<ForeignCurrency>();
		List<ForeignCurrencyThrift> list = null;
		try {
			list = getClient().findAllForeignCurrency();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (ForeignCurrencyThrift dmd : list) {
				result.add(ClassCast.cast(dmd, ForeignCurrency.class));
			}
		}
		return result;
	}

	@Override
	public int initForeignCurrency(String currencyCode) {
		try {
			return getClient().initForeignCurrency(currencyCode);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int saveLendingRate(LendingRate r) {
		try {
			return getClient().saveLendingRate(ClassCast.cast(r, LendingRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateLendingRate(LendingRate r) {
		try {
			return getClient().updateLendingRate(ClassCast.cast(r, LendingRateThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteLendingRate(int id) {
		try {
			return getClient().deleteLendingRate(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public LendingRate getLendingRate(int id) {
		try {
			return ClassCast.cast(getClient().getLendingRate(id),LendingRate.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<LendingRate> queryLendingRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryLendingRateList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<LendingRate>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<LendingRate> findAllLendingRate() {
		List<LendingRate> result = new ArrayList<LendingRate>();
		List<LendingRateThrift> list = null;
		try {
			list = getClient().findAllLendingRate();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (LendingRateThrift dmd : list) {
				result.add(ClassCast.cast(dmd, LendingRate.class));
			}
		}
		return result;
	}

	@Override
	public int saveSocialInsurance(SocialInsurance r) {
		try {
			return getClient().saveSocialInsurance(ClassCast.cast(r, SocialInsuranceThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateSocialInsurance(SocialInsurance r) {
		try {
			return getClient().updateSocialInsurance(ClassCast.cast(r, SocialInsuranceThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteSocialInsurance(int id) {
		try {
			return getClient().deleteSocialInsurance(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public SocialInsurance getSocialInsurance(int id) {
		try {
			return ClassCast.cast(getClient().getSocialInsurance(id),SocialInsurance.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<SocialInsurance> querySocialInsuranceList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().querySocialInsuranceList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<SocialInsurance>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<SocialInsurance> findAllSocialInsurance() {
		List<SocialInsurance> result = new ArrayList<SocialInsurance>();
		List<SocialInsuranceThrift> list = null;
		try {
			list = getClient().findAllSocialInsurance();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (SocialInsuranceThrift dmd : list) {
				result.add(ClassCast.cast(dmd, SocialInsurance.class));
			}
		}
		return result;
	}

	@Override
	public int saveTaxBase(TaxBase r) {
		try {
			return getClient().saveTaxBase(ClassCast.cast(r, TaxBaseThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateTaxBase(TaxBase r) {
		try {
			return getClient().updateTaxBase(ClassCast.cast(r, TaxBaseThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteTaxBase(int id) {
		try {
			return getClient().deleteTaxBase(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public TaxBase getTaxBase(int id) {
		try {
			return ClassCast.cast(getClient().getTaxBase(id),TaxBase.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<TaxBase> queryTaxBaseList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryTaxBaseList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<TaxBase>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<TaxBase> findAllTaxBase() {
		List<TaxBase> result = new ArrayList<TaxBase>();
		List<TaxBaseThrift> list = null;
		try {
			list = getClient().findAllTaxBase();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (TaxBaseThrift dmd : list) {
				result.add(ClassCast.cast(dmd, TaxBase.class));
			}
		}
		return result;
	}

	@Override
	public int saveTaxLevel(TaxLevel r) {
		try {
			return getClient().saveTaxLevel(ClassCast.cast(r, TaxLevelThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateTaxLevel(TaxLevel r) {
		try {
			return getClient().updateTaxLevel(ClassCast.cast(r, TaxLevelThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int deleteTaxLevel(int id) {
		try {
			return getClient().deleteTaxLevel(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public TaxLevel getTaxLevel(int id) {
		try {
			return ClassCast.cast(getClient().getTaxLevel(id),TaxLevel.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<TaxLevel> queryTaxLevelList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryTaxLevelList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<TaxLevel>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<TaxLevel> findAllTaxLevel() {
		List<TaxLevel> result = new ArrayList<TaxLevel>();
		List<TaxLevelThrift> list = null;
		try {
			list = getClient().findAllTaxLevel();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (TaxLevelThrift dmd : list) {
				result.add(ClassCast.cast(dmd, TaxLevel.class));
			}
		}
		return result;
	}
	@Override
	public int addRateDiscount(RateDiscount t) {
		try {
			return getClient().addRateDiscount(ClassCast.cast(t, RateDiscountThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}
	@Override
	public boolean deleteRateDiscount(int id) {
		try {
			return getClient().deleteRateDiscount(id);
		} catch (TException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public RateDiscount getRateDiscount(int id) {
		try {
			return ClassCast.cast(getClient().getRateDiscount(id),RateDiscount.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public boolean modifyRateDiscount(RateDiscount t) {
		try {
			return getClient().modifyRateDiscount(ClassCast.cast(t, RateDiscountThrift.class));
		} catch (TException e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public PageHolder<RateDiscount> queryRateDiscountList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().queryRateDiscountList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<RateDiscount>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}
	@Override
	public List<RateDiscount> findAllRateDiscount() {
		List<RateDiscount> result = new ArrayList<RateDiscount>();
		List<RateDiscountThrift> list = null;
		try {
			list = getClient().findAllRateDiscount();
		} catch (TException e) {
			logger.error(e);
		}
		if (list != null && list.size() > 0) {
			for (RateDiscountThrift dmd : list) {
				result.add(ClassCast.cast(dmd, RateDiscount.class));
			}
		}
		return result;
	}

}
