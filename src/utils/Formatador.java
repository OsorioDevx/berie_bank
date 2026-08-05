package utils;

public class Formatador {

    /*mais umna vez, assim como o validador e as outras classes do diretório utils, são utilitários, então
    * nenhuma outra classe precisa herdar ou criar algum objeto baseado nessa classe, por isso é priuate*/
    private Formatador(){

    }

        public static String moeda(double valor) {
            boolean negativo = valor < 0;

            /*ternário de if e else, validação rápida em uma linha*/
            /*não vou usar a validação do math.abs só a validação lógica mesmo
            * nesse if e else se o valor for true (-valor) se for false (valor)
            * vai retirar o sinal de negativo pra obter o valor absoluto*/
            double absoluto = negativo ? -valor : valor;

            /*o long em parêntes é pra fazer o Java realizar o cast de qualquer forma
            * cast é quando você converte um tipo de dado para outro
            * nesse caso eu forcei para que a variável totalCentavos fosse convertida de double para long
            * o +0.5 é pra tenmtar fazer um arredondamento do valor*/
            long totalCentavos = (long) (absoluto * 100 + 0.5);
            long parteInteira = totalCentavos / 100;
            /*a ideia aqui é quebrar em duas partes o valor absoluto, em reais e centavos*/
            long centavos = totalCentavos % 100;

            /*lógica pra que os centavos semore tenha dois dígitos tipo 10.05*/
            String centavosTexto = centavos < 10 ? "0" + centavos : "" + centavos;

            String inteiraTexto = inserirSeparadorMilhar(parteInteira);

            String sinal = negativo ? "-": "";
            return sinal + "R$ " + inteiraTexto + "," + centavosTexto;

        }

        private static String inserirSeparadorMilhar(long numero){
            String digitos = "" + numero;
            String resultado = "";
            int contador = 0;

            for (int i = digitos.length() -1; i >= 0; i--){
                resultado = digitos.charAt(i) + resultado;
                contador ++;

                boolean precisaPonto = contador % 3 == 0 && i != 0;
                if (precisaPonto) {
                    resultado = "." + resultado;
                }


            }
            return resultado;
        }

        public static String linha(String rotulo, String valor){
            return rotulo + ": " + valor;
        }
    }



