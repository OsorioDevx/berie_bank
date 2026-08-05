package model;
import utils.Validador;

public abstract class Pessoa {
    /*classe abstratas porque pessoa genérica não existe no banco, é cliente ou é gerente*/

    private String nome;
    private String cpf;

    /*para preencher campos neutros, pra não voltar valores nulos
    * aqui o this ta chamando outro construtor. pra evitar duplicação no código está sendo feito dessa maneira*/
    public Pessoa(){
        this("Não informado", "00000000000");
    }


    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    /*public void porque não retorna nenhum valor mas pode ser acessado de qualquer lugar*/
    public void setNome(String nome) {
        this.nome = Validador.nomeValido(nome) ? nome.trim() : "Não informado";
    }

    public void setCpf(String cpf){
        this.cpf = Validador.cpfValido(cpf) ? cpf.trim() : "00000000000";
    }


    public String getCpfMascarado(){
        String inicio = cpf.substring(0, 3);
        String fim = cpf.substring(9, 11);
        return inicio + ".***.***-" + fim;
    }


    public abstract String getDescricao();

    @Override
    public String toString() {
        return getDescricao() + "| Nome: " + getNome() + " | CPF: " + getCpfMascarado();
    }
    }
