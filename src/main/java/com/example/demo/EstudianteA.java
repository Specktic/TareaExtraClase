package com.example.demo;

public class EstudianteA extends Estudiante{ //La subclase EstudianteA HEREDA de la superclase Estudiante
    private int NotaA;
    private int NotaB;

    public EstudianteA(String carnet,
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
                       int proyecto3)
    {
        super(carnet,
                nombre,
                correo,
                telefono,
                nick,
                tipo,
                examenes,
                quices,
                tareas,
                proyecto1,
                proyecto2,
                proyecto3);
        setNotaA(examenes, quices, tareas);
        setNotaB();
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

    // Se hace SOBREESCRITURA de los getters y setters del atributo NotaFinal
    public int getNotaA() {return NotaA;}
    public void setNotaA(int examenes, int quices, int tareas) {
        NotaA = (examenes + quices + tareas) / 3;}

    public int getNotaB() {return NotaB;}
    public void setNotaB(){NotaB = 0;}
}