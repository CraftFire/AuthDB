/**          (C) Copyright 2011 Contex <contexmoh@gmail.com>
	
	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/
package com.authdb.scripts.forum;

  import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;
import java.util.Arrays;

import com.authdb.util.Config;
import com.authdb.util.Encryption;
import com.authdb.util.Util;
import com.authdb.util.databases.MySQL;


  public class myBB {
  	
    public static void adduser(int checkid, String player, String email, String password, String ipAddress) throws SQLException
    {
		if(checkid == 1)
	    {
	long timestamp = System.currentTimeMillis()/1000;
	String salt = Encryption.hash(8,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",0,0);
	String hash = hash("create",player,password, salt);
	//
	PreparedStatement ps;
	//
	ps = MySQL.mysql.prepareStatement("INSERT INTO `"+Config.database_prefix+"users"+"` (`username`,`password`,`salt`,`email`,`regdate`,`lastactive`,`lastvisit`,`regip`,`longregip`,`signature`,`buddylist`,`ignorelist`,`pmfolders`,`notepad`,`usernotes`,`usergroup`)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 1);
	ps.setString(1, player); //username
	ps.setString(2, hash); // password
	ps.setString(3, salt); //salt
	ps.setString(4, email); //email
	ps.setLong(5, timestamp); //regdate
	ps.setLong(6, timestamp); //lastactive
	ps.setLong(7, timestamp); //lastvisit
	ps.setString(8, ipAddress); //regip
	ps.setLong(9, Util.IP2Long(ipAddress));
	//need to add these, it's complaining about not default is set.
	ps.setString(10, ""); //signature
	ps.setString(11, ""); //buddylist
	ps.setString(12, ""); //ignorelist
	ps.setString(13, ""); //pmfolders
	ps.setString(14, ""); //notepad
	ps.setString(15, ""); //usernotes
	ps.setString(16, "5");//usergroup
	ps.executeUpdate();
	 
    int userid = MySQL.countitall(Config.database_prefix+"user");
    String oldcache =  MySQL.getfromtable(Config.database_prefix+"datastore", "`data`", "title", "userstats");
    String newcache = Util.ForumCache(oldcache, player, userid, "numusers", null, "lastusername", "lastuid");
    ps = MySQL.mysql.prepareStatement("UPDATE `"+Config.database_prefix+"datacache"+"` SET `cache` = '" + newcache + "' WHERE `title` = 'stats'");
    ps.executeUpdate();
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
  	return Encryption.md5(Encryption.md5(salt) + Encryption.md5(password));
  	}
}