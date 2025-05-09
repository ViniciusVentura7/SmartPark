package br.com.smartpark.smartpark;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @GetMapping("/vagas")
    public String listVagas(){
        return "Lista de vagas disponíveis";
    }

}
