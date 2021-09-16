package Version1;

import javax.swing.*;

public class Estudiante {
    private String codigo;
    private String Nombre;
    private char genero;
    private float nota;

    public Estudiante(){
        this.codigo="";
        this.Nombre="";
        this.genero='*';
        this.nota=0;
    }

    public Estudiante(String codigo, String Nombre, char genero, float nota){
        this.codigo=codigo;
        this.Nombre=Nombre;
        this.genero=genero;
        this.nota=nota;
    }

    //Modificadores
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    //Analizadores
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getGenero() {
        return genero;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return this.codigo + "," + this.Nombre + "," + this.genero + "," + this.nota;
    }
}

