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
        Cliente c = consultar(cpf);
        
        if(this.set.contains(c)) {
            this.set.remove(c);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for(Cliente c : this.set) {
            if(c.equals(cliente)) {
                c.setNome(cliente.getNome());
                c.setCpf(cliente.getCpf());
                c.setTel(cliente.getTel());
                c.setEnd(cliente.getEnd());
                c.setNumero(cliente.getNumero());
                c.setCidade(cliente.getCidade());
                c.setEstado(cliente.getEstado());
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
