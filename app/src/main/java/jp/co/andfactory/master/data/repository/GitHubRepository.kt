package jp.co.andfactory.master.data.repository

import jp.co.andfactory.master.data.api.GitHubService
import javax.inject.Inject

/**
 * Created by watanabe on 2018/01/06.
 */
class GitHubRepository @Inject constructor(private val gitHubService: GitHubService) {

    fun fetchUserRepos(userName: String) = gitHubService.getUserRepos(userName)

    fun fetchReadme(userName: String, repoName: String) = gitHubService.getReadme(userName, repoName)

}