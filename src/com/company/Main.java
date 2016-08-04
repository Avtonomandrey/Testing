package com.company;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Андрей on 04.08.2016.
 */
public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new FreeSpaceManagerFrame();
                frame.setTitle("Free space manager");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.pack();
                frame.setResizable(false);
            }
        });
    }
}
