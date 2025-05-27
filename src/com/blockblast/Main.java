
//declare package
package com.blockblast;
//import files
import com.blockblast.Test.Test;
import com.blockblast.network.Ip;
import com.blockblast.storage.Data;
import com.blockblast.controller.controller;

public class Main
{
    public static void main(String[] args) {
        //DONT TOUCH

        //test project at startup
        boolean testatstartup = true;
        if(testatstartup)
        {
            System.out.println("Testing!");
            Test test = new Test();
            test.testAll();
        }

    }

}
