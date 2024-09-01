package com.ups.oop.services;

import com.ups.oop.dto.ClientDTO;
import com.ups.oop.entities.City;
import com.ups.oop.entities.Client;
import com.ups.oop.repository.CityRepository;
import com.ups.oop.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;

    public ClientService(ClientRepository clientRepository, CityRepository cityRepository) {
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
    }

    private List<ClientDTO> clientDTOList = new ArrayList<>();

    public ResponseEntity createClient(ClientDTO clientDTO) {
        String clientId = clientDTO.getIdClient();
        Optional<Client> clientOptional = clientRepository.findByIdClient(clientId);

        if (clientOptional.isPresent()) {
            String errorMessage = "Client with id " + clientId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            Optional<City> cityOptional = cityRepository.findByNameCity(clientDTO.getCity());

            if (cityOptional.isPresent()) {
                Client client = new Client();
                client.setIdClient(clientId);
                client.setRegistrationDate(new Date(clientDTO.getRegistrationDate()));
                client.setCiClient((clientDTO.getCiClient()));
                client.setNameClient(clientDTO.getNameClient());
                client.setLastNameClient(clientDTO.getLastNameClient());
                client.setCity(cityOptional.get());
                client.setAddress(clientDTO.getAddress());
                client.setPhoneNumber(clientDTO.getPhoneNumber());
                client.setEmail(clientDTO.getEmail());
                clientRepository.save(client);
                return ResponseEntity.status(HttpStatus.OK).body(client);
            } else {
                String errorMessage = "City don't exists.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        }
    }

    public ResponseEntity getAllClients() {
        Iterable<Client> clientIterable = clientRepository.findAll();
        List<ClientDTO> clientsList = new ArrayList<>();

            for (Client cl : clientIterable) {
                ClientDTO client = new ClientDTO(cl.getIdClient(), cl.getRegistrationDate().toString(),
                        cl.getCiClient(), cl.getNameClient(), cl.getLastNameClient(), cl.getCity().getNameCity(),
                        cl.getAddress(), cl.getPhoneNumber(), cl.getEmail());
                clientsList.add(client);
            }

            if (clientsList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clients List not found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(clientsList);
    }

    //TemplateController
    public List<ClientDTO> getClients(){
        Iterable<Client> clientIterable = clientRepository.findAll();
        List<ClientDTO> clientList = new ArrayList<>();
        for (Client cl : clientIterable) {
            ClientDTO client = new ClientDTO(cl.getIdClient(), cl.getRegistrationDate().toString(),
                    cl.getCiClient(), cl.getNameClient(), cl.getLastNameClient(), cl.getCity().getNameCity(),
                    cl.getAddress(), cl.getPhoneNumber(), cl.getEmail());
            clientList.add(client);
        }
        return clientList;
    }


    public ResponseEntity getClientById(String clientId){
        Optional<Client> clientOptional = clientRepository.findByIdClient(clientId);

        if(clientOptional.isPresent()){
            Client clientFound = clientOptional.get();
            ClientDTO client = new ClientDTO(
                    clientFound.getIdClient(),clientFound.getRegistrationDate().toString(),
                    clientFound.getCiClient(),clientFound.getNameClient(),clientFound.getLastNameClient(),
                    clientFound.getCity().getNameCity(),clientFound.getAddress(),clientFound.getPhoneNumber(),
                    clientFound.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }else{
            String errorMessage = "Clients with id " + clientId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateClient(ClientDTO clientDTO){
        String clientId = clientDTO.getIdClient();
        Optional<Client> clientOptional = clientRepository.findByIdClient(clientId);

        if (clientOptional.isPresent()) {
            Optional<City> cityOptional = cityRepository.findByNameCity(clientDTO.getCity());
            if (cityOptional.isPresent()) {
                Client client = new Client();
                client.setIdClient(clientId);
                client.setRegistrationDate(new Date(clientDTO.getRegistrationDate()));
                client.setCiClient((clientDTO.getCiClient()));
                client.setNameClient(clientDTO.getNameClient());
                client.setLastNameClient(clientDTO.getLastNameClient());
                client.setCity(cityOptional.get());
                client.setAddress(clientDTO.getAddress());
                client.setPhoneNumber(clientDTO.getPhoneNumber());
                client.setEmail(clientDTO.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(client);
            } else {
                String errorMessage = "City don't exists.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client with id " + clientId + " doesn't exits");
        }
    }

    public ResponseEntity deleteClient(String id){
        String message = "Client with id " + id;
        Optional<Client> clientOptional = clientRepository.findByIdClient(id);

        if(clientOptional.isPresent()){
            clientRepository.delete((clientOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }

}
