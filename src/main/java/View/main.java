/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAO.DAOPersona;
import DAO.PrincipalWindowDAO;
import Entity.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class main {
    public static void main(String[] args) {
        int num;
        DAOPersona obj = new DAOPersona();
        Vista1 ob=new Vista1();
        ob.setVisible(true);
        PrincipalWindowDAO c=new PrincipalWindowDAO(ob,obj);
       /* do{
            System.out.println("---MENÚ CRUD-------\n"
                    + "1.Crear usuario\n"
                    + "2.Editar usuario\n"
                    + "3.ver usuario\n"
                    + "4.Ver todos los usuarios\n"
                    + "5.eliminar usuario\n"
                    + "6.Salir\n"
                    + "-------------------");
            do
        {
            System.out.println("Inserte el número de la operación que quiere realizar:");
            Scanner scan = new Scanner(System.in);
            num=scan.nextInt();

        } while ( num < 1 || num > 5 );
            
            if(num==1){
                Scanner sc = new Scanner(System.in);
                System.out.println("Inserte el nombre: ");
                String Nombre=sc.nextLine();
                System.out.println("Inserte la cédula: ");
                String Cedula=sc.nextLine();
                System.out.println("Inserte la edad: ");
                int Edad = sc.nextInt();
                boolean varOne =obj.Crear(Nombre, Cedula, Edad);
                if(varOne){
                    System.out.println("Se creó el usuario correctamente");
                }else{
                    System.out.println("no se pudo crear el usuario");
                }
                
            }
            if(num==2){
                Scanner sca = new Scanner(System.in);
                System.out.println("Inserte el Id: ");
                int Id=sca.nextInt();
                sca.nextLine();
                System.out.println("Inserte el nombre: ");
                String Nombre=sca.nextLine();
                System.out.println("Inserte la cédula: ");
                String Cedula=sca.nextLine();
                System.out.println("Inserte la edad: ");
                int Edad = sca.nextInt();
                boolean varTwo = obj.Editar(Id,Nombre, Cedula, Edad);
                if(varTwo){
                     System.out.println("Se editó el usuario correctamente");
                }else{
                    System.out.println("no se pudo editar el usuario");
                }
            }
            if(num==3){
                System.out.println("Inserte el id del usuario que desea ver");
                Scanner sc=new Scanner(System.in);
                int id=sc.nextInt();
                Persona p = obj.BuscarId(id);
                System.out.println("---------------------------");
                System.out.println("Id: "+p.getId());
                System.out.println( "Nombre: "+p.getNombre());
                System.out.println("Cédula: "+p.getCedula());
                System.out.println("Edad: "+p.getEdad());
                System.out.println("----------------------------");
            }
            if(num==4){
                List <Persona> lista = new ArrayList();
                
                lista=obj.DevolverTodos();
               for(Persona s: lista){
                   System.out.println(s);
                   
               }
            }
            if(num==5){
                System.out.println("Inserte el id del usuario que desea eliminar");
                Scanner sc=new Scanner(System.in);
                int id=sc.nextInt();
                System.out.println("Está seguro de que desea eliminar el usuario?");
                System.out.println("Tecleé s para confirmar o n para cancelar: ");
                String opc;
                 sc.nextLine();
                opc=sc.nextLine();
               
                if(opc.equals("s")){
                     boolean varTrhee = obj.Borrar(id);
                     if(varTrhee){
                          System.out.println("Se eliminó el usuario correctamente");
                     }else{
                          System.out.println("no se pudo eliminar el usuario");
                     }
                }else{
                    System.out.println("Se canceló la operación de eliminación de usuario :)");
                }
               
            }
        }while(num!=6);*/
    }
}

