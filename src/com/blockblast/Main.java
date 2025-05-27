
//declare package
package com.blockblast;
//import files
import com.blockblast.Test.Test;
import com.blockblast.network.Ipconf;
import com.blockblast.controller.controller;
import com.blockblast.storage.Data;

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
