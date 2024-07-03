package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.CtrlExcluirLivro;
import model.Livro;

public class JanelaExcluirLivro extends JanelaAbstrato {

	//
	// ATRIBUTOS
	//
	private Livro livroParaExclusao;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaExcluirLivro(CtrlExcluirLivro ctrl, Livro l) {
		super(ctrl);
		this.livroParaExclusao = l;
		
		setTitle("Excluir Livro");
		setBounds(100, 100, 417, 192);
		getContentPane().setLayout(null);

		JLabel lbMensagem = new JLabel("Deseja Excluir o Livro " + l + "?");
		lbMensagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMensagem.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbMensagem.setBounds(10, 22, 382, 46);
		getContentPane().add(lbMensagem);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlExcluirLivro ctrl = (CtrlExcluirLivro)getCtrl();
				ctrl.excluirLivro();
			}
		});
		btOk.setBounds(66, 86, 89, 33);
		getContentPane().add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
			}
		});
		btCancelar.setBounds(242, 86, 89, 33);
		getContentPane().add(btCancelar);
		setVisible(true);
		setModalExclusionType(null);
	}
}
