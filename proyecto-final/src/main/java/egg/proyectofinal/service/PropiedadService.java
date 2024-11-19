/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal.service;

import egg.proyectofinal.model.Propiedad;
import egg.proyectofinal.repository.PropiedadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author 54113
 */
@Service
public class PropiedadService implements UserDetailsService{
    
    
    @Autowired
    private PropiedadRepository propiedadRepository;
    
    public List<Propiedad> lista(){
        List<Propiedad> listaPropiedad = propiedadRepository.findAll();
        return listaPropiedad;
    }

    public void eliminarPorId(Long id) {
        propiedadRepository.deleteById(id); //y aca uso un metodo del repositorio
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
