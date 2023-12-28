package br.com.ramonborges.rinhabackend.modules.pessoas.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ramonborges.rinhabackend.modules.pessoas.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, UUID> {

    @Query(value = "SELECT * FROM pessoas p " +
            "WHERE p.nome ILIKE %:t% OR " +
            "      p.apelido ILIKE %:t% OR " +
            "      p.stack ILIKE %:t%", nativeQuery=true)
    Optional<List<PessoaEntity>> findByTerm(String t);

}
