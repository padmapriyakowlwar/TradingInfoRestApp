package com.db.tradingstore.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.db.tradingstore.model.TradingInfo;

@Component
public interface TradingInfoJpaRespository extends JpaRepository<TradingInfo, Integer>{

	TradingInfo findByTradeId(String tradeId, Sort sort);
	
	List<TradingInfo> findAllByTradeIdOrderByVersionDesc(String tradeId);
}
