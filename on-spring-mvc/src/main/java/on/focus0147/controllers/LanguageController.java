package on.focus0147.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LanguageController {

    @GetMapping(path = "language")
    public String home(Model model) {
        return "language";
    }
}