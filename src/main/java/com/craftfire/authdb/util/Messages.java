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
package com.craftfire.authdb.util;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.craftfire.authdb.AuthDB;

public class Messages {
///////////////////////////////////////////
//  messages
///////////////////////////////////////////

    ///////////////////////////////////////////
    //               AuthDB
    ///////////////////////////////////////////
        public static String time_millisecond, time_milliseconds, time_second, time_seconds, time_minute, time_minutes, time_hour, time_hours, time_day, time_days;
        ///////////////////////////////////////////
        //               database
        ///////////////////////////////////////////
        public static String AuthDB_message_database_failure;

        ///////////////////////////////////////////
        //               reload
        ///////////////////////////////////////////
        public static String AuthDB_message_reload_success;

        ///////////////////////////////////////////
        //               join
        ///////////////////////////////////////////
        public static String AuthDB_message_join_restrict;

        ///////////////////////////////////////////
        //               register
        ///////////////////////////////////////////
        public static String AuthDB_message_register_welcome, AuthDB_message_register_success, AuthDB_message_register_failure, AuthDB_message_register_offline, AuthDB_message_register_exists, AuthDB_message_register_disabled, AuthDB_message_register_usage, AuthDB_message_register_timeout, AuthDB_message_register_processing, AuthDB_message_register_limit;

        ///////////////////////////////////////////
        //               unregister
        ///////////////////////////////////////////
        public static String AuthDB_message_unregister_success, AuthDB_message_unregister_failure, AuthDB_message_unregister_usage;

        ///////////////////////////////////////////
        //               logout
        ///////////////////////////////////////////
        public static String AuthDB_message_logout_success, AuthDB_message_logout_failure, AuthDB_message_logout_admin, AuthDB_message_logout_admin_success, AuthDB_message_logout_admin_failure, AuthDB_message_logout_admin_notfound, AuthDB_message_logout_usage, AuthDB_message_logout_processing;

        ///////////////////////////////////////////
        //               login
        ///////////////////////////////////////////
        public static String AuthDB_message_login_normal, AuthDB_message_login_prompt, AuthDB_message_login_success, AuthDB_message_login_failure, AuthDB_message_login_offline, AuthDB_message_login_authorized, AuthDB_message_login_notregistered, AuthDB_message_login_timeout, AuthDB_message_login_admin, AuthDB_message_login_admin_success, AuthDB_message_login_admin_failure, AuthDB_message_login_admin_notfound, AuthDB_message_login_usage, AuthDB_message_login_processing;

        ///////////////////////////////////////////
        //               link
        ///////////////////////////////////////////
        public static String AuthDB_message_link_welcome, AuthDB_message_link_success, AuthDB_message_link_failure, AuthDB_message_link_exists, AuthDB_message_link_usage, AuthDB_message_link_duplicate, AuthDB_message_link_registered, AuthDB_message_link_invaliduser, AuthDB_message_link_renamed, AuthDB_message_link_processing;

        ///////////////////////////////////////////
        //               unlink
        ///////////////////////////////////////////
        public static String AuthDB_message_unlink_success, AuthDB_message_unlink_failure, AuthDB_message_unlink_nonexist, AuthDB_message_unlink_usage, AuthDB_message_unlink_invaliduser, AuthDB_message_unlink_invalidpass, AuthDB_message_unlink_renamed, AuthDB_message_unlink_processing;

        ///////////////////////////////////////////
        //               email
        ///////////////////////////////////////////
        public static String AuthDB_message_email_required, AuthDB_message_email_invalid, AuthDB_message_email_badcharacters;

        ///////////////////////////////////////////
        //               filter
        ///////////////////////////////////////////
        public static String AuthDB_message_filter_renamed, AuthDB_message_filter_username, AuthDB_message_filter_password, AuthDB_message_filter_whitelist;

        ///////////////////////////////////////////
        //               username
        ///////////////////////////////////////////
        public static String AuthDB_message_username_minimum, AuthDB_message_username_maximum;

        ///////////////////////////////////////////
        //               password
        ///////////////////////////////////////////
        public static String AuthDB_message_password_minimum, AuthDB_message_password_maximum, AuthDB_message_password_success, AuthDB_message_password_failure, AuthDB_message_password_notregistered, AuthDB_message_password_usage;

        ///////////////////////////////////////////
        //               session
        ///////////////////////////////////////////
        public static String AuthDB_message_session_valid, AuthDB_message_session_protected;

        ///////////////////////////////////////////
        //               protection
        ///////////////////////////////////////////
        public static String AuthDB_message_protection_denied, AuthDB_message_protection_notauthorized;

