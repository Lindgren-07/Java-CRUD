package controller;

import model.dao.Serializador;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {

	private JanelaPrincipal janela;
	private CtrlConsultarLivro ctrlConsultarLivro;
	private CtrlConsultarLocalizacao ctrlConsultarLocalizacao;
	private CtrlConsultarPeriodico ctrlConsultarPeriodico;

	public CtrlPrograma() {
		super(null);

	}

	public void iniciar() {
		Serializador.recuperarObjetos();
		this.janela = new JanelaPrincipal(this);

	}

	public void encerrar() {
		Serializador.salvarObjetos();
		this.janela.fechar();
		System.exit(0);

	}
	
	public void iniciarCtrlConsultarLivro() {
		if(this.ctrlConsultarLivro == null)
			this.ctrlConsultarLivro = new CtrlConsultarLivro(this);
	}
	
	public void informarEncerramentoDeCtrlConsultarLivro() {
		this.ctrlConsultarLivro = null;
	}
	
	public void iniciarCtrlConsultarLocalizacao() {
		if(this.ctrlConsultarLocalizacao == null)
			this.ctrlConsultarLocalizacao = new CtrlConsultarLocalizacao(this);
	}
	
	public void informarEncerramentoDeCtrlConsultarLocalizacao() {
		this.ctrlConsultarLocalizacao = null;
	}
	
	public void iniciarCtrlConsultarPeriodico() {
		if(this.ctrlConsultarPeriodico == null)
			this.ctrlConsultarPeriodico = new CtrlConsultarPeriodico(this);
	}
	
	public void informarEncerramentoDeCtrlConsultarPeriodico() {
		this.ctrlConsultarPeriodico = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CtrlPrograma();

	}

}
