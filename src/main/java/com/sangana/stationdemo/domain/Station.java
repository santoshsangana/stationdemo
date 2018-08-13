package com.sangana.stationdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	//@GeneratedValue(strategy=GenerationType.AUTO)
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Station)) {
			return false;
		}
		Station other = (Station) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (stationId == null) {
			if (other.stationId != null) {
				return false;
			}
		} else if (!stationId.equals(other.stationId)) {
			return false;
		}
		return true;
	}


	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", name=" + name + ", hdEnabled=" + hdEnabled + ", callSign="
				+ callSign + "]";
	}
	
	
}
