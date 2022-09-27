/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Hilos extends Thread {
    JLabel label,label1,label2;
    public int con;
    public int con1;
    public int con2;
    public Hilos(){
        con=270;
        con1=200;
        con2=200;
    }
    @Override
    public void run(){
        while(con>0){
            try{
        
        label.setBounds(0,0,con,700);
        label1.setBounds(20,100,con1,270);
        label2.setBounds(40,380, con2, 80);
        con--;
        con1--; 
        con2--;
            sleep(1);
        }catch(InterruptedException e){
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE,null, e);
        }
        }
    }
    public void recibeLabel(JLabel label, JLabel label1,JLabel label2){
        this.label=label;
        this.label1=label1;
        this.label2=label2;
    }
}
