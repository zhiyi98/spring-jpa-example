package com.example.zhiyi.controller;

import com.example.zhiyi.entity.Movie;
import com.example.zhiyi.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Resource
    private MovieService movieService;
    
    @GetMapping("/queryMovieList")
    public Page<Movie> queryMovieList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                      @RequestParam(value = "searchWord") String searchWord) {
        Page<Movie> movieList = null;
        try {
            movieList = this.movieService.queryMovieList(pageNum, pageSize, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
    
    @PostMapping("/save")
    public Movie save(@RequestBody Movie movie) {
        Movie saveMovie = null;
        try {
            saveMovie = this.movieService.save(movie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveMovie;
    }
    
}
