package com.youguu.asteroid.rpc.client.tool;

import java.nio.ByteBuffer;
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
import com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

/**
* @ClassName: ToolClient 
* @Description: 工具箱 client
* @author lqipr
* @date 2014年12月4日 下午6:46:34
 */
public class ToolClient implements Iface{
private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private static RPCMultiplexPool pool = RPCServiceClient.getMultiplexCPool(Constants.ASTEROIDRPCPOOL);
	
	ToolClient() {
		super();
	}
	
	private RPCMultiplexConnection getClient() {
		try {
			return pool.borrowObject();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	
	@Override
	public int saveBenchmarkRate(BenchmarkRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveBenchmarkRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateBenchmarkRate(BenchmarkRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateBenchmarkRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteBenchmarkRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteBenchmarkRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public BenchmarkRateThrift getBenchmarkRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getBenchmarkRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryBenchmarkRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryBenchmarkRateList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<BenchmarkRateThrift> findAllBenchmarkRate() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllBenchmarkRate();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveDepositRate(DepositRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveDepositRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateDepositRate(DepositRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateDepositRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteDepositRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteDepositRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public DepositRateThrift getDepositRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getDepositRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryDepositRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryDepositRateList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<DepositRateThrift> findAllDepositRate() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllDepositRate();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveForeignCurrency(ForeignCurrencyThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveForeignCurrency(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateForeignCurrency(ForeignCurrencyThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateForeignCurrency(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteForeignCurrency(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteForeignCurrency(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ForeignCurrencyThrift getForeignCurrency(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getForeignCurrency(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryForeignCurrencyList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryForeignCurrencyList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<ForeignCurrencyThrift> findAllForeignCurrency()
			throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllForeignCurrency();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int initForeignCurrency(String currencyCode) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).initForeignCurrency(currencyCode);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveLendingRate(LendingRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveLendingRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateLendingRate(LendingRateThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateLendingRate(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteLendingRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteLendingRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public LendingRateThrift getLendingRate(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getLendingRate(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryLendingRateList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryLendingRateList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<LendingRateThrift> findAllLendingRate() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllLendingRate();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int addRateDiscount(RateDiscountThrift t) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).addRateDiscount(t);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public boolean deleteRateDiscount(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteRateDiscount(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public RateDiscountThrift getRateDiscount(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getRateDiscount(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public boolean modifyRateDiscount(RateDiscountThrift t) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).modifyRateDiscount(t);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryRateDiscountList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryRateDiscountList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<RateDiscountThrift> findAllRateDiscount() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllRateDiscount();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveSocialInsurance(SocialInsuranceThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveSocialInsurance(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateSocialInsurance(SocialInsuranceThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateSocialInsurance(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteSocialInsurance(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteSocialInsurance(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public SocialInsuranceThrift getSocialInsurance(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getSocialInsurance(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer querySocialInsuranceList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).querySocialInsuranceList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<SocialInsuranceThrift> findAllSocialInsurance()
			throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllSocialInsurance();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveTaxBase(TaxBaseThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveTaxBase(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateTaxBase(TaxBaseThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateTaxBase(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteTaxBase(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteTaxBase(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public TaxBaseThrift getTaxBase(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getTaxBase(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryTaxBaseList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryTaxBaseList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<TaxBaseThrift> findAllTaxBase() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllTaxBase();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int saveTaxLevel(TaxLevelThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).saveTaxLevel(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int updateTaxLevel(TaxLevelThrift r) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateTaxLevel(r);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int deleteTaxLevel(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).deleteTaxLevel(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public TaxLevelThrift getTaxLevel(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getTaxLevel(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer queryTaxLevelList(ByteBuffer hm, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).queryTaxLevelList(hm, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<TaxLevelThrift> findAllTaxLevel() throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).findAllTaxLevel();
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

}
