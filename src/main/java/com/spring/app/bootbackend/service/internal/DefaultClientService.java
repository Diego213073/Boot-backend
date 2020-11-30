package com.spring.app.bootbackend.service.internal;

import com.spring.app.bootbackend.model.Client;
import com.spring.app.bootbackend.repository.CLientRepository;
import com.spring.app.bootbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

@Service
public class DefaultClientService implements ClientService {

    private final CLientRepository cLientRepository;

    @Autowired
    public DefaultClientService(CLientRepository cLientRepository) {
        this.cLientRepository = cLientRepository;
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) cLientRepository.findAll();
    }

    @Override
    public void createClient(Client client) {
        cLientRepository.save(setField.apply(client));
    }

    private Function<Client,Client> setField = cl -> {
        if (Objects.isNull(cl.getId())) {
            cl.setId(UUID.randomUUID().toString());
            cl.setCreateAt(LocalDate.now());
        }
        cl.setCreateAt(LocalDate.now());
        return cl;
    };

    @Override
    public Client findById(String id) {
        return cLientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteClient(String id) {
        cLientRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cLientRepository.deleteAll();
    }
}
