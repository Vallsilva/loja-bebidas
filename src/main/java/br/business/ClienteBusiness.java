package br.business;


import br.model.Cliente;
import br.repository.ClienteRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteBusiness {

    @Autowired
    private ClienteRepository clienteRepositry;

    public Cliente saveCliente(Cliente cliente) throws Exception {
        if(cliente.getIdade() < 18){
            throw new Exception("Cliente não tem mais de 18 anos");
        }
        return clienteRepositry.save(cliente);
    }
}
