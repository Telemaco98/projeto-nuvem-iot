package br.ufrn.imd.winecloud.business;

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
	
	public void registerBarrel() {
		System.out.println(barrel.toString());
		
		
//		Método: POST
//		Link:   http://169.254.169.254#53:1026/v1/contextEntities
//		Header
//			KEY: Content-Type
//			VALUE: applcation/json
//		Body
//		{ 
//			"type": ("user.getUserId() + "_" + "barril") ", 
//			"isPattern": "false", 
//			"id": "barrel.getID()",
//			"attributes": [ 
//				{ 
//					"name": "Medicao", 
//					"type": "float", 
//					"value": "25.0" }, 
//				{ 
//					"name": "Localizacao", 
//					"type": "coords", 
//					"value": "-5.8323934,-35.2076385"
//				} 
//			]
//		}

	}
}