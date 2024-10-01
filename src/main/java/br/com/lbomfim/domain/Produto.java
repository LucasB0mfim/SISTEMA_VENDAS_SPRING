package br.com.lbomfim.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lucas Bomfim
 */

@Entity
@Table(name = "TB_PRODUTO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "seq_produto", initialValue = 1, allocationSize = 1)
	private Long ID;

	@Column(name = "DESCRICAO", nullable = false)
	private String DESCRICAO;

	@Column(name = "PRECO", nullable = false)
	private Double PRECO;
}
