package on.focus0147.controllers;

import jakarta.validation.Valid;
import on.focus0147.model.ClientEntity;
import on.focus0147.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "client/{id}")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService clientService){
        this.service = clientService;
    }

    @GetMapping
    public String showClient(@PathVariable("id") Long id, Model model){
        ClientEntity client = service.getById(id);
        model.addAttribute("client", client);
        return "clients/show";
    }

    @GetMapping(value = "/photo")
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("id") Long id) {
        ClientEntity client = service.getById(id);
        return client.getPhoto();
    }

    @DeleteMapping
    public String deleteClient(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping(path = "/edit/profile" )
    public String editClientForm(@PathVariable Long id, Model model){
        model.addAttribute("client", service.getById(id));
        return "clients/edit-profile";
    }

    @PutMapping
    public String editClient(@Valid @ModelAttribute("client") ClientEntity client,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Client was not saved due to validation errors.");
            model.addAttribute("client", client);
            return "clients/edit-profile";
        } else {
            model.asMap().clear();
            service.update(client);
            return "redirect:/client/" + client.getId();
        }
    }

    @GetMapping(path = "/edit/photo" )
    public String editClientPhotoForm(@PathVariable Long id, Model model){
        model.addAttribute("client", service.getById(id));
        return "clients/edit-photo";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "edit/photo")
    public String editClientPhoto(@PathVariable Long id, Model model,
                                  MultipartFile file){
        service.updatePhoto(file,id);
        return "redirect:/client/" + id;
    }
}
