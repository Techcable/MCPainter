/*
 * The MIT License
 *
 * Copyright 2013 SBPrime.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.PrimeSoft.MCPainter.Commands;

import org.PrimeSoft.MCPainter.Help;
import org.PrimeSoft.MCPainter.PermissionManager;
import org.PrimeSoft.MCPainter.MCPainterMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author SBPrime
 */
public class PurgeCommand {

    public static void Execte(MCPainterMain sender, Player player, String[] args) {
        if (args.length < 1 || args.length > 2) {
            Help.ShowHelp(player, Commands.COMMAND_PURGE);
            return;
        }

        if (args.length == 1) {
            if (!PermissionManager.isAllowed(player, PermissionManager.Perms.Purge_Self)) {
                MCPainterMain.say(player, ChatColor.RED + "You have no permissions to do that.");
                return;
            }

            sender.getBlockPlacer().purge(player.getName());
        } else {
            String arg = args[1];
            if (arg.startsWith("u:")) {
                if (!PermissionManager.isAllowed(player, PermissionManager.Perms.Purge_Other)) {
                    MCPainterMain.say(player, ChatColor.RED + "You have no permissions to do that.");
                    return;
                }

                String user = arg.substring(2);
                sender.getBlockPlacer().purge(user);
            } else {                
                if (!arg.toLowerCase().equalsIgnoreCase("all")) {
                    Help.ShowHelp(player, Commands.COMMAND_PURGE);
                    return;
                }
                
                if (!PermissionManager.isAllowed(player, PermissionManager.Perms.Purge_All)) {
                    MCPainterMain.say(player, ChatColor.RED + "You have no permissions to do that.");
                    return;
                }
                
                sender.getBlockPlacer().purgeAll();
            }
        }
    }
}
