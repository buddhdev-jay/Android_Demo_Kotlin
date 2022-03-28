
import android.text.TextUtils
import android.util.Patterns
import com.example.android_demo_kotlin.MVC.IUser
import com.example.android_demo_kotlin.utils.MINUS_ONE
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.TWO
import com.example.android_demo_kotlin.utils.ZERO

class User(private val email: String, private val password: String) : IUser {

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isValid(): Int {
        return if (TextUtils.isEmpty(getEmail())){
            ZERO
        }else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            ONE
        }else if(TextUtils.isEmpty(getPassword())){
            TWO
        }else MINUS_ONE
    }
}