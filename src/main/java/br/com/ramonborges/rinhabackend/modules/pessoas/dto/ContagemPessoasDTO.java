package br.com.ramonborges.rinhabackend.modules.pessoas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ContagemPessoasDTO {

    private long contagem_pessoas;

}
