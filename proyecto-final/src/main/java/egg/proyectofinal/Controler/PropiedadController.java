package egg.proyectofinal.Controler;

 // Importación correcta para la clase Propiedad
import egg.proyectofinal.model.Propiedad;
import egg.proyectofinal.repository.PropiedadRepository;
import egg.proyectofinal.service.PropiedadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

@Controller // Cambiado a @Controller para manejar vistas además de API REST
@RequestMapping("/propiedad") // Ruta base para las funcionalidades de Propiedad
public class PropiedadController {

    @Autowired
    private PropiedadRepository propiedadRepository; // Acceso a la base de datos

    @Autowired
    private PropiedadService propiedadService;
    
    @GetMapping("/registrar")
    public String mostrarFormulario() {
        return "propiedad/registrar_propiedad"; // Retorna el archivo HTML (sin la extensión .html)
    }

    /**
     * Endpoint para registrar una propiedad.
     * Recibe datos del formulario y un archivo de imagen.
     *
     * @param model
     * @param nombre    Nombre de la propiedad.
     * @param descripcion  Teléfono asociado a la propiedad.
     * @param imagen      Imagen subida por el usuario.
     * @return          Respuesta indicando éxito o error.
     */
    @PostMapping("/upload")
    public String registrarPropiedad(
            Model model,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") MultipartFile imagen){
        System.out.println("LLEGUE HASTO UPLOAD");
        try {
            // Directorio donde se guardarán las imágenes
            String uploadsDir = "uploads/";
            File uploadsFolder = new File(uploadsDir);
            if (!uploadsFolder.exists()) {
                uploadsFolder.mkdirs(); // Crear directorio si no existe
            }
            System.out.println("!1!");
            // Generar la ruta completa del archivo
            
            
            Path path = Paths.get(uploadsDir, imagen.getOriginalFilename());
            Files.write(path, imagen.getBytes());
            
            
            /*String filePath = uploadsDir + imagen.getOriginalFilename();
            File destFile = new File(filePath);
            imagen.transferTo(destFile); // Guardar la imagen en el servidor**/
            System.out.println("!2!");
            // Crear una nueva instancia de Propiedad
            Propiedad propiedad = new Propiedad();
            propiedad.setNombre(nombre);
            propiedad.setDescripcion(descripcion);
            propiedad.setImagen(uploadsDir); // Guardar la ruta de la imagen en la base de datos
            System.out.println("!3!");
            // Guardar la propiedad en la base de datos
            propiedadRepository.save(propiedad);
            System.out.println("!4!");
            // Retornar respuesta exitosa
            List<Propiedad> propiedades=propiedadService.lista();
            model.addAttribute("listaDePropiedades", propiedades);
            return "propiedad/busqueda_propiedades";
        } catch (IOException e) {
            // Manejar errores de E/S
            return "upload/registrar_propiedad";
        }
    }
    
    @Deprecated
    @GetMapping("/busquedaPropiedad")
    public String mostrarPropiedades (){
        return "propiedad/busqueda_propiedades";
    }
    
    @GetMapping("/mostrarPropiedades")
    public String mostrarPropiedad(Model model){
        Propiedad prop = new Propiedad(); //aca creo un usuario user
        model.addAttribute("prop",prop);
        List<Propiedad> propiedades=propiedadService.lista();
        model.addAttribute("listaDePropiedades", propiedades);
       return "propiedad/busqueda_propiedades";//en pantalla me va a mostrar el html inicio
    }
    
    @GetMapping("/eliminar/{id}")//este metodo o esta ruta se activa cuando toco el boton delete al lado de la lista de nombres
    public String eliminar(@PathVariable Long id, Model model) {
        /**Propiedad prop = new Propiedad(); //aca creo un usuario user
        model.addAttribute("prop",prop);**/
        propiedadService.eliminarPorId(id); // aca llamo al metodo que va a eliminar en el service
        List<Propiedad> propiedades=propiedadService.lista();//aca vuelvo a listar los elementos de la lista
        model.addAttribute("listaDePropiedades", propiedades);//esto es como mando un objeto desde el controlador a la vista
        return "propiedad/busqueda_propiedades";
    }
    }
