/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.*;
public class ButtonInsertDAO implements ActionListener {
    public     Insertar in;
    public ButtonInsertDAO(Insertar in){
        this.in = in;
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     
      if(e.getSource()==in.bInsertar){
                String no= in.tfName.getText();
                String ce=in.tfcedula.getText();
                int ed=Integer.parseInt(in.tfedad.getText());
                String fo=in.Salida;
                DAOPersona obj = new DAOPersona();
                obj.Crear(no,ce,ed,fo);
                JOptionPane.showMessageDialog(null, "Inserción de datos Exitosa");   
        }
    }
}