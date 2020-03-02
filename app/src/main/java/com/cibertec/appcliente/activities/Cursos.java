package com.cibertec.appcliente.activities;

public class Cursos {
    private String curso_Name;
    private String description_Name;
    private int banner_Curso;

    public Cursos() {
    }

    public Cursos(String curso_Name, String description_Name, int banner_Curso) {
        this.curso_Name = curso_Name;
        this.description_Name = description_Name;
        this.banner_Curso = banner_Curso;
    }

    public String getCurso_Name() {
        return curso_Name;
    }

    public void setCurso_Name(String curso_Name) {
        this.curso_Name = curso_Name;
    }

    public String getDescription_Name() {
        return description_Name;
    }

    public void setDescription_Name(String description_Name) {
        this.description_Name = description_Name;
    }

    public int getBanner_Curso() {
        return banner_Curso;
    }

    public void setBanner_Curso(int banner_Curso) {
        this.banner_Curso = banner_Curso;
    }
}
