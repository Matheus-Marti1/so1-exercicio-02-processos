package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kCont = new KillController();
		
		int opc = 0;
		while (opc != 9) {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite uma opção:\n1 - Listar processos\n2 - Matar um processo por PID\n3 - Matar processo por nome\n9 - Sair"));
				switch (opc) {
				case 1:
					kCont.listaProcessos();
					break;
				case 2:
					int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite um PID para matar o processo:"));
					kCont.mataPid(pid);
					break;
				case 3:
					String nomeProcesso = JOptionPane.showInputDialog("Digite o nome completo do processo para matar:");
					kCont.mataNome(nomeProcesso);
					break;
				case 9:
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
			}
		}

	}

}
