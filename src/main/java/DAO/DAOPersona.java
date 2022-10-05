/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Controller.PersonaJpaController;
import Controller.exceptions.NonexistentEntityException;
import Entity.Persona;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/** * @author David */

public class DAOPersona {
    
    private  Persona Objeto = new Persona();
    private final PersonaJpaController Metodo = new PersonaJpaController();
    
    public boolean Crear(String Nombre, String Cedula, int Edad){
        Objeto.setNombre(Nombre);
        Objeto.setCedula(Cedula);
        Objeto.setEdad(Edad);
        
        try{
            Metodo.create(Objeto);
            return true;
        }
        catch(Exception Ex){
            return false;
        }
    }
    public boolean Editar(int id,String Nombre, String Cedula, int Edad){
        Objeto.setId(id);
          Objeto.setNombre(Nombre);
        Objeto.setCedula(Cedula);
        Objeto.setEdad(Edad);
        
        try{
            Metodo.edit(Objeto);
            return true;
        }
        catch(Exception Ex){
            return false;
        }
    }
    public boolean Borrar(int id){
        try{
            Metodo.destroy(id);
            return true;
        }
        catch(NonexistentEntityException Ex){
            return false;
        }
    }
      public Persona BuscarId(int id){ 
        this.Objeto=Metodo.findPersona(id);
        if(Objeto!=null) {
            return this.Objeto;
        } else {
            return null;
        } 
    }
      public List<Persona> DevolverTodos(){
          return Metodo.findPersonaEntities();
      }
      public String Codificar_Imagen(String DireccionImagen) throws IOException{//c:/imagen.png
        FileInputStream file = new FileInputStream(DireccionImagen);
        byte[] fileContent = file.readAllBytes();
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);
        return encodedString;
    }
    //jLabel1.setIcon(Consulta.Deodificar_Imagen(Consulta.BuscarId(3).getFoto())); en swing
    public ImageIcon Deodificar_Imagen(String base64Imagen, int size){
        ImageIcon imagi = null;
        if(!base64Imagen.equals("")){
            
        try{
          byte[] decodedBytes = Base64
          .getDecoder()
          .decode(base64Imagen);
          BufferedImage imagen;
          InputStream in = new ByteArrayInputStream(decodedBytes);
          imagen = ImageIO.read(in);
          imagi = new ImageIcon(imagen.getScaledInstance(size, size, 0));
          
        }
        
        catch(IOException e){
           
        }
        }else{
            ImageIcon imageIcon = new ImageIcon("R.jpg"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(size, size, 0);
            imagi = new ImageIcon(newimg); 
        }
        return imagi;
    }
}
