/*
 * Copyright (C) 2006 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */
package com.datazuul.apps.bsaf.singleframeexample3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.jdesktop.application.Application.ExitListener;
import org.jdesktop.application.SingleFrameApplication;

/**
 * A SingleFrameApplication example with an exitListener.
 *
 * @author Hans Muller (Hans.Muller@Sun.COM)
 */
public class App extends SingleFrameApplication {

    @Override
    protected void startup() {
        ExitListener maybeExit = new ExitListener() {
            public boolean canExit(EventObject e) {
                Object source = (e != null) ? e.getSource() : null;
                Component owner = (source instanceof Component) ? (Component) source : null;
                int option = JOptionPane.showConfirmDialog(owner, "Really Exit?");
                return option == JOptionPane.YES_OPTION;
            }

            public void willExit(EventObject e) {
            }
        };
        addExitListener(maybeExit);
        JButton button = new JButton();
        button.setName("button");
        button.setAction(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        show(button);
    }

    public static void main(String[] args) {
        launch(App.class, args);
    }
}
