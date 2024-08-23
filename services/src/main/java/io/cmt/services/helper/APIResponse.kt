package io.cmt.services.helper

class APIResponse<T> {
    var err_code: String? = null
    var error_code: String? = null
    var message: String? = null
    var data: T? = null
    var status: String? = null
    var balance: String? = null
}