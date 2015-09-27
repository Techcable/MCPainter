/*
 * The MIT License
 *
 * Copyright 2014 SBPrime.
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
package org.PrimeSoft.MCPainter.worldEdit;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.PrimeSoft.MCPainter.MCPainterMain;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author SBPrime
 */
public class WorldEditFactory {

    private static Plugin getWorldEdit(JavaPlugin plugin) {
        try {
            Plugin wPlugin = plugin.getServer().getPluginManager().getPlugin("WorldEdit");

            if ((wPlugin == null) || (!(wPlugin instanceof WorldEditPlugin))) {
                return null;
            }

            return (WorldEditPlugin) wPlugin;
        } catch (NoClassDefFoundError ex) {
            return null;
        }
    }

    public static IWorldEdit getWorldEditWrapper(JavaPlugin plugin) {
        Plugin wePlugin = getWorldEdit(plugin);
        
        if (wePlugin != null) {
            MCPainterMain.log("WorldEdit found - using the \"real thing\".");
            return new WorldEditWrapper(wePlugin);
        }
        
        MCPainterMain.log("WorldEdit not found - using stub wrapper classes.");
        return new StubWrapper();
    }
}
