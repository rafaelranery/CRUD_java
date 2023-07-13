package validate;

public class Validator implements IValidator {
    @Override
    public Boolean isOpcaoValida(String opcao) {
        switch (opcao) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                return true;
            default:
                return false;
        }
    }
    @Override
    public Boolean isCadastro(String opcao) {
        if("1".equals(opcao)) {
            return true;
        }
        return false;
    }
    @Override
    public Boolean isConsulta(String opcao) {
        if("2".equals(opcao)) {
            return true;
        }
        return false;
    }
    @Override
    public Boolean isExclusao(String opcao) {
        if("3".equals(opcao)) {
            return true;
        }
        return false;
    }
    @Override
    public Boolean isAlteracao(String opcao) {
        if("4".equals(opcao)) {
            return true;
        }
        return false;
    }
    @Override
    public Boolean isSair(String opcao) {
        if("5".equals(opcao)) {
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean isCamposValidos(String ...campos) {
        for(String campo : campos) {
            if(campo == null || campo.equals("")) {
                return false;
            }
        }
        return true;
    }
}
