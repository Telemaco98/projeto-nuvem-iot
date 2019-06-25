package br.ufrn.imd.winecloud.entity;

/**
 * The SensorType enumerates the sensor types. A sensor can be typed with
 * Humidity or Temperature
 *
 * @author  Shirley Ohara (shirleyohara@ufrn.edu.br)
 * @version 18 de jun de 2019 | 23:13:03
 */
public enum SensorType {
	Humidity, Temperature;
	
	/**
	 * Return the sensor type from a string
	 * @param type
	 * @return
	 */
	public static SensorType SensorTypeFromStr (String type) {
		switch (type) {
			case "Humidity":
				return SensorType.Humidity;
			default:
				return SensorType.Temperature;
		}
	}
}