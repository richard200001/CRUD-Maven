/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

//import controlador.ButtonInsertController;
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
    private JLabel lId, lName,lCountry, lDate; 
    public JTextField tfId; 
    public JTextField tfName; 
    public JTextField tfCountry; 
    public JTextField tfDate;
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
     //   ButtonInsertController contro=new ButtonInsertController(this);
      //  bInsertar.addActionListener(contro);
         
        //Se crean los etiquetas que se mostraran al lado del cuadro de texto, para el ingreso de datos. 
        lId = new JLabel("idCompany:") ;       
        lName = new JLabel("Name : ") ;
        lCountry = new JLabel("Country:") ;       
        lDate = new JLabel("Date Creation: ") ;
        //Se crean los campos de textos donde el usuario ingresara los datos y 
        //se mostrarán los resultados. 
        tfId = new JTextField(10);
        tfId.setToolTipText("Los id no pueden ser repetido");
        tfName = new JTextField(10);
        tfName.setToolTipText("Ingrese el nombre");
        tfCountry = new JTextField(10);
        tfCountry.setToolTipText("Ingrese el país correspondiente");
        tfDate = new JTextField(10);
        tfDate.setToolTipText("Ingrese primero el año, luego el mes y por último el día, de lo contrario no se actualizará la fecha");
        
        //Construcción de la intefaz: 
        //1. Crear los Layout para cada Panel
        //2. Adicionar los componentes a los paneles
        
        
        //1. Crear el Layout para el Panel pDatos
        pDatos.setLayout(new GridLayout(4,2)); //Es como crear una tabla de 2X2
        //2. Adicionar los componentes a el panel pDatos (Etiquetas y campos de texto)
        pDatos.add(lId);
        pDatos.add(tfId);
        pDatos.add(lName);
        pDatos.add(tfName);
        pDatos.add(lCountry);
        pDatos.add(tfCountry);
        pDatos.add(lDate);
        pDatos.add(tfDate);
        
        
        //1. Crear el Layout para el Panel pBotones
        pBoton.setLayout(new GridLayout(1,1)); //Es como crear una tabla de 1X4
        //2. Adicionar los componentes a el panel pBotones (Botones)
        pBoton.add(bInsertar);
    }
}
        
