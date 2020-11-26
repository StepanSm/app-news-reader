package com.smerkis.news

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    private var _activity: MainActivity? = null
    protected val activity get() = _activity!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activity = getActivity() as MainActivity

    }

    override fun onDestroy() {
        super.onDestroy()
        _activity = null
    }
    protected fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    protected fun popBackStack() {
        findNavController().popBackStack()
    }

    protected fun activity() = activity as MainActivity

    fun showInfoDialog(title: String, message: String?, call: (() -> Unit)? = null) {
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

    fun showShortToast(msg: String) {
        Toast.makeText(activity as Context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(msg: String) {
        Toast.makeText(activity as Context, msg, Toast.LENGTH_LONG).show()
    }

}