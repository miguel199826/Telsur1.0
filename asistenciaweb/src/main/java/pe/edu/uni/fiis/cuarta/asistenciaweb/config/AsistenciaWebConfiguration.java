package pe.edu.uni.fiis.cuarta.asistenciaweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@Component
@ComponentScan(basePackages = "pe.edu.uni.fiis.cuarta.asistenciaweb")
public class AsistenciaWebConfiguration {

}
