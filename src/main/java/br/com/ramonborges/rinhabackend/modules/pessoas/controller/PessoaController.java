package br.com.ramonborges.rinhabackend.modules.pessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramonborges.rinhabackend.modules.pessoas.dto.ContagemPessoasDTO;
import br.com.ramonborges.rinhabackend.modules.pessoas.entity.PessoaEntity;
import br.com.ramonborges.rinhabackend.modules.pessoas.useCases.CountPessoa;
import br.com.ramonborges.rinhabackend.modules.pessoas.useCases.CreatePessoa;
import br.com.ramonborges.rinhabackend.modules.pessoas.useCases.GetPessoaById;
import br.com.ramonborges.rinhabackend.modules.pessoas.useCases.SearchPessoaByTerm;
import jakarta.validation.Valid;

@RestController
public class PessoaController {

    @Autowired
    private CreatePessoa createPessoa;

    @Autowired
    private GetPessoaById getPessoaById;

    @Autowired
    private CountPessoa countPessoa;

    @Autowired
    private SearchPessoaByTerm searchPessoaByTerm;
    
    @PostMapping("/pessoas")
    public ResponseEntity<Object> createPearson(@Valid @RequestBody PessoaEntity pessoaEntity) {
        try {
            var result = this.createPessoa.execute(pessoaEntity);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/pessoas/" + result.getId())
                .body(result);

        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(e.getMessage());
        }
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable(value="id") String id) {
        try {
            var result = this.getPessoaById.execute(id);

            return ResponseEntity
                .ok()
                .body(result);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
        }
    }

    @GetMapping("/pessoas")
    public ResponseEntity<Object> searchPessoaByTerm(@RequestParam String t) {
        try {
            var result = this.searchPessoaByTerm.execute(t);

            return ResponseEntity
                .ok()
                .body(result);
        } catch (Exception e) {
            return ResponseEntity
                .badRequest()
                .body(e.getMessage());
        }
    }

    @GetMapping("/contagem-pessoas")
    public ResponseEntity<Object> countPerson() {
        try {
            var result = this.countPessoa.execute();

            var contagemPessoas = ContagemPessoasDTO.builder()
                .contagem_pessoas(result)
                .build();
            
            return ResponseEntity.ok().body(contagemPessoas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}