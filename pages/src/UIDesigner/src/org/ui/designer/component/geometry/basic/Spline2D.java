/*
 * Copyright (c) Ovidiu Serban, ovidiu@roboslang.org
 *               web:http://ovidiu.roboslang.org/
 * All Rights Reserved. Use is subject to license terms.
 *
 * This file is part of AgentSlang Project (http://agent.roboslang.org/).
 *
 * AgentSlang is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3 of the License and CECILL-B.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * The CECILL-B license file should be a part of this project. If not,
 * it could be obtained at  <http://www.cecill.info/>.
 *
 * The usage of this project makes mandatory the authors citation in
 * any scientific publication or technical reports. For websites or
 * research projects the AgentSlang website and logo needs to be linked
 * in a visible area.
 */

package org.ui.designer.component.geometry.basic;
import java.util.Vector;

public class Spline2D extends BasicSpline {
    private Vector<Cubic> xCubics;
    private Vector<Cubic> yCubics;

    public Spline2D() {
        this.xCubics = new Vector<Cubic>();
        this.yCubics = new Vector<Cubic>();
    }

    public void calcSpline() {
        calcNaturalCubic(Point3D.Axis.x, xCubics);
        calcNaturalCubic(Point3D.Axis.y, yCubics);
    }

    public Point3D getPoint(float position) {
        position = position * xCubics.size(); // extrapolate to the arraysize
        int cubicNum = (int) position;
        float cubicPos = (position - cubicNum);

        return new Point3D(xCubics.get(cubicNum).evaluate(cubicPos), yCubics.get(cubicNum).evaluate(cubicPos));
    }
}

