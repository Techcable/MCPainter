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
package org.PrimeSoft.MCPainter.MC3D;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;

/**
 * This class represents a 3D vertex
 * @author SBPrime
 */
public class DoubleVertex extends Vertex<Double> {    
    /**
     * Create a new instance of the class
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     * @param u u texture coordinate
     * @param v v texture coordinate
     */
    public DoubleVertex(double x, double y, double z, double  u, double  v) {
        super(x, y, z, u, v);
    }
    
    
    /**
     * Create a new instance of the class based on another vertice
     * @param v source vertice
     */
    public DoubleVertex(DoubleVertex v)
    {
        super(v.getX(), v.getY(), v.getZ(), v.getU(), v.getV());
    }
    
    /**
     * Apply matrix transformation to vertice
     * @param matrix the tranfsormation matrix
     * @return transformed vertex
     */
    public DoubleVertex transform(Matrix matrix) {
        final double[][] m = matrix.getM();

        final double[] l0 = m[0];
        final double[] l1 = m[1];
        final double[] l2 = m[2];

        double x = l0[0] * m_x + l0[1] * m_y + l0[2] * m_z + l0[3];
        double y = l1[0] * m_x + l1[1] * m_y + l1[2] * m_z + l1[3];
        double z = l2[0] * m_x + l2[1] * m_y + l2[2] * m_z + l2[3];
        
        return new DoubleVertex((int)x, (int)y, (int)z, m_u, m_v);
    }

    Vector getVector() {
        return new BlockVector(m_x, m_y, m_z);
    }
    
    
    /**
     * Convert vertice to array
     * @return 
     */
    double[] getArray()
    {
        return new double[]{m_x, m_y, m_z, m_u, m_v};
    }
}
