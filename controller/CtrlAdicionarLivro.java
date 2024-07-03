package controller;

import javax.swing.JOptionPane;

import model.Livro;
import model.Localizacao;
import model.ModelException;
import model.dao.DaoLivro;
import viewer.JanelaLivro;

public class CtrlAdicionarLivro extends CtrlAbstrato {
	
	private JanelaLivro janela;
	
	public CtrlAdicionarLivro(CtrlConsultarLivro c) {
		super(c);
		
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaLivro(this);

	}
	
	public void adicionarLivro(String titulo, int ano, int mes, Localizacao localizacao, String isbn, String autor) {
		try {
			Livro l = new Livro(titulo, ano, mes, localizacao, isbn, autor);
			DaoLivro dao = new DaoLivro();
			dao.adicionar(l);
			this.janela.notificar("Objeto criado: " + l);
			this.encerrar();
			
		} catch (ModelException me) {
			JOptionPane.showMessageDialog(null, me.getMessage());
			return;
		}
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlConsultarLivro ctrl = (CtrlConsultarLivro)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAdicionarLivro();
		

	}

}
