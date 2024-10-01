package br.com.lbomfim.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "TB_VENDA")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
	@SequenceGenerator(name = "venda_seq", sequenceName = "seq_venda", initialValue = 1, allocationSize = 1)
	private Long ID;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProdutoVenda> produtosVenda = new ArrayList<>();

	@Column(name = "TOTAL", nullable = false)
	private Double TOTAL;
}
