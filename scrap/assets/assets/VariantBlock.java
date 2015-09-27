/*
 * The MIT License
 *
 * Copyright 2015 SBPrime.
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
package org.PrimeSoft.MCPainter.mods.assets;

import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import org.PrimeSoft.MCPainter.Drawing.IColorMap;
import org.PrimeSoft.MCPainter.blocksplacer.BlockLoger;
import org.PrimeSoft.MCPainter.voxelyzer.ClippingRegion;
import org.PrimeSoft.MCPainter.voxelyzer.Matrix;
import org.bukkit.entity.Player;

/**
 *
 * @author SBPrime
 */
public class VariantBlock {

    private final CompiledModel m_model;
    private final boolean m_uvLock;
    private final Matrix m_rotMatrix;

    public VariantBlock(CompiledModel model, boolean uvLock, double rotX, double rotY) {
        Matrix matrix = Matrix.getIdentity();
        matrix.rotateX(Math.PI / 180 * rotX);
        matrix.rotateY(Math.PI / 180 * rotY);

        m_rotMatrix = matrix;
        m_model = model;
        m_uvLock = uvLock;    
    }

    public void render(Vector origin, Player player,
            BlockLoger loger, IColorMap colorMap, ClippingRegion clipping)
            throws MaxChangedBlocksException {

        //TODO: Implement uvLock
        m_model.render(origin, player, loger, colorMap, clipping, m_rotMatrix);
    }

}
