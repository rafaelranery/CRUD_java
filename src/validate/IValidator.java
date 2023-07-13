package validate;

public interface IValidator {

    public Boolean isOpcaoValida(String opcao);
    public Boolean isCadastro(String opcao);
    public Boolean isConsulta(String opcao);
    public Boolean isExclusao(String opcao);
    public Boolean isAlteracao(String opcao);
    public Boolean isSair(String opcao);
    public Boolean isCamposValidos(String ...campos);
}
