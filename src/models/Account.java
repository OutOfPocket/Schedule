/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author AppleSauce
 */
public class Account
{
    
	private String email, displayName, password;
        private int id;
	
	public Account()
	{
		email = displayName = password = "";
                id = 0;
	}

	public Account(String email, String displayName, String password) {
		super();
		this.email = email;
		this.displayName = displayName;
		this.password = password;
                this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
        public void setID(int id) {
        this.id = id;
        }
        public int getID() {
        return id;
        }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}