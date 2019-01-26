package pe.edu.uni.fiis.cuarta.asistenciaweb.service;

import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.Alumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.ListaAlumno;

public interface AsistenciaService {
    public Alumno agregarAsistencia(Alumno dto);
    public ListaAlumno obtenerAlumnos();
}
