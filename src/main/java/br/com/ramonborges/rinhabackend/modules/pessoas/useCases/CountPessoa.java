package br.com.ramonborges.rinhabackend.modules.pessoas.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonborges.rinhabackend.modules.pessoas.repository.PessoaRepository;

@Service
public class CountPessoa {

    @Autowired
    private PessoaRepository pessoaRepository;

    public long execute() {
        return this.pessoaRepository.count();
    }

}
