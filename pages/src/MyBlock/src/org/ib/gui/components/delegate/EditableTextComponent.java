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

package org.ib.gui.components.delegate;

import org.ib.gui.data.DataProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ovidiu Serban, ovidiu@roboslang.org
 * @version 1, 1/17/13
 */
public class EditableTextComponent extends EditableComponent implements ActionListener {
    private JTextField component;

    public EditableTextComponent(int columns) {
        super(columns);
    }

    protected void initComponent(int columns) {
        component = new JTextField(columns);
    }

    protected void initLayout() {
        setLayout(new BorderLayout());
        add(component, BorderLayout.CENTER);
    }

    protected void initActions() {
        component.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        fireActionListeners(e);
    }

    public void setText(String text) {
        component.setText(text);
    }

    public String getText() {
        return component.getText();
    }

    public void subscribeToDataProvider(DataProvider provider) {
        //-- ignore
    }
}
