package br.ufrn.imd.winecloud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Barrel. It is represented with two fields: the id
 * that identifies the barrel and a list of sensors.
 *
 * @author  Shirley Ohara (shirleyohara@ufrn.edu.br)
 * @version 18 de jun de 2019 | 23:16:57
 */
public class Barrel {
	private String id;
	private Date dob;
	private String grapeType;
	private List<Sensor> sensors;

	/**
	 * Convenience constructor
	 * @param id
	 * @param dob
	 * @param grapeType
	 */
	public Barrel(String id, Date dob, String grapeType) {
		this.id 		= id;
		this.dob 		= dob;
		this.grapeType 	= grapeType;
		this.sensors 	= new ArrayList<Sensor>();
	}
	
	/**
	 * Returns the barrel id
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Returns the day of birth
	 * @return dob
	 */
	public Date getDob() {
		return dob;
	}
	
	/**
	 * Returns the grape type
	 * @return grapeType
	 */
	public String getGrapeType() {
		return grapeType;
	}
	
	/**
	 * Returns the barrel sensors
	 * @return
	 */
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	/**
	 * Changes the value of the barrel sensors
	 * @param sensors
	 */
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	/**
	 * Converts a barrel to String type
	 */
	@Override
	public String toString() {
		return "[ id: "+ this.id + 
				", dob: " + this.dob + 
				", grape type: " + this.grapeType +
				" ]";
	}
}