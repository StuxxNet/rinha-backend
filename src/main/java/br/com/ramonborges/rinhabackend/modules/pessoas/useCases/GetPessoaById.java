package br.com.ramonborges.rinhabackend.modules.pessoas.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonborges.rinhabackend.modules.pessoas.entity.PessoaEntity;
import br.com.ramonborges.rinhabackend.modules.pessoas.repository.PessoaRepository;

@Service
public class GetPessoaById {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity execute(String id) {
        return this.pessoaRepository.findById(UUID.fromString(id)).get();
    }

}
