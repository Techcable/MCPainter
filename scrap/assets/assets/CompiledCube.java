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
import org.PrimeSoft.MCPainter.voxelyzer.Face;
import org.PrimeSoft.MCPainter.voxelyzer.Matrix;
import org.PrimeSoft.MCPainter.voxelyzer.Vertex;
import org.bukkit.entity.Player;

/**
 *
 * @author SBPrime
 */
public class CompiledCube {

    private final Vertex[] m_vertex;
    private final Face[] m_faces;

    public CompiledCube(Vertex[] modelVertex, Face[] modelFace) {
        m_vertex = modelVertex;
        m_faces = modelFace;
    }

    public void render(Vector origin, Player player,
            BlockLoger loger, IColorMap colorMap, ClippingRegion clipping,
            Matrix matrix)
            throws MaxChangedBlocksException {
        for (Face face : m_faces) {
            face.render(origin, loger, colorMap, matrix, clipping, m_vertex);
        }
    }
}
