import aplicacao.ACMERobots;
import data.BaseDeDados;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        BaseDeDados dadosClientes = new BaseDeDados();
        dadosClientes.arquivoClientes();

        BaseDeDados dadosRobos = new BaseDeDados();
        dadosRobos.arquivoRobos();

        BaseDeDados dadosLocacoes = new BaseDeDados();
        dadosLocacoes.arquivoLocacoes();

        SwingUtilities.invokeLater(ACMERobots::new);

    }
}
