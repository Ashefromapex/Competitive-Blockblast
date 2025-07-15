package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Queue extends JPanel
{
    ControllerGUI c;

    public Queue(ControllerGUI c)
    {
        this.c = c;
        setVisible(true);
        setLayout(null);
        setSize(500, 500);
        setBackground(new Color(16, 25, 74));

        JLabel ip = new JLabel("IP:" + getIp());
        ip.setFont(new Font("Tahoma",Font.BOLD,20));
        ip.setBounds(100, 200, 300, 30);
        ip.setForeground(new Color(255, 255, 255));

        JLabel title = new JLabel("Waiting for other player");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setBounds(100, 100, 300, 30);
        title.setForeground(new Color(255, 255, 255));


        add(ip);
        add(title);
    }

    public String getIp()
    {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost. getHostAddress();
        }catch (UnknownHostException ignored){}
        return "";
    }
}
