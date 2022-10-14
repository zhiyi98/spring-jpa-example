package com.example.zhiyi.dao;

import com.example.zhiyi.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    
    @Query("select m from Movie m where m.movieName like :movieName")
    Page<Movie> findByMovieNameLike(@Param("movieName") String movieName, Pageable pageable);
    
    @Query("select m from Movie m")
    Page<Movie> findAll(Pageable pageable);
}
