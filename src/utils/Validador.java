package utils;
/*pra centralizar as validações do sistema
* não guarda estado, é um conjunto de regras
* chama direto pela classe: Validador.nomeValido("Matheus")*/

/*classe de utilitários é private, não precisa de instancia e não vai ser criado nenhum objeto a partir dela*/
public class Validador {
    private Validador(){

    }

    public static boolean nomeValido(String nome){
        return nome != null && !nome.trim().isEmpty(); /*trim remove os espaços em brancos, isEMpty retorna true
        se a string estiver vazia, vê se ainda sobrou algo mesmo passando por nome !=null
        validação trim + isEmpty*/
    }

    /*Só é possível chamar essas classes diretamente sem criar nenhum objeto porque elas são static, não guardam estado*/
    public static boolean cpfValido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()){
            return false;
        }

        String limpo = cpf.trim();

        if (limpo.length() != 11) {
            return false;
        }

        /*aqui só vai faltar uma validação que vou implementar depois que verifica os dois últimos
         * dígitos que são baseados nos 9 primeiros, nesse estado atual se alguém digitar 11111111111
         * ele considera como um cpf válido*/
        for (int i = 0; i < limpo.length(); i++) {
            char caractere = limpo.charAt(i);
            if (caractere < '0' || caractere > '9'){
                return false;

            }
        }
        return true;
    }

    /*saque. depósito, investimento, tudo tem que ser >0*/
    public static boolean valorPositivo(double valor) {
        return valor > 0;
    }
}
