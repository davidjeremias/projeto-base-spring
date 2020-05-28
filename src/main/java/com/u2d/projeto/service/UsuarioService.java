package com.u2d.projeto.service;

import com.u2d.projeto.dto.UsuarioDTO;
import com.u2d.projeto.exception.NegocioException;
import com.u2d.projeto.model.Usuario;
import com.u2d.projeto.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioDTO save(UsuarioDTO usuarioDTO) throws NegocioException {
        validaDuplicidadeCPF(usuarioDTO);
        Usuario retorno = repository.save(modelMapper.map(usuarioDTO, Usuario.class));
        return modelMapper.map(retorno, UsuarioDTO.class);
    }

    private void validaDuplicidadeCPF(UsuarioDTO usuarioDTO) throws NegocioException {
        Usuario user = repository.findByCpf(usuarioDTO.getCpf());
        if(user != null){
            throw new NegocioException("Usuario já cadastrado com esse cpf");
        }
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> listaUsuario = repository.findAll();
        List<UsuarioDTO> listaRetorno = new ArrayList<>();
        listaUsuario.forEach(e -> {
            listaRetorno.add(modelMapper.map(e, UsuarioDTO.class));
        });
        return listaRetorno;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
