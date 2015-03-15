/*
 * Copyright (C) 2006 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */
package com.datazuul.apps.bsaf.singleframeexample2;

import javax.swing.JLabel;

import org.jdesktop.application.SingleFrameApplication;

/**
 * @author Hans Muller (Hans.Muller@Sun.COM)
 */
public class App extends SingleFrameApplication {

    @Override
    protected void startup() {
        JLabel label = new JLabel();
        label.setName("label");
        show(label);
    }

    public static void main(String[] args) {
        launch(App.class, args);
    }
}
