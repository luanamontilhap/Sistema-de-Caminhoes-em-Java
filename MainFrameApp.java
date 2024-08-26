import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe principal da interface gráfica
public class MainFrameApp extends JFrame {
    private Patio patio;
    private JTextField campoIdent;
    private JTextField campoModelo;
    private JTextField campoAno;
    private JTextField campoValor;
    private JTextField campoExtra;
    private JComboBox<String> comboTipo;
    private JTextArea areaTexto;

    public MainFrameApp() {
        patio = new Patio();
        criarIG();
    }

    private void criarIG() {
        setTitle("Pátio de Caminhões");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(7, 2, 10, 10));

        campoIdent = new JTextField();
        campoModelo = new JTextField();
        campoAno = new JTextField();
        campoValor = new JTextField();
        campoExtra = new JTextField();
        comboTipo = new JComboBox<String>(new String[]{"Plataforma", "Cegonha"});

        JButton botaoAdicionar = new JButton("Adicionar Caminhão");
        JButton botaoRemover = new JButton("Remover Caminhão");
        JButton botaoListar = new JButton("Listar Caminhões");

        painel.add(new JLabel("Identificador:"));
        painel.add(campoIdent);
        painel.add(new JLabel("Modelo:"));
        painel.add(campoModelo);
        painel.add(new JLabel("Ano:"));
        painel.add(campoAno);
        painel.add(new JLabel("Valor:"));
        painel.add(campoValor);
        painel.add(new JLabel("Tipo:"));
        painel.add(comboTipo);
        painel.add(new JLabel("Extra (Tamanho/Carga):"));
        painel.add(campoExtra);
        painel.add(botaoAdicionar);
        painel.add(botaoRemover);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane rolagem = new JScrollPane(areaTexto);

        add(painel, BorderLayout.NORTH);
        add(rolagem, BorderLayout.CENTER);

        JPanel painelListar = new JPanel();
        painelListar.add(botaoListar);
        add(painelListar, BorderLayout.SOUTH);

        botaoAdicionar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                adicionarCaminhao();
            }
        });

        botaoRemover.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                removerCaminhao();
            }
        });

        botaoListar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                listarCaminhoes();
            }
        });
    }

    private void adicionarCaminhao() {
        try {
            int ident = Integer.parseInt(campoIdent.getText());
            String modelo = campoModelo.getText();
            int ano = Integer.parseInt(campoAno.getText());
            double valor = Double.parseDouble(campoValor.getText());
            String tipo = (String) comboTipo.getSelectedItem();
            double extra = Double.parseDouble(campoExtra.getText());

            Caminhao caminhao;
            if (tipo.equals("Plataforma")) {
                caminhao = new CaminhaoPlataforma(modelo, ano, valor, ident, extra);
            } else {
                caminhao = new CaminhaoCegonha(modelo, ano, valor, ident, extra);
            }

            patio.comprarCaminhao(caminhao);
            JOptionPane.showMessageDialog(this, "Caminhão adicionado com sucesso.");
            limparCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para todos os campos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado: " + ex.getMessage());
        }
    }

    private void removerCaminhao() {
        try {
            int ident = Integer.parseInt(campoIdent.getText());
            if (patio.venderCaminhao(ident)) {
                JOptionPane.showMessageDialog(this, "Caminhão removido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Caminhão com ID " + ident + " não encontrado.");
            }
            limparCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um identificador válido.");
        }
    }

    private void listarCaminhoes() {
        areaTexto.setText(patio.imprimirAtributos());
    }

    private void limparCampos() {
        campoIdent.setText("");
        campoModelo.setText("");
        campoAno.setText("");
        campoValor.setText("");
        campoExtra.setText("");
    }
}