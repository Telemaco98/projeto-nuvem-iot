package br.ufrn.imd.winecloud.entity;

import java.util.ArrayList;
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
	private List<Sensor> sensors;

	/**
	 * Default constructor
	 * @param id
	 */
	public Barrel(String id) {
		this.id = id;
		this.sensors = new ArrayList<Sensor>();
	}
	
	/**
	 * Default constructor
	 * @param id
	 */
	public Barrel(String id, List<Sensor> sensors) {
		this.id = id;
		this.sensors = sensors;
	}
	
	/**
	 * Returns the barrel id
	 * @return
	 */
	public String getId() {
		return id;
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
}