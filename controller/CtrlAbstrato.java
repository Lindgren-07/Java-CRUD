package controller;

abstract public class CtrlAbstrato {
	
	private CtrlAbstrato ctrl;
	
	public CtrlAbstrato(CtrlAbstrato c) {
		this.ctrl = c;
		this.iniciar();
	}
	
	public CtrlAbstrato getCtrlPai() {
		return this.ctrl;
	}
	
	public abstract void iniciar();
	
	public abstract void encerrar();

}
