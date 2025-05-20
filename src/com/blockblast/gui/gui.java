package com.blockblast.gui;
import javax.swing.JFrame;

public class gui extends JFrame {


    block block1einser;
    block block2linie2;
    block block3linie3;
    block block4linie4;
    block block5linie5;
    block block6ecke;
    block block72x2;
    block block83x3;
    block block9LBlock;
    block block10squiggles;
    block block11grosseecke;
    block block12TBlock;
    block block132x3;


    public gui()
    {
       this.getContentPane().setLayout(null);
       this.initWindow();
    }
    public void test()
    {
        System.out.println("Hello and welcome fron gui!");
    }
    public void initWindow()
    {
       //Luzia: instanzieren
        block1einser = new block();
        block2linie2 = new block();
        block3linie3 = new block();
        block4linie4 = new block();
        block5linie5 = new block();
        block6ecke = new block();
        block72x2 = new block();
        block83x3 = new block();
        block9LBlock = new block();
        block10squiggles = new block();
        block11grosseecke = new block();
        block12TBlock = new block();
        block132x3 = new block();
        // positionen festlegen, erstmal einer
        //block1einser.setBounds(5,10,4,3);
        this.getContentPane().add(block1einser);

        this.pack();
    }

}
class block
{
  public block()
  {

  }
}