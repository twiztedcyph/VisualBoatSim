package com.twizted;

import com.twizted.Frames.MapFrame;
import com.twizted.Frames.OutputFrame;

import javax.swing.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("user.dir", "C:\\Program Files (x86)\\ArcGIS SDKs\\java10.2.4\\");

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    MapFrame mapFrame = new MapFrame();
                    mapFrame.setVisible(true);
                    mapFrame.startTimer();

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
