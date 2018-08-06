package com.sangana.stationdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author sksangana
 *
 */
@XmlRootElement
@Entity
@Table(name="stations")
public class Station {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="station_id")
	String stationId;
	@Column(name="station_name")
	String name;
	@Column(name="hd_enabled")
	boolean hdEnabled;
	@Column(name="callSign")
	String callSign;
	
	
	public Station() {
		super();
	}


	public Station(String staionId, String name, boolean hdEnabled, String callSign) {
		this();
		this.stationId = staionId;
		this.name = name;
		this.hdEnabled = hdEnabled;
		this.callSign = callSign;
	}


	public String getStaionId() {
		return stationId;
	}


	public void setStaionId(String staionId) {
		this.stationId = staionId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isHdEnabled() {
		return hdEnabled;
	}


	public void setHdEnabled(boolean hdEnabled) {
		this.hdEnabled = hdEnabled;
	}


	public String getCallSign() {
		return callSign;
	}


	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
}
