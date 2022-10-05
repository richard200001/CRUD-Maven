/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.*;
import Entity.*;
import clases.IconCellRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class PrincipalWindowDAO implements ActionListener {
    Vista1 vista;
    DAOPersona obj;
  
    public PrincipalWindowDAO(Vista1 vista,DAOPersona obj){
        this.vista = vista;
        this.obj=obj;
        vista.boton.addActionListener(this);
        vista.botonbor.addActionListener(this);
        vista.botoncon.addActionListener(this);
        vista.botoninsert.addActionListener(this);
        vista.botonborrar.addActionListener(this);
        vista.botonbuscarid.addActionListener(this);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==vista.botoncon){
            List <Persona> lista = new ArrayList();
                
            lista=obj.DevolverTodos();   
            vista.modelo.setRowCount(0);
          int i=0;
           for(Persona h:lista){
               ImageIcon perfil = obj.Deodificar_Imagen(h.getFoto(), 30);
               vista.modelo.addRow(h.toArray());
               vista.modelo.setValueAt(new JLabel(perfil), i, 4);
               i++;
           }
      
        }
        if(e.getSource()==vista.boton){
            
            int row= vista.tabla1.getSelectedRow();
            Actualizar act=new Actualizar();
            try{
                
              int id = (int) vista.tabla1.getValueAt(row, 0);
                String nombre=(String) vista.tabla1.getValueAt(row, 1);
                String cedula=(String) vista.tabla1.getValueAt(row, 2);
                String edad= String.valueOf(vista.tabla1.getValueAt(row, 3));
                act.tfNombre.setText(nombre);
                act.tfcedula.setText(cedula);
                act.tfedad.setText(edad);
                Persona p=new Persona();
                p= obj.BuscarId(id);
                act.label6.setIcon(obj.Deodificar_Imagen(p.getFoto(),30));
                act.id= (int) vista.tabla1.getValueAt(row, 0);
                
            }catch(Exception ex){
                act.setVisible(false);
                JOptionPane.showMessageDialog(null, "Error, tiene que seleccionar una casilla");
                
                
            }
        }
       
        if(e.getSource()==vista.botonbuscarid){  
            Consultar con=new Consultar(vista,obj);
           
        }
        if(e.getSource()==vista.botoninsert){
           Insertar ins=new Insertar();
        }
        if(e.getSource()==vista.botonbor){
            //este método borra la tabla por completo
           vista.modelo.setRowCount(0);
        }
        if(e.getSource()==vista.botonborrar){
            System.out.println("hola");
         int row= vista.tabla1.getSelectedRow();
            try{
                
                int vi=(int) vista.tabla1.getValueAt(row, 0);
                obj.Borrar(vi);
                JOptionPane.showMessageDialog(null, "Borrado Exitoso");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error, tiene que seleccionar una casilla");
                
            }
        }
    }
    
}