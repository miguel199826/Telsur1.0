package pe.edu.uni.fiis.cuarta.asistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.ListaAlumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.Alumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.service.AsistenciaService;

@Controller
/**
 * Identificador de anotacion controller
 * Spring crea un objeto por cada thread
 **/
public class AsistenciaController {
    @Autowired
    //@Qualifier(value = "service")
    /**
     * Spring inyecta el objeto de tipo AsistenciaService
     * del contexto Spring.
     * Nota: La anotacion @Service que el objeto CitaServiceImpl
     * que tiene el tipo AsistenciaService usando polimorfismo
     */
    private AsistenciaService asistenciaService;
    @RequestMapping(value = "/agregarAsistencia",
            method = {RequestMethod.POST},
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    /**
     * @RequestMapping: Permite el mapeo de URL con metodo del controller.
     * value: Url de mapeo del metodo
     * method: Tipo de metodo HTTP, usar POST o GET
     * produces: El formato de salida del requerimiento HTTP
     * @ResponseBody: Convierte el parametro de salida del metodo
     * de tipo Alumno a formato JSON
     *  ejemplo: {"identificador":1,"nombre":"Paolo",
     *  "dni":"812122121","telefono":"5364842","correo":"rj@uni.edu.pe"}
     *  @RequestBody: Convierte el parametro de entrada del metodo
     * de tipo Alumno a formato JSON
     *  ejemplo: {"identificador":null,"nombre":"Paolo",
     *  "dni":"812122121","telefono":"5364842","correo":"rj@uni.edu.pe"}
     */
    public @ResponseBody Alumno agregarAsistencia(@RequestBody Alumno dto){
        return asistenciaService.agregarAsistencia(dto);
    }

    @RequestMapping(value = "/obtenerAlumnos",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ListaAlumno obtenerAlumnos(){
        return asistenciaService.obtenerAlumnos();
    }
}
