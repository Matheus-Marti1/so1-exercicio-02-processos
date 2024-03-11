package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	@SuppressWarnings("deprecation")
	public void listaProcessos() {
		String os = os();
		if (os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void mataPid (int pid) {
		String os = os();
		if (os.contains("Windows")) {
			String cmdPid = "TASKKILL /PID";
			StringBuffer buffer = new StringBuffer();
			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			String cmdPid = "kill -9";
			StringBuffer buffer = new StringBuffer();
			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void mataNome (String nomeProcesso) {
		String os = os();
		if (os.contains("Windows")) {
			String cmdPid = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();
			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(nomeProcesso);
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			String cmdPid = "pkill -f";
			StringBuffer buffer = new StringBuffer();
			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(nomeProcesso);
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
