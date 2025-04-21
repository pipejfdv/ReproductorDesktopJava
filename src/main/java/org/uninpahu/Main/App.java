package org.uninpahu.Main;

import org.uninpahu.Vistas.JFrames.JFIndex;


public class App 
{
    public static void main( String[] args )
    {                  
        JFIndex index = new JFIndex();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
        index.setSize(769, 498);
        index.setResizable(false);
    }
}
