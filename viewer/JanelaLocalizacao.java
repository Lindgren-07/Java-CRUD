package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.CtrlAdicionarLocalizacao;
import controller.CtrlAlterarLocalizacao;
import model.Localizacao;
import model.ModelException;

public class JanelaLocalizacao extends JanelaAbstrato {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCorredor;
	private JTextField tfEstante;
	private JTextField tfPrateleira;

	/**
	 * Create the frame.
	 */
	public JanelaLocalizacao(CtrlAbstrato ctrl) {
		super(ctrl);
		setTitle("Localização");
		setBounds(100, 100, 909, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Corredor:");
		lblNewLabel.setBounds(34, 61, 71, 14);
		contentPane.add(lblNewLabel);

		JLabel lblEstante = new JLabel("Estante:");
		lblEstante.setBounds(34, 103, 46, 14);
		contentPane.add(lblEstante);

		JLabel lblPrateleira = new JLabel("Prateleira:");
		lblPrateleira.setBounds(34, 152, 71, 14);
		contentPane.add(lblPrateleira);

		tfCorredor = new JTextField();
		tfCorredor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String c = tfCorredor.getText();
				int corredor;

				if (c != null && c.length() != 0) {
					try {
						corredor = Integer.parseInt(c);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "corredor invalido");
						tfCorredor.requestFocus();
						return;
					}

					try {
						Localizacao.validarNumCorredor(corredor);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfCorredor.requestFocus();
					}

				}
			}
		});
		tfCorredor.setBounds(139, 58, 133, 20);
		contentPane.add(tfCorredor);
		tfCorredor.setColumns(10);

		tfEstante = new JTextField();
		tfEstante.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String es = tfEstante.getText();
				int estante;

				if (es != null && es.length() != 0) {
					try {
						estante = Integer.parseInt(es);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "estante invalida");
						tfEstante.requestFocus();
						return;
					}

					try {
						Localizacao.validarNumEstante(estante);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfEstante.requestFocus();
					}

				}
			}
		});
		tfEstante.setBounds(139, 103, 133, 20);
		tfEstante.setColumns(10);
		contentPane.add(tfEstante);

		tfPrateleira = new JTextField();
		tfPrateleira.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String p = tfPrateleira.getText();
				int prateleira;

				if (p != null && p.length() != 0) {
					try {
						prateleira = Integer.parseInt(p);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "prateleira invalida");
						tfPrateleira.requestFocus();
						return;
					}

					try {
						Localizacao.validarNumPrateleira(prateleira);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfPrateleira.requestFocus();
					}

				}
			}
		});
		tfPrateleira.setBounds(139, 149, 133, 20);
		tfPrateleira.setColumns(10);
		contentPane.add(tfPrateleira);

		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(29, 236, 89, 23);
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auxC = tfCorredor.getText();
				String auxE = tfEstante.getText();
				String auxP = tfPrateleira.getText();
				int corredor;
				int estante;
				int prateleira;

				try {
					corredor = Integer.parseInt(auxC);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero de corredor invalido: " + auxC);
					return;
				}

				try {
					estante = Integer.parseInt(auxE);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero de estante invalido: " + auxE);
					return;
				}

				try {
					prateleira = Integer.parseInt(auxP);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero da prateleira invalido: " + auxP);
					return;
				}

				if (getCtrl() instanceof CtrlAdicionarLocalizacao) {
					CtrlAdicionarLocalizacao ctrl = (CtrlAdicionarLocalizacao) getCtrl();
					ctrl.adicionarLocalizacao(corredor, estante, prateleira);
				} else if (getCtrl() instanceof CtrlAlterarLocalizacao) {
					CtrlAlterarLocalizacao ctrl = (CtrlAlterarLocalizacao) getCtrl();
					ctrl.alterarLocalizacao(corredor, estante, prateleira);

				}

			}
		});
		contentPane.add(btConfirmar);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(152, 236, 89, 23);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
				;
			}
		});
		contentPane.add(btCancelar);
		this.setVisible(true);
	}

	public void limparFormulario() {
		tfCorredor.setText("");
		tfEstante.setText("");
		tfPrateleira.setText("");
	}

	public void preencherDados(int corredor, int estante, int prateleira) {
		tfCorredor.setText(Integer.toString(corredor));
		tfEstante.setText(Integer.toString(estante));
		tfPrateleira.setText(Integer.toString(prateleira));

	}
}
