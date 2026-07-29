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


    public static boolean cpfValido(String cpf) {
        if (cpf == null ){

        }
    }
}
