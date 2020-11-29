package com.smerkis.news

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import retrofit2.HttpException

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    protected fun activity() = activity as MainActivity

    protected fun createToolbar(
        toolbar: Toolbar,
        shouldSetUpBtn: Boolean = true,
        title: String = ""
    ) {
        toolbar.title = title
        setHasOptionsMenu(true)

        activity().setSupportActionBar(toolbar)
        if (shouldSetUpBtn) {
            activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

            toolbar.apply {
                setNavigationIcon(R.drawable.ic_up_home)
                setNavigationOnClickListener {
                    popBackStack()
                }
            }
        }
    }

    protected fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    protected fun popBackStack() {
        findNavController().popBackStack()
    }

    protected fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    protected fun showInfoDialog(title: String, message: String?, call: (() -> Unit)? = null) {
        AlertDialog.Builder(activity as Context)
            .setTitle(title)
            .setMessage(message ?: getString(R.string.dialog_missing_message))
            .setCancelable(false)
            .setPositiveButton("Ok") { _, _ ->
                call?.invoke()
            }
            .create()
            .show()
    }

    protected fun showShortToast(msg: String) {
        Toast.makeText(activity as Context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showLongToast(msg: String) {
        Toast.makeText(activity as Context, msg, Toast.LENGTH_LONG).show()
    }

    protected fun errorHandler(throwable: Throwable) {
        if (throwable is HttpException && throwable.code() == 429) {
            showLongToast("")
            showShortToast("Too Many Requests")
        } else if (throwable is HttpException && throwable.code() == 404) {
            showShortToast("Not Found")
        } else {
            showInfoDialog("Error", "Something went wrong ¯\\_(ツ)_/¯ => ${throwable.message}") {
                activity().finish()
            }
        }


    }

    protected fun showInputMethod(view: View) {
        (activity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
            view,
            0
        )
    }

    override fun onStop() {
        super.onStop()
        (activity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            view?.windowToken,
            0
        );
    }

}