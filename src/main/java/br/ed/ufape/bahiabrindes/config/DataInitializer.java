package br.ed.ufape.bahiabrindes.config;

import br.ed.ufape.bahiabrindes.model.entity.Funcionario;
import br.ed.ufape.bahiabrindes.model.entity.Perfil;
import br.ed.ufape.bahiabrindes.repository.FuncionarioRepository;
import br.ed.ufape.bahiabrindes.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final FuncionarioRepository funcionarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        criarPerfilPadrao();
        criarFuncionarioPadrao();
    }

    private void criarPerfilPadrao() {
        if (!perfilRepository.existsByNome("ROLE_FUNCIONARIO")) {
            Perfil perfil = Perfil.builder()
                    .nome("ROLE_FUNCIONARIO")
                    .build();
            perfilRepository.save(perfil);
            log.info("Perfil padrão 'ROLE_FUNCIONARIO' criado.");
        }
    }

    private void criarFuncionarioPadrao() {
        String email = "admin@gmail.com";

        if (!funcionarioRepository.existsByEmail(email)) {
            Perfil perfil = perfilRepository.findByNome("ROLE_FUNCIONARIO")
                    .orElseThrow(() -> new IllegalStateException("Perfil 'ROLE_FUNCIONARIO' não encontrado."));

            Funcionario admin = Funcionario.builder()
                    .nome("Administrador")
                    .email(email)
                    .senha(passwordEncoder.encode("123456"))
                    .ativo(true)
                    .perfis(Set.of(perfil))
                    .build();

            funcionarioRepository.save(admin);
            log.info("Funcionário padrão criado: {}", email);
        } else {
            log.info("Funcionário padrão já existe: {}", email);
        }
    }
}
