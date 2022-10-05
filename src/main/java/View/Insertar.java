/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAO.ButtonInsertDAO;
import DAO.DAOPersona;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Usuario
 */
public class Insertar extends JFrame  implements ActionListener{
    private JPanel pDatos;
    private JLabel lName,lcedula, ledad,lfoto,label6; 
    public JTextField tfName,tfcedula, tfedad; 
    public JButton bInsertar, bCargarImage;
    public String Salida,Entrada;
    public DAOPersona Consulta=new DAOPersona();
    public Insertar(){
        setSize(300,270);
        setTitle("Insertar datos");
        initComponente();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void initComponente()
    {
        pDatos = new JPanel();
        pDatos.setBackground(Color.WHITE);//así le colocamos color al panel
        pDatos.setBounds(0,0,300,270);
        pDatos.setLayout(null);
        pDatos.setVisible(true);
        this.add(pDatos);
      
        
        //Se crean los bordes y los titulos de los paneles
        pDatos.setBorder(BorderFactory.createTitledBorder("Ingrese nuevos datos: ")) ;
      
        
        
        //Se crean los botones a usar
        
        bInsertar = new JButton("Insertar");
        bInsertar.setBounds(7, 180, 270, 30);
        ButtonInsertDAO contro=new ButtonInsertDAO(this);
        bInsertar.addActionListener(contro);
        pDatos.add(bInsertar);
        
        
        //Se crean los etiquetas que se mostraran al lado del cuadro de texto, para el ingreso de datos.    
        lName = new JLabel("Nombre : ") ;
        lName.setBounds(7, 12,70, 30);
        pDatos.add(lName);
         
        lcedula = new JLabel("Cédula:") ;
        lcedula.setBounds(7, 45, 70,30);
        pDatos.add(lcedula);
        
        ledad = new JLabel("Edad: ") ;
        ledad.setBounds(7, 85,70,30);
        pDatos.add(ledad); 
        
        lfoto = new JLabel("Foto: ") ;
        lfoto.setBounds(7, 130, 70, 30);
        pDatos.add(lfoto); 
       
        tfName = new JTextField(10);
        tfName.setBounds(60,17,70,24);
        tfName.setToolTipText("Ingrese el nombre");
        pDatos.add(tfName);
        
        tfcedula = new JTextField(10);
        tfcedula.setBounds(60, 50,70,24);
        tfcedula.setToolTipText("Ingrese la cédula");
        pDatos.add(tfcedula);
        
        tfedad = new JTextField(10);
        tfedad.setBounds(60,87, 70,24);
        tfedad.setToolTipText("Ingrese la edad");
        pDatos.add(tfedad); 
        
        bCargarImage = new JButton("Cargar Imagen");
        bCargarImage.setBounds(50,130, 220, 30);
        bCargarImage.addActionListener( this);
        pDatos.add(bCargarImage);
     
        ImageIcon image= new ImageIcon("R.jpg");//
        label6=new JLabel(image);
        label6.setBounds(150,17,115,100);
        label6.setIcon(new ImageIcon(image.getImage().getScaledInstance(label6.getWidth(), label6.getHeight(), Image.SCALE_SMOOTH)));
        pDatos.add(label6);

       // create a separator
        JSeparator s = new JSeparator();
         
        // set layout as vertical
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(7, 168, 270, 2);
        pDatos.add(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==bCargarImage){
           JFileChooser selectorArchivos = new JFileChooser();
            FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("*.jpg, *.png, *.gif","jpg","png","gif");
            selectorArchivos.setFileFilter(filtroImagen);
            selectorArchivos.showOpenDialog(this);
            File archivo = selectorArchivos.getSelectedFile();
    
            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(this, "Inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
            }
            try {
                Entrada = archivo.getAbsolutePath();
                Entrada=Entrada.replace("\\", "/");
                Salida = Consulta.Codificar_Imagen(Entrada);
            } catch (IOException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
            label6.setIcon(Consulta.Deodificar_Imagen(Salida,100));
      }
    }
}
        
