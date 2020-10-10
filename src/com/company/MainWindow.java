package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawPanel();
        this.add(panel);
    }

}
