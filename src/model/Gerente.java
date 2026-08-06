package model;

public class Gerente extends Pessoa {
    /*também herda cpf e data de pessoa.java só que oferece benefícios de administrador para o gerente*/

    private String matricula;
    private double limiteAutorizacao;


    public Gerente() {
        this("Não informado", "00000000000" , "0000");
    }

    public Gerente(String nome, String cpf, String matricula) {
        this(nome, cpf, matricula, 5000.0);
    }

    public Gerente (String nome, String cpf, String matricula, double limiteAutorizacao) {
        super(nome, cpf);
        setMatricula(matricula);
        setLimiteAutorizacao(limiteAutorizacao);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        boolean valida = matricula != null && !matricula.trim().isEmpty();
        this.matricula = valida ? matricula.trim() : "0000";
    }

    public double getLimiteAutorizacao() {
        return limiteAutorizacao;
    }

    public void setLimiteAutorizacao(double limiteAutorizacao) {
        this.limiteAutorizacao = limiteAutorizacao > 0 ? limiteAutorizacao : 0;
    }

    public boolean podeAutorizar(double valor) {
        return valor > 0 && valor <= limiteAutorizacao;
    }

    @Override
    public String getDescricao() {
        return "[GERENTE" + matricula + "]";
    }
}
