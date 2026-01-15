package br.com.procardio.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import br.com.procardio.api.exceptions.UsuarioNaoEncontradoException;
import br.com.procardio.api.repository.UsuarioRepository;

public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(username));
    }

}