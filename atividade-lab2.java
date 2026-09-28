import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de produtos (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        // Vetores simples para armazenar os dados dos produtos
        int[] codigos = new int[n];
        String[] descricoes = new String[n];
        double[] precos = new double[n];

        // Cadastro dos produtos
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Cadastro do Produto " + (i + 1) + " ---");
            System.out.print("Código: ");
            codigos[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Descrição: ");
            descricoes[i] = scanner.nextLine();

            System.out.print("Preço: ");
            precos[i] = scanner.nextDouble();
        }

        System.out.print("\nInforme o código do produto para pesquisar: ");
        int codigoProcurado = scanner.nextInt();

        // -------------------------------------------------------------
        // a) PESQUISA LINEAR
        // -------------------------------------------------------------
        int compLinear = 0;
        boolean achouLinear = false;

        for (int i = 0; i < n; i++) {
            compLinear++; // Conta cada comparação feita no 'if'
            if (codigos[i] == codigoProcurado) {
                System.out.println("\n[Pesquisa Linear] Produto encontrado!");
                System.out.println("Código: " + codigos[i] + " | Descrição: " + descricoes[i] + " | Preço: R$ " + precos[i]);
                achouLinear = true;
                break; // Para o laço assim que encontra
            }
        }

        if (!achouLinear) {
            System.out.println("\n[Pesquisa Linear] Produto não encontrado.");
        }
        System.out.println("Quantidade de comparações (Linear): " + compLinear);

        // -------------------------------------------------------------
        // ORDENAÇÃO (Bubble Sort)
        // A Pesquisa Binária EXIGE que o vetor esteja ordenado por código!
        // -------------------------------------------------------------
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (codigos[j] > codigos[j + 1]) {
                    // Troca os códigos
                    int auxCodigo = codigos[j];
                    codigos[j] = codigos[j + 1];
                    codigos[j + 1] = auxCodigo;

                    // Troca as descrições para manter o alinhamento dos dados
                    String auxDesc = descricoes[j];
                    descricoes[j] = descricoes[j + 1];
                    descricoes[j + 1] = auxDesc;

                    // Troca os preços para manter o alinhamento dos dados
                    double auxPreco = precos[j];
                    precos[j] = precos[j + 1];
                    precos[j + 1] = auxPreco;
                }
            }
        }

        // -------------------------------------------------------------
        // b) PESQUISA BINÁRIA
        // -------------------------------------------------------------
        int inicio = 0;
        int fim = n - 1;
        int compBinaria = 0;
        boolean achouBinaria = false;

        while (inicio <= fim) {
            compBinaria++; // Conta a comparação do 'if' principal
            int meio = (inicio + fim) / 2;

            if (codigos[meio] == codigoProcurado) {
                System.out.println("\n[Pesquisa Binária] Produto encontrado!");
                System.out.println("Código: " + codigos[meio] + " | Descrição: " + descricoes[meio] + " | Preço: R$ " + precos[meio]);
                achouBinaria = true;
                break;
            }

            if (codigos[meio] < codigoProcurado) {
                inicio = meio + 1; // Procura na metade da direita
            } else {
                fim = meio - 1;    // Procura na metade da esquerda
            }
        }

        if (!achouBinaria) {
            System.out.println("\n[Pesquisa Binária] Produto não encontrado.");
        }
        System.out.println("Quantidade de comparações (Binária): " + compBinaria);

        scanner.close();
    }
}