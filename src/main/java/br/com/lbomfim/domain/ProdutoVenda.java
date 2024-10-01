package br.com.lbomfim.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_PRODUTO_VENDA")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_venda_seq")
	@SequenceGenerator(name = "produto_venda_seq", sequenceName = "seq_produto_venda", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "venda_id", nullable = false)
	private Venda venda;

	@Column(name = "QUANTIDADE", nullable = false)
	private int quantidade;

	@Column(name = "SUBTOTAL", nullable = false)
	private Double subtotal;
}
