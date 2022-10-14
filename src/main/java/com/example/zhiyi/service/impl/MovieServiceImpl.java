package com.example.zhiyi.service.impl;

import com.example.zhiyi.dao.MovieRepository;
import com.example.zhiyi.entity.Movie;
import com.example.zhiyi.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Resource
    private MovieRepository movieRepository;
    
    @Override
    public Movie save(Movie movie) {
        movie.setCreatedDate(new Date());
        movie.setUpdateDate(new Date());
        return this.movieRepository.save(movie);
    }
    
    @Override
    public Page<Movie> queryMovieList(Integer pageNum, Integer pageSize, String searchWord) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        Page<Movie> all = null;
        if (StringUtils.isEmpty(searchWord)) {
            all = this.movieRepository.findAll(pageable);
        }else{
            all = this.movieRepository.findByMovieNameLike(searchWord, pageable);
        }
        return all;
    }
    
}
