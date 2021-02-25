package br.business;

import br.model.Cliente;
import br.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessClienteTest {

    @InjectMocks
    private ClienteBusiness clienteBusiness;
    @Mock
    private ClienteRepository clienteRepository;

    @Test(expected = Exception.class)
    public void testeIdadeValida() throws Exception {
        Cliente cliente = new Cliente("Valéria", 17, "09000201640");

        clienteBusiness.saveCliente(cliente);
    }

    @Test
    public void testeIdadeValidaMaior() throws Exception {
        Cliente cliente = new Cliente("Valéria", 18, "09000201640");

        Assertions.assertThatCode(() -> clienteBusiness.saveCliente(cliente))
                .doesNotThrowAnyException();
        Mockito.verify(clienteRepository, Mockito.times(1)).save(Mockito.any());
    }




}
