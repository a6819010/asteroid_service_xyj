namespace java com.youguu.asteroid.rpc.thrift.gen

/** 敏感词*/
struct SensitiveWordThrift {
	1: i32 id
	2: string word
	3: i64 createTime
}


/** 统计投票*/
struct MarketWindVanePollVoteThrift {
	1: string date
	2: i32 num
	3: i32 up
	4: i32 down
	5: i32 result
}

/** 模拟炒股广告墙*/
struct AdWallThrift {
	1: i32 id
	2: string title
	3: string forwardUrl
	4: i64 beginDate
	5: i64 endDate
	6: string adImage
	7: string positionType
	8: string contentType
	9: string content
	10: i64 createTime
	11: i32 rank
}
/** 工资纳税起征基数*/
struct TaxBaseThrift{
	1:i32 taxBase
	2:i32 id
	3:i64 createTime
}
/** 社保及公积金缴存比例*/
struct SocialInsuranceThrift{
	1:i32 houseBase
	2:double houseDown
	3:double houseRate
	4:double houseUp
	5:double medicalDown
	6:double medicalRate
	7:double medicalExt
	8:double medicalUp
	9:i32 socialBase
	10:string cityCode
	11:string cityName
	12:double oldDown
	13:double oldRate
	14:double birthDown
	15:double birthRate
	16:double workUp
	17:double injuryDown
	18:double injuryRate
	19:i64 updateTime
	20:double birthUp
	21:i32 id
	22:double workDown
	23:double workRate
	24:double oldUp
	25:double injuryUp
	26:i32 socialMax
}
struct LendingRateThrift{
	1:string bankCode
	2:string bankName
	3:double year3ToYear5
	4:double month6ToYear1
	5:i64 updateTime
	6:double month6Below
	7:double year1ToYear3
	8:i32 id
	9:double year5Above
	10:double year5Below
}
/** 外汇汇率表*/
struct ForeignCurrencyThrift{
	1:string beforeMoneyCode
	2:string beforeMoneyName
	3:string afterMoneyCode
	4:string afterMoneyName
	5:double convertRate
	6:i64 updateTime
	7:i32 id
}
/** 存款利率表*/
struct DepositRateThrift{
	1:string bankCode
	2:string bankName
	3:double currentDepositRate
	4:double fixedDeposit3month
	5:double fixedDeposit6month
	6:i64 updateTime
	7:i32 id
	8:double fixedDeposit1year
	9:double fixedDeposit2year
	10:double fixedDeposit3year
	11:double fixedDeposit5year
}
/** 基准利率表*/
struct BenchmarkRateThrift{
	1:double businessRate
	2:i64 updateTime
	3:i32 id
	4:double housingRate
}
/** 工资纳税标准等级*/
struct TaxLevelThrift{
	1:double taxRate
	2:i32 salaryStart
	3:i64 updateTime
	4:i32 salaryEnd
	5:i32 id
	6:i32 quickDeduction
}
struct RateDiscountThrift{
	1:string discountLevel
	2:i32 id
	3:i32 rank
	4:double value
}

/** 活动抽奖业务传递PO*/
struct VoPrizeInfoThrift{
	1:i32 prizeId;
	2:i32 taskId;
	3:i32 num;
}

/** 活动抽奖用户*/
struct ActivityUserThrift{
	1:i32 brokerId
	2:string brokerUserId
	3:i32 taskId
	4:i64 ctime
}

/** 活动奖品*/
struct ActivityPrizeThrift{
	1:i32 id
	2:string name
	3:i32 prizeValue
	4:i32 prizeType
}

/** 银行列表service */
struct BankThrift{
	1:i32 id
	2:string bankName
	3:string bankNameAbbr
	4:string bankLogo
}

/** 银行分组信息service */
struct BankGroupThrift{
	1:i32 id
	2:i32 groupType
	3:i32 bankId
	4:string bankCode
}

/** 敏感词service*/
service WordThriftRpcService {
	/** 添加敏感词*/
	i32 addSensitiveWord(1:string words);
	/** 更新敏感词*/
	i32 updateSensitiveWord(1:SensitiveWordThrift word);
	/** 删除敏感词*/
	i32 deleteSensitiveWord(1:i32 id);
	/** 获取敏感词*/
	SensitiveWordThrift getSensitiveWord(1:i32 id);
	
	/** 分页查询敏感词*/
	binary querySensitiveWordList(1:string word, 2:i32 pageIndex, 3:i32 pageSize);
	
	/** 判断是否包含敏感词*/
	bool isContainSensitiveWord(1:string text);
	
	/** 重载敏感词缓存*/
	bool refreshSensitiveWord();
	
	/** 获取文本中的敏感词*/
	binary getMatchedWords(1:string text);

	/** 获取图片中的文字*/
	string getStringByImg(1:binary img)
}


