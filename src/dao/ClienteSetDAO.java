package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO {
    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<Cliente>();
    }

    public Set<Cliente> getSet() {
        return set;
    }

    public void setSet(Set<Cliente> set) {
        this.set = set;
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.set.contains(cliente.getCpf())) {
            return false;
        } else {
            set.add(cliente);
            return true;
        }
    }

    @Override
    public void excluir(Long cpf) {
        if(this.set.contains(cpf)) {
            this.set.remove(cpf);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for(Cliente c : this.set) {
            if(c.equals(cliente)) {
                c = cliente;
                break;
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for(Cliente c : this.set) {
            if(c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> consultarTodos() {
        return this.set;
    }
}
