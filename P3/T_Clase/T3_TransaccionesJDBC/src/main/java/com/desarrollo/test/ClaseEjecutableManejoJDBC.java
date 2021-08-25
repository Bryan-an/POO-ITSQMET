/*
 * Clase ejecutable
 */
package com.desarrollo.test;

import com.desarrollo.datos.Conexion;
import com.desarrollo.datos.PersonaDAO;
import com.desarrollo.domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableManejoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        List<Persona> personas;
        String nombre, apellido, email;
        int edad, telefono, idPersona;
        Connection conexionTransaccional = null;

        try {
            conexionTransaccional = Conexion.getConnection();
            //estado de autocomit -> false
            if (conexionTransaccional.getAutoCommit()) {
                conexionTransaccional.setAutoCommit(false);
            }

            //objeto persona DAO
            PersonaDAO personaDAO = new PersonaDAO(conexionTransaccional);

            do {
                System.out.println("Menú operaciones");
                System.out.println("1. Listar personas");
                System.out.println("2. Insertar persona");
                System.out.println("3. Actualizar persona");
                System.out.println("4. Eliminar persona");
                System.out.println("5. Salir");
                System.out.println("Escoja una opción: ");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        personas = personaDAO.select();

                        for (Persona persona : personas) {
                            System.out.println(persona);
                        }
                        break;
                    case 2:
                        System.out.println("Información persona");
                        System.out.println("Nombre");
                        nombre = sc.next();
                        System.out.println("Apellido");
                        apellido = sc.next();
                        System.out.println("Edad");
                        edad = sc.nextInt();
                        System.out.println("Teléfono:");
                        telefono = sc.nextInt();
                        System.out.println("Email:");
                        email = sc.next();
                        //generar objeto
                        Persona personaInsertar = new Persona(nombre, apellido, edad, telefono, email);

                        System.out.println("Los registros insertados son: "
                                + personaDAO.insert(personaInsertar));
                        break;
                    case 3:
                        System.out.println("Ingrese el id de la persona a actualizar: ");
                        idPersona = sc.nextInt();
                        System.out.println("\n-----------------------------------");
                        System.out.println("Información a actualizar");
                        System.out.println("Nombre: ");
                        nombre = sc.next();
                        System.out.println("Apellido: ");
                        apellido = sc.next();
                        System.out.println("Edad: ");
                        edad = sc.nextInt();
                        System.out.println("Telefono: ");
                        telefono = sc.nextInt();
                        System.out.println("Email: ");
                        email = sc.next();

                        Persona personaActualizar
                                = new Persona(idPersona, nombre, apellido, edad, telefono, email);

                        System.out.println("Los registros actualizados son: "
                                + personaDAO.update(personaActualizar));
                        break;
                    case 4:
                        System.out.println("Eliminar persona");
                        System.out.println("Id persona: ");
                        idPersona = sc.nextInt();

                        Persona personaEliminar = new Persona(idPersona);

                        System.out.println("Los registros eliminados son: "
                                + personaDAO.delete(personaEliminar));
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar nuestro programa");
                        //guardar datos en la BDD
                        conexionTransaccional.commit();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (op != 5);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

            try {
                //revertir cambios en la BDD
                System.out.println("ROLLBACK - BDD");
                conexionTransaccional.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            } 
        }
    }

}
