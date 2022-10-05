/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.*;
public class ButtonUpdateDAO implements ActionListener {
    Vista1 vista;
    public     Actualizar act;
    public ButtonUpdateDAO(Actualizar act,Vista1 vis){
        this.act = act;
        this.vista=vis;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     
      if(e.getSource()==act.bActualizar){
            String nom= act.tfNombre.getText();
            int id= act.id;
            String cedula=act.tfcedula.getText();
            int edad=Integer.parseInt(act.tfedad.getText());
             String fo=act.Salida;
            DAOPersona u=new DAOPersona();
            u.Editar(id,nom,cedula,edad,fo);
            JOptionPane.showMessageDialog(null, "Actualización de datos Exitosa");
         
            
        }
    }
}