    public enum Message {
        database_failure (AuthDB_message_database_failure),
        reload_success (AuthDB_message_reload_success),
        register_welcome (AuthDB_message_register_welcome),
        register_success (AuthDB_message_register_success),
        register_failure (AuthDB_message_register_failure),
        register_offline (AuthDB_message_register_offline),
        register_exists (AuthDB_message_register_exists),
        register_disabled (AuthDB_message_register_disabled),
        register_timeout (AuthDB_message_register_timeout),
        register_usage (AuthDB_message_register_usage),
        register_processing (AuthDB_message_register_processing),
        register_limit (AuthDB_message_register_limit),
        join_restrict (AuthDB_message_join_restrict),
        unregister_success (AuthDB_message_unregister_success),
        unregister_failure (AuthDB_message_unregister_failure),
        unregister_usage (AuthDB_message_unregister_usage),
        login_normal (AuthDB_message_login_normal),
        login_prompt (AuthDB_message_login_prompt),
        login_success (AuthDB_message_login_success),
        login_failure (AuthDB_message_login_failure),
        login_offline (AuthDB_message_login_offline),
        login_authorized (AuthDB_message_login_authorized),
        login_notregistered (AuthDB_message_login_notregistered),
        login_timeout (AuthDB_message_login_timeout),
        login_admin (AuthDB_message_login_admin),
        login_admin_success (AuthDB_message_login_admin_success),
        login_admin_failure (AuthDB_message_login_admin_failure),
        login_admin_notfound (AuthDB_message_login_admin_notfound),
        login_usage (AuthDB_message_login_usage),
        login_processing (AuthDB_message_login_processing),
        logout_success (AuthDB_message_logout_success),
        logout_failure (AuthDB_message_logout_failure),
        logout_admin (AuthDB_message_logout_admin),
        logout_admin_success (AuthDB_message_logout_admin_success),
        logout_admin_failure (AuthDB_message_logout_admin_failure),
        logout_admin_notfound (AuthDB_message_logout_admin_notfound),
        logout_usage (AuthDB_message_logout_usage),
        logout_processing (AuthDB_message_logout_processing),
        link_welcome (AuthDB_message_link_welcome),
        link_success (AuthDB_message_link_success),
        link_failure (AuthDB_message_link_failure),
        link_exists (AuthDB_message_link_exists),
        link_duplicate (AuthDB_message_link_duplicate),
        link_registered (AuthDB_message_link_registered),
        link_invaliduser (AuthDB_message_link_invaliduser),
        link_renamed (AuthDB_message_link_renamed),
        link_usage (AuthDB_message_link_usage),
        link_processing (AuthDB_message_link_processing),
        unlink_success (AuthDB_message_unlink_success),
        unlink_failure (AuthDB_message_unlink_failure),
        unlink_nonexist (AuthDB_message_unlink_nonexist),
        unlink_invaliduser (AuthDB_message_unlink_invaliduser),
        unlink_invalidpass (AuthDB_message_unlink_invalidpass),
        unlink_renamed (AuthDB_message_unlink_renamed),
        unlink_usage (AuthDB_message_unlink_usage),
        unlink_processing (AuthDB_message_unlink_processing),
        email_required (AuthDB_message_email_required),
        email_invalid (AuthDB_message_email_invalid),
        email_badcharacters (AuthDB_message_email_badcharacters),
        filter_renamed (AuthDB_message_filter_renamed),
        filter_username (AuthDB_message_filter_username),
        filter_password (AuthDB_message_filter_password),
        filter_whitelist (AuthDB_message_filter_whitelist),
        username_minimum (AuthDB_message_username_minimum),
        username_maximum (AuthDB_message_username_maximum),
        password_minimum (AuthDB_message_password_minimum),
        password_maximum (AuthDB_message_password_maximum),
        password_success (AuthDB_message_password_success),
        password_failure (AuthDB_message_password_failure),
        password_notregistered (AuthDB_message_password_notregistered),
        password_usage (AuthDB_message_password_usage),
        session_valid (AuthDB_message_session_valid),
        session_protected (AuthDB_message_session_protected),
        protection_denied (AuthDB_message_protection_denied),
        protection_notauthorized (AuthDB_message_protection_notauthorized),
        left_server ("fake"),
        kickPlayerIdleLoginMessage ("fake"),
        OnEnable ("fake"),
        OnDisable ("fake");
        public String text;

        Message(String text) {
            this.text = text;
        }
    }

