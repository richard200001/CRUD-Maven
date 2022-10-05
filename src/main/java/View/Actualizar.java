/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import DAO.ButtonUpdateDAO;
import DAO.DAOPersona;
import View.Vista1;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Usuario
 */
public class Actualizar extends JFrame implements ActionListener {
    private JPanel pDatos;
    public JLabel lNombre,lcedula,ledad,lfoto,label6; 
    public int id;
    public JTextField tfNombre,tfcedula,tfedad; 
    public JButton bActualizar,bCargarImage;
    public String Salida,Entrada;
    private Vista1 vista;
    public DAOPersona Consulta=new DAOPersona();
    
    public Actualizar(){
        
        setSize(300,270); //Define el tamaño del FRAME
        setTitle("Actualizar datos");
        initComponente(); 
        setLocationRelativeTo(null);
        this.setVisible(true); // Hace visible el FRAME(El objeto que contiene la interfaz)
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
        pDatos.setBorder(BorderFactory.createTitledBorder("Actualice los datos: ")) ;
      
        
        
        //Se crean los botones a usar
        bActualizar = new JButton("Actualizar");
        bActualizar.setBounds(7, 180, 270, 30);
        ButtonUpdateDAO contro=new ButtonUpdateDAO(this , vista);
        bActualizar.addActionListener(contro);
        pDatos.add(bActualizar);
         
        //Se crean los etiquetas que se mostraran al lado del cuadro de texto, para el ingreso de datos. 
       
        lNombre = new JLabel("Nombre : ") ;
        lNombre.setBounds(7, 12,70, 30);
        pDatos.add(lNombre);
         
        lcedula = new JLabel("Cédula:") ;
        lcedula.setBounds(7, 45, 70,30);
        pDatos.add(lcedula);
        
        ledad = new JLabel("Edad: ") ;
        ledad.setBounds(7, 85,70,30);
        pDatos.add(ledad); 
        
        lfoto = new JLabel("Foto: ") ;
        lfoto.setBounds(7, 130, 70, 30);
        pDatos.add(lfoto); 
        
        tfNombre = new JTextField(10);
        tfNombre.setBounds(60,17,70,24);
        tfNombre.setToolTipText("Actualice el nombre");
        pDatos.add(tfNombre);
        
        tfcedula = new JTextField(10);
        tfcedula.setBounds(60, 50,70,24);
        tfcedula.setToolTipText("Actualice la cédula");
        pDatos.add(tfcedula);
        
        tfedad = new JTextField(10);
        tfedad.setBounds(60,87, 70,24);
        tfedad.setToolTipText("Actualice la edad");
        pDatos.add(tfedad); 
        
        bCargarImage = new JButton("Actualice la Imagen");
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
        