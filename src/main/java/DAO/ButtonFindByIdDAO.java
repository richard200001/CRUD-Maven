/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Persona;
import View.Consultar;

import View.Vista1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ButtonFindByIdDAO implements ActionListener {
    Vista1 vista1;
    public Consultar con;
    DAOPersona u;
    Persona p;
    public ButtonFindByIdDAO(Consultar con,Vista1 vista1, DAOPersona u){
        this.con = con;
        this.vista1=vista1;
        this.u=u;
        con.bConsultar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        vista1.modelo.setRowCount(0);
      if(e.getSource()==con.bConsultar){
          try{
            
            int id=Integer.parseInt(con.tfid.getText());
            u=new DAOPersona();
            p = u.BuscarId(id);
            ImageIcon perfil = u.Deodificar_Imagen(p.getFoto(), 65);
            vista1.modelo.addRow(p.toArray());
            vista1.modelo.setValueAt(new JLabel(perfil), 0, 4);
            con.ldato.setText("");
          }catch(Exception ex){
           con.ldato.setText("Ese id no existe");
          }   
        }
    }
}

