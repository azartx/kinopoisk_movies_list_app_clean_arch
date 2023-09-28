package com.solo4.kinoapp.data.datasource

import com.solo4.kinoapp.data.model.moviesentity.Docs
import com.solo4.kinoapp.data.model.moviesentity.MoviesEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("/v1.3/movie")
    fun getMovies(@Query("page") page: Int, @Query("limit") limit: Int): Single<MoviesEntity>

    @GET("/v1.3/movie/{movieId}")
    fun getMovieById(@Path("movieId") movieId: Int): Single<Docs>
}
