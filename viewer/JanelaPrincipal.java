package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.CtrlPrograma;

public class JanelaPrincipal extends JanelaAbstrato {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma c) {
		super(c);
		setTitle("Principal");
		setBounds(100, 100, 572, 323);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btLivro = new JButton("Livro");
		btLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarCtrlConsultarLivro();
			}
		});
		btLivro.setBounds(143, 83, 111, 53);
		getContentPane().add(btLivro);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
			}
		});
		btSair.setBounds(409, 83, 111, 53);
		getContentPane().add(btSair);
		
		JButton btnLocalizacao = new JButton("Localizacao");
		btnLocalizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarCtrlConsultarLocalizacao();
			}
		});
		btnLocalizacao.setBounds(10, 83, 111, 53);
		getContentPane().add(btnLocalizacao);
		
		JButton btPeriodico = new JButton("Periodico");
		btPeriodico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarCtrlConsultarPeriodico();
			}
		});
		btPeriodico.setBounds(275, 83, 111, 53);
		getContentPane().add(btPeriodico);
		this.setVisible(true);

	}
}
