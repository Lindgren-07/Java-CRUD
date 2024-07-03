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
import controller.CtrlAdicionarLivro;
import controller.CtrlAlterarLivro;
import model.Livro;
import model.Localizacao;
import model.ModelException;
import model.dao.DaoLocalizacao;

public class JanelaLivro extends JanelaAbstrato {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfIsbn;
	private JTextField tfAutor;
	private JComboBox cbAno;
	private JComboBox cbMes;
	private JComboBox cbLocalizacao;

	/**
	 * Create the frame.
	 */
	public JanelaLivro(CtrlAbstrato c) {
		super(c);
		setTitle("Livro");
		
		setBounds(100, 100, 908, 490);
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

		JLabel lblNewLabel_1_2 = new JLabel("ISBN:");
		lblNewLabel_1_2.setBounds(316, 64, 46, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Autor:");
		lblNewLabel_1_3.setBounds(316, 110, 46, 14);
		contentPane.add(lblNewLabel_1_3);

		tfTitulo = new JTextField();
		tfTitulo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String titulo = tfTitulo.getText();
				
				if(titulo != null && titulo.length() != 0) {
					
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

		tfIsbn = new JTextField();
		tfIsbn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String isbn = tfIsbn.getText();
				
				if(isbn != null && isbn.length() != 0) {
					
					try {
						Livro.validarIsbn(isbn);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfIsbn.requestFocus();
					}
					
				}
			}
		});
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(370, 61, 136, 20);
		contentPane.add(tfIsbn);

		tfAutor = new JTextField();
		tfAutor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String autor = tfAutor.getText();
				
				if(autor != null && autor.length() != 0) {
					
					try {
						Livro.validarAutor(autor);
					} catch (ModelException me) {
						JOptionPane.showMessageDialog(null, me.getMessage());
						tfAutor.requestFocus();
					}
				}
			}
		});
		tfAutor.setColumns(10);
		tfAutor.setBounds(370, 107, 136, 20);
		contentPane.add(tfAutor);

		cbAno = new JComboBox();
		cbAno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String anoAux = (String)cbAno.getSelectedItem();
				int ano;
				
				ano = Integer.parseInt(anoAux);
				
				
				
				
				if(!anoAux.equals("0")) {
					
					try {
						Livro.validarAnoPublicacao(ano);
					} catch (ModelException me) {
						
						JOptionPane.showMessageDialog(null, me.getMessage());
						cbAno.requestFocus();
						
					}
				}
			}
		});
		cbAno.setModel(new DefaultComboBoxModel(new String[] { "0", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
		cbAno.setBounds(165, 106, 82, 22);
		contentPane.add(cbAno);

		cbMes = new JComboBox();
		cbMes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String mesAux = (String)cbAno.getSelectedItem();
				int mes;
				
				mes = Integer.parseInt(mesAux);
				
				
				
				
				if(!mesAux.equals("0")) {
					
					try {
						Livro.validarAnoPublicacao(mes);
					} catch (ModelException me) {
						
						JOptionPane.showMessageDialog(null, me.getMessage());
						cbAno.requestFocus();
						
					}
				}
				
			}
		});
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
				int ano;
				int mes;
				String isbn = tfIsbn.getText();
				String autor = tfAutor.getText();
				Localizacao localizacao = (Localizacao) cbLocalizacao.getSelectedItem();

				try {
					ano = Integer.parseInt(anoAux);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero do ano invalido: " + anoAux);
					return;
				}

				try {
					mes = Integer.parseInt(mesAux);
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Numero do mes invalido: " + mesAux);
					return;
				}
				
				if(getCtrl() instanceof CtrlAdicionarLivro) {
					CtrlAdicionarLivro ctrl = (CtrlAdicionarLivro)getCtrl();
					ctrl.adicionarLivro(titulo, ano, mes, localizacao, isbn, autor);
				}
				else if(getCtrl() instanceof CtrlAlterarLivro) {
					CtrlAlterarLivro ctrl = (CtrlAlterarLivro)getCtrl();
					ctrl.alterarLivro(titulo, ano, mes, localizacao, isbn, autor);
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
		lblNewLabel_2.setBounds(316, 167, 58, 14);
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
		cbLocalizacao.setBounds(413, 163, 160, 22);
		contentPane.add(cbLocalizacao);
		this.setVisible(true);
	}

	public void limparFormulario() {
		tfTitulo.setText("");
		cbAno.setSelectedIndex(0);
		cbMes.setSelectedIndex(0);
		tfIsbn.setText("");
		tfAutor.setText("");
		cbLocalizacao.setSelectedIndex(0);

	}
	
	public void preencherDados(String titulo, int ano, int mes, Localizacao localizacao, String isbn, String autor) {
		tfTitulo.setText(titulo);
		cbAno.setSelectedItem(Integer.toString(ano));
		cbMes.setSelectedItem(Integer.toString(mes));
		cbLocalizacao.setSelectedItem(localizacao);
		tfIsbn.setText(isbn);
		tfAutor.setText(autor);
	}
}
