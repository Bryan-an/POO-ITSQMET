/*
 * Clase ejecutable
 */
package com.desarrollo.test;

import com.desarrollo.datos.*;
import com.desarrollo.domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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
        List<PersonaDTO> personas;
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
            AccesoDatosDAO accesoDatosDAO = new PersonaDAOImpl(conexionTransaccional);

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
                        personas = accesoDatosDAO.select();

                        for (PersonaDTO persona : personas) {
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
                        PersonaDTO personaInsertar = new PersonaDTO(nombre, apellido, edad, telefono, email);

                        System.out.println("Los registros insertados son: "
                                + accesoDatosDAO.insert(personaInsertar));
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

                        PersonaDTO personaActualizar
                                = new PersonaDTO(idPersona, nombre, apellido, edad, telefono, email);

                        System.out.println("Los registros actualizados son: "
                                + accesoDatosDAO.update(personaActualizar));
                        break;
                    case 4:
                        System.out.println("Eliminar persona");
                        System.out.println("Id persona: ");
                        idPersona = sc.nextInt();

                        PersonaDTO personaEliminar = new PersonaDTO(idPersona);

                        System.out.println("Los registros eliminados son: "
                                + accesoDatosDAO.delete(personaEliminar));
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
