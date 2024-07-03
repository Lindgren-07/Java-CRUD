package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.CtrlExcluirLocalizacao;
import model.Localizacao;

public class JanelaExcluirLocalizacao extends JanelaAbstrato {

	//
	// ATRIBUTOS
	//
	private Localizacao localizacaoParaExclusao;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaExcluirLocalizacao(CtrlExcluirLocalizacao ctrl, Localizacao l) {
		super(ctrl);
		this.localizacaoParaExclusao = l;
		
		setTitle("Excluir Localizacao");
		setBounds(100, 100, 417, 192);
		getContentPane().setLayout(null);

		JLabel lbMensagem = new JLabel("Deseja Excluir o Localizacao " + l + "?");
		lbMensagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMensagem.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbMensagem.setBounds(10, 22, 382, 46);
		getContentPane().add(lbMensagem);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlExcluirLocalizacao ctrl = (CtrlExcluirLocalizacao)getCtrl();
				ctrl.excluirLocalizacao();
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
