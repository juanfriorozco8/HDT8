import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<<< SISTEMA DE EMERGENCIAS >>>");
        System.out.println("¿Qué implementación deseas usar?");
        System.out.println("1. VectorHeap");
        System.out.println("2. PriorityQueue");
        System.out.print("Opción (1 o 2): ");
        String opcion = scanner.nextLine();

        if (opcion.equals("1")) {
            atenderConVectorHeap(scanner);
        } else if (opcion.equals("2")) {
            atenderConPriorityQueue(scanner);
        } else {
            System.out.println("Opción inválida. Finalizando programa.");
        }
    }

    private static void atenderConVectorHeap(Scanner scanner) {
        VectorHeap<Patient> heap = new VectorHeap<>();
        System.out.println("\n--- Ingreso de pacientes ---");
        ingresarPacientes(scanner, heap);
        System.out.println("\n--- Atención de pacientes ---");
        atenderPacientesVector(heap);
    }

    private static void atenderConPriorityQueue(Scanner scanner) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        System.out.println("\n--- Ingreso de pacientes ---");
        ingresarPacientes(scanner, queue);
        System.out.println("\n--- Atención de pacientes ---");
        atenderPacientes(queue);
    }

    private static void ingresarPacientes(Scanner scanner, Queue<Patient> queue) {
        while (true) {
            System.out.print("\nNombre del paciente (enter para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) break;

            System.out.print("Condición del paciente: ");
            String condicion = scanner.nextLine();

            String prioridad;
            while (true) {
                System.out.print("Prioridad (A-E, donde A es más urgente): ");
                prioridad = scanner.nextLine().trim().toUpperCase();
                if (prioridad.matches("[A-E]")) break;
                System.out.println("¡Prioridad inválida! Intente de nuevo.");
            }

            queue.add(new Patient(nombre, condicion, prioridad));
            System.out.println("Paciente ingresado.");
        }
    }

    private static void ingresarPacientes(Scanner scanner, VectorHeap<Patient> heap) {
        while (true) {
            System.out.print("\nNombre del paciente (enter para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) break;

            System.out.print("Condición del paciente: ");
            String condicion = scanner.nextLine();

            String prioridad;
            while (true) {
                System.out.print("Prioridad (A-E, donde A es más urgente): ");
                prioridad = scanner.nextLine().trim().toUpperCase();
                if (prioridad.matches("[A-E]")) break;
                System.out.println("¡Prioridad inválida! Intente de nuevo.");
            }

            heap.add(new Patient(nombre, condicion, prioridad));
            System.out.println("Paciente ingresado.");
        }
    }

    private static void atenderPacientes(Queue<Patient> queue) {
        int turno = 1;
        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.println("Turno " + turno + ": " + p);
            turno++;
        }
    }

    private static void atenderPacientesVector(VectorHeap<Patient> heap) {
        int turno = 1;
        while (!heap.isEmpty()) {
            Patient p = heap.remove();
            System.out.println("Turno " + turno + ": " + p);
            turno++;
        }
    }
}


