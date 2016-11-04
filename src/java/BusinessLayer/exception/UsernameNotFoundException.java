/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLayer.exception;


public class UsernameNotFoundException extends RuntimeException {

	public UsernameNotFoundException(String strexception) {
		super(strexception);
	}
}