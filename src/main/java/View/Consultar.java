/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;



import DAO.ButtonFindByIdDAO;
import DAO.DAOPersona;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import View.Vista1;

/**
 *
 * @author Usuario
 */
public class Consultar extends JFrame implements ActionListener {
    private JPanel pDatos, pBoton;
    public JLabel lid,ldato; 
    public JTextField tfid; 
    public JButton bConsultar;
    
    Container ppal;
    Vista1 vista;
    DAOPersona u;
    
    public Consultar(Vista1 vista,DAOPersona u){
        this.vista=vista;
        this.u=u;
        setTitle("Buscar por id");
        setSize(500,500); //Define el tamaño del FRAME
        setVisible(true); // Hace visible el FRAME(El objeto que contiene la interfaz)
        
        initComponente(); // Método que instancia todos los componentes de la interfaz
        ppal= getContentPane(); // Se crea el contenedor principal
        
        //1. Se define con un Layout la distribución de los Paneles dentro del contenedor principal
        ppal.setLayout(new GridLayout(2,1)); //Es como crear una tabla de 2X2
        //2. Adicionar los paneles a el panel Principal ppal (pDatos, pBotones, pResultados)    
        ppal.add(pDatos);
        ppal.add(pBoton);
        
        
        pack();
        
        //Cierra el proceso al dar clic en el boton de X del FRAME
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
  
    
    public void initComponente()
    {
        //Se crean los paneles que marcan la distribución de los elementos en el FRAME
        pDatos = new JPanel();
        pBoton = new JPanel();
      
        //Se crean los bordes y los titulos de los paneles
        pDatos.setBorder(BorderFactory.createTitledBorder("Busque la persona que desea: ")) ;
      
        
        
        //Se crean los botones a usar
        bConsultar = new JButton("Buscar por id");
        ButtonFindByIdDAO contro=new ButtonFindByIdDAO(this , vista,u);
        bConsultar.addActionListener(contro);
        
         
        //Se crean los etiquetas que se mostraran al lado del cuadro de texto, para el ingreso de datos. 
       
        lid = new JLabel("Id : ") ;
        ldato = new JLabel();
        
        //Se crean los campos de textos donde el usuario ingresara los datos y 
        //se mostrarán los resultados. 
       
        tfid = new JTextField(10);
        tfid.setToolTipText("Inserte el id de la persona que desea buscar");
        //Construcción de la intefaz: 
        //1. Crear los Layout para cada Panel
        //2. Adicionar los componentes a los paneles
        
        
        //1. Crear el Layout para el Panel pDatos
        pDatos.setLayout(new GridLayout(2,2)); //Es como crear una tabla de 2X2
        //2. Adicionar los componentes a el panel pDatos (Etiquetas y campos de texto)
        
        pDatos.add(lid);
        pDatos.add(tfid);
        pDatos.add(ldato);
        
        
        //1. Crear el Layout para el Panel pBotones
        pBoton.setLayout(new GridLayout(1,1)); //Es como crear una tabla de 1X4
        //2. Adicionar los componentes a el panel pBotones (Botones)
        pBoton.add(bConsultar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      
       
    }
}
       