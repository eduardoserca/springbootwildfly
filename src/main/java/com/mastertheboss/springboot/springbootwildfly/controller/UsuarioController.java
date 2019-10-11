package com.mastertheboss.springboot.springbootwildfly.controller;

import com.mastertheboss.springboot.springbootwildfly.exception.ResourceNotFoundException;
import com.mastertheboss.springboot.springbootwildfly.model.Usuario;
import com.mastertheboss.springboot.springbootwildfly.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hi " + name + " !";
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuariosById(@PathVariable(value = "id") Long usuarioId)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuarios(@PathVariable(value = "id") Long usuarioId,
                                                   @Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios not found for this id: " + usuarioId));

        usuario.setId(usuarioId);
        usuario.setName(usuarioDetails.getName());
        usuario.setLastname(usuarioDetails.getLastname());
        usuario.setMail(usuarioDetails.getMail());
        usuario.setAge(usuarioDetails.getAge());
        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioId));

        usuarioRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
