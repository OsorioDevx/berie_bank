package utils;
/*InputMismatchException é usado pra tratamento de dados
* se o usuário digitar um valor do tipo String onde se espera tipo Int ele dispara um alerta*/
import java.util.InputMismatchException;
import java.util.Scanner;

/*Encapsulamento da leitura de dados
* nenhuma outra classe deve ter scanner*/

public class EntradaConsole {
    private static Scanner scanner = new Scanner(System.in);

    private EntradaConsole() {
    }

    public static String lerTexto(String mensagem) {
        String texto = "";
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            texto = scanner.nextLine();

            valido = Validador.nomeValido(texto);

            if (!valido) {
                System.out.println("Entrada vazia, digite algo");
            }

        }

        return texto.trim();
    }

    public static int lerInteiro(String mensagem) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensagem);

            /*tratamento de exceções
             * finally acontece sempre, independente de ter ocorrido ou não uma exceção
             * nesse caso está limpando o buffer do scanner*/
            try {
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite apenas números inteiros.");
            } finally {
                scanner.nextLine();
            }
        }
        return numero;
    }

    /*usado para valores monetários que vão precisar de vírgula pra ler os decimais*/
    public static double lerDecimal(String mensagem) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensagem);

            try {
                /*tenta ler o número decimal com pónto flutuante*/
                numero = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, use vírgula para decimais. Ex: 150,75");
            } finally {
                scanner.nextLine();
            }
        }
        return numero;
    }

    public static double lerValorPositivo(String mensagem) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            valor = lerDecimal(mensagem);
            valor = Validador.valorPositivo(valor);

            if (!valido) {
                System.out.println("O valor deve ser maior que zero!");
            }
        }
        return valor;

    }

    public static String lerCpf(String mensagem) {
        String cpf = "";
        boolean valido = false;

        while (!valido){
            cpf = lerTexto(mensagem);
            valido = Validador.cpfValido(cpf);

            if (!valido) {
                System.out.println("CPF inválido, digite 11 números, sem pontos ou traços");
            }

        }
        return cpf.trim();


    }

    public static void fechar() {
        scanner.close();
    }

}
