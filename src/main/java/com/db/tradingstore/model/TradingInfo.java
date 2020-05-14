package com.db.tradingstore.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * Entity for table trading_info table
 * @author PadmaPriyaKowlwar
 *
 */

@Entity
public class TradingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADINGINFO_SEQUENCE")
	@SequenceGenerator(name = "TRADINGINFO_SEQUENCE", sequenceName = "SEQ_TRADINGINFO")
	@Column(name = "Id")
	private Integer Id;
	
	@Column(name = "Tradeid")
	private String tradeId;
	
	@Column(name = "Version")
	private int version;
	
	@Column(name = "Counterpartyid")
	private String counterPartyId;
	
	@Column(name = "Bookid")
	private String  bookId;

	@Column(name = "Maturitydate")
	private Date maturityDate;
	
	@Column(name = "Createddate")
	private Date createdDate;
	
	@Column(name = "Expired")
	private boolean expired;

	public TradingInfo() {
		
	}

	public TradingInfo(String tradeId, int version, String counterPartyId, String bookId, Date maturityDate,
			Date createdDate, boolean expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	
	@Override
	public String toString() {
		return "TradingInformation [tradeId=" + tradeId + ", version=" + version + ", counterPartyId=" + counterPartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + "]";
	}
}
