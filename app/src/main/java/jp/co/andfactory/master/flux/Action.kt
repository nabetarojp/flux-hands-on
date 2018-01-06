package jp.co.andfactory.master.flux

/**
 * Created by watanabe on 2018/01/06.
 */
interface Action<out T> {
    val type: String
    val data: T
}