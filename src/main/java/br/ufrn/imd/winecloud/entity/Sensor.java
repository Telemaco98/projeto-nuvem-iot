package br.ufrn.imd.winecloud.entity;

/**
 * The class that represents a sensor. In this case, the sensor can be 
 * of the humidity or the temperature, this is defined by the "type" field 
 * named. Furthermore, the sensor has the id (named in the creation) and the 
 * measure fields.
 *
 * @author  Shirley Ohara (shirleyohara@ufrn.edu.br)
 * @version 18 de jun de 2019 | 23:00:59
 */
public class Sensor {
	private String		id;
	private SensorType	type;
	private double		measure;
	
	/**
	 * Convenience constructor
	 * @param id
	 * @param type
	 * @param measure
	 */
	public Sensor (String id, SensorType type, double measure) {
		this.id   	 = id; 
		this.type 	 = type;
		this.measure = measure;
	}
	
	/**
	 * Return the id field 
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Returns the type field
	 * @return type
	 */
	public SensorType getType() {
		return type;
	}
	
	/**
	 * Returns the measure field
	 * @return measure
	 */
	public double getMeasure() {
		return measure;
	}
	
	/**
	 * Changes the value of the measure field 
	 * @param measure
	 */
	public void setMeasure(double measure) {
		this.measure = measure;
	}
}