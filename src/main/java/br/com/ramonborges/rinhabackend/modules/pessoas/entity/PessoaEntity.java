package br.com.ramonborges.rinhabackend.modules.pessoas.entity;

import java.util.List;
import java.util.UUID;

import br.com.ramonborges.rinhabackend.modules.pessoas.converter.StackListConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "pessoas")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\s'-]+$", message = "The field 'apelido' accepts only characters")
    @Length(max = 32, message = "The field 'apelido' must have 32 characters max")
    @Column(unique = true)
    private String apelido;

    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\s'-]+$", message = "The field 'nome' accepts only characters")
    @Length(max = 100, message = "The field 'nome' must have 100 characters max")
    private String nome;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$")
    private String nascimento;

    @Convert(converter = StackListConverter.class)
    private List<String> stack;
}
