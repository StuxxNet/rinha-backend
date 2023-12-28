package br.com.ramonborges.rinhabackend.modules.pessoas.useCases;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonborges.rinhabackend.modules.pessoas.entity.PessoaEntity;
import br.com.ramonborges.rinhabackend.modules.pessoas.repository.PessoaRepository;

@Service
public class SearchPessoaByTerm {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<PessoaEntity> execute(String t) {
        var result = this.pessoaRepository.findByTerm(t);
        if(result.isPresent()) 
            return result.get();

        return Collections.emptyList();
    }
    
}
