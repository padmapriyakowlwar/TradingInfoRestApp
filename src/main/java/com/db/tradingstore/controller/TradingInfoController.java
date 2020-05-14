package com.db.tradingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.tradingstore.model.TradingInfo;
import com.db.tradingstore.repository.TradingInfoJpaRespository;

@RestController
@RequestMapping("/tradinginformation")
public class TradingInfoController {

	@Autowired
	private TradingInfoJpaRespository tradingInfoJpaRespository;
	
	/**
	 * Get method to read all the records {@link TradingInfo} from database 
	 */
	@GetMapping(value = "/all")
	public List<TradingInfo> getAll(){
		return tradingInfoJpaRespository.findAll();
	}
	
	@PostMapping(value = "/getBytradeId")
	public TradingInfo fetchWithTradeId(@RequestBody final TradingInfo tradingInfo){
		return tradingInfoJpaRespository.findByTradeId(tradingInfo.getTradeId(), Sort.unsorted());
	}
	
	/*
	 * Post method to write single record to database 
	 */
	@PostMapping(value="/load")
	public List<TradingInfo> persist(@RequestBody final TradingInfo tradingInfo){
		tradingInfoJpaRespository.save(tradingInfo);
		return tradingInfoJpaRespository.findAll();
		
	}
	
	/*
	 * Post method to write single record to database only if the version of the trade has higher value than the version available in the database for a particular trade id. 
	 */
	@PostMapping(value="/loadBasedOnCondition")
	public List<TradingInfo> persistOnlyBasedOnCondition(@RequestBody final TradingInfo tradingInfo){
		
		List<TradingInfo> filteredTrades = tradingInfoJpaRespository.findAllByTradeIdOrderByVersionDesc(tradingInfo.getTradeId());
		if(filteredTrades.get(0).getVersion() < tradingInfo.getVersion())
		{
			tradingInfoJpaRespository.save(tradingInfo);
		}
		
		return tradingInfoJpaRespository.findAllByTradeIdOrderByVersionDesc(tradingInfo.getTradeId());
		
	}
	
}
