package model;

public class Cliente extends Pessoa {


    /*reaproveita nome e cpf da pessoa.java e adiciona só as permissões que o cliente deve ter*/
    private String dataCadastro;

    /*construtor padrão*/
    public Cliente() {
        this("Não informado", "00000000000");
    }

    /*super chama o construtor da classe pai, ou seja, da classe que eu estou herdando que no caso
    * é PÉSSOA*/
    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.dataCadastro = "Não informada";
    }

    public String getDataCadastro(){
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public String getCategoria(double saldoTotal) {
        return saldoTotal > 1000 ? "Premiun" : "Padrão";
    }

    @Override
    public String getDescricao() {
        return "[CLIENTE]";
    }


}
