package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CtrlConsultarLocalizacao;
import model.Localizacao;

public class JanelaConsultarLocalizacoes extends JanelaAbstrato {

	//
	// ATRIBUTOS
	//
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private Localizacao[] listaLocalizacaos;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarLocalizacoes(Localizacao[] listaLocalizacaos, CtrlConsultarLocalizacao c) {
		super(c);
		setTitle("Localizacaos");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados(listaLocalizacaos);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
			}
		});
		btSair.setBounds(335, 227, 89, 23);
		contentPane.add(btSair);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrl();
				ctrl.iniciarCtrlAdicionarLocalizacao();
				
			}
		});
		btAdicionar.setBounds(33, 227, 89, 23);
		contentPane.add(btAdicionar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Localizacao l = obterLinhaSelecionada();
				if(l == null) {
					notificar("deve selecionar um objeto");
					return;
				}
				
				CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrl();
				ctrl.iniciarCtrlExcluirLocalizacao(l);
				
				
			}
		});
		btExcluir.setBounds(132, 227, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Localizacao l = obterLinhaSelecionada();
				if(l == null) {
					notificar("selecione uma linha");
					return;
				}
				
				CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrl();
				ctrl.iniciarCtrlAlterarLocalizacao(l);
			}
		});
		btAlterar.setBounds(236, 227, 89, 23);
		contentPane.add(btAlterar);

		this.setVisible(true);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Localizacao[] lstLocalizacaos) {
		this.listaLocalizacaos = lstLocalizacaos;
		HelperTableModel h = new HelperTableModel(lstLocalizacaos);
		if(this.tabela == null)
			this.tabela = new JTable(h.getTableModel());
		else 
			this.tabela.setModel(h.getTableModel());
	}

	public Localizacao obterLinhaSelecionada() {
		int numLinhaSelecionada = this.tabela.getSelectedRow();
		if(numLinhaSelecionada != -1)
			return this.listaLocalizacaos[numLinhaSelecionada];
		return null;
	}
}