package com.tunnelrat16.gijoeapi.figure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureRepository extends CrudRepository<Figure, Long> {}