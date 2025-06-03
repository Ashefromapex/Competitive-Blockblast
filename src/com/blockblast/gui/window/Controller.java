package com.blockblast.gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    //Instanzvariable
    private Window window;

    @Override
    public void actionPerformed(ActionEvent e)
    {


        String Command = e.getActionCommand();

        //Wort nach Klick auf Button ausgeben
        if(Command.equals("Start"))
            System.out.println("Start");

        else if(Command.equals("Close"))
            System.out.println("Close");


    }
}
