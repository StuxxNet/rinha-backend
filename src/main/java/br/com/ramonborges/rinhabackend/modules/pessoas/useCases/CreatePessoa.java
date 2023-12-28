package br.com.ramonborges.rinhabackend.modules.pessoas.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonborges.rinhabackend.modules.pessoas.entity.PessoaEntity;
import br.com.ramonborges.rinhabackend.modules.pessoas.repository.PessoaRepository;

@Service
public class CreatePessoa {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity execute(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }

}
