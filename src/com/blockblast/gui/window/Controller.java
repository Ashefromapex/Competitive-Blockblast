package com.blockblast.gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    //Instanzvariable
    private Window window;

    //Erzeugt Fenster
    public void startGui()
    {
        window = new Window(this);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent g)
    {


        String Command = g.getActionCommand();

        //Wort nach Klick auf Button ausgeben
        if(Command.equals("Repeat")) {
            System.out.println("Repeat");
            window.showMessage("Repeat");
        }
        else if(Command.equals("Start"))
        {
            System.out.println("Start");
            window.showMessage("Start");
        }

    }
}
