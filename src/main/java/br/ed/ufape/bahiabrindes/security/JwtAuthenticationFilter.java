package br.ed.ufape.bahiabrindes.security;

import br.ed.ufape.bahiabrindes.model.entity.Cliente;
import br.ed.ufape.bahiabrindes.model.entity.Funcionario;
import br.ed.ufape.bahiabrindes.model.enums.TipoUsuario;
import br.ed.ufape.bahiabrindes.repository.ClienteRepository;
import br.ed.ufape.bahiabrindes.repository.FuncionarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil,
                                   ClienteRepository clienteRepository,
                                   FuncionarioRepository funcionarioRepository) {
        this.jwtUtil = jwtUtil;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                String email = jwtUtil.extractEmail(token);
                TipoUsuario tipoUsuario = jwtUtil.extractTipoUsuario(token);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken authentication =
                            buildAuthentication(token, email, tipoUsuario);

                    if (authentication != null) {
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (Exception e) {
            }
        }

        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken buildAuthentication(String token, String email, TipoUsuario tipoUsuario) {

        if (!Boolean.TRUE.equals(jwtUtil.validateToken(token, email))) {
            return null;
        }

        List<SimpleGrantedAuthority> authorities;

        if (tipoUsuario == TipoUsuario.CLIENTE) {
            Cliente cliente = clienteRepository.findByEmailAndAtivoTrue(email).orElse(null);

            if (cliente == null) return null;

            authorities = List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));

        } else {
            Funcionario funcionario = funcionarioRepository.findByEmailAndAtivoTrue(email).orElse(null);

            if (funcionario == null) return null;

            authorities = funcionario.getPerfis().stream()
                    .map(perfil -> new SimpleGrantedAuthority(perfil.getNome()))
                    .collect(Collectors.toList());
        }

        return new UsernamePasswordAuthenticationToken(email, null, authorities);
    }
}