package com.example.demo;

public class Estudiante {
    protected String  Carnet;
    protected String Nombre;
    protected String Correo;
    protected String Telefono;
    protected String Nick;
    protected String Tipo;
    protected int Examenes;
    protected int Quices;
    protected int Tareas;
    protected int Proyecto1;
    protected int Proyecto2;
    protected int Proyecto3;
    protected int NotaFinalA;
    protected int NotaFinalB;
    protected int NotaFinalP;

    public Estudiante(String carnet,
                      String nombre,
                      String correo,
                      String telefono,
                      String nick,
                      String tipo,
                      int examenes,
                      int quices,
                      int tareas,
                      int proyecto1,
                      int proyecto2,
                      int proyecto3,
                      int notaFinalA,
                      int notaFinalB,
                      int notaFinalP) {
        Carnet = carnet;
        Nombre = nombre;
        Correo = correo;
        Telefono = telefono;
        Nick = nick;
        Tipo = tipo;
        Examenes = examenes;
        Quices = quices;
        Tareas = tareas;
        Proyecto1 = proyecto1;
        Proyecto2 = proyecto2;
        Proyecto3 = proyecto3;
        NotaFinalA = notaFinalA;
        NotaFinalB = notaFinalB;
        NotaFinalP = notaFinalP;
    }

    public String getCarnet() {return Carnet;}
    public void setCarnet(String carnet) {Carnet = carnet;}

    public String getNombre() {return Nombre;}
    public void setNombre(String nombre) {Nombre = nombre;}

    public String getCorreo() {return Correo;}
    public void setCorreo(String correo) {Correo = correo;}

    public String getTelefono() {return Telefono;}
    public void setTelefono(String telefono) {Telefono = telefono;}

    public String getNick() {return Nick;}
    public void setNick(String nick) {Nick = nick;}

    public String getTipo() {return Tipo;}
    public void setTipo(String tipo) {Tipo = tipo;}

    public int getExamenes() {return Examenes;}
    public void setExamenes(int examenes) {Examenes = examenes;}

    public int getQuices() {return Quices;}
    public void setQuices(int quices) {Quices = quices;}

    public int getTareas() {return Tareas;}
    public void setTareas(int tareas) {Tareas = tareas;}

    public int getProyecto1() {return Proyecto1;}
    public void setProyecto1(int proyecto1) {Proyecto1 = proyecto1;}

    public int getProyecto2() {return Proyecto2;}
    public void setProyecto2(int proyecto2) {Proyecto2 = proyecto2;}

    public int getProyecto3() {return Proyecto3;}
    public void setProyecto3(int proyecto3) {Proyecto3 = proyecto3;}

    public int getNotaFinalA() {return NotaFinalA;}
    public void calcNotaFinalA(int examenes, int quices, int tareas) {
        NotaFinalA = (examenes + quices + tareas) / 3;}

    public int getNotaFinalB() {return NotaFinalB;}
    public void calcNotaFinalB(int proyecto1, int proyecto2, int proyecto3) {
        NotaFinalB = (proyecto1 + proyecto2 + proyecto3) / 3;}

    public int getNotaFinalP() {return NotaFinalP;}
    public void calcNotaFinalP(int examenes, int quices, int tareas, int proyecto1, int proyecto2, int proyecto3){
        NotaFinalP = (examenes + quices + tareas + proyecto1 + proyecto2 + proyecto3) / 6;}
}

