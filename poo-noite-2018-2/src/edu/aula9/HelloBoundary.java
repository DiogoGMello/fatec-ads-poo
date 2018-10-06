package edu.aula9;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class HelloBoundary implements ActionListener {
	private JLabel lblTexto;
	private String estado;
	public HelloBoundary() { 
		JFrame janela = new JFrame("Teste de Bot�o");
		JPanel painel = new JPanel();
		lblTexto = new JLabel("Texto para ser mudado");
		JButton btn1 = new JButton("Bot�o 1");
		JButton btn2 = new JButton("Bot�o 2");
		painel.add(lblTexto);
		painel.add(btn1);
		painel.add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		janela.setContentPane(painel);
		janela.setSize(400, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
//		if ("aperte aqui".equals(estado)) { 
//			estado = "Bot�o apertado";
//		} else {
//			estado = "aperte aqui";
//		}
//		lblTexto.setText(estado);
		if ("Bot�o 1".equals(cmd)) { 
			lblTexto.setText("Apertado pelo Bot�o 1");
		} else { 
			lblTexto.setText("Apertado pelo Bot�o 2");
		}
	}
	
	public static void main(String[] args) {
		new HelloBoundary();
	}
}
