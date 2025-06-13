package on.focus0147.controllers;

import jakarta.validation.Valid;
import on.focus0147.model.ClientEntity;
import on.focus0147.model.forms.ClientForm;
import on.focus0147.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/clients")
public class ClientsController {

    private final ClientService service;

    @Autowired
    public ClientsController(ClientService clientService){
        this.service = clientService;
    }

    @GetMapping
    public String getAll(Model model){
        List<ClientEntity> list = service.getAllSort();
        model.addAttribute("clients",list);
        return "clients/list";
    }


    @GetMapping(path = "/create" )
    public String createClientForm(Model model){
        model.addAttribute("client", new ClientForm());
        return "clients/create";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createClient(Model model,
                               @Valid @ModelAttribute("client") ClientForm form,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("message", "Client was not saved due to validation errors.");
            model.addAttribute("client", form);
            return "clients/create";
        }
        model.asMap().clear();
        var created = service.create(form);
        return "redirect:client/" + created.getId();
    }
}
