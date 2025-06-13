package on.focus0147.services;

import on.focus0147.exception.ClientNotFoundException;
import on.focus0147.model.ClientEntity;
import on.focus0147.model.forms.ClientForm;
import on.focus0147.model.forms.FileHandler;
import on.focus0147.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
         this.clientRepository = clientRepository;
    }

    public Optional<ClientEntity> getByName(String name){
        Iterator<ClientEntity> iterator = clientRepository.findByFirstName(name).iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.empty();
    }

    public List<ClientEntity> getAllSort(){
        return clientRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public ClientEntity getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(()->new ClientNotFoundException("Client with id " + id + " not found"));
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    public void update(ClientEntity client){
        var fromDb = getById(client.getId());
        fromDb.setFirstName(client.getFirstName());
        fromDb.setLastName(client.getLastName());
        fromDb.setBirthDate(client.getBirthDate());
        clientRepository.save(fromDb);
    }

    public void updatePhoto(MultipartFile file, Long id){
        var fromDb = getById(id);
        fromDb.setPhoto(FileHandler.getPhotoByte(file));
        clientRepository.save(fromDb);
    }

    public ClientEntity create(ClientForm form){
        var client = new ClientEntity();
        client.setFirstName(form.getFirstName());
        client.setLastName(form.getLastName());
        client.setBirthDate(form.getBirthDate());
        client.setPhoto(form.getPhotoByte());
        return clientRepository.save(client);
    }
}
