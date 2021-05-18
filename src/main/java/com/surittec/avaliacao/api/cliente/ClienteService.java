package com.surittec.avaliacao.api.cliente;

import com.surittec.avaliacao.api.config.MessageConfig;
import com.surittec.avaliacao.api.exception.ClienteNotFoundException;
import com.surittec.avaliacao.api.exception.InvalidTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final MessageConfig message;
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> lista() {
        return clienteRepository.findAll();
    }

    public Cliente busca(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException(message.getMessage001()));
    }

    @Transactional
    public ResponseEntity<Cliente> insere(Cliente cliente) {
        if (nonNull(cliente.getId())) {
            throw new InvalidTypeException(message.getMessage002());
        }
        setCliente(cliente);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    public ResponseEntity<Cliente> atualiza(Long clienteId, Cliente cliente) {
        busca(clienteId);
        setCliente(cliente);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @Transactional
    public ResponseEntity<Void> exclui(Long clienteId) {
        busca(clienteId);
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }

    private void setCliente(Cliente cliente) {
        cliente.getEmails().forEach(item -> item.setCliente(cliente));
        cliente.getTelefones().forEach(item -> item.setCliente(cliente));
    }

}
