package co.edu.itm.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileIn {

    public String readTxt(String archivo){
        String data="";
        try{
            BufferedReader bf =new BufferedReader(new FileReader((new File("file").getAbsolutePath())+archivo));
            String temp ="";
            String bfReader;
            while((bfReader=bf.readLine())!=null){
                temp += temp+bfReader;
            }
            data=temp;
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
}
