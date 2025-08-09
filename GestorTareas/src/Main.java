//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar todas las tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Editar tarea");
            System.out.println("5. Listar tareas pendientes");
            System.out.println("6. Listar tareas completadas");
            System.out.println("7. Eliminar tarea");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();

                    System.out.print("Fecha límite: ");
                    String fecha = sc.nextLine();

                    System.out.print("Prioridad (Alta, Media, Baja): ");
                    String prioridad = sc.nextLine();

                    System.out.print("Categoría (Trabajo, Estudio, Personal, Otro): ");
                    String categoria = sc.nextLine();

                    Tarea nuevaTarea = new Tarea(desc, fecha, prioridad, categoria);
                    gestor.agregarTarea(nuevaTarea);
                    break;

                case 2:
                    gestor.listarTareas();
                    break;

                case 3:
                    System.out.print("Número de tarea a marcar como completada: ");
                    int numCompletar = sc.nextInt();
                    sc.nextLine();
                    gestor.marcarTareaComoCompletada(numCompletar - 1);
                    break;

                case 4:
                    System.out.print("Número de tarea a editar: ");
                    int numEditar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nueva descripción: ");
                    String nuevaDesc = sc.nextLine();

                    System.out.print("Nueva fecha límite: ");
                    String nuevaFecha = sc.nextLine();

                    System.out.print("Nueva prioridad (Alta, Media, Baja): ");
                    String nuevaPrioridad = sc.nextLine();

                    System.out.print("Nueva categoría (Trabajo, Estudio, Personal, Otro): ");
                    String nuevaCategoria = sc.nextLine();

                    gestor.editarTarea(numEditar - 1, nuevaDesc, nuevaFecha, nuevaPrioridad, nuevaCategoria);
                    break;

                case 5:
                    System.out.println("Tareas pendientes:");
                    gestor.listarTareasPorEstado(false);
                    break;

                case 6:
                    System.out.println("Tareas completadas:");
                    gestor.listarTareasPorEstado(true);
                    break;

                case 7:
                    System.out.print("Número de tarea a eliminar: ");
                    int numEliminar = sc.nextInt();
                    sc.nextLine();
                    gestor.eliminarTarea(numEliminar - 1);
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, por favor elige otra.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
