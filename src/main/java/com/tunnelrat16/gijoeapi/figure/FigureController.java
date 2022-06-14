package com.tunnelrat16.gijoeapi.figure;

import java.util.Map;
import java.util.HashMap;

import com.tunnelrat16.gijoeapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/gijoe")
public class FigureController {
    @Autowired
    private FigureService figureService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Figure>> list() {
        Iterable<Figure> figures = figureService.list();
        return createHashPlural(figures);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Figure> read(@PathVariable Long id) {
        Figure figure = figureService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No figure with that ID"));
        return createHashSingular(figure);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Figure> create(@Validated @RequestBody Figure figure) {
        Figure createdResource = figureService.create(figure);
        return createHashSingular(createdResource);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Figure> update(@RequestBody Figure figure, @PathVariable Long id) {
      Figure updatedResource = figureService
        .update(figure)
        .orElseThrow(() -> new ResourceNotFoundException("No figure with that ID"));
  
      return createHashSingular(updatedResource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        figureService.deleteById(id);
    }

    private Map<String, Figure> createHashSingular(Figure figure) {
        Map<String, Figure> response = new HashMap<String, Figure>();
        response.put("figure", figure);

        return response;
    }

    private Map<String, Iterable<Figure>> createHashPlural(Iterable<Figure> figures) {
        Map<String, Iterable<Figure>> response = new HashMap<String, Iterable<Figure>>();
        response.put("figures", figures);

        return response;
    }
}
