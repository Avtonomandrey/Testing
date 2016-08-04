package com.company;

import ru.eleron.FreeSpaceEvent;
import ru.eleron.FreeSpaceEventListenerIF;
import ru.eleron.FreeSpaceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FreeSpaceManagerFrame extends JFrame {


    FreeSpaceManagerFrame(){

        // Инициализация фрейма
        JPanel mainPanel = new JPanel();
        DefaultListModel detailsListModel = new DefaultListModel();
        JList detailsList = new JList(detailsListModel);
        detailsList.setPreferredSize(new Dimension(800,400));
        detailsList.setLayoutOrientation(JList.VERTICAL);
        mainPanel.add(detailsList);
        JButton shawFileStoresButton = new JButton(" Shaw file stores");
        shawFileStoresButton.setPreferredSize(new Dimension(200,400));
        mainPanel.add(shawFileStoresButton);
        JButton stopButton = new JButton("Stop Sheduled executor");
        stopButton.setPreferredSize(new Dimension(200, 400));
        mainPanel.add(stopButton);
        getContentPane().add(mainPanel);

        // Инициализация и создание объекта типа FreeSpaceManager
        FreeSpaceEventListenerIF freeSpaceEventListener = new FreeSpaceEventListenerIF() {
            @Override
            public void notifyThatAvailableSpaceIsLess(FreeSpaceEvent freeSpaceEvent) {
                detailsListModel.addElement(freeSpaceEvent.getMessage());
            }
        };
        long a = 999999999999L;
        FreeSpaceManager manager = new FreeSpaceManager(a, freeSpaceEventListener);

        shawFileStoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    detailsListModel.clear();
                    for (Object details : manager.getFileStoresDetails()) {
                        detailsListModel.addElement(details.toString());
                    }
                    revalidate();
                }
                catch (IOException ioe){
                    ioe.getMessage();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.stop();
            }
        });

    }

}