package br.Controllers;

import br.business.ClienteBusiness;
import br.model.Cliente;
import br.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.lang.*;
import java.util.Optional;




@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteBusiness clienteBusiness;


    //Tipo e end point da API
//    @GetMapping("/clientes")
//    //Retorno do metodo, nome do mesmo, parametro para manipular no metodo
//    public ResponseEntity<List<Cliente>> getAllClientes(){
//        try {
//            // Objeto de array do tipo listado
//            List<Cliente> clientes = clienteRepositry.findAll();
//
//            if (clientes.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(clientes, HttpStatus.OK);
//        } catch(Exception e){
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/clientes/{id}")
//    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long id) {
//        Optional<Cliente> clienteData = clienteRepositry.findById(id);
//        if(clienteData.isPresent()){
//            return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

   @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
          try {
             Cliente clienteNovo = clienteBusiness.saveCliente(cliente);
              return new ResponseEntity<>(clienteNovo, HttpStatus.CREATED);
          } catch (Exception e){
//              return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
              e.printStackTrace();
             return null;
          }
    }


//    @PutMapping("/clientes/{id}")
//    public ResponseEntity<Cliente> updateCliente(@PathVariable ("id") long id, @RequestBody Cliente cliente) {
//        Optional<Cliente> clienteData = clienteRepositry.findById(id);
//        if (clienteData.isPresent()){
//            return new ResponseEntity<>(clienteRepositry.save(cliente), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//   @DeleteMapping("/clientes/{id}")
//    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") long id) {
//        try {
//            clienteRepositry.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}