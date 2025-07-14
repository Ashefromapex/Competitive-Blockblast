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
    public boolean host;
    public boolean join;
    JButton joinButton;

    public EnemySelect()
    {
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        setBackground(new Color(16, 25, 74));

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

        JButton hostButton = new JButton("Host Game");
        hostButton.setFont(new Font("Tahoma",Font.BOLD,20));
        hostButton.setBounds(75, 300, 150, 30);
        hostButton.setBackground(Color.WHITE);
        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean hosty = host;
                if(hosty)
                {
                    host = false;
                    hostButton.setBackground(Color.WHITE);
                }
                if(!hosty)
                {
                    host = true;
                    hostButton.setBackground(Color.GREEN);
                    if(join)
                    {
                        join = false;
                        joinButton.setBackground(Color.WHITE);
                    }
                }
            }
        });

        joinButton = new JButton("Join Game");
        joinButton.setFont(new Font("Tahoma",Font.BOLD,20));
        joinButton.setBounds(275, 300, 150, 30);
        joinButton.setBackground(Color.WHITE);
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean joiny = join;
                if(joiny)
                {
                    join = false;
                    joinButton.setBackground(Color.WHITE);
                }
                if(!joiny)
                {
                    join = true;
                    joinButton.setBackground(Color.GREEN);
                    if(host)
                    {
                        host = false;
                        hostButton.setBackground(Color.WHITE);
                    }
                }
            }
        });

        add(title);
        add(ip);
        add(ipLabel);
        add(IpButton);
        add(hostButton);
        add(joinButton);

    }

    public void getIp()
    {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System. out. println(localHost. getHostAddress());
        }catch (UnknownHostException ignored){}
    }
}
