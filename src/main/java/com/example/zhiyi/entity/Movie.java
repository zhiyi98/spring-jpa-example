package com.example.zhiyi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "MOVIE")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "movie_seq", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "ranking")
    private Integer ranking;
    
    @Column(name = "MOVIE_NAME")
    private String movieName;
    
    @Column(name = "DIRECTOR")
    private String director;
    
    @Column(name = "RELEASE_DATE")
    @JsonFormat(pattern = "yyyy")
    @DateTimeFormat(pattern = "yyyy")
    private Date releaseDate;
    
    @Column(name = "ISSUING_REGION")
    private String issuingRegion;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "SCORE")
    private Float score;
    
    @Column(name = "NUMBER_OF_EVALUATORS")
    private Integer numberOfEvaluators;
    
    @Column(name = "HOT_REVIEWS")
    private String hotReviews;
    
    @Column(name = "COVER_POSTER")
    private String coverPoster;
    
    @Column(name = "CREATED_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    
    @Column(name = "UPDATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
