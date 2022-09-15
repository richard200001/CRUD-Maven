/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.PersonaJpaController;
import Controller.exceptions.NonexistentEntityException;
import Entity.Persona;

/** * @author David */

public class DAOPersona {
    
    private  Persona Objeto = new Persona();
    private final PersonaJpaController Metodo = new PersonaJpaController();
    
    public String Crear(String Nombre, String Cedula, int Edad){
        Objeto.setNombre(Nombre);
        Objeto.setCedula(Cedula);
        Objeto.setEdad(Edad);
        
        try{
            Metodo.create(Objeto);
            return "Se creó el usuario exitosamente";
        }
        catch(Exception Ex){
            return "Ocurrió un error, no se pudo crear el usuario";
        }
    }
    public String Editar(int id,String Nombre, String Cedula, int Edad){
        Objeto.setId(id);
          Objeto.setNombre(Nombre);
        Objeto.setCedula(Cedula);
        Objeto.setEdad(Edad);
        
        try{
            Metodo.edit(Objeto);
            return "Se actualizó el usuario exitosamente";
        }
        catch(Exception Ex){
            return "Ocurrió un error, no se pudo editar el usuario";
        }
    }
    public String Borrar(int id){
        try{
            Metodo.destroy(id);
            return "Se eliminó exitosamente al usuario";
        }
        catch(NonexistentEntityException Ex){
            return "Ocurrió un error, no se pudo eliminar el usuario";
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
}
