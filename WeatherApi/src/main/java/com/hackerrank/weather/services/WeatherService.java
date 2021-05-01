package com.hackerrank.weather.services;

import com.hackerrank.weather.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.model.Weather;

@Service
public class WeatherService {

  @Autowired
  WeatherRepository weatherRepository;

  public List<Weather> findAll(){
    return weatherRepository.findAll();
  }

  public Weather findById(Integer id) {
    Optional<Weather> weather = weatherRepository.findById(id);
    return weather.orElseThrow(() -> new ResourceNotFoundException());
  }

  public Weather insert(Weather weather){
    return weatherRepository.save(weather);
  }

  public void delete(Integer id) {
    try {
        weatherRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException();
    } 
  }  

}