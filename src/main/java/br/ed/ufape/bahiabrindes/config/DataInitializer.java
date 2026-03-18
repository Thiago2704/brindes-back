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
        criarPerfisPadrao();
        criarFuncionarioAdmin();
    }

    private void criarPerfisPadrao() {

        if (!perfilRepository.existsByNome("ROLE_FUNCIONARIO")) {
            perfilRepository.save(
                Perfil.builder()
                    .nome("ROLE_FUNCIONARIO")
                    .build()
            );
            log.info("Perfil 'ROLE_FUNCIONARIO' criado.");
        }

        if (!perfilRepository.existsByNome("ROLE_ADMIN")) {
            perfilRepository.save(
                Perfil.builder()
                    .nome("ROLE_ADMIN")
                    .build()
            );
            log.info("Perfil 'ROLE_ADMIN' criado.");
        }
    }

    private void criarFuncionarioAdmin() {
        String email = "admin@gmail.com";

        Funcionario admin = funcionarioRepository.findByEmail(email)
                .orElse(null);

        Perfil perfilFuncionario = perfilRepository.findByNome("ROLE_FUNCIONARIO")
                .orElseThrow();

        Perfil perfilAdmin = perfilRepository.findByNome("ROLE_ADMIN")
                .orElseThrow();

        if (admin == null) {
            admin = Funcionario.builder()
                    .nome("Administrador")
                    .email(email)
                    .senha(passwordEncoder.encode("123456"))
                    .ativo(true)
                    .perfis(Set.of(perfilFuncionario, perfilAdmin))
                    .build();

            funcionarioRepository.save(admin);
            log.info("Admin criado.");
        } else {
            admin.getPerfis().add(perfilAdmin);
            funcionarioRepository.save(admin);

            log.info("Admin atualizado com ROLE_ADMIN.");
        }
    }
}