    public static void sendMessage(final Message type, final Player player, PlayerLoginEvent event, String extra) {
        long start = Util.timeMS();
        if (type.equals(Message.login_admin_success)) {
            String message = AuthDB_message_login_admin_success;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        } else if (type.equals(Message.login_admin_failure)) {
            String message = AuthDB_message_login_admin_failure;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        } else if (type.equals(Message.login_admin_notfound)) {
            String message = AuthDB_message_login_admin_success;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        } else if (type.equals(Message.logout_admin_success)) {
            String message = AuthDB_message_logout_admin_success;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        } else if (type.equals(Message.logout_admin_failure)) {
            String message = AuthDB_message_logout_admin_failure;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        } else if (type.equals(Message.logout_admin_notfound)) {
            String message = AuthDB_message_logout_admin_notfound;
            message = message.replaceAll("\\{PLAYER\\}", extra);
            player.sendMessage(Util.replaceStrings(message, player, null));
        }
        long stop = Util.timeMS();
        Util.logging.timeUsage(stop - start, "send a message");
    }

    public static void sendMessage(final Message type, final Player player, PlayerLoginEvent event) {
        long start = Util.timeMS();
        if (type.equals(Message.database_failure)) {
            AuthDB.server.broadcastMessage(Util.replaceStrings(AuthDB_message_database_failure, null, null));
        } else if (Config.database_ison) {
            if (type.equals(Message.register_welcome)) {
                if (Config.authdb_enabled) {
                    if (Config.link_enabled) {
                        player.sendMessage(Util.replaceStrings(AuthDB_message_register_welcome + " " + AuthDB_message_link_welcome, player, null));
                    } else {
                        player.sendMessage(Util.replaceStrings(AuthDB_message_register_welcome, player, null));
                    }
                } else {
                    player.sendMessage(Util.replaceStrings(AuthDB_message_register_offline, player, null));
                }
            } else if (type.equals(Message.login_success)) {
                AuthDB.AuthDB_PasswordTries.put(player.getName(), "0");
                player.sendMessage(Util.replaceStrings(AuthDB_message_login_success, player, null));
            } else if (type.equals(Message.login_failure)) {
                String temp = "0";
                if (AuthDB.AuthDB_PasswordTries.containsKey(player.getName())) {
                    temp = AuthDB.AuthDB_PasswordTries.get(player.getName());
                }
                int tries = Integer.parseInt(temp) + 1;
                    if (tries > Integer.parseInt(Config.login_tries) && Config.login_action.equalsIgnoreCase("kick")) {
                        player.kickPlayer(Util.replaceStrings(AuthDB_message_login_failure, player, null));
                        AuthDB.AuthDB_PasswordTries.put(player.getName(), "0");
                    } else {
                        AuthDB.AuthDB_PasswordTries.put(player.getName(), "" + tries);
                        player.sendMessage(Util.replaceStrings(AuthDB_message_login_failure, player, null));
                    }
            } else if (type.equals(Message.link_renamed)) {
                player.getServer().broadcastMessage(Util.replaceStrings(AuthDB_message_link_renamed, player, null));
            } else if (type.equals(Message.filter_username)) {
                Config.has_badcharacters = true;
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Util.replaceStrings(AuthDB_message_filter_username, player, null));
                Config.has_badcharacters = false;
            } else if (type.equals(Message.filter_password)) {
                if (Config.filter_action.equalsIgnoreCase("kick")) {
                    player.kickPlayer(Util.replaceStrings(AuthDB_message_filter_password, player, null));
                } else {
                    player.sendMessage(Util.replaceStrings(AuthDB_message_filter_password, player, null));
                }
            } else if (type.equals(Message.username_minimum)) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Util.replaceStrings(AuthDB_message_username_minimum, player, null));
            } else if (type.equals(Message.username_maximum)) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Util.replaceStrings(AuthDB_message_username_maximum, player, null));
            } else if (type.equals(Message.session_valid)) {
                player.sendMessage(Util.replaceStrings(AuthDB_message_session_valid, player, null));
            } else if (type.equals(Message.session_protected)) {
                event.disallow(Result.KICK_OTHER, Util.replaceStrings(AuthDB_message_session_protected, player, "login"));
            } else if (type.equals(Message.join_restrict)) {
                event.disallow(Result.KICK_OTHER, Util.replaceStrings(AuthDB_message_join_restrict, player, "login"));
            } else if (type.equals(Message.login_timeout)) {
                player.kickPlayer(Util.replaceStrings(AuthDB_message_login_timeout, player, null));
            } else if (type.equals(Message.register_timeout)) {
                player.kickPlayer(Util.replaceStrings(AuthDB_message_register_timeout, player, null));
            } else {
                player.sendMessage(Util.replaceStrings(type.text, player, null));
            }
        } else {
            Messages.sendMessage(Message.database_failure, null, null);
        }

        long stop = Util.timeMS();
        Util.logging.timeUsage(stop - start, "send a message");
    }
}
