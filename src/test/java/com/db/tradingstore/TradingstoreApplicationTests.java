package com.db.tradingstore;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.db.tradingstore.model.TradingInfo;
import com.db.tradingstore.repository.TradingInfoJpaRespository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TradingstoreApplicationTests {


	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TradingInfoJpaRespository tradingInfoJpaRepository;
	
	@Before
	public void createTradeInfo() {
       
    }
	
	@Test
	public void contextLoads() {
		
		TradingInfo ti = new TradingInfo("T1", 1, "CP-1", "B1", new Date(2020, 05, 13), new Date(2020, 05, 13),true);
		List<TradingInfo> tradeList = Collections.singletonList(ti);
		BDDMockito.given(tradingInfoJpaRepository.findByTradeId("T1")).willReturn(tradeList);
		
		//Mockito.when(tradingInfoJpaRepository.findAll()).thenReturn((List<TradingInfo>) new TradingInfo("T1", 1, "CP-1", "B1", new Date(2020, 05, 13), new Date(2020, 05, 13),true));
		
		try {
			MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.get("/tradinginformation/load/T1")
					.contentType(MediaType.APPLICATION_JSON)
					.characterEncoding("UTF-8")
					)
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$..tradeId").value("T1"))
					.andReturn();
			System.out.println(mvcResult.getResponse());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mockito.verify(tradingInfoJpaRepository).findByTradeId(ti.getTradeId());
	}

}
