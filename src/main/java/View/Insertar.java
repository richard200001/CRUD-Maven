/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAO.ButtonInsertDAO;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Usuario
 */
public class Insertar extends JFrame{
    private JPanel pDatos, pBoton;
    private JLabel lName,lcedula, ledad; 
    public JTextField tfName,tfcedula, tfedad; 
    public JButton bInsertar;
    // private Vista1 vista;
    Container ppal;
    
    public Insertar(){
        super("Insertar datos");// - es igual a usar setTitle("Calculadora:  ")
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
        pDatos.setBorder(BorderFactory.createTitledBorder("Ingrese nuevos datos: ")) ;
      
        
        
        //Se crean los botones a usar
        bInsertar = new JButton("Insertar");
        ButtonInsertDAO contro=new ButtonInsertDAO(this);
        bInsertar.addActionListener(contro);
         
        //Se crean los etiquetas que se mostraran al lado del cuadro de texto, para el ingreso de datos.    
        lName = new JLabel("Nombre : ") ;
        lcedula = new JLabel("Cédula:") ;       
        ledad = new JLabel("Edad: ") ;
        //Se crean los campos de textos donde el usuario ingresara los datos y 
        //se mostrarán los resultados. 
        tfName = new JTextField(10);
        tfName.setToolTipText("Ingrese el nombre");
        tfcedula = new JTextField(10);
        tfcedula.setToolTipText("Ingrese la cédula");
        tfedad = new JTextField(10);
        tfedad.setToolTipText("Ingrese la edad");
        
        //Construcción de la intefaz: 
        //1. Crear los Layout para cada Panel
        //2. Adicionar los componentes a los paneles
        
        
        //1. Crear el Layout para el Panel pDatos
        pDatos.setLayout(new GridLayout(3,2)); //Es como crear una tabla de 2X2
        //2. Adicionar los componentes a el panel pDatos (Etiquetas y campos de texto)
        pDatos.add(lName);
        pDatos.add(tfName);
        pDatos.add(lcedula);
        pDatos.add(tfcedula);
        pDatos.add(ledad);
        pDatos.add(tfedad);
        
        
        //1. Crear el Layout para el Panel pBotones
        pBoton.setLayout(new GridLayout(1,1)); //Es como crear una tabla de 1X4
        //2. Adicionar los componentes a el panel pBotones (Botones)
        pBoton.add(bInsertar);
    }
}
        
