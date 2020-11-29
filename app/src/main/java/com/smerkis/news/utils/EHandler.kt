package com.smerkis.news.utils

import android.widget.Toast
import com.smerkis.news.MyApp
import isdigital.errorhandler.ErrorHandler
import retrofit2.HttpException
import java.io.IOException

object EHandler {

    private const val NETWORK_ERROR_MESSAGE =
        "Please check your internet connectivity and try again!"
    private const val EMPTY_RESPONSE = "Server returned empty response."
    const val NO_SUCH_DATA = "Data not found in the database"
    const val UNKNOWN_ERROR = "An unknown error occurred!"
    const val TAG = "ErrorHandler"

    val errorHandler = ErrorHandler
        .defaultErrorHandler()


        // Bind HTTP 404 status to 404
        .bind(404) { errorCode ->
            { throwable ->
                throwable is HttpException && throwable.code() == 404
            }
        }

        // Bind HTTP 500 status to 500
        .bind(500) { errorCode ->
            { throwable ->
                throwable is HttpException && throwable.code() == 500
            }
        }

        .bind("IOException") { errorCode ->
            { throwable ->
                throwable is IOException
            }
        }
        // Handle unknown errors
        .otherwise { throwable, errorHandler ->
            //  displayAlert("Oooops?!")
        }

        // Always log to a crash/error reporting service
        .always { throwable, errorHandler ->
            throwable.message?.let {
                Toast.makeText(MyApp.instance, it, Toast.LENGTH_SHORT).show()
            }
        }

}