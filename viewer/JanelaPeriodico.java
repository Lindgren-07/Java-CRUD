package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.CtrlAdicionarPeriodico;
import controller.CtrlAlterarPeriodico;
import model.Livro;
import model.Localizacao;
import model.ModelException;
import model.Periodico;
import model.dao.DaoLocalizacao;

public class JanelaPeriodico extends JanelaAbstrato {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfNumero;
	private JTextField tfSubTitulo;
	private JComboBox cbAno;
	private JComboBox cbMes;
	private JComboBox cbLocalizacao;
	private JTextField tfNumArtigo;

	/**
	 * Create the frame.
	 */
	public JanelaPeriodico(CtrlAbstrato ctrl) {
		super(ctrl);
		setTitle("Periodico");
		setBounds(100, 100, 906, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setBounds(41, 64, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ano Publicação:");
		lblNewLabel_1.setBounds(41, 110, 76, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mes Publicação:");
		lblNewLabel_1_1.setBounds(41, 167, 76, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Numero:");
		lblNewLabel_1_2.setBounds(316, 64, 46, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Subtitulo:");
		lblNewLabel_1_3.setBounds(316, 110, 46, 14);
		contentPane.add(lblNewLabel_1_3);

		tfTitulo = new JTextField();
		tfTitulo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				String titulo = tfTitulo.getText();

				if (titulo != null && titulo.length() != 0) {

					try {
						Livro.validarTitulo(titulo);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfTitulo.requestFocus();
					}

				}

			}
		});
		tfTitulo.setBounds(111, 61, 136, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);

		tfNumero = new JTextField();
		tfNumero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String nAux = tfNumero.getText();
				int numero;

				if (nAux != null && nAux.length() != 0) {
					try {
						numero = Integer.parseInt(nAux);
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(null, "numero invalido");
						tfNumero.requestFocus();
						return;
					}

					try {
						Periodico.validarNumero(numero);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfNumero.requestFocus();
					}

				}

			}
		});
		tfNumero.setColumns(10);
		tfNumero.setBounds(370, 61, 136, 20);
		contentPane.add(tfNumero);

		tfSubTitulo = new JTextField();
		tfSubTitulo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String subTitulo = tfSubTitulo.getText();

				if (subTitulo != null && subTitulo.length() != 0) {

					try {
						Periodico.validarSubTitulo(subTitulo);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfSubTitulo.requestFocus();
					}
				}
			}
		});
		tfSubTitulo.setColumns(10);
		tfSubTitulo.setBounds(370, 107, 136, 20);
		contentPane.add(tfSubTitulo);

		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] { "0", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
		cbAno.setBounds(165, 106, 82, 22);
		contentPane.add(cbAno);

		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(
				new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cbMes.setBounds(165, 163, 82, 22);
		contentPane.add(cbMes);

		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = tfTitulo.getText();
				String anoAux = (String) cbAno.getSelectedItem();
				String mesAux = (String) cbMes.getSelectedItem();
				String auxN = tfNumero.getText();
				String auxNa = tfNumArtigo.getText();
				int ano;
				int mes;
				int numero;
				int artigo;
				String subTitulo = tfSubTitulo.getText();
				Localizacao localizacao = (Localizacao) cbLocalizacao.getSelectedItem();

				try {
					numero = Integer.parseInt(auxN);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero invalido: " + auxN);
					return;
				}

				try {
					ano = Integer.parseInt(anoAux);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero invalido: " + anoAux);
					return;
				}

				try {
					mes = Integer.parseInt(mesAux);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero invalido: " + mesAux);
					return;
				}

				try {
					artigo = Integer.parseInt(auxNa);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero do artigo invalido: " + auxNa);
					return;
				}
				
				if(getCtrl() instanceof CtrlAdicionarPeriodico) {
					 CtrlAdicionarPeriodico ctrl = (CtrlAdicionarPeriodico)getCtrl();
					 ctrl.adicionarPeriodico(titulo, ano, mes, localizacao, numero, subTitulo, artigo);
				}
				else if(getCtrl() instanceof CtrlAlterarPeriodico) {
					CtrlAlterarPeriodico ctrl = (CtrlAlterarPeriodico)getCtrl();
					ctrl.alterarPeriodico(titulo, ano, mes, localizacao, numero, subTitulo, artigo);
				}

				

			}
		});
		btConfirmar.setBounds(62, 243, 89, 23);
		contentPane.add(btConfirmar);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
			}
		});
		btCancelar.setBounds(195, 243, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel_2 = new JLabel("Localização:");
		lblNewLabel_2.setBounds(316, 221, 58, 14);
		contentPane.add(lblNewLabel_2);

		cbLocalizacao = new JComboBox();
		cbLocalizacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
	Localizacao l = (Localizacao)cbLocalizacao.getSelectedItem();
				
				if(l != null) {
					
					try {
						Livro.validarLocalizacao(l);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						cbLocalizacao.requestFocus();
						
					}
				}
			}
		});
		DaoLocalizacao dao = new DaoLocalizacao();
		Localizacao[] lista = dao.obterLista();
		cbLocalizacao.setModel(new DefaultComboBoxModel(lista));
		cbLocalizacao.setBounds(417, 217, 160, 22);
		contentPane.add(cbLocalizacao);

		JLabel lblNewLabel_1_3_1 = new JLabel("Artigo:");
		lblNewLabel_1_3_1.setBounds(316, 167, 46, 14);
		contentPane.add(lblNewLabel_1_3_1);

		tfNumArtigo = new JTextField();
		tfNumArtigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String at = tfNumArtigo.getText();
				int artigo;

				if (at != null && at.length() != 0) {

					try {
						artigo = Integer.parseInt(at);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "numero de artigo invalido");
						tfNumArtigo.requestFocus();
						return;
					}
					
					try {
						Periodico.validarNumeroArtigo(artigo);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfNumArtigo.requestFocus();
					}
				}

			}
		});
		tfNumArtigo.setColumns(10);
		tfNumArtigo.setBounds(370, 164, 136, 20);
		contentPane.add(tfNumArtigo);
		this.setVisible(true);
	}

	public void limparFormulario() {
		tfTitulo.setText("");
		cbAno.setSelectedIndex(0);
		cbMes.setSelectedIndex(0);
		tfNumero.setText("");
		tfSubTitulo.setText("");
		tfNumArtigo.setText("");
		cbLocalizacao.setSelectedIndex(0);

	}
	
	public void preencherDados(String titulo, int ano, int mes,Localizacao localizacao, int numero,String subTitulo,int artigo) {
		tfTitulo.setText(titulo);
		cbAno.setSelectedItem(Integer.toString(ano));
		cbMes.setSelectedItem(Integer.toString(mes));
		cbLocalizacao.setSelectedItem(localizacao);
		tfNumero.setText(Integer.toString(numero));
		tfSubTitulo.setText(subTitulo);
		tfNumArtigo.setText(Integer.toString(artigo));
	}
}
