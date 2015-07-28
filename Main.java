package com.twizted;

import com.twizted.Frames.InputPanel;
import com.twizted.Frames.MapFrame;

import javax.swing.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("user.dir", "C:\\Program Files (x86)\\ArcGIS SDKs\\java10.2.4\\");

        JOptionPane.showConfirmDialog(null,
                                      new InputPanel(),
                                      "Journey section details",
                                      JOptionPane.OK_CANCEL_OPTION,
                                      JOptionPane.PLAIN_MESSAGE);

//        SwingUtilities.invokeLater(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                try
//                {
//                    MapFrame mapFrame = new MapFrame();
//                    mapFrame.setVisible(true);
//                    mapFrame.startTimer();
//
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
