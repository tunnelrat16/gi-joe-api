package com.tunnelrat16.gijoeapi.figure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FigureService {
  @Autowired
  private FigureRepository figureRepository;

  public Iterable<Figure> list() {
    return figureRepository.findAll();
  }

  public Optional<Figure> findById(Long id) {
    return figureRepository.findById(id);
  }

  public Figure create(Figure figure) {
    return figureRepository.save(figure);
  }

  public Optional<Figure> update(Figure figure) {
    Optional<Figure> foundFigure = figureRepository.findById(figure.getId());

    if (foundFigure.isPresent()) {
      Figure updatedFigure = foundFigure.get();
      updatedFigure.setYear(figure.getYear());
      updatedFigure.setTeam(figure.getTeam());
      updatedFigure.setVariation(figure.getVariation());
      updatedFigure.setImageUrl(figure.getImageUrl());
      updatedFigure.setOwnIt(figure.getOwnIt());
      updatedFigure.setWatchList(figure.getWatchList());
      updatedFigure.setTotal(figure.getTotal());
      updatedFigure.setNotes(figure.getNotes());
      updatedFigure.setVersion(figure.getVersion());
      updatedFigure.setVariant(figure.getVariant());

      figureRepository.save(updatedFigure);
      return Optional.of(updatedFigure);
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    figureRepository.deleteById(id);
  }
}
