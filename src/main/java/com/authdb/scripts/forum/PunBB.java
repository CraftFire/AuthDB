/**
(C) Copyright 2011 CraftFire <dev@craftfire.com>
Contex <contex@craftfire.com>, Wulfspider <wulfspider@craftfire.com>

This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License. 
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/ 
or send a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.
**/

package com.authdb.scripts.forum;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.authdb.util.Config;
import com.authdb.util.Encryption;
import com.authdb.util.databases.MySQL;

public class PunBB {
	
	public static String Name = "punbb";
	public static String ShortName = "pun";
	public static String VersionRange = "1.3.4-1.3.5";
	public static String LatestVersionRange = VersionRange;
	
	
  public static void adduser(int checkid,String player, String email, String password, String ipAddress) throws SQLException
  {
	if(checkid == 1)
	{
		long timestamp = System.currentTimeMillis()/1000;
		//
		PreparedStatement ps;
		//
		String salt = Encryption.hash(12,"none",33, 126);
		String hash = hash("create",player,password,salt);
		
		ps = MySQL.mysql.prepareStatement("INSERT INTO `"+Config.database_prefix+"users"+"` (`group_id`,`username`,`password`,`salt`,`email`,`registered`,`registration_ip`,`last_visit`)  VALUES (?,?,?,?,?,?,?,?)", 1);
	    ps.setInt(1, 3); //group_id
		ps.setString(2, player); //username
	    ps.setString(3, hash); //password
	    ps.setString(4, salt); //salt
		ps.setString(5, email); //email
		ps.setLong(6, timestamp); //registered
		ps.setString(7, ipAddress); //registration_ip
		ps.setLong(8, timestamp); //last_visit
		///
	    ps.executeUpdate();
	    
	    /*
	    ps = MySQL.mysql.prepareStatement("UPDATE `"+Config.database_prefix+"config"+"` SET `config_value` = '" + userid + "' WHERE `config_name` = 'newest_user_id'");
	    ps.executeUpdate();
	    ps = MySQL.mysql.prepareStatement("UPDATE `"+Config.database_prefix+"config"+"` SET `config_value` = '" + player + "' WHERE `config_name` = 'newest_username'");
	    ps.executeUpdate();
	    ps = MySQL.mysql.prepareStatement("UPDATE `"+Config.database_prefix+"config"+"` SET `config_value` = config_value+1 WHERE `config_name` = 'num_users'");
	    ps.executeUpdate();*/
	}
 }

    public static String hash(String action,String player,String password, String thesalt) throws SQLException {
    	if(action.equals("find"))
    	{
  	try {
  		String salt = MySQL.getfromtable(Config.database_prefix+"users", "`salt`", "username", player);
  		return passwordHash(password, salt);
  	} catch (NoSuchAlgorithmException e) {
  		e.printStackTrace();
  	} catch (UnsupportedEncodingException e) {
  		e.printStackTrace();
  	}
    	}
    	else if(action.equals("create"))
    	{
    		try {
				return passwordHash(password, thesalt);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
  	return "fail";
    }

  	public static boolean check_hash(String passwordhash, String hash)
  	{
  		if(passwordhash.equals(hash)) return true;
  		else return false;
  	}
  	
  	public static String passwordHash(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException
  	{
  		return Encryption.SHA1(salt + Encryption.SHA1(password));
  	}
}