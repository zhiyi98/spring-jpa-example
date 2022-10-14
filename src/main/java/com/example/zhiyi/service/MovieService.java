package com.example.zhiyi.service;

import com.example.zhiyi.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MovieService {
    
    Movie save(Movie movie);
    
    Page<Movie> queryMovieList(Integer pageNum, Integer pageSize, String searchWord);
}
