/*
 * This file is part of AuthDB.
 *
 * Copyright (c) 2011 CraftFire <http://www.craftfire.com/>
 * AuthDB is licensed under the GNU Lesser General Public License.
 *
 * AuthDB is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AuthDB is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.craftfire.authdb.scripts.social;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.craftfire.authdb.util.Config;
import com.craftfire.authdb.util.encryption.Encryption;
import com.craftfire.authdb.util.Util;
import com.craftfire.authdb.util.databases.MySQL;
import com.craftfire.authdb.util.databases.EBean;

public class Oxwall {
    public static String Name = "oxwall";
    public static String ShortName = "ow";
    public static String VersionRange = "1.4.0-1.4.1";
    public static String LatestVersionRange = VersionRange;

    public static void adduser(int checkid, String player, String email, String password, String ipAddress) throws SQLException {
        if (checkid == 1) {
            long timestamp = MySQL.getUnixTimestamp();
            String hash = hash(password);
            PreparedStatement ps;
            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_user" + "` (`email`, `username`, `password`, `joinStamp`, `activityStamp`, `accountType`, `emailVerify`, `joinIp`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)", 1);
            ps.setString(1, email); // email
            ps.setString(2, player); // username
            ps.setString(3, hash); // password
            ps.setLong(4, timestamp); // joinStamp
            ps.setLong(5, timestamp); // activityStamp
            ps.setString(6, "290365aadde35a97f11207ca7e4279cc"); // accountType
            ps.setInt(7, 1); // emailVerify
            ps.setLong(8, Util.ip2Long(ipAddress)); // joinIp
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            int userid = MySQL.countitall(Config.script_tableprefix + "base_user");

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`)  VALUES (?, ?)", 1);
            ps.setString(1, "relationship"); // questionName
            ps.setInt(2, userid); // userId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`)  VALUES (?, ?)", 1);
            ps.setString(1, "9221d78a4201eac23c972e1d4aa2cee6"); // questionName
            ps.setInt(2, userid); // userId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`)  VALUES (?, ?)", 1);
            ps.setString(1, "c441a8a9b955647cdf4c81562d39068a"); // questionName
            ps.setInt(2, userid); // userId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`, `textValue`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "realname"); // questionName
            ps.setInt(2, userid); // userId
            ps.setString(3, player); // textValue
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`, `intValue`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "sex"); // questionName
            ps.setInt(2, userid); // userId
            ps.setInt(3, 1); // intValue
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`)  VALUES (?, ?)", 1);
            ps.setString(1, "match_sex"); // questionName
            ps.setInt(2, userid); // userId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_question_data" + "` (`questionName`, `userId`, `dateValue`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "birthdate"); // questionName
            ps.setInt(2, userid); // userId
            ps.setString(3, "1970-01-01 00:00:00"); // dateValue
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_authorization_user_role" + "` (`userId`, `roleId`)  VALUES (?, ?)", 1);
            ps.setInt(1, userid); // userId
            ps.setInt(2, 12); // roleId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_preference_data" + "` (`key`, `userId`, `value`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "newsfeed_generate_action_set_timestamp"); // key
            ps.setInt(2, userid); // userId
            ps.setInt(3, 0); // value
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "base_preference_data" + "` (`key`, `userId`, `value`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "send_wellcome_letter"); // key
            ps.setInt(2, userid); // userId
            ps.setInt(3, 1); // value
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            int entityId = MySQL.getLastID(Config.script_tableprefix + "newsfeed_action", "`entityType` = 'user_join'", "entityId") + 1;

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "newsfeed_action" + "` (`entityId`, `entityType`, `pluginKey`, `data`)  VALUES (?, ?, ?, ?)", 1);
            ps.setInt(1, entityId); // entityId
            ps.setString(2, "user_join"); // entityType
            ps.setString(3, "base"); // pluginKey
            ps.setString(4, "{\"string\":\"joined our site!\",\"view\":{\"iconClass\":\"ow_ic_user\"},\"actionDto\":null}"); // data
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "newsfeed_activity" + "` (`activityType`, `activityId`, `userId`, `data`, `actionId`, `timeStamp`, `privacy`, `visibility`, `status`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 1);
            ps.setString(1, "create"); // activityType
            ps.setInt(2, entityId); // activityId
            ps.setInt(3, userid); // userId
            ps.setString(4, "[]"); // data
            ps.setInt(5, entityId); // actionId
            ps.setLong(6, timestamp); // timeStamp
            ps.setString(7, "everybody"); // privacy
            ps.setInt(8, 15); // visibility
            ps.setString(9, "active"); // status
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            int activityId = MySQL.countitall(Config.script_tableprefix + "newsfeed_activity");

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "newsfeed_activity" + "` (`activityType`, `activityId`, `userId`, `data`, `actionId`, `timeStamp`, `privacy`, `visibility`, `status`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 1);
            ps.setString(1, "subscribe"); // activityType
            ps.setInt(2, entityId); // activityId
            ps.setInt(3, userid); // userId
            ps.setString(4, "[]"); // data
            ps.setInt(5, entityId); // actionId
            ps.setLong(6, timestamp); // timeStamp
            ps.setString(7, "everybody"); // privacy
            ps.setInt(8, 15); // visibility
            ps.setString(9, "active"); // status
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();

            ps = MySQL.mysql.prepareStatement("INSERT INTO `" + Config.script_tableprefix + "newsfeed_action_feed" + "` (`feedType`, `feedId`, `activityId`)  VALUES (?, ?, ?)", 1);
            ps.setString(1, "user"); // feedType
            ps.setInt(2, entityId); // feedId
            ps.setInt(3, activityId); // activityId
            Util.logging.mySQL(ps.toString());
            ps.executeUpdate();
            ps.close();
        }
    }

    public static String hash(String password) throws SQLException {
        try {
            return passwordHash(password, Config.script_passwordsalt);
        } catch (NoSuchAlgorithmException e) {
            Util.logging.StackTrace(e.getStackTrace(), Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getFileName());
        } catch (UnsupportedEncodingException e) {
            Util.logging.StackTrace(e.getStackTrace(), Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getFileName());
        }
        return "fail";
    }

    public static boolean check_hash(String passwordhash, String hash) {
        if (passwordhash.equals(hash)) {
            return true;
        } else {
            return false;
        }
    }

    public static String passwordHash(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return Encryption.SHA256(salt + password);
    }
}
