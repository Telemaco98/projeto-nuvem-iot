package br.ufrn.imd.winecloud.business;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.appengine.api.users.User;

import br.ufrn.imd.winecloud.entity.Barrel;

/**
 * 
 * @author  Shirley Ohara (shirleyohara@ufrn.edu.br)
 * @version 25 de jun de 2019 | 02:07:17
 */
public class BarrelServices {
	private Barrel 	barrel;
	private User 	user;
	
	/**
	 * Convenience constructor
	 * @param barrel
	 * @param user
	 */
	public BarrelServices (Barrel barrel, User user) {
		this.barrel = barrel;
		this.user 	= user;
	}
	
	public void registerBarrel() throws IOException {
		System.out.println(barrel.toString());

		String url_str 	= "http://" + ConnectionUtils.IP + ":" + ConnectionUtils.PORT_ORION + "/v1/contextEntities";
		String json 	= 
			"{ " +
					"\"type\": \"" + user.getUserId() + "_" + "barrel\", " +
					"\"isPattern\": \"false\", " +
					"\"id\": \"" + barrel.getId() + "\", " +
					"\"attributes\": [" + 
						"{ " +
							"\"name\": \"dob\"    ," + 
							"\"type\": \"String\" ," + 
							"\"value\": \""+ barrel.getDob() + "\" }," + 
						"{ " +
							"\"name\": \"grapeType\"," + 
							"\"type\": \"String\"," + 
							"\"value\": \"" + barrel.getGrapeType() + "\" }" + 
					"]" +
				"}";
		
		System.out.println(url_str);
		System.out.println(json);
		
		URL	   url = new URL(url_str);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("Content-Type", "application/json; charset=UFT-8");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		
		OutputStream os = con.getOutputStream();
		os.write(json.getBytes("UTF-8"));
		os.close();
		
		InputStream is = new BufferedInputStream(con.getInputStream());
		String result = IOUtils.toString(is, "UTF-8");
		is.close();
		
		System.out.println(result);
		
		con.disconnect();
	}
}