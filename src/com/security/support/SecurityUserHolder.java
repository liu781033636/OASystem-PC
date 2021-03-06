/**
 * 
 */
package com.security.support;

import org.springframework.security.context.SecurityContextHolder;

import com.security.model.User;


/**
 * @author Downpour
 * 
 */
public class SecurityUserHolder {

	/**
	 * Returns the current user
	 * 
	 * @return
	 */
	public static User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
