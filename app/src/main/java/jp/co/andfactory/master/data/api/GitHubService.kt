package jp.co.andfactory.master.data.api

import io.reactivex.Single
import jp.co.andfactory.master.data.entity.Readme
import jp.co.andfactory.master.data.entity.Repo
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by watanabe on 2018/01/06.
 */
interface GitHubService {

    @GET("/users/{username}/repos")
    fun getUserRepos(@Path("username") user: String): Single<List<Repo>>

    @GET("/repos/{owner}/{repo}/readme")
    fun getReadme(@Path("owner") owner: String, @Path("repo") repo: String): Single<Readme>

}