/** 交易日service*/
service TradeDayThriftRpcService {
	/** 判断是否是交易日 **/
	bool isTradeDay_string(1:string date);
	
	/** 判断是否是交易日 **/
	bool isTradeDay_long(1:i64 date);
	
	/** 判断下个交易日 **/
	string nextTradeDay_string(1:string date,2:i32 num);
	
	/** 判断下个交易日 **/
	string nextTradeDay_long(1:i64 date,2:i32 num);
	
	string queryTradeDayEnd(1:i64 date, 2:i32 days, 3:bool isContainStartDate)
	
	i32 queryTradeDayInterval(1:i64 date, 2:i32 days, 3:bool isContainStartDate)
	
	i32 getTradeDayNum(1:string beginDate,2:string endDate)
}

/** 市场风向标service*/
service WindVaneThriftRpcService {
	/** 获取指定日期的统计投票 **/
	MarketWindVanePollVoteThrift getMarketWindVanePollVote(1:string date);
	
	/** 更新统计投票 **/
	i32 updateMarketWindVanePollVote(1:MarketWindVanePollVoteThrift mwv);
	
	/** 闭市清算投票结果 **/
	i32 closeClear();
	
	/** 查询风向标信息 **/
	map<string, string> findWindVane(1:i32 uid);
	
	/** 投票 **/
	i32 vote(1:i32 uid,2:i32 voteflag);
	
	/** 牛熊比 **/
	map<string, list<double>> cowThanBear();
	
	/** 获取牛熊比的时间 **/
	list<string> getNDaysWindVaneTime(1:i32 daynum);
}

/** 模拟炒股广告墙service*/
service AdWallThriftRpcService{
	/** 添加广告*/
	i32 addAdWall(1:AdWallThrift t);
	
	/** 删除广告*/
	i32 deleteAdWall(1:i32 id);
	
	/** 修改广告*/
	i32 updateAdWall(1:AdWallThrift t);
	
	/** 查询广告*/
	AdWallThrift getAdWall(1:i32 id);
	
	/** 查询广告 分页*/
	binary queryAdWallList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	
	/**  将广告按位置类型缓存到redis中*/
	bool flushRedis(1:string positionType);
	
	/**  按照位置类型从redis中查询广告*/
	list<AdWallThrift> queryAdWallFromRedis(1:string positionType);
}

/** 工具箱*/
service ToolThriftRpcService{
	i32 saveBenchmarkRate(1:BenchmarkRateThrift r);
	i32 updateBenchmarkRate(1:BenchmarkRateThrift r);
	i32 deleteBenchmarkRate(1:i32 id);
	BenchmarkRateThrift getBenchmarkRate(1:i32 id);
	binary queryBenchmarkRateList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<BenchmarkRateThrift> findAllBenchmarkRate();
	
	i32 saveDepositRate(1:DepositRateThrift r);
	i32 updateDepositRate(1:DepositRateThrift r);
	i32 deleteDepositRate(1:i32 id);
	DepositRateThrift getDepositRate(1:i32 id);
	binary queryDepositRateList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<DepositRateThrift> findAllDepositRate();
	
	i32 saveForeignCurrency(1:ForeignCurrencyThrift r);
	i32 updateForeignCurrency(1:ForeignCurrencyThrift r);
	i32 deleteForeignCurrency(1:i32 id);
	ForeignCurrencyThrift getForeignCurrency(1:i32 id);
	binary queryForeignCurrencyList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<ForeignCurrencyThrift> findAllForeignCurrency();
	i32 initForeignCurrency(1:string currencyCode);
	
	i32 saveLendingRate(1:LendingRateThrift r);
	i32 updateLendingRate(1:LendingRateThrift r);
	i32 deleteLendingRate(1:i32 id);
	LendingRateThrift getLendingRate(1:i32 id);
	binary queryLendingRateList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<LendingRateThrift> findAllLendingRate();
	
	i32 addRateDiscount(1:RateDiscountThrift t);
	bool deleteRateDiscount(1:i32 id);
	RateDiscountThrift getRateDiscount(1:i32 id);
	bool modifyRateDiscount(1:RateDiscountThrift t);
	binary queryRateDiscountList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<RateDiscountThrift> findAllRateDiscount();
	
	i32 saveSocialInsurance(1:SocialInsuranceThrift r);
	i32 updateSocialInsurance(1:SocialInsuranceThrift r);
	i32 deleteSocialInsurance(1:i32 id);
	SocialInsuranceThrift getSocialInsurance(1:i32 id);
	binary querySocialInsuranceList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);
	list<SocialInsuranceThrift> findAllSocialInsurance();
	
	i32 saveTaxBase(1:TaxBaseThrift r);
	i32 updateTaxBase(1:TaxBaseThrift r);
	i32 deleteTaxBase(1:i32 id);
	TaxBaseThrift getTaxBase(1:i32 id);
	binary queryTaxBaseList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);	
	list<TaxBaseThrift> findAllTaxBase();
	
	i32 saveTaxLevel(1:TaxLevelThrift r);
	i32 updateTaxLevel(1:TaxLevelThrift r);
	i32 deleteTaxLevel(1:i32 id);
	TaxLevelThrift getTaxLevel(1:i32 id);
	binary queryTaxLevelList(1:binary hm, 2:i32 pageIndex, 3:i32 pageSize);	
	list<TaxLevelThrift> findAllTaxLevel();
	
}

