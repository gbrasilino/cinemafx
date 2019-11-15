package br.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Pagamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagemtno;
    private String formaPagamento;
   // private ImprimirTicket idImprimirTicket;


}
