/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal.Controler;

import egg.proyectofinal.repository.ReservaRepository;
import egg.proyectofinal.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 54113
 */
@Controller
@RequestMapping(path="/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;//al tenerlo como autowired lo instancia automatico y puedo acceder a sus atributos y metodos
            
    @Autowired
    private ReservaRepository reservaRepository;
    
    @GetMapping("/inicio") // como accedo a este metodo a traves de un get
    public String inicio(){
        return "reserva/inicio";//en pantalla me va a mostrar el html inicio
    }
    
    
}
