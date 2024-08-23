package io.cmt.helper

import io.cmt.services.model.BankDetailsModel
import io.cmt.services.model.UserModel

interface IConstants {
    object IntentStrings {
        const val type = "type"
        const val is_nested = "is_nested"
        const val userId = "userId"
        const val mobileNum = "mobileNum"
    }

    object FragmentTypes {
        const val login = "login"
        const val register = "register"
        const val otp = "otp"
        const val forgotPassword = "forgotPassword"
        const val changePassword = "changePassword"
        const val main = "main"
        const val home = "home"
        const val bank_details = "bank_details"
        const val faq = "faq"
        const val deposit = "deposit"
        const val params = "params"
        const val privacyPolicy = "privacyPolicy"
        const val termsConditions = "termsConditions"
        const val refundPolicy = "refundPolicy"
        const val cancellationPolicy = "cancellationPolicy"
        const val dream_bike = "dream_bike"
        const val contactUs = "contactUs"
        const val editProfile = "editProfile"
        const val withdraw = "withdraw"
    }

    object Defaults {
        const val request_from = "service_vendor_android_app"
        const val forgot_password = "forgot_password"
        const val registration = "registration"
        const val throughLogin = "throughLogin"
        const val throughRegister = "throughRegister"
    }

    object FileUploadType {
        const val aadharFrontImage = "aadhar_front_image"
        const val aadharBackImage = "aadahar_back_image"
        const val panCard = "pan_card"
        const val uploadUserImage = "upload_user_image"
        const val recieptImage = "reciept_image"
    }


    object Pref {
        const val shared_preference = "shared_preference"
        const val auth_token = Params.access_token
        const val user_id = Params.user_id
        const val payment_status = Params.payment_status
    }

    object Params {
        const val user_name = "username"
        const val password = "password"
        const val old_password = "old_password"
        const val payment_status = "payment_status"
        const val request_from = "request_from"
        const val version_code = "version_code"
        const val access_token = "access_token"
        const val image = "image"
        const val name = "name"
        const val phone = "phone"
        const val bank_name = "bank_name"
        const val account_holder_name = "account_holder_name"
        const val account_no = "account_no"
        const val ifsc_code = "ifsc_code"
        const val otp = "otp"
        const val username = "username"
        const val user_id = "user_id"
        const val question = "question"
        const val email = "email"
        const val message = "message"
        const val mobile = "mobile"
        const val aadhar_no = "aadhar_no"
        const val aadhar_front_image = "aadhar_front_image"
        const val aadhar_front_page = "aadhar_front_page"
        const val aadhar_back_image = "aadhar_back_image"
        const val aadhar_back_page = "aadhar_back_page"
        const val pan_no = "pan_no"
        const val pan_image = "pan_image"
        const val profile_image = "profile_image"
        const val referral_code = "referral_code"
        const val transaction_id = "transaction_id"
        const val reciept_image = "reciept_image"
        const val type = "type"
        const val amount = "amount"

    }

    object HomeRecyclerType {
        const val accounts = "Accounts"
        const val earnings = "Earnings"
        const val downlines = "Downlines"
        const val profile = "Profile"
        const val refer_friend = "Refer a Friend"
        const val feed_back = "Feedback"
        const val withdrawl = "Withdrawals"
        const val apply_loans = "Apply Loans"
        const val shop = "Shop"

    }

    object ValueHolder {
        var userData: UserModel? = null
        var userBankModel: BankDetailsModel? = null
        var aadharFrontImage: String? = null

    }

    enum class ObserverEvents {
        OPEN_MENU, OPEN_MAIN_ACTIVITY, OPEN_LOGIN_SCREEN, OPEN_FORGOT_PWD_SCREEN, START_LOADER, STOP_LOADER
    }

    object PermissionCode {
        const val app_permission = 1000
        const val storage_camera = 1001
    }


}
