/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import clases.IconCellRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Vista1 extends JFrame implements ActionListener {
    public JPanel panel,panel2;
    public JLabel label,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
    public JButton boton,boton2,botonP2,botonP3,botonP4,botoncon,botonbor,botoninsert,botonborrar,botonbuscarid;
    public JTextField caja,caja2;
    public JComboBox ListaDesplegable;
    public JTable tabla1;
    public DefaultTableModel modelo ;
    public Hilos hilo1=new Hilos();
    public Hilo1 hilo2;
    public Vista1(){
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proyecto Java CRUD Maven");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        //this.pack();
        this.setVisible(true);      
    } 
    private void iniciarComponentes(){
        colocarPaneles();
        tablas();
        colocarBotones();
        cajaTexto();
        colocarEtiquetas();
        eti2();
        tabla1.setDefaultRenderer(Object.class,new IconCellRenderer());
        tabla1.setRowHeight(30);
    }
    private void colocarPaneles(){
        panel=new JPanel();
        panel.setBackground(Color.WHITE);//así le colocamos color al panel
        panel.setBounds(0,0,1000,700);
        panel.setLayout(null);
        panel.setVisible(true);
        this.add(panel);
        
        panel2=new JPanel();
        panel2.setBackground(Color.WHITE);//así le colocamos color al panel
        panel2.setBounds(0, 0,400, 1000);
        panel2.setLayout(null);
        panel2.setVisible(false);
        this.add(panel2);
        
    }
    private void eti2(){
        ImageIcon imag= new ImageIcon("fondointerfaz1.png");//
        label8=new JLabel(imag);
        label8.setBounds(270,0,800,700);
        label8.setIcon(new ImageIcon(imag.getImage().getScaledInstance(label8.getWidth(), label8.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(label8);
        
        ImageIcon imagi= new ImageIcon("menu1.jpg");//
        label9=new JLabel(imagi);
        label9.setBounds(0,0,270,700);
        label9.setIcon(new ImageIcon(imagi.getImage().getScaledInstance(label9.getWidth(), label9.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(label9);
        
        ImageIcon ima= new ImageIcon("fondointerfaz1.png");//
        label10=new JLabel(ima);
        label10.setBounds(270,0,800,700);
        label10.setIcon(new ImageIcon(imag.getImage().getScaledInstance(label10.getWidth(), label10.getHeight(), Image.SCALE_SMOOTH)));
        panel2.add(label10);
        
        ImageIcon im= new ImageIcon("menu1.jpg");//
        label11=new JLabel(im);
        label11.setBounds(0,0,270,700);
        label11.setIcon(new ImageIcon(im.getImage().getScaledInstance(label11.getWidth(), label11.getHeight(), Image.SCALE_SMOOTH)));
        panel2.add(label11);
       
    }
    private void colocarEtiquetas(){
        
        label=new JLabel();
        label.setText("Bienvenid@");
        label.setBounds(280,20,550,100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.black);
        label.setOpaque(false);
        label.setFont(new Font("calibri",3,70));
        panel.add(label);
        
        label2=new JLabel();
        label2.setText("Bienvenid@");
        label2.setBounds(280,20,550,100);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setOpaque(false);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("calibri",3,70));
        panel2.add(label2);
        
        ImageIcon imagen= new ImageIcon("User.png");//
        label3=new JLabel(imagen);
        label3.setBounds(20,100,200,270);
        label3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(label3);
        
        label4=new JLabel();
        label4.setText("Nombres");
        label4.setBounds(20,405,80,20);
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setOpaque(false);
        label4.setForeground(Color.black);
   
        label4.setFont(new Font("arial",1,17));
        panel.add(label4);
        label5=new JLabel();
        label5.setText("Apellidos");
        label5.setBounds(20,455,80,20);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setOpaque(false);
        label5.setForeground(Color.black);
        
        label5.setFont(new Font("arial",3,17));
        panel.add(label5);
        ImageIcon image= new ImageIcon("User.png");//
        label6=new JLabel(image);
        label6.setBounds(20,100,200,270);
        label6.setIcon(new ImageIcon(image.getImage().getScaledInstance(label6.getWidth(), label6.getHeight(), Image.SCALE_SMOOTH)));
        panel2.add(label6);
        label5.setVisible(true);
        label7=new JLabel();
        label7.setBounds(40,380,200,80);
        label7.setFont(new Font("arial",3,15));
        panel2.add(label7);
        
       
    }
    private void colocarBotones(){
        boton=new JButton();
        boton.setText("Actualizar");//establecemos un texto al botón
        boton.setBounds(800,270,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        boton.setEnabled(true);//si colocamos false, el boton se deshabilita
        boton.setOpaque(false);
        boton.setMnemonic('a');//establecemos alt + la letra que le coloque y el botón funciona
        boton.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        boton.setBackground(Color.WHITE);
        boton.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        boton.setBorder(new RounderBorder(40)); 
        boton.addActionListener(this);
        panel2.add(boton);
        
        botonborrar=new JButton();
        botonborrar.setText("Borrar");//establecemos un texto al botón
        botonborrar.setBounds(800,365,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        botonborrar.setEnabled(true);//si colocamos false, el boton se deshabilita
        botonborrar.setOpaque(false);
        botonborrar.setMnemonic('o');//establecemos alt + la letra que le coloque y el botón funciona
        botonborrar.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        botonborrar.setBackground(Color.WHITE);
        botonborrar.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        botonborrar.setBorder(new RounderBorder(40)); 
        botonborrar.addActionListener(this);
        panel2.add(botonborrar);
        
        botonbor=new JButton();
        botonbor.setText("Limpiar");//establecemos un texto al botón
        botonbor.setBounds(800,460,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        botonbor.setEnabled(true);//si colocamos false, el boton se deshabilita
        botonbor.setOpaque(false);
        botonbor.setMnemonic('l');//establecemos alt + la letra que le coloque y el botón funciona
        botonbor.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        botonbor.setBackground(Color.WHITE);
        botonbor.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        botonbor.setBorder(new RounderBorder(40)); 
        botonbor.addActionListener(this);
        panel2.add(botonbor);
        
        botoncon=new JButton();
        botoncon.setText("Ver Todo");//establecemos un texto al botón
        botoncon.setBounds(800,100,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        botoncon.setEnabled(true);//si colocamos false, el boton se deshabilita
        botoncon.setOpaque(false);
        botoncon.setMnemonic('v');//establecemos alt + la letra que le coloque y el botón funciona
        botoncon.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        botoncon.setBackground(Color.WHITE);
        botoncon.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        botoncon.setBorder(new RounderBorder(40)); 
        botoncon.addActionListener(this);
        panel2.add(botoncon);
        
        botoninsert=new JButton();
        botoninsert.setText("Insertar");//establecemos un texto al botón
        botoninsert.setBounds(800,180,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        botoninsert.setEnabled(true);//si colocamos false, el boton se deshabilita
        botoninsert.setOpaque(false);
        botoninsert.setMnemonic('n');//establecemos alt + la letra que le coloque y el botón funciona
        botoninsert.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        botoninsert.setBackground(Color.WHITE);
        botoninsert.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        botoninsert.setBorder(new RounderBorder(40)); 
        botoninsert.addActionListener(this);
        panel2.add(botoninsert);
        
        botonbuscarid=new JButton();
        botonbuscarid.setText("Buscar");//establecemos un texto al botón
        botonbuscarid.setBounds(800,550,150,50);//los dos primeros son las posiciones los otros dos son el ancho y largo
        botonbuscarid.setEnabled(true);//si colocamos false, el boton se deshabilita
        botonbuscarid.setOpaque(false);
        botonbuscarid.setMnemonic('b');//establecemos alt + la letra que le coloque y el botón funciona
        botonbuscarid.setForeground(Color.BLACK);//establecemos el color de la letra del botón
        botonbuscarid.setBackground(Color.WHITE);
        botonbuscarid.setFont(new Font("arial",1,15));//establecemos la fuente de la letra del botón 
        botonbuscarid.setBorder(new RounderBorder(40)); 
        botonbuscarid.addActionListener(this);
        panel2.add(botonbuscarid);
        
        boton2=new JButton();
        boton2.setText("Iniciar Sesión");//establecemos un texto al botón
        boton2.setBounds(45,550,150,70);//los dos primeros son las posiciones los otros dos son el ancho y largo
        boton2.setEnabled(true);//si colocamos false, el boton se deshabilita
        boton2.setMnemonic('i');//establecemos alt + la letra que le coloque y el botón funciona
        boton2.setForeground(Color.WHITE);//establecemos el color de la letra del botón
        boton2.setBackground(Color.darkGray);
        boton2.setFont(new Font("arial black",Font.ITALIC,15));
        boton2.addActionListener(this);
        panel.add(boton2);
        
        botonP2=new JButton();
        botonP2.setBounds(20,20,70,50);
        ImageIcon clic=new ImageIcon("regresar1.png");
        botonP2.setMnemonic('r');//establecemos alt + la letra que le coloque y el botón funciona
        botonP2.setIcon(new ImageIcon(clic.getImage().getScaledInstance(botonP2.getWidth(), botonP2.getHeight(), Image.SCALE_SMOOTH)));
        botonP2.setBorder(null);
        botonP2.setOpaque(false);
        botonP2.addActionListener(this);
        panel2.add(botonP2);
        
        botonP3=new JButton();
        botonP3.setBounds(190,20,50,50);
        ImageIcon clit=new ImageIcon("tresrayitas1.png");
        botonP3.setMnemonic('m');//establecemos alt + la letra que le coloque y el botón funciona
        botonP3.setOpaque(false);
        botonP3.setIcon(new ImageIcon(clit.getImage().getScaledInstance(botonP3.getWidth(), botonP3.getHeight(), Image.SCALE_SMOOTH)));
        botonP3.addActionListener(this);
        botonP3.setBorder(null);
        panel2.add(botonP3);
        
        botonP4=new JButton();
        botonP4.setBounds(20,80,50,50);
        ImageIcon cli=new ImageIcon("tresrayitas1.png");
        botonP4.setMnemonic('m');//establecemos alt + la letra que le coloque y el botón funciona
        botonP4.setOpaque(false);
        botonP4.setEnabled(true);
        botonP4.setVisible(false);
        botonP4.setIcon(new ImageIcon(cli.getImage().getScaledInstance(botonP3.getWidth(), botonP3.getHeight(), Image.SCALE_SMOOTH)));
        botonP4.addActionListener(this);
        botonP4.setBorder(null);
        panel2.add(botonP4);
       
    }
    
    private void cajaTexto(){
        caja=new JTextField();
        caja.setBounds(110,400,100,30);
        panel.add(caja);
        caja2=new JTextField();
        caja2.setBounds(110,450,100,30);
        panel.add(caja2);
        
    }
    
    public void tablas(){
       
        modelo= new DefaultTableModel();
        
        modelo.addColumn("idPersona");
        modelo.addColumn("name");
        modelo.addColumn("cédula");
        modelo.addColumn("edad");
        modelo.addColumn("foto");
        
        tabla1=new JTable(modelo);
        
        int anchos[]={80,140,170,110,140};
        for (int i = 0; i < 5; i++) {
            tabla1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            
        }
        tabla1.setVisible(true);
        tabla1.setBounds(290, 100, 500, 500);
        panel2.add(tabla1);
        JScrollPane scroll=new JScrollPane(tabla1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scroll.setBounds(290, 100, 500, 500);
        panel2.add(scroll);
    }
   
    
    int contador=0;

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==boton2){
          panel.setVisible(false);
          panel2.setVisible(true);
      }
      if(e.getSource()==botonP2){
          panel.setVisible(true);
          panel2.setVisible(false);
      }
      if(e.getSource()==boton2){
          label7.setText(caja.getText()+" "+caja2.getText());
      }
      if(e.getSource()==botonP3){
            
           
            hilo1=new Hilos();
            hilo1.recibeLabel(label11,label6,label7);
            hilo1.start();
            contador=1;
            System.out.println(label11.getBounds().width);
            botonP3.setVisible(false);
            botonP4.setVisible(true);
          
      }
      if(e.getSource()==botonP4){
            
             hilo2=new Hilo1(); 
             hilo2.recibeLabel1(label11,label6,label7);
             hilo2.start();
             System.out.println(label11.getBounds().width);
             botonP4.setVisible(false);
             botonP3.setVisible(true);
             
      } 
     
    }

    
}