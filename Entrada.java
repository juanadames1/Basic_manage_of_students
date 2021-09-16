package Version1;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Entrada {

    private ArrayList<Estudiante> misEstudiantes;

    public static void main (String[] X){

        new Entrada();
    }

    public Entrada(){
        this.misEstudiantes=new ArrayList();
        this.menu();
    }

    private void menu(){
        int opcion;
        String x;
        int v;
        do {
            x = JOptionPane.showInputDialog("======== Opciones ======== \n" +
                    "1. Agregar Estudiante \n" +
                    "2. Buscar un Estudiante \n" +
                    "3. Ver Todos los Estudiantes \n" +
                    "4. Modificar Estudiantes \n" +
                    "5. Eliminar Estudiante \n" +
                    "0. SALIR \n");
            opcion = Integer.parseInt(x);
            switch (opcion) {
                case 1:
                    this.nuevoEstudiante();
                    break;
                case 2:
                    v=misEstudiantes.size();
                    if(v==0){
                        JOptionPane.showMessageDialog(null, "No hay estudiantes creados, por favor dirigase a la opción 1");
                        break;
                    }
                    else {
                        this.buscaEstudiante();
                    }
                    break;
                case 3:
                    v=misEstudiantes.size();
                    if(v==0){
                        JOptionPane.showMessageDialog(null, "No hay estudiantes creados, por favor dirigase a la opción 1");
                        break;
                    }
                    else {
                        this.verTodos();
                    }
                    break;
                case 4:
                    v=misEstudiantes.size();
                    if(v==0){
                        JOptionPane.showMessageDialog(null, "No hay estudiantes creados, por favor dirigase a la opción 1");
                        break;
                    }
                    else {
                        this.menuModificaciones();
                    }
                    break;
                case 5:
                    v=misEstudiantes.size();
                    if(v==0){
                        JOptionPane.showMessageDialog(null, "No hay estudiantes creados, por favor dirigase a la opción 1");
                        break;
                    }
                    else {
                        this.eliminarEstudiante();
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"No existe");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Vemos my lof");
                    break;
            }
        }
        while (opcion!=0);
    }

    private void menuModificaciones(){
        int opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("======== Modify Menu ======== \n" +
                    "1. Modificar Código \n" +
                    "2. Modificar Nombre \n" +
                    "3. Modificar Género \n" +
                    "4. Modificar Nota \n" +
                    "0. Regresar \n");
            opcion = Integer.parseInt(x);
            switch (opcion) {
                case 1:
                    this.modifyCode();
                    break;
                case 2:
                    this.modifyName();
                    break;
                case 3:
                    this.modifyGender();
                    break;
                case 4:
                    this.modifyGrade();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"No existe");
                    break;
                case 0:
                    break;
            }
        }
        while (opcion!=0);
    }

    private void nuevoEstudiante() {
        String cod, nomb;
        char gen;
        float notas;

        cod = JOptionPane.showInputDialog("Digite el código del alumno: ");
        boolean existe=false;
        for (Estudiante stud : this.misEstudiantes){
            while (stud.getCodigo().equals(cod)){
                System.out.println("El alumno está repetido: "+stud);
                cod = JOptionPane.showInputDialog("Digite el código del alumno nuevamente: ");
                existe=true;
            }
        }
        nomb = JOptionPane.showInputDialog("Digite el nombre: ");
        gen = JOptionPane.showInputDialog("Ingrese el género: ").charAt(0);
        while (gen != 'F' && gen != 'M') {
            gen = JOptionPane.showInputDialog("Género no válido, ingrese el género del alumno nuevamente: ").charAt(0);
        }
        notas = Float.parseFloat(JOptionPane.showInputDialog("Digite la nota: "));
        while (notas < 0.0) {

            notas = Float.parseFloat(JOptionPane.showInputDialog("OJO profe, el rango es de 0.0 a 5.0, intente nuevamente: "));
        }
        while (notas > 5.0) {
            notas = Float.parseFloat(JOptionPane.showInputDialog("OJO profe, el rango es de 0.0 a 5.0, intente nuevamente: "));
        }

        Estudiante student = new Estudiante(cod, nomb, gen, notas);

        this.misEstudiantes.add(student);

    }

    private void buscaEstudiante(){
        String code;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                System.out.println("El alumno es: "+stud);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }
    }
    private void verTodos(){

        for(Estudiante stud : this.misEstudiantes){
            System.out.println("El alumno es: "+stud);
            }

    }
    private void eliminarEstudiante(){

        String code;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                this.misEstudiantes.remove(stud);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }
    }

    private void modifyCode(){
        String code, newDato;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante a modificar: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                newDato=JOptionPane.showInputDialog("Digite el nuevo código del estudiante: ");
                boolean Ecist=false;
                    while (stud.getCodigo().equals(newDato)){
                        System.out.println("El alumno está repetido: "+stud);
                        newDato = JOptionPane.showInputDialog("Digite el código del alumno nuevamente: ");
                        Ecist=true;
                    }
                stud.setCodigo(newDato);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }

    }
    private void modifyName(){

        String code, newDato;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante a modificar: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                newDato=JOptionPane.showInputDialog("Digite el nuevo nombre del estudiante: ");
                stud.setNombre(newDato);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }

    }
    private void modifyGender(){

        String code; char newDato;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante a modificar: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                newDato=JOptionPane.showInputDialog("Digite el nuevo género del estudiante: ").charAt(0);
                while (newDato != 'F' && newDato != 'M') {
                    newDato = JOptionPane.showInputDialog("Género no válido, ingrese el género del alumno nuevamente: ").charAt(0);
                }
                stud.setGenero(newDato);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }

    }
    private void modifyGrade(){

        String code; float newDato;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el ID del estudiante a modificar: ");
        for(Estudiante stud : this.misEstudiantes){
            if(stud.getCodigo().equals(code)){
                newDato=Float.parseFloat(JOptionPane.showInputDialog("Digite la nueva nota"));
                while (newDato < 0.0) {

                    newDato = Float.parseFloat(JOptionPane.showInputDialog("OJO profe, el rango es de 0.0 a 5.0, intente nuevamente: "));
                }
                while (newDato > 5.0) {
                    newDato = Float.parseFloat(JOptionPane.showInputDialog("OJO profe, el rango es de 0.0 a 5.0, intente nuevamente: "));
                }
                stud.setNota(newDato);
                existe=true;
                break;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "El estudiante no existe, intente de nuevo");
        }

    }
}
