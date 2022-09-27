/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.PersonaJpaController;
import Controller.exceptions.NonexistentEntityException;
import Entity.Persona;
import java.util.List;

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
}
