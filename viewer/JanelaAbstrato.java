package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.CtrlAbstrato;

abstract public class JanelaAbstrato extends JFrame {

	private CtrlAbstrato ctrl;
	
	public JanelaAbstrato(CtrlAbstrato c) {
		super();
		this.ctrl = c;
	}
	
	public CtrlAbstrato getCtrl() {
		return this.ctrl;
	}
	
	public void fechar() {
		this.setVisible(false);
	}
	
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
		
	}
	
	

}
