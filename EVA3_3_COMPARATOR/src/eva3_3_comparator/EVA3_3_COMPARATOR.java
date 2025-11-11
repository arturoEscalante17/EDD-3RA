package eva3_3_comparator;

import java.util.Comparator;
import java.util.LinkedList;

public class EVA3_3_COMPARATOR {

    public static void main(String[] args) {
        LinkedList<Persona> lista = new LinkedList<Persona>();

        lista.add(new Persona("Juan", "Perez", "11/10/2020"));
        lista.add(new Persona("Karla", "Hernandez", "30/05/2025"));
        lista.add(new Persona("Antonio", "Zarate", "11/10/2025"));

        Comparator<Persona> nombre = new Comparator<Persona>() {
            @Override
            public int compare(Persona per1, Persona per2) {
                return per1.getNombre().compareTo(per2.getNombre());
            }
        };
        lista.sort(nombre);
        System.out.println(lista);
    }

    static class Persona {

        private String nombre;
        private String apellido;
        private String fechaNac;

        public Persona(String nombre, String apellido, String fechaNac) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNac = fechaNac;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getFechaNac() {
            return fechaNac;
        }

        public void setFechaNac(String fechaNac) {
            this.fechaNac = fechaNac;
        }

        @Override
        public String toString() {
            return nombre + " " + apellido + " (Nac: " + fechaNac + ")";
        }
    }
}
