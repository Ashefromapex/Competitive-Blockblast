package com.blockblast.gui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnemySelect extends JPanel
{
    ControllerGUI c;
    TextField ip;

    public EnemySelect()
    {
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        setBackground(Color.BLUE);

        JLabel title = new JLabel("Choose your enemy!");
        title.setFont(new Font("Tahoma",Font.BOLD,40));
        title.setBounds(30, 30, 500, 50);

        JLabel ipLabel = new JLabel("IP:");
        ipLabel.setFont(new Font("Tahoma",Font.BOLD,20));
        ipLabel.setBounds(100, 170, 500, 30);

        ip = new TextField();
        ip.setBounds(100,200,300,50);
        ip.setFont(new Font("Tahoma",Font.BOLD,40));
        ip.setBackground(Color.LIGHT_GRAY);

        JButton IpButton = new JButton("Get your IP by pressing this button:");
        IpButton.setFont(new Font("Tahoma",Font.BOLD,20));
        IpButton.setBounds(0, 370, 500, 30);
        IpButton.setOpaque(false);
        IpButton.setBorderPainted(false);
        IpButton.setContentAreaFilled(false);
        IpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    InetAddress localHost = InetAddress.getLocalHost();
                    System. out. println(localHost. getHostAddress());
                }catch (UnknownHostException ignored){}
            }
        });

        add(title);
        add(ip);
        add(ipLabel);
        add(IpButton);

    }

    public void getIp()
    {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System. out. println(localHost. getHostAddress());
        }catch (UnknownHostException ignored){}
    }
}
