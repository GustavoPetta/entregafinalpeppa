package br.usjt.temprevisao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.usjt.temprevisao.model.Tempo;
import br.usjt.temprevisao.service.TemposService;

import java.util.List;


@SuppressWarnings("unused")
@Controller
public class TemposController {

//    @Autowired
//    private PeriodosRepository repository;

//    @Autowired
//    public PeriodosController(PeriodosRepository repository) {
//        this.repository = repository;
//    }
//
//    @Autowired
//    public void setRepository(PeriodosRepository repository){
//        this.repository = repository;
//    }

    @Autowired
    private TemposService temposService;
    
    /*------------------------------------------------Model and View-----------------------------------------------------------------*/

    @GetMapping("/tempo")
    public ModelAndView listarPeriodos() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
        List<Tempo> tempos = temposService.listarTodos();
        mv.addObject("tempos", tempos);
       return mv;
    }
    /*------------------------------------------------Buscas-----------------------------------------------------------------*/
      @PostMapping("/buscarCidade")
    public ModelAndView buscarCidade(String nome){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
           List<Tempo> tempos = temposService.buscarCidade(nome);
        //Future<List<Tempo>> tempos = peridosService.buscarCidade(nome);
        mv.addObject("tempos", tempos);
        return mv;
    }

    @PostMapping("/buscarLateLon")
    public ModelAndView buscarLateLon(Double lat, Double lon){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        List<Tempo> tempos = temposService.buscarLateLon(lat,lon);
        mv.addObject("tempos", tempos);
        return mv;
    }
    
    //Salvar Tempo

   /* @PostMapping("/salvarTempo")
    public ModelAndView Home() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
        List<Tempo> tempos = temposService.salvar();
        mv.addObject("tempos", tempos);
        return mv;
    }
    */
    
   /* @PostMapping("/salvarTempo")
    public String addUser(Tempo tempo) {

         temposService.salvar(tempo); 
         return "Sucesso";
     
    }*/
    
    @PostMapping("/salvarTempo")
    public String salvarTempo(@RequestBody Tempo tempo){
       temposService.salvar(tempo);
    return "Sucesso";
    }
}
