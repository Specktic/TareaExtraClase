package com.example.demo;

public class Estudiante { //La clase Estudiante es una ABSTRACCIÓN del concepto de un estudiante del curso
    // Se proegen los atributos de la clase con objetivo de encapsularla, de manera que la unica forma de accederlos o modificarlos sea atravez de un metodo controlador
    protected String  Carnet; //El atributo esta protegido, no privado ya que se desea acceder en clases heredadas
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
    protected int NotaFinal;

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
                      int proyecto3)
    {
        setCarnet(carnet);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setNick(nick);
        setTipo(tipo);
        setExamenes(examenes);
        setQuices(quices);
        setTareas(tareas);
        setProyecto1(proyecto1);
        setProyecto2(proyecto2);
        setProyecto3(proyecto3);
        setNotaFinal();
        NotaFinal = getNotaFinal();

    }

    // Se definen los metodos de la clase Estudiante
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

    public int getNotaFinal(){ return NotaFinal;}
    public void setNotaFinal() {NotaFinal = (getExamenes() + getQuices() + getTareas() + getProyecto1() + getProyecto2() + getProyecto3()) / 6;}

    public Estudiante TipoEstudiante(String tipo) { // Permite el POLIMORFISMO al tratar a las subclases EstudianteA y EstudianteB como una misma
        if (tipo.equals("A")){
            return new EstudianteA(
                    getCarnet(),
                    getNombre(),
                    getCorreo(),
                    getTelefono(),
                    getNick(),
                    getTipo(),
                    getExamenes(),
                    getQuices(),
                    getTareas(),
                    getProyecto1(),
                    getProyecto2(),
                    getProyecto3());
        }
        else {
            return new EstudianteB(
                    getCarnet(),
                    getNombre(),
                    getCorreo(),
                    getTelefono(),
                    getNick(),
                    getTipo(),
                    getExamenes(),
                    getQuices(),
                    getTareas(),
                    getProyecto1(),
                    getProyecto2(),
                    getProyecto3());
        }
    }
}

