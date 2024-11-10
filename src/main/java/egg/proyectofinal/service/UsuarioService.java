/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal.service;

import egg.proyectofinal.model.Usuario;
import egg.proyectofinal.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 54113
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository; //aca accedo a UsuarioRepository
    
    public Usuario crear(Usuario x){
        Usuario usuarioConId = usuarioRepository.save(x);//este metodo me lo graba en la BD
        return usuarioConId;
    }
    
    public List<Usuario> lista(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id.intValue()); //y aca uso un metodo del repositorio
    }
    
    public List<Usuario> buscarPorNombre(String nombreABuscar){
        System.out.println("Service nombre: " + nombreABuscar);
        return usuarioRepository.findByNombre(nombreABuscar);
    }
    
    public Usuario buscarPorId (Long id){
        Usuario usuarioPorId=usuarioRepository.findById(id.intValue()).get();
        return usuarioPorId;
    }
    
    public Usuario modificar (Usuario x){
        return usuarioRepository.save(x);
        
    }
}
