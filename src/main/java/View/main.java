/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAO.DAOPersona;
import Entity.Persona;
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
        do{
            System.out.println("---MENÚ CRUD-------\n"
                    + "1.Crear usuario\n"
                    + "2.Editar usuario\n"
                    + "3.ver usuario\n"
                    + "4.eliminar usuario\n"
                    + "5.Salir\n"
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
                System.out.println(obj.Crear(Nombre, Cedula, Edad));
                
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
                System.out.println(obj.Editar(Id,Nombre, Cedula, Edad));
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
                System.out.println("Inserte el id del usuario que desea eliminar");
                Scanner sc=new Scanner(System.in);
                int id=sc.nextInt();
                System.out.println(obj.Borrar(id));
            }
        }while(num!=5);
    }
}