/** 微信礼包service*/
service WxgiftThriftRpcService{

	/** 查询状态*/
	string queryStatus(1:string openid , 2:string hopenid);
	
	/** 拆红包*/
	i32 open(1:string openid , 2:string hopenid);
	
	/** 记录手机*/
	i32 phone(1:string openid , 2:string phone);
}

/** 活动抽奖 service*/
service ActivityLotteryThriftRpcService{

	/** 加载活动抽奖首页数据*/
	binary findUserAwardInfo(1:i32 userId);
	
	/** 查询用户中奖记录*/
	binary findUserAwardRecord(1:i32 userId);
	
	/** 点击抽奖*/
	binary clickLottery(1:i32 userId);
	
	/** 获取奖励*/
	binary getAward(1:i32 poolId,2:string phone,3:i32 userId);
	
	/** 生成奖品池*/
	i32 createPrizePool(1:list<VoPrizeInfoThrift> listDate,2:i32 batchNum);
	
	/** 生成奖品池*/
	i32 createBigPrize(1:VoPrizeInfoThrift vpi);
	
	/** 比对数据*/
	i32 comparisonData();
	
	/** 分页查询活动用户信息*/
	binary findAllActivityUser(1:binary parameter,2:i32 pageIndex,3:i32 pageSize);
	
	/** 分页查询奖品*/
	binary findAllActivityPrize(1:binary parameter,2:i32 pageIndex,3:i32 pageSize);
	
	/** 分页用户抽奖总次数信息*/
	binary findAllUserAwardNum(1:binary parameter,2:i32 pageIndex,3:i32 pageSize);
	
	/** 批量插入活动用户信息*/
	i32 batchInsertActivityUser(1:list<ActivityUserThrift> listData);
	
	/** 新增奖品 */
	i32 addActivityPrize(1:ActivityPrizeThrift ap);
	
	/** 分页查询领取记录 */
	binary findAllActivityUserAwardRecord(1:binary parameter,2:i32 pageIndex,3:i32 pageSize);
	
	/** 删除奖品 */
	i32 delActivityPrize(1:i32 id);
	
	/** 修改用户奖品记录信息 */
	i32 updateUserAwardRecordStatus(1:i32 pooId,2:i32 status);
}

/** BankService */
service BankThriftRpcService{
	/** 增加银行信息 */
	i32 addBank(1:BankThrift bankThrift);
	
	/** 通过银行ID删除银行信息 */
	i32 removeBankById(1:i32 id);
	
	/** 通过银行id修改银行信息 */
	i32 modifyBankById(1:i32 id,2:BankThrift bankThrift);
	
	/** 通过银行ID查找银行信息 */
	BankThrift getBankById(1:i32 id);
	
	/** 获取银行信息列表 */
	list<BankThrift> getBankList();
	
	/** 添加银行分组信息 */
	i32 addBankGroup(1:list<BankGroupThrift> listBankGroup);
	
	/** 通过ID删除银行分组信息 */
	i32 removeBankGroupById(1:i32 id);
	
	/** 通过id修改银行分组信息 */
	i32 modifyBankGroupById(1:i32 id,2:BankGroupThrift bankGroupThrift);
	
	/** 通过type查询银行分组信息 */
	list<BankThrift> getBankGroupByType(1:i32 type);
	
	/** 获取所有银行分组信息 */
	list<BankGroupThrift> getBankGroupList(1:i32 type,2:string bankCode);
	
	/** 通过银行ID查找银行信息 */
	BankGroupThrift getBankGroupById(1:i32 id);
	
	/** 通过银行ID列表查找银行信息列表 */
	list<BankThrift> getBankListById(1:list<i32> id);
	
	/** 通过分组类别和分组代码查询银行信息 */
	list<BankThrift> findBankByGroup(1:i32 type,string bankCode);
	
	/** 通过组装参数查询银行信息 */
	list<BankThrift> findBankByParams(1:i32 id,2:string bankName,3:string bankNameAbbr);
}
/** BuncRPCService */
service FuncThriftRpcService{
	list<string> queryFunc(1:string ak);
}