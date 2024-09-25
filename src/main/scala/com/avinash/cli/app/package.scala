package com.avinash.cli

import okhttp3.OkHttpClient
import sttp.client3.okhttp.OkHttpSyncBackend
import sttp.client3.{Identity, RequestT}

import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.{SSLContext, TrustManager, X509TrustManager}
import scala.util.{Failure, Success, Try}

package object app {

  def makeApiCall(request: RequestT[Identity, Either[String, String], Any]): Response = {

    val trustAllCerts = getAllTrustedCerts()

    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, new SecureRandom())

    val okHttpClient = new OkHttpClient.Builder()
      .readTimeout(60, TimeUnit.SECONDS)
      .connectTimeout(60, TimeUnit.SECONDS)
      .writeTimeout(60, TimeUnit.SECONDS)
      .sslSocketFactory(sslContext.getSocketFactory, trustAllCerts(0).asInstanceOf[X509TrustManager])
      .hostnameVerifier((_, _) => true)
      .build()

    Try(OkHttpSyncBackend.usingClient(okHttpClient).send(request)) match {
      case Failure(x) =>
        Response(
          -1,
          "No response from Server." +
            "It might be down ?. Please check with CEF Team",
          success = false
        )
      case Success(res) =>
        (res.code.code, res.body) match {
          case (200 | 201, Right(body)) => Response(res.code.code, body)
          case (400, Right(body))       => Response(res.code.code, body, success = false)
          case (401, _) =>
            Response(
              res.code.code,
              "SSO Token is no longer Valid. \n" +
                "Please re-initiate the CLI terminal and refresh the token",
              success = false
            )
          case (500, Right(body)) => Response(res.code.code, body, success = false)
          case (_, Left(error))   => Response(res.code.code, error, success = false)
          case (_, Right(error))  => Response(res.code.code, error, success = false)
        }
    }
  }

  /** Method to return all the trusted Certificates
    * @return
    *   all trusted Certificates
    */
  def getAllTrustedCerts(): Array[TrustManager] = {
    Array[TrustManager](new X509TrustManager {
      def checkClientTrusted(chain: Array[X509Certificate], authType: String): Unit = {}

      def checkServerTrusted(chain: Array[X509Certificate], authType: String): Unit = {}

      def getAcceptedIssuers: Array[X509Certificate] = Array[X509Certificate]()
    })
  }

  val autoCompleteWords = List(
    "exit",
    "hi",
    "api",
    "version",
    "help"
  )

  // ANSI color codes
  val green = "\u001B[32m"
  val red = "\u001B[31m"
  val yellow = "\u001B[33m"
  val reset = "\u001B[0m"

  // Colors and their mapped keywords
  val colorKeywords = Map(
    green -> Set("ONLINE", "RUNNING", "SUCCESS"),
    red -> Set("FAILURE","FAILED", "STOP"),
    yellow -> Set("OFFLINE")
  )

}
