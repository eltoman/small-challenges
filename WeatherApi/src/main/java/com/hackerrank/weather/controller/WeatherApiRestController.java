package com.hackerrank.weather.controller;

import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(path="/weather")
public class WeatherApiRestController {

  @Autowired
  WeatherService weatherService;

  @GetMapping
  public ResponseEntity<List<Weather>> findAll(){
    return ResponseEntity.ok().body(weatherService.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Weather> findById(@PathVariable Integer id){
    Weather weather = weatherService.findById(id);
    return ResponseEntity.ok().body(weather);
  }

  @PostMapping
  public ResponseEntity<Weather>  insert(@RequestBody Weather weather){
    weather = weatherService.insert(weather);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(weather.getId()).toUri();
    return ResponseEntity.created(uri).body(weather);
  } 

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    weatherService.delete(id);
    return ResponseEntity.noContent().build();
  }  

}
