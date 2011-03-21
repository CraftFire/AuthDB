package com.authdb.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Encryption
{  
	
	public static String Encrypt(String encryption,String toencrypt) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		if(encryption.equals("md5")) return md5(toencrypt);
		else if(encryption.equals("sha1")) return SHA1(toencrypt);
		if(Config.debug_enable) Util.Log("info","Could not find encryption method: "+Config.custom_encryption+", using default: md5");
		Config.custom_encryption = "md5";
		return md5(toencrypt);
	}
	
	public static String hash(int length, String charset,int RangeFrom, int RangeTo)
	{
		if(charset.equals("none"))
		{
			String salt = "";
			for (int i = 0; i < length; i++)
			{
				salt += (char)(Util.randomNumber(RangeFrom, RangeTo));
			}
			return salt;
		}
		else
		{
		    Random rand = new Random(System.currentTimeMillis());
		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < length; i++) {
		        int pos = rand.nextInt(charset.length());
		        sb.append(charset.charAt(pos));
		    }
		    return sb.toString();
		}
	}
	
	public static String md5(String data)
	{
		try
		{
			byte[] bytes = data.getBytes("ISO-8859-1");
			MessageDigest md5er = MessageDigest.getInstance("MD5");
			byte[] hash = md5er.digest(bytes);
			return Util.bytes2hex(hash);
		}
		catch (GeneralSecurityException e)
		{
			throw new RuntimeException(e);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  
    { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return Util.convertToHex(sha1hash);
    } 
   
	public static String pack(String hex)
	{
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < hex.length(); i += 2)
		{
			char c1 = hex.charAt(i);
			char c2 = hex.charAt(i + 1);
			char packed = (char) (Util.hexToInt(c1) * 16 + Util.hexToInt(c2));
			buf.append(packed);
		}
		return buf.toString();
	}
}