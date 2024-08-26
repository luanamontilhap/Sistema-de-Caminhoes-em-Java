
import java.util.ArrayList;
import java.util.List;

class Patio {
    private List<Caminhao> caminhões;

    public Patio() {
        caminhões = new ArrayList<Caminhao>();
    }

    public void comprarCaminhao(Caminhao caminhao) {
        caminhões.add(caminhao);
        System.out.println("Caminhão adicionado com sucesso! " + caminhao);
    }

    public boolean venderCaminhao(int ident) {
        for (int i = 0; i < caminhões.size(); i++) {
            Caminhao caminhao = caminhões.get(i);
            if (caminhao.getIdent() == ident) {
                caminhões.remove(i);
                System.out.println("Caminhão removido do pátio: " + caminhao);
                return true;
            }
        }
        System.out.println("Caminhão com ID " + ident + " não encontrado no pátio.");
        return false;
    }

    public String imprimirAtributos() {
        StringBuilder detalhes = new StringBuilder();
        if (caminhões.size() == 0) {
            detalhes.append("O pátio está vazio.\n");
        } else {
            detalhes.append("Atributos dos caminhões:\n");
            for (Caminhao caminhao : caminhões) {
                detalhes.append(caminhao).append("\n");
            }
        }
        return detalhes.toString();
    }}
