package jp.co.andfactory.master.flux

/**
 * Created by watanabe on 2018/01/06.
 * Action (Action Creator) : 特定の要求（Viewからのユーザ入力など）を処理し、その結果となるデータをStoreへと伝達する
 */
interface Action<out T> {
    val type: String
    val data: T
}