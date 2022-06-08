package com.tunnelrat16.gijoeapi.figure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FigureService {
  @Autowired
  private FigureRepository figureRepository;

  public Iterable<Figure> list(){
    return figureRepository.findAll();
  }

  public Optional<Figure> findById(Long id){
    return figureRepository.findById(id);
  }

  public Figure create(Figure figure) {
    return figureRepository.save(figure);
  }

  public void deleteById(Long id) {
    figureRepository.deleteById(id);
  }
}