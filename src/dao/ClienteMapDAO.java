package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {
    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<Long, Cliente>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())) {
            return false;
        } else {
            map.put(cliente.getCpf(), cliente);
            return true;
        }
    }

    @Override
    public void excluir(Long cpf) {
        if(this.map.containsKey(cpf)) {
            this.map.remove(cpf);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if(clienteCadastrado != null) {
            this.map.replace(clienteCadastrado.getCpf(), cliente);
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> consultarTodos() {
        return this.map.values();
    }
}
