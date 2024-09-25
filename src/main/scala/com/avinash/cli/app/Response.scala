package com.avinash.cli.app

case class Response(code: Int, body: String = "", success: Boolean = true) {

  // Function to apply colorization based on specific keywords
  private def colorizeBody(body: String): String = {
    // Colorization applied
    colorKeywords.foldLeft(body) { case (updatedBody, (color, keywords)) =>
      keywords.foldLeft(updatedBody) { (bodyWithColor, keyword) =>
        bodyWithColor.replace(keyword, s"$color$keyword$reset")
      }
    }
  }

  // Method to return the rgb string
  def asString: String = {
    colorizeBody(body)
  }
